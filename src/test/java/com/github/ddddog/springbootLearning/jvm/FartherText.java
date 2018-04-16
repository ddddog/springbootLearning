package com.github.ddddog.springbootLearning.jvm;

public class FartherText {
	 static
	    {
	        System.out.println("静态块      farther");
	    }

	    {
	        System.out.println("构造块  farther");
	    }
	    public FartherText()
	    {
	    	System.out.println("构造函数  farther");
	       // System.out.println("call farther counter1="+Singleton.counter1+"  counter2="+Singleton.counter2);

	        //Singleton.counter1++;
	    }
}
