package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        items=new ArrayList<>();

        items.add(new ItemModel("data 1",R.drawable.thumb1,R.drawable.wall1));
        items.add(new ItemModel("data 2",R.drawable.thumb2,R.drawable.wall2));
        items.add(new ItemModel("data 3",R.drawable.thumb3,R.drawable.wall3));
        items.add(new ItemModel("data 4",R.drawable.thumb4,R.drawable.wall4));
        items.add(new ItemModel("data 5",R.drawable.thumb5,R.drawable.wall5));
        items.add(new ItemModel("data 6",R.drawable.thumb6,R.drawable.wall6));
        items.add(new ItemModel("data 7",R.drawable.thumb7,R.drawable.wall7));
        items.add(new ItemModel("data 8",R.drawable.thumb8,R.drawable.wall8));
        items.add(new ItemModel("data 9",R.drawable.thumb9,R.drawable.wall1));
        items.add(new ItemModel("data 10",R.drawable.thumb10,R.drawable.wall2));
        items.add(new ItemModel("data 11",R.drawable.thumb11,R.drawable.wall3));
        items.add(new ItemModel("data 12",R.drawable.thumb12,R.drawable.wall4));
        items.add(new ItemModel("data 13",R.drawable.thumb13,R.drawable.wall5));
        items.add(new ItemModel("data 14",R.drawable.thumb6,R.drawable.wall6));
        items.add(new ItemModel("data 15",R.drawable.thumb7,R.drawable.wall7));
        items.add(new ItemModel("data 16",R.drawable.thumb8,R.drawable.wall8));

        //truyền vào context :this(chính là activity hiện tại)
        GridAdapterModel adapter=new GridAdapterModel(items,this);

        GridView gridView=findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);


    }
}
