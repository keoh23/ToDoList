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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView maintitleView;
    private ListView mainlistView;
    private FloatingActionButton mainFAB;
    private ArrayList<String> maintodoList = new ArrayList<>();
    private ArrayAdapter<String> mainarrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainlistView = (ListView)findViewById(R.id.list_view1);
        maintitleView = (TextView)findViewById(R.id.title1);
        mainFAB = (FloatingActionButton)findViewById(R.id.mainFAB);

//        final CustomBaseAdapter adapter = new CustomBaseAdapter(MainActivity.this,);
        mainarrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, maintodoList);
        mainlistView.setAdapter(mainarrayAdapter);

        maintitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setView(input);

                builder.setMessage(R.string.change_the_title)
                        .setPositiveButton(R.string.change, new DialogInterface.OnClickListener() {
                             public void onClick(DialogInterface dialog, int id) {
                                maintitleView.setText(input.getText().toString());
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(), "NVM", Toast.LENGTH_SHORT).show();
                            }
                        });

                Dialog dialog = builder.create();
                dialog.show();
            }
        });

        mainFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setView(input);

                builder.setMessage(R.string.change_the_text)
                        .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                maintodoList.add(input.getText().toString());
                                mainarrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(), "Whoopsie!", Toast.LENGTH_SHORT).show();

                            }
                        });

                Dialog dialog = builder.create();
                dialog.show();
            }
        });
        mainlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Title", maintodoList.get(position));
                startActivity(intent);

            }
        });
        mainlistView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                maintodoList.remove(position);
                Toast.makeText(getApplicationContext(), "It's Gone!", Toast.LENGTH_SHORT).show();
                mainarrayAdapter.notifyDataSetChanged();

                return false;
            }
        });
    }
}