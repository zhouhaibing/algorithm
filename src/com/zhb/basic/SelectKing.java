package com.zhb.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Administrator
 *	猴子选大王  循环链表解决
 *  题目描述：
 *  【问题描述-猴子选大王】：M只猴子要选大王，选举办法如下：所有猴子按1-M编号围坐一圈，从1号开始按顺序1，2，，，K报数，凡报到K的猴子退出到圈外，如此循环报数，直到圈内只剩下一只猴子时，这只猴子就是大王。M和K由输入文件提供，要求在输出文件中打印出最后剩下的猴子的编号。数据规模（M<=1000,K<=10）
	【输入文件】
		输入文件monkey.in 的第1 行，为两个正整数，用一个空格隔开:
		M K
	【输出文件】
		输出文件monkey.out 只有一个正整数,输出最后一个猴子的编号
	【输入样例】
		7 3
	【输出样例】
		4
 */
public class SelectKing {
	public static void main(String[] args) throws IOException{
		SelectKing sk = new SelectKing();
		String infoStr = sk.getFileInfo("temp.txt");
		//System.out.println(infoStr);
		String[] infoStrArray = infoStr.split("\\s+");
		//for(String s : infoStrArray){
			//System.out.println(s);
		//}
		int numOfMonkey = Integer.parseInt(infoStrArray[0]);//人数
		int targetNum = Integer.parseInt(infoStrArray[1]);//出圈的报数
		//初始化猴子链表，循环链表
		MonkeyList mokeyList = new MonkeyList();
		for(int i=numOfMonkey;i >=1;i--){
			mokeyList.insertFirst(i);
		}
		
		//开始报数
		Monkey king = sk.selectKing(mokeyList,numOfMonkey,targetNum);
		System.out.println("the king is : "+ king.no);
	}
	
	public String getFileInfo(String filePath) throws IOException{
		Scanner input = new Scanner(new File(filePath));
		String temp = input.nextLine();
		input.close();
		return temp;
	}
	
	public Monkey selectKing(MonkeyList list,int numOfMonkey,int targetNum){
		Monkey current = list.first;
		Monkey previous = list.first;
		int moveNum = 1;
		while(current.next != current){			
			if(moveNum == targetNum){
				previous.next = current.next;//退出圈
				moveNum = 0;
			}else{
				previous = current;
			}	
			current = current.next;
			moveNum++;
		}
		return current;
	}
	
}

class Monkey{
	public int no;
	public Monkey next;
	
	public Monkey(int n){
		this.no = n;
	}
	public void display(){
		System.out.println(no);
	}
}

class MonkeyList{
	public Monkey first;
	public Monkey last;
	int num;
	
	public MonkeyList(){
		first = null;
		last = null;
		num = 0;
	}
	//加入元素
	public void insertFirst(int no) {
		Monkey newMonkey = new Monkey(no);
		newMonkey.next = first;
		first = newMonkey;
		
		//循环链表构建
		num++;
		if(num == 1){
			last = newMonkey;
		}
		last.next = first;
	}
	//删除元素,返回删除的元素
	public Monkey delete(int no){
		Monkey current = first;
		Monkey previous = first;
		while(current.no != no){
			if(current.next == null)
				return null;
			else{
				previous = current;
				current = current.next;
			}
		}
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
				
		return current;
	}
			
	//查找元素，返回找到的元素
	public Monkey find(int no){
		Monkey current = first;
		while(current.no != no){
			if(current.next == null){
				return null;
			}else{
				current = current.next;
			}
		}
		return current;
	}
	//打印链表
	public void displayMonkeyLink(){
		System.out.println("link (first --> last):");
		Monkey current = first;
		while(current.next != null){
			current.display();
			System.out.println(" ");
			current = current.next;
		}
	}
}
