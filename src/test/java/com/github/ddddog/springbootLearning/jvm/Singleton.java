package com.github.ddddog.springbootLearning.jvm;

public class Singleton extends Farther{
	static
    {
        System.out.println("静态代码块1  counter1="+Singleton.counter1 +"  counter2="+Singleton.counter2);
    }

    public static int counter1;
    public static int counter2 = 1;

    static
    {
        System.out.println("静态代码块2  counter1="+counter1 +"  counter2="+counter2);
    }

    private static Singleton sin = new Singleton();
    static
    {
        System.out.println("静态代码块3  counter1="+counter1 +"  counter2="+counter2);
    }

    {
        counter1++;
        System.out.println("构造代码块  counter1="+counter1+"  counter2="+counter2);
    }

    public Singleton() {
        System.out.println("call Singleton");
        counter1++;
        counter2++;
    }
}
