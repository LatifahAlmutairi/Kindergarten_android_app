package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.google.zxing.WriterException;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class CreatQR extends AppCompatActivity {
    String TAG="GenerateQrCode";
    String TAG2="GenerateQrCode2"; //newwwwww



    EditText edttxt ;
    EditText edttxt2 ; //newwwwwww

    ImageView qrimg;
    ImageView qrimg2; //neww

    String inputvalue;
    String inputvalue2;

    Button start;
    Button start2;//newwwwww

    Button upload;
    Bitmap bitmap;
    Bitmap bitmap2;//newww

    QRGEncoder qrgEncoder;
    QRGEncoder qrgEncoder2; //newwwwww

    private StorageReference mStorageRef;
    private StorageTask uploadTask;
    public Uri imageuri;
    public Uri imageuri2; //newwwwww
    Personal_information_for_child p;
    private DatabaseReference mDatabaseRef;
    String userkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_q_r);

        //l
        upload=(Button)findViewById(R.id.buttonupload);

        p=(Personal_information_for_child) getIntent().getSerializableExtra("ChildName");
        mStorageRef=FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef=FirebaseDatabase.getInstance().getReference("personal_information_for_child");
        userkey = p.getUser_key();
        Log.d("MUTEE", "USER KEY: " + userkey);
        mDatabaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Log.d("MUTEE", "onDataChange: personal_info_for_parent Exists");


                    for (DataSnapshot child : dataSnapshot.getChildren()){
                        Personal_information_for_child personal_information_for_child=child.getValue(Personal_information_for_child.class);
                        if (personal_information_for_child.getUser_key() != null){
                            if (personal_information_for_child.getUser_key().equals(userkey)) {
                                p = personal_information_for_child;

                            }
                        }

                    }
                    if (p != null) {
                        Log.d("MUTEE", "onDataChange: "+p.getImageId()==null?"null":p.getImageId());
                    } else {
                        Toast.makeText(CreatQR.this, "Error While Reading Parent Information", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.d("MUTEE", "onDataChange: personal_info_for_parent  NOT Exists");
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //

        qrimg=(ImageView)findViewById(R.id.qrcode);
        qrimg2=(ImageView)findViewById(R.id.qrcode2);//newwwww
        edttxt=(EditText)findViewById(R.id.edittext);
        edttxt2=(EditText)findViewById(R.id.edittext2); //newwwww

        start=(Button)findViewById(R.id.creatbtn);
        start2=(Button)findViewById(R.id.creatbtn2);//newwwwww


        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                inputvalue=edttxt.getText().toString().trim();
                if(inputvalue.length()>0){
                    WindowManager manager=(WindowManager)getSystemService(WINDOW_SERVICE);
                    Display display=manager.getDefaultDisplay();
                    Point point=new Point();
                    display.getSize(point);
                    int width=point.x;
                    int height=point.y;
                    int smallerdimenstion=width<height? width:height;
                    smallerdimenstion=smallerdimenstion*3/4;
                    qrgEncoder=new QRGEncoder(inputvalue,null, QRGContents.Type.TEXT,smallerdimenstion);
                    try {

                        bitmap=qrgEncoder.encodeAsBitmap();
                        qrimg.setImageBitmap(bitmap);
                        qrimg.setImageURI(imageuri);
                    }
                    catch (WriterException e){
                        Log.v(TAG,e.toString());
                    }


                }else {
                    edttxt.setError("Required");
                }

            }
        });

        ///////// newwwwwwwwwwww
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputvalue2=edttxt2.getText().toString().trim();
                if(inputvalue2.length()>0){
                    WindowManager manager=(WindowManager)getSystemService(WINDOW_SERVICE);
                    Display display=manager.getDefaultDisplay();
                    Point point=new Point();
                    display.getSize(point);
                    int width=point.x;
                    int height=point.y;
                    int smallerdimenstion=width<height? width:height;
                    smallerdimenstion=smallerdimenstion*3/4;
                    qrgEncoder2=new QRGEncoder(inputvalue2,null, QRGContents.Type.TEXT,smallerdimenstion);
                    try {

                        bitmap2=qrgEncoder2.encodeAsBitmap();
                        qrimg2.setImageBitmap(bitmap2);
                        qrimg2.setImageURI(imageuri2);
                    }
                    catch (WriterException e){
                        Log.v(TAG2,e.toString());
                    }


                }else {
                    edttxt2.setError("Required");
                }

            }
        });
        //lllll
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadFile();


            }
        });

//llllllllll


    }
    //l

    private String getFileExtension(Uri uri){
        ContentResolver cR=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void uploadFile(){

        qrimg.setDrawingCacheEnabled(true);
        qrimg.buildDrawingCache();
        Bitmap bitmap1=((BitmapDrawable)qrimg.getDrawable()).getBitmap();
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
        byte[] bytes = outputStream.toByteArray();
        final StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+"."+"JPEG");

        UploadTask uploadTask = fileReference.putBytes(bytes);

        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }

                // Continue with the task to get the download URL
                return fileReference.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {

                    final Uri downloadUri = task.getResult();
                    Toast.makeText(CreatQR.this, "Image Uploaded", Toast.LENGTH_SHORT).show();


                    mDatabaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                Log.d("MUTEE", "onDataChange: personal_info_for_parent Exists");


                                for (DataSnapshot child : dataSnapshot.getChildren()){
                                    Personal_information_for_child personal_information_for_child=child.getValue(Personal_information_for_child.class);
                                    if (personal_information_for_child.getUser_key() != null){
                                        if (personal_information_for_child.getUser_key().equals(userkey)) {
                                            p = personal_information_for_child;
                                            p.setImageId(downloadUri.toString());
                                            Map<String, Object> stringObjectMap = p.toMap();
                                            child.getRef().updateChildren(stringObjectMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(CreatQR.this, "Image Updated", Toast.LENGTH_SHORT).show();

                                                    }else {
                                                        Toast.makeText(CreatQR.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });


                                        }
                                    }

                                }
                                if (p != null) {

                                } else {
                                    Toast.makeText(CreatQR.this, "Error While Reading  Information", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Log.d("MUTEE", "onDataChange: personal_info_for_parent  NOT Exists");
                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                } else {

                    // Handle failures
                    // ...
                }
            }
        });

    }
    //l
}
