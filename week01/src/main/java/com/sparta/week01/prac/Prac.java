package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;


public class Prac {

    public static int countFruit(String fruit) {
        List<String> fruits = new ArrayList<>();
        fruits.add("감");
        fruits.add("배");
        fruits.add("감");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("딸기");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("메론");
        fruits.add("수박");
        fruits.add("감");

        int count = 0;
        for (int i = 0; i < fruits.size(); i++) {
            String f = fruits.get(i);
            if (f == fruit) {
                count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String title = "웹개발의 봄, Spring";
        String tutor = "남병관";
        int days = 35;

        Course course = new Course(title, tutor, days);
        course.setTitle(title);
        course.setTutor(tutor);
        course.setDays(days);

        System.out.println(course.getTitle());
        System.out.println(course.getTutor());

    }
}
