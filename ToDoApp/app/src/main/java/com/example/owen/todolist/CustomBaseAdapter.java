package com.example.owen.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Owen on 8/17/2016.
 */
public class CustomBaseAdapter extends BaseAdapter{

    private ArrayList<MainList> data;
    private Context context;

    public CustomBaseAdapter(Context context, ArrayList<MainList> maintodoList) {
        this.data = maintodoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.mainlist_item, parent, false);
        }

        TextView toDoTextView = (TextView) convertView.findViewById(R.id.list_item_toDo);
        TextView descriptTextView = (TextView) convertView.findViewById(R.id.list_item_descript);

        final MainList todoList = data.get(i);

        toDoTextView.setText(todoList.getToDo());
        descriptTextView.setText(todoList.getToDescript());

        return convertView;
    }
}
