package com.github.ddddog.springbootLearning.jvm;

public class Test extends Super {

    public static final String field1 = "Test.field1";
    
    public static final String field2 = InnerClass.pint("Initializing Test.field2 ");
    public static String field3 = InnerClass.pint("Initializing Test.field3 ");
    
    public String field4 = InnerClass.pint("Initializing Test.field4 ");
    
    static{
        System.out.println("initializing Test class ");
        System.out.println("\t" + field1 + " - " + field2 + " - " + field3);
    }
    
    public Test(){
        System.out.println("in Test() ");
    }
    
    public void bMethod() {    
        System.out.println("in Test.bMethod() ");
    }

    
    public static class InnerClass{
        public static String pint(String s){
            System.out.println(s);
            return s.substring(s.indexOf(" ") + 1);
        }
        
        static {
            System.out.println("initialzation in Test$innerClass ");
            System.out.println("\t" + field1 + " - " + field2 + " - " + field3);        
        }
    }
}