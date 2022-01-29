package com.example.kindergarten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerV extends AppCompatActivity {
    private RecyclerView rv;
    private DatabaseReference databaseReference;
    private  ArrayList<Personal_information_for_child> personal_information_for_children;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler_v);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("personal_information_for_child");
        rv = findViewById(R.id.rv_main); //  هينا عرفت الريسايكلر فيو
        personal_information_for_children = new ArrayList<>(); // عرفت الاراي لست
        //cats.add(new Cat(R.drawable.bkg2,"cat1")); //   وهينا نعبي الارري لست بيانات عشان اخذ منها طبعا بعدين راح   نعبي الاراي لست من الداتا بيس
        // cats.add(new Cat(R.drawable.bkg3,"cat2"));
        //cats.add(new Cat(R.drawable.meke,"cat333"));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(personal_information_for_children); //   سويت اوبجيكت من الادابتر وضفته علي الاراي لست وبكذا صار الادابتر جاهز لاضافته على الريسايكلر فيو
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);//  هذا الكلاس "الاي اوت مانيجر " هو مدير الادابتر اللي انا سويته ؟ كيف ؟ يستدعي  ماثودات الادابتر وينسق بينها
        rv.setHasFixedSize(true);// عشان يكون عرض او حجم الريسايكلر  ثابت  ولا يتغير العرض  اثناء استخدام التطبيق
       // rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        rv.setDrawingCacheEnabled(true);
        rv.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        rv.setLayoutManager(new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false));


        Query query = databaseReference.orderByKey(); //.. عن طريق الكويري هذي راح اجيب البيانات اللي في الستيودنت انفورميشن B <<<<<  //ماحددت كي داخله عشان ابغى كل اللبيانات اللي داخل  studentinformation ..we want to recevie all keys
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    personal_information_for_children.clear();

                    for (DataSnapshot user : dataSnapshot.getChildren()) { //     هينا الماثود dataSnapshoten.getChildren   رجعت لي البيانات كامله اللي تحت studentinformation  داخل اليوزر
                        // do something with the individual "issues"
                        Personal_information_for_child usersBean = user.getValue(Personal_information_for_child.class);  //   وحطهم كلهم usearBesn    ..  بعدين مشى عليهم واحد واحد وضافه على اللسته
                        personal_information_for_children.add(usersBean); //±±±±±±±±±± /؟// C  >>>>> الف علي البيانات الموجودة عندي  بالداتا بيس وارسلها  للآري لست

                    }

                    rv.getAdapter().notifyDataSetChanged(); // اعلم او اشعر الادابتر ان البيانات تغيرت فارجع ارسم الفيو حقتها
                    //  نقول للسايكلر الفيو لو سمحت البيانات حقت لو تغيرت ارجع ارسم الفيو من جديد
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Database error", Toast.LENGTH_LONG).show();
            }
        });

    }


    //


    // holder class for recycler view
    class CatViewHolder extends RecyclerView.ViewHolder { //  هينا سويت وراثة للفيو هولدير  عشان اقول للريسايكلر فيو ان هذا الكلا هو الفيو هولدير حقك
        TextView tv_name; //  نعرف عناصر اللي اوت
        ImageView iv_image;
        Button viewName;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.cat_custom_tv);
            //  iv_image = itemView.findViewById(R.id.cat_custom_iv);
           // viewName=fi
        }
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<com.example.kindergarten.RecyclerViewAdapter.CatViewHolder> {

        private List<Personal_information_for_child> plist =new ArrayList<>();

        public RecyclerViewAdapter(List<Personal_information_for_child> plist) { //  كونستراكتور عشان ابعث البيانات من الخارج
            this.plist = plist;
        }

        @NonNull
        @Override
        public com.example.kindergarten.RecyclerViewAdapter.CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_custom_item, parent, false);
            com.example.kindergarten.RecyclerViewAdapter.CatViewHolder viewHolder = new com.example.kindergarten.RecyclerViewAdapter.CatViewHolder(v);
            return viewHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull com.example.kindergarten.RecyclerViewAdapter.CatViewHolder holder, int position) {
            final Personal_information_for_child p = plist.get(position);//  روح لي للاري لست وجب لي العنصر الي في الموقع  هذا
            //   holder.iv_image.setImageResource(c.getImg()); //  خذ الايدي حق الصوره وضيفها علي الصورة
            holder.tv_name.setText(p.getFirstname());
           // holder.tv_name.setText(p.getFathername());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainRecyclerV.this, TestActi.class);
                    intent.putExtra("ChildName", p);
                    startActivity(intent);

                }
            });
        }


        @Override
        public int getItemCount() {
            return plist.size();
        }

    }
}
