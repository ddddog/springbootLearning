package com.github.ddddog.springbootLearning.jvm.initializationExtends;

public class Output {
    
    public static String printWhenInit(String s){
        System.out.println(s);
        return s.substring(s.indexOf(" "));
    }
}