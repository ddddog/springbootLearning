package com.github.ddddog.springbootLearning.thread;

public class ThreadDomain17
{
    public synchronized void testMethod()
    {
        try
        {
            System.out.println("Enter ThreadDomain17.testMethod, currentThread = " + 
                    Thread.currentThread().getName());
            long l = 100L;
            while (true)
            {
                long lo = 2 / l;
                l--;
                Thread.sleep(1);
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
