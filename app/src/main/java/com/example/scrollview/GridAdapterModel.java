package com.example.scrollview;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class GridAdapterModel extends BaseAdapter {
    List<ItemModel> items;

    Context context;//nó tương ứng với activity nào

    int itemWidth;//khích thước chiều cao và rộng của mỗi image

    public GridAdapterModel(List<ItemModel> items, Context context) {
        this.items = items;
        this.context = context;

        //lấy kích thước màn hình
        DisplayMetrics displayMetrics=new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int space=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,8,displayMetrics);
        itemWidth=(displayMetrics.widthPixels-space)/3;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override //View convertView cái này là cái nằm ngoài khung nhìn hiển thị ->ta có thể tái chế
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        //đây là đối tượng view mới mà nó ko tái sử dụng ->cần khởi tạo
        if(convertView==null)
        {
            imageView=new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(itemWidth,itemWidth));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        else// nó là view tái chế tạo bởi đối tượng trước đó nhưng nó nằm ngoài khung nhìn
        {
            imageView=(ImageView) convertView;
        }

        imageView.setImageResource(items.get(position).getThumbnailResource());

        return imageView;
    }
}
