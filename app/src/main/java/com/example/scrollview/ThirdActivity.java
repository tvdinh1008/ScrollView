package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    List<ContactModel> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        contacts=new ArrayList<>();
        contacts.add(new ContactModel("name 1",R.drawable.thumb1));
        contacts.add(new ContactModel("name 2",R.drawable.thumb2));
        contacts.add(new ContactModel("name 3",R.drawable.thumb3));
        contacts.add(new ContactModel("name 4",R.drawable.thumb4));
        contacts.add(new ContactModel("name 5",R.drawable.thumb5));
        contacts.add(new ContactModel("name 6",R.drawable.thumb6));
        contacts.add(new ContactModel("name 7",R.drawable.thumb7));
        contacts.add(new ContactModel("name 8",R.drawable.thumb8));
        contacts.add(new ContactModel("name 9",R.drawable.thumb9));
        contacts.add(new ContactModel("name 10",R.drawable.thumb10));
        contacts.add(new ContactModel("name 11",R.drawable.thumb11));
        contacts.add(new ContactModel("name 12",R.drawable.thumb12));
        contacts.add(new ContactModel("name 13",R.drawable.thumb13));
        contacts.add(new ContactModel("name 14",R.drawable.thumb14));

        ContactAdapter adapter=new ContactAdapter(contacts);

        ListView listView=findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
}
