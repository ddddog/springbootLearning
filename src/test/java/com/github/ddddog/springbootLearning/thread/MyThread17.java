package com.github.ddddog.springbootLearning.thread;

public class MyThread17 extends Thread
{
    private ThreadDomain17 td;
    
    public MyThread17(ThreadDomain17 td)
    {
        this.td = td;
    }
    
    public void run()
    {
        td.testMethod();
    }
    
   
}