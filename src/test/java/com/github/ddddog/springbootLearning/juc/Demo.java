package com.github.ddddog.springbootLearning.juc;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo {
	 public Integer count = 0;
	    public static void main(String[] args) {
	        final Demo demo = new Demo();
	        Executor executor = Executors.newFixedThreadPool(10);
	        for(int i=0;i<100000;i++){
	            executor.execute(new Runnable() {
	                @Override
	                public void run() {
	                    demo.count++;
	                }
	            });
	        }
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("final count value:"+demo.count);
	    }
}
