package com.zhb.digui;

import java.util.Scanner;

/**
 * 
 * @author Administrator
 * 汉诺塔
 * 问题描述：A   B   C  这里有三个塔座，
 * 需要将A的碟子搬到C座。
 * 搬移规则：1.每次只能搬一个 
 * 2：圆盘可以插在任意一个塔座上 
 * 3：任何时刻都不能将一个较大的圆盘放在一个较小的圆盘上
 * 假设有N的个盘子,2 ^ N - 1次
 */
public class Hanoi {
	public static int n = 1;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		hanoi(num,'A','B','C');
	}
	
	//汉诺塔递归调用
	public static void hanoi(int i,char A,char B,char C){
		if(i == 1){
			move(i,A,C);
		}else{
			hanoi(i - 1,A,C,B);
			move(i,A,C);
			hanoi(i - 1,B,A,C);
		}
	}
	
	//移动盘子
	public static void move(int i,char a , char b){
		System.out.println((n++) + ": " + i + " 从"+a+"移到"+b);
	}

}
