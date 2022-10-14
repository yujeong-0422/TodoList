package com.example.TodoList.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Setter @Getter
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long tid;

    public String loginId;
    public String loginPw;
    public String name;
    public String age;
    public String phoneNum;
    public String birth;

    public String title;
    public String content;
    public String date;

}
