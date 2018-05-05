package com.zhb.digui;

import java.util.Arrays;

/**
 * 
 * @author Administrator
 * ���ֲ��ң��ǵݹ�ʵ��
 * �����ǣ�
 */
public class BinarySearch {
	public static void main(String[] args){
		int[] array = {2,1,3,4,5,6,7};
		Arrays.sort(array);//ʹ�ö��ַ���ʱ�������򣬵��õĿ�������Ч��O(n log(n)) 
		for(int i : array) System.out.print(i + " ");
		//int findIndex = binaryFind(array,3);
		int findIndex = recFind(array,3,0,array.length - 1);
		System.out.println(findIndex);
	}
	
	// 二分查找
	public static int binaryFind(int[] array,int num){
		int start = 0;
		int end = array.length - 1;
		while(end >= start){
			int middle = (start + end) / 2;
			if(num == array[middle]){
				return middle;
			}else if(num > array[middle]){
				start = middle + 1;
			}else{
				end = middle - 1;
			}
		}
		return -1;
	}
	
	//ʹ�õݹ�ķ���
	public static int recFind(int[] array,int num,int start,int end){
		int middle = (start + end) / 2;
		if(array[middle] == num){
			return middle;
		}else if(start > end){
			return array.length;
		}else{
			if(array[middle] > num)
				return recFind(array,num,start,middle - 1);
			else
				return recFind(array,num,middle + 1,end);
		}
	}
}
