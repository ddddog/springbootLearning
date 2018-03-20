package com.github.ddddog.springbootLearning.classs;
/**
 * 局部内部类
 * @author admin
 *
 */
public class Outer1 {
	private int s = 100;
	private int out_i = 1;

	public void f(final int k) {
		final int s = 200;
		int i = 1;
		final int j = 10;
		class Inner { // 定义在方法内部
			int s = 300;// 可以定义与外部类同名的变量
			// static int m = 20;//不可以定义静态变量

			Inner(int k) {
				inner_f(k);
			}

			int inner_i = 100;

			void inner_f(int k) {
				System.out.println(out_i);// 如果内部类没有与外部类同名的变量，在内部类中可以直接访问外部类的实例变量
				System.out.println(k);// *****可以访问外部类的局部变量(即方法内的变量)，但是变量必须是final的*****
				// System.out.println(i);
				System.out.println(s);// 如果内部类中有与外部类同名的变量，直接用变量名访问的是内部类的变量
				System.out.println(this.s);// 用"this.变量名" 访问的也是内部类变量
				System.out.println(Outer1.this.s);// 用外部"外部类类名.this.变量名"
													// 访问的是外部类变量
			}
		}
		new Inner(k);
	}

	public static void main(String[] args) {
		// 访问局部内部类必须先有外部类对象
		Outer1 out = new Outer1();
		out.f(3);
	}
}
