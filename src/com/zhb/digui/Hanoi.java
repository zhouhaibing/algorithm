package com.zhb.digui;

import java.util.Scanner;

/**
 * 
 * @author Administrator
 * ��ŵ��
 * ����������A   B   C  ����������������
 * ��Ҫ��A�ĵ��ӰᵽC����
 * ���ƹ���1.ÿ��ֻ�ܰ�һ�� 
 * 2��Բ�̿��Բ�������һ�������� 
 * 3���κ�ʱ�̶����ܽ�һ���ϴ��Բ�̷���һ����С��Բ����
 * ������N�ĸ�����,2 ^ N - 1��
 */
public class Hanoi {
	public static int n = 1;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		hanoi(num,'A','B','C');
	}
	
	//��ŵ���ݹ����
	public static void hanoi(int i,char A,char B,char C){
		if(i == 1){
			move(i,A,C);
		}else{
			hanoi(i - 1,A,C,B);
			move(i,A,C);
			hanoi(i - 1,B,A,C);
		}
	}
	
	//�ƶ�����
	public static void move(int i,char a , char b){
		System.out.println((n++) + ": " + i + " ��"+a+"�Ƶ�"+b);
	}

}
