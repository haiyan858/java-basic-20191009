package com.myself1009;

import org.junit.Test;

/**
 * @Author cuihaiyan
 * @Create_Time 2019-10-09 10:23
 */
public class Student {
    public String name;
    public int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void test() {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}
