package com.github.ddddog.springbootLearning.jvm.initializationExtends;

public interface I extends SuperI{
	public static String iField = Output.printWhenInit("initializing I.iField ");
}
