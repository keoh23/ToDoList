package com.example.owen.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Owen on 8/17/2016.
 */
public class AddedActivity extends AppCompatActivity {
    private String toDo;
    private String toDescript;
    private TextView addedtitleView;
    private ListView addedlistView;
    private FloatingActionButton addedFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added);

        addedtitleView = (TextView)findViewById(R.id.added_title1);
        addedlistView = (ListView)findViewById(R.id.added_list_view1);
        addedFAB = (FloatingActionButton)findViewById(R.id.addedFAB);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        addedtitleView.setText(title);

//        CustomBaseAdapter adapter = new CustomBaseAdapter(this, );
//        addedlistView.setAdapter(adapter);

    }

//    public AddedActivity(String toDo, String toDescript){
//        this.toDo = toDo;
//        this.toDescript = toDescript;
//
//    }
//
//    public String getToDo() {
//        return toDo;
//    }
//
//    public void setToDo(String toDo) {
//        this.toDo = toDo;
//    }
//
//    public String getToDescript() {
//        return toDescript;
//    }
//
//    public void setToDescript(String toDescript) {
//        this.toDescript = toDescript;
//    }
}
