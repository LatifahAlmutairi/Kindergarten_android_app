package com.example.kindergarten;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class picRequirement extends AppCompatActivity {

    ImageView img;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_requirement);


        img = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView);
    }

    public  void btn_click_photo(View view){
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent,100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK){
            Uri uri =data.getData();
            img.setImageURI(uri);
        }
    }


   /* public void btn_22(View view) {
        Intent intent = new Intent(PicRequirment.this ,MainforFragment.class);
        startActivity(intent);
    }*/
}