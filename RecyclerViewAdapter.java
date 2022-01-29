package com.example.kindergarten;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CatViewHolder> {


    ArrayList<Personal_information_for_child> personal_information_for_children ;

    public RecyclerViewAdapter(ArrayList<Personal_information_for_child> personal_information_for_children) { //  كونستراكتور عشان ابعث البيانات من الخارج
        this.personal_information_for_children = personal_information_for_children;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_custom_item,null,false);
        CatViewHolder viewHolder = new CatViewHolder(v);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Personal_information_for_child p = personal_information_for_children.get(position);//  روح لي للاري لست وجب لي العنصر الي في الموقع  هذا
       // holder.iv_image.setImageResource(p.getImg()); //  خذ الايدي حق الصوره وضيفها علي الصورة
        holder.tv_name.setText(p.getFirstname());
        //holder.tv_name.setText(p.getFathername());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }




    @Override
    public int getItemCount() {
        return personal_information_for_children.size();
    }


    //________________________________________________________________________________________

    // holder class for recycler view
    static class  CatViewHolder extends  RecyclerView.ViewHolder { //  هينا سويت وراثة للفيو هولدير  عشان اقول للريسايكلر فيو ان هذا الكلا هو الفيو هولدير حقك
        TextView tv_name ; //  نعرف عناصر اللي اوت
       // ImageView iv_image ;
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.cat_custom_tv);
           // iv_image = itemView.findViewById(R.id.cat_custom_iv);
        }
    }


}


