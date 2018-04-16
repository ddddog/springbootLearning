package com.github.ddddog.springbootLearning.jvm.initializationExtends;

public interface SubI extends I{
	 public static String subField = Output.printWhenInit(" initializing SubI.subField ");
}
