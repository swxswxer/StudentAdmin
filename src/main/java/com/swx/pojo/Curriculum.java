package com.swx.pojo;

import java.util.List;

public class Curriculum {
    int id ;
    String name ;
    int credit;
    String time ;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    public Curriculum(int id, String name, int credit,String time) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", time='" + time + '\'' +
                '}';
    }
}
