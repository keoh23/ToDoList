package com.example.owen.todolist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Owen on 8/18/2016.
 */
public class SecondActivity extends AppCompatActivity {
    private TextView addedtitleView;
    private ListView addedlistView;
    private FloatingActionButton addedFAB;
    private ArrayList<String> addedtodoList = new ArrayList<>();
    private ArrayAdapter<String> addedarrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added);

        addedtitleView = (TextView)findViewById(R.id.added_title1);
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        addedtitleView.setText(title);

        addedlistView = (ListView)findViewById(R.id.added_list_view1);
        addedFAB = (FloatingActionButton)findViewById(R.id.addedFAB);
        addedarrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, addedtodoList);
        addedlistView.setAdapter(addedarrayAdapter);

        addedFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);

                final EditText input = new EditText(SecondActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setView(input);

                builder.setMessage("To Do!")
                        .setPositiveButton(R.string.change, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                addedtodoList.add(input.getText().toString());
                                addedarrayAdapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });

                Dialog dialog = builder.create();
                dialog.show();
            }
        });




//        CustomBaseAdapter adapter = new CustomBaseAdapter(this, );
//        addedlistView.setAdapter(adapter);

    }


}

