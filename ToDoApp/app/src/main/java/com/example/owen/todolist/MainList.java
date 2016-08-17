package com.example.owen.todolist;

/**
 * Created by Owen on 8/17/2016.
 */
public class MainList {
    private String toDo;
    private String toDescript;

    public MainList(String toDo, String toDescript){
        this.toDo = toDo;
        this.toDescript = toDescript;

    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public String getToDescript() {
        return toDescript;
    }

    public void setToDescript(String toDescript) {
        this.toDescript = toDescript;
    }
}
