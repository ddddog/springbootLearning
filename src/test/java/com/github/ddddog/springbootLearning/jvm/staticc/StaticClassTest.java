package com.github.ddddog.springbootLearning.jvm.staticc;

import com.github.ddddog.springbootLearning.jvm.staticc.OuterClass.InnerStaticClass;

public class StaticClassTest {
	 public static void main(String[] args) {
	        System.out.println("内部类静态变量加载时间：" + InnerStaticClass.INNER_STATIC_DATE );
	        //System.out.println("外部类静态变量加载时间：" + OuterClass.OUTER_DATE );
	    }

}
