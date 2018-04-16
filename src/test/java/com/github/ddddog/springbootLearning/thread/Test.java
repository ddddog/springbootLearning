package com.github.ddddog.springbootLearning.thread;

public class Test {
	public static void main(String[] args)
	{
		test17();
	}
	
	
	public static void test04(){
		 MyThread04 mt = new MyThread04();
		    mt.start();
		    
		    Thread.currentThread().interrupt();
		    System.out.println("是否停止1？" + Thread.interrupted());
		    System.out.println("是否停止2？" + Thread.interrupted());
		    System.out.println("end!");
	}
	
	public static void test17(){
		ThreadDomain17 td = new ThreadDomain17();
	    MyThread17 mt0 = new MyThread17(td);
	    MyThread17 mt1 = new MyThread17(td);
	    mt0.start();
	    mt1.start();
	}
}
