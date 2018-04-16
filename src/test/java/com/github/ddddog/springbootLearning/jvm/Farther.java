package com.github.ddddog.springbootLearning.jvm;

public class Farther {
	 static
	    {
	        System.out.println("静态代码块      farther");
	    }

	    {
	        System.out.println("构造代码块  farther");
	    }
	    public Farther()
	    {
	        System.out.println("call farther counter1="+Singleton.counter1+"  counter2="+Singleton.counter2);

	        Singleton.counter1++;
	    }
}
