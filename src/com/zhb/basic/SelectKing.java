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
 *	����ѡ����  ѭ��������
 *  ��Ŀ������
 *  ����������-����ѡ��������Mֻ����Ҫѡ������ѡ�ٰ취���£����к��Ӱ�1-M���Χ��һȦ����1�ſ�ʼ��˳��1��2������K������������K�ĺ����˳���Ȧ�⣬���ѭ��������ֱ��Ȧ��ֻʣ��һֻ����ʱ����ֻ���Ӿ��Ǵ�����M��K�������ļ��ṩ��Ҫ��������ļ��д�ӡ�����ʣ�µĺ��ӵı�š����ݹ�ģ��M<=1000,K<=10��
	�������ļ���
		�����ļ�monkey.in �ĵ�1 �У�Ϊ��������������һ���ո����:
		M K
	������ļ���
		����ļ�monkey.out ֻ��һ��������,������һ�����ӵı��
	������������
		7 3
	�����������
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
		int numOfMonkey = Integer.parseInt(infoStrArray[0]);//����
		int targetNum = Integer.parseInt(infoStrArray[1]);//��Ȧ�ı���
		//��ʼ����������ѭ������
		MonkeyList mokeyList = new MonkeyList();
		for(int i=numOfMonkey;i >=1;i--){
			mokeyList.insertFirst(i);
		}
		
		//��ʼ����
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
				previous.next = current.next;//�˳�Ȧ
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
	//����Ԫ��
	public void insertFirst(int no) {
		Monkey newMonkey = new Monkey(no);
		newMonkey.next = first;
		first = newMonkey;
		
		//ѭ��������
		num++;
		if(num == 1){
			last = newMonkey;
		}
		last.next = first;
	}
	//ɾ��Ԫ��,����ɾ����Ԫ��
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
			
	//����Ԫ�أ������ҵ���Ԫ��
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
	//��ӡ����
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
