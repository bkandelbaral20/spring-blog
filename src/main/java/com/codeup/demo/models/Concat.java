package com.codeup.demo.models;

public class Concat {
    public static void main(String[] args) {

        int one = 1;
        String two = "2";

        System.out.println(1 + two); // 12
        System.out.println(one + two + 3 + 4); //1234
        System.out.println(3 + one); // 4
        System.out.println(3 + two + 4); //324
        System.out.println(1 + 3 + 4 + two);//82

        String hello = "hello";
        String hi = hello + "World";
        hi = hello;
        System.out.println(hi + hello); //

        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3");

        System.out.println(s1);//1
        System.out.println(s2);//12

    }

}
