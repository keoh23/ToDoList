package com.example.owen.todolist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton mainFAB;
    private ArrayList<String> maintodoList = new ArrayList<>();
    private ArrayAdapter<String> mainarrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list_view1);
        mainFAB = (FloatingActionButton)findViewById(R.id.mainFAB);
        
//        CustomBaseAdapter adapter = new CustomBaseAdapter(this, maintodoList);
        mainarrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, maintodoList);
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
//                                Intent intent = new Intent(MainActivity.this, AddedActivity.class);
//                                intent.putExtra("Title", "BACON");
//                                startActivity(intent);
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
    }

}
