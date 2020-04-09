package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemModel> items;
    ImageView imageLarge;//ảnh chi tiết

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items=new ArrayList<>();

        items.add(new ItemModel("data 1",R.drawable.thumb1,R.drawable.wall1));
        items.add(new ItemModel("data 2",R.drawable.thumb2,R.drawable.wall2));
        items.add(new ItemModel("data 3",R.drawable.thumb3,R.drawable.wall3));
        items.add(new ItemModel("data 4",R.drawable.thumb4,R.drawable.wall4));
        items.add(new ItemModel("data 5",R.drawable.thumb5,R.drawable.wall5));
        items.add(new ItemModel("data 6",R.drawable.thumb6,R.drawable.wall6));
        items.add(new ItemModel("data 7",R.drawable.thumb7,R.drawable.wall7));
        items.add(new ItemModel("data 8",R.drawable.thumb8,R.drawable.wall8));

        LinearLayout linearLayoutList=findViewById(R.id.layout_list);
        imageLarge=findViewById(R.id.image_large);
        //duyêt từng đối tượng item gắn vào đối tượng view(trong layout .xml)
        for(int i=0;i<items.size();i++)
        {
            View itemView= getLayoutInflater().inflate(R.layout.layout_item,null);

            itemView.setId(i);//để biết đc item nào được nhấn vào->được vị trí của đối tượng trong model
            final ImageView imageView=itemView.findViewById(R.id.image_view);
            TextView textView=itemView.findViewById(R.id.text_view);

            textView.setText(items.get(i).getLable());
            imageView.setImageResource(items.get(i).getThumbnailResource());
            //bắt sự kiện click vào ảnh thumbnail

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i= v.getId();
                    int imageResource=items.get(i).getImageResource();
                    //gán vào .xml (ảnh chi tiết)
                    imageLarge.setImageResource(imageResource);
                }
            });

            //cho đối tượng view vào linearlayout(trong main.xml)
            linearLayoutList.addView(itemView);
        }
        //bắt sự kiện click vào ảnh thumbnail


    }
}
