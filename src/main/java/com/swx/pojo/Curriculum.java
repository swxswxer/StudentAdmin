package com.swx.pojo;

import java.util.List;

public class Curriculum {
    int id ;
    String name ;
    int credit;
    int numberOfPeople ;

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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Curriculum(int id, String name, int credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public void addStudent(Student student){
        this.numberOfPeople++;
        List<String> curriculums = student.getCurriculums();
        curriculums.add(this.name);
        student.setCurriculums(curriculums);
    }

    public void reduceStudent(Student student){
        this.numberOfPeople--;
        List<String> curriculums = student.getCurriculums();
        //删除list中的课程
        for (int i = 0; i < curriculums.size(); i++) {
            if(curriculums.get(i).equals(this.name)){
                curriculums.remove(i);
            }
        }

    }
}
