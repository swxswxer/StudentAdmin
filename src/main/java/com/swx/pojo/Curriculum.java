package com.swx.pojo;

import java.util.List;

public class Curriculum {
    int id ;
    String name ;
    int credit;


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


    public Curriculum(int id, String name, int credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
