package com.example.scrollview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    //để gu
    List<ContactModel> contacts;

    public ContactAdapter(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    //vấn đề hiệu năng với máy yếu
    //findViewById luôn đc gọi liên tục dù là tao mới hay tái chế-->làm giảm hiệu năng ứng dụng --> ta sẽ tạo class viewHolder

    //quy định cách thức hiển thị cho mỗi đối tượng
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //ViewGroup parent lấy đấy đc context chính là listView(chứa tất cả các item)
        //nếu chưa khởi tạo ->tạo mới vidu nhu lần chay đầu tiên
        if(convertView==null)
        {

            //lấy đc layout của mối item
            //list_view là do adapter quy định -> tham số thứ 3 là false
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_list_view,parent,false);


        }
        //convertView chính là layout của 1 item -> mỗi item có nhiều thuộc tính ta sẽ xét tưng cái 1
        //chú ý là item sẽ có nhiều thuộc tính (model nhiều thuộc tính) trong nó
        ImageView imageAvatar= convertView.findViewById(R.id.image_avatar);
        TextView textFullname=convertView.findViewById(R.id.text_fullname);
        CheckBox chkSelected=convertView.findViewById(R.id.chk_select);

        ContactModel contact=contacts.get(position);
        imageAvatar.setImageResource(contact.getAvatarResource());
        textFullname.setText(contact.getFullname());
        chkSelected.setChecked(contact.isSelected());


        return convertView;
    }
     */


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            //convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_list_view,parent,false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_avatar,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textFullname=convertView.findViewById(R.id.text_fullname);

            viewHolder.textRound=convertView.findViewById(R.id.text_round);

            viewHolder.imageAvatar=convertView.findViewById(R.id.image_avatar);
            //viewHolder.chkSelected=convertView.findViewById(R.id.chk_select);
            viewHolder.imageFavorite=convertView.findViewById(R.id.image_favorite);

            //mỗi một cái view ta sẽ gắn vào 1 tag là viewHolder
            convertView.setTag(viewHolder);
        }
        else
        {
            //convertView khác null ta sẽ lấy ra viewHolder tương ứng
            viewHolder=(ViewHolder) convertView.getTag();
        }
        final ContactModel contact=contacts.get(position);
        viewHolder.imageAvatar.setImageResource(contact.getAvatarResource());
        viewHolder.textFullname.setText(contact.getFullname());
        viewHolder.textRound.setText(contact.getFullname().substring(0,1));

        //viewHolder.textRound.getBackground().setColorFilter();

        //viewHolder.chkSelected.setChecked(contact.isSelected());
        /*
        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected=contacts.get(position).isSelected();
                contacts.get(position).setSelected(!isSelected);
                //báo cho adapter list view thay đổi cần cập nhật tương ứng
                notifyDataSetChanged();
            }
        });
         */
        if(contact.isSelected()) {
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_favorite);
        }
        else
        {
            viewHolder.imageFavorite.setImageResource(R.drawable.ic_star_normal);
        }
        viewHolder.imageFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected=contacts.get(position).isSelected();
                contacts.get(position).setSelected(!isSelected);
                //báo cho adapter list view thay đổi cần cập nhật tương ứng
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    /*
        sẽ thay thế cho findViewById
    */
    class ViewHolder{
        ImageView imageAvatar;
        TextView textFullname;
        TextView textRound;
        //CheckBox chkSelected;
        ImageView imageFavorite;

    }
}
