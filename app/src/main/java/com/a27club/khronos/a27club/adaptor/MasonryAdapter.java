package com.a27club.khronos.a27club.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a27club.khronos.a27club.R;

public class MasonryAdapter  extends RecyclerView.Adapter<MasonryAdapter.MasonryView>{

    private Context context;

    int[] imgList ={
            R.drawable.two, R.drawable.one, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten
    };
    String[] nameList ={
            "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten"
    };

    public MasonryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MasonryView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()
        ).inflate(R.layout.grid_item,viewGroup,false);
        MasonryView masonryView = new MasonryView(layoutView);
        return masonryView;
    }

    @Override
    public void onBindViewHolder(@NonNull MasonryView masonryView, int i) {
        masonryView.imageView.setImageResource(imgList[i]);
        masonryView.textView.setText(nameList[i]);

    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }

    class MasonryView  extends RecyclerView.ViewHolder{
   ImageView imageView;
   TextView textView;

         public MasonryView(@NonNull View itemView) {
             super(itemView);
             imageView = (ImageView)itemView.findViewById(R.id.img);
             textView = (TextView)itemView.findViewById(R.id.img_name);
         }
     }
}
