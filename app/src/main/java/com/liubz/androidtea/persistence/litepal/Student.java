package com.liubz.androidtea.persistence.litepal;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Student extends LitePalSupport {

    @Column(nullable = false, unique = true)
    private String no;
    private String name;
    private String number;
    private String addr;
    private int score;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
