package com.zhb.sort;

import java.io.IOException;

public class ClassA {
	public void print() throws RuntimeException{
		
	}
	public static void main(String[] args){
		ClassA ca = new ClassA();
		System.out.println(ca.monkeyKing(10, 3));
	}
	
	public int monkeyKing(int amount,int key){
		int[] monkeys = new int[amount];
		for(int i=0; i < amount; i++){
			monkeys[i] = 1;
		}
		int outMonkeys = 0,kingIndex = 0;
		
		int j = 0;
		int t = 0;
		while(outMonkeys < amount - 1){
			if(monkeys[j] == 1){				
				t++;
				if(t == key){
					t=0;
					monkeys[j] = 0;
					outMonkeys++;
				}
			}
			if(j == amount - 1){
				j = 0;
			}else{
				j++;
			}
		}
		for(int i=0;i<amount;i++){
			if(monkeys[i] == 1)
				kingIndex =i;
		}
		return kingIndex;
	}

}

class ClassB extends ClassA{
	public void print() throws NullPointerException{
		
	}
}
