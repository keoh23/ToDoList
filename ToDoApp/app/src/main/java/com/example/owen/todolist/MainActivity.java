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
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton myFAB;
    private ArrayList<MainList> maintodoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list_view1);
        myFAB = (FloatingActionButton)findViewById(R.id.myFAB);

        maintodoList.add(new MainList("Poetic Justice", "Kendrick Lamar"));
        maintodoList.add(new MainList("Can I Kick It", "A Tribe Called Quest"));
        maintodoList.add(new MainList("Sober", "Childish Gambino"));
        maintodoList.add(new MainList("Brown Skin Lady", "Black Star"));
        maintodoList.add(new MainList("G.O.M.D.", "J. Cole"));


        CustomBaseAdapter adapter = new CustomBaseAdapter(this, maintodoList);

        listView.setAdapter(adapter);

        myFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setView(input);

                builder.setMessage(R.string.change_the_text)
                        .setPositiveButton(R.string.change, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(this, NewActivity.class);
                                startActivity(intent);
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
