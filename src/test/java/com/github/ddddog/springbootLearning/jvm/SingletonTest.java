package com.github.ddddog.springbootLearning.jvm;

public class SingletonTest {
	// System.out.println("counter1:"+counter1+",counter2:"+counter2);
	public static void main(String[] args) {
		Singleton sin = new Singleton();
        System.out.println(sin.counter1);
        System.out.println(sin.counter2);
    }
}
