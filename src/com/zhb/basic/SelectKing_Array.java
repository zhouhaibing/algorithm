package com.zhb.basic;

/**
 * 
 * @author Administrator
 * 猴子选大王  数组实现
 * 思路：
 * 用数组表示猴子是否在位的状态 1,0
 * 从头开始数，用报数器记录数到多少，数到k时标记猴子状态为0,p=p%sum表示循环遍历
 * 最后直到剩下一个猴子为止，退出循环。
 */
public class SelectKing_Array {
	public static int sum = 10;
	public static int num = 3;
	public static void main(String[] args){
		int[] monkeys = new int[sum];
		for(int i=1;i <=sum;i++){
			monkeys[i-1]=1;//所有的猴子都在位
		}
		int p = 0;//下标
		int m = 0;//报数器，报一次加一
		int n = sum;//在位的猴子
		while(n > 1){//只有一个猴子的时候退出循环
			while(m < num){//报数报到num表示退出圈子
				if(monkeys[p] == 1){
					m++;
					if(m == num){
						monkeys[p] = 0;//退出圈子
					}
				}
				p++;
				p=p%sum;////这一步是为了解决循环数组成环遍历的目的
			}
			m = 0;//报数器清零
			n--;//总体猴子减一
		}
		int kingNum = 0;
		for(int i = 1;i <= sum; i++){
			if(monkeys[i - 1] == 1){
				kingNum = i;
			}
		}
		System.out.println("the king is :" + kingNum);
	}

}
