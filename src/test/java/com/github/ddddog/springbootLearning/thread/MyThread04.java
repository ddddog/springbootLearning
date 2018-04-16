package com.github.ddddog.springbootLearning.thread;

public class MyThread04 extends Thread
{
    static
    {
        System.out.println("静态块的打印：" + 
                Thread.currentThread().getName());    
    }
    
    public MyThread04()
    {
        System.out.println("构造方法的打印：" + 
                Thread.currentThread().getName());
        System.out.println("MyThread5----->Begin");
        System.out.println("Thread.currentThread().getName()----->" + 
                Thread.currentThread().getName());
        System.out.println("this.getName()----->" + this.getName());
        System.out.println("MyThread5----->end");
    }
    
    public void run()
    {
        System.out.println("run()方法的打印：" + 
                Thread.currentThread().getName());
        System.out.println("MyThread5----->Begin");
        System.out.println("Thread.currentThread().getName()----->" + 
                Thread.currentThread().getName());
        System.out.println("this.getName()----->" + this.getName());
        System.out.println("MyThread5----->end");
    }
}