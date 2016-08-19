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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton mainFAB;
    private LinkedList<String> maintodoList = new LinkedList<>();
    private ArrayAdapter<String> mainarrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list_view1);
        mainFAB = (FloatingActionButton)findViewById(R.id.mainFAB);

//        final CustomBaseAdapter adapter = new CustomBaseAdapter(MainActivity.this,);
        mainarrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, maintodoList);
        listView.setAdapter(mainarrayAdapter);

        mainFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setView(input);

                builder.setMessage(R.string.change_the_text)
                        .setPositiveButton(R.string.change, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                maintodoList.add(input.getText().toString());
                                mainarrayAdapter.notifyDataSetChanged();
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//                intent.putExtra("Title", maintodoList);
                startActivity(intent);

            }
        });
    }

}
