package com.istudy.jcase;

import java.util.Scanner;

/**
 * 
 * HelloWorld,控制台输入
 * @desc: The beginning of this tools
 * @author: wyc
 * @createTime: 2016年10月24日 上午8:51:10
 * @history:
 * @version: v1.0
 */
public class ConsoleInput {
	/**
	 * 
	 * 主函数
	 * 
	 * @author: wyc
	 * @createTime: 2016年10月21日 下午1:24:38
	 * @history:
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		System.out.println("HelloWorld!");
		console();
	}

	/**
	 * 
	 * 控制台输入
	 * @author: wyc
	 * @createTime: 2016年10月21日 下午1:32:47
	 * @history: void
	 */
	public static void console() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a:");
		String inputStrA=sc.nextLine();
		int a=Integer.valueOf(inputStrA);
		System.out.println("You input  a is :"+a);
		
		System.out.println("Please input b:");
		String inputStrB=sc.nextLine();
		//String 转  int
		int b=Integer.valueOf(inputStrB);
		System.out.println("You input is :"+b);
		
		System.out.println("a+b is:"+(a+b));
	}

}
