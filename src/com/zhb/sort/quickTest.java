package com.zhb.sort;

public class quickTest {
	public static void main(String[] args) {
		int[] arrs = new int[]{123,23, 3, 2,6,9,1,5};
		quickSort(arrs, 0, arrs.length - 1);
		//mergeSort(arrs, 0, arrs.length - 1);
		for(int i=0; i < arrs.length; i++){
			System.out.print(arrs[i] + " ");
		}
	}
	
	public static void mergeSort(int[] arrs, int start, int end){
		int mid = (start + end) / 2;
		if (start < end) {
			mergeSort(arrs, start, mid);
			mergeSort(arrs, mid + 1, end);
			merge(arrs, start, mid, end);
		}
	}
	
	public static void merge(int[] arrs, int start, int mid, int end) {
		int[] newArrs = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= end) {
			 if (arrs[i] < arrs[j]){
				 newArrs[k++] = arrs[i++];
			 } else {
				 newArrs[k++] = arrs[j++];
			 }
		}
		while(i <= mid){
			newArrs[k++] = arrs[i++];
		}
		while(j <= end){
			newArrs[k++] = arrs[j++];
		}
		for(int n=0; n < newArrs.length; n++){
			arrs[start + n] = newArrs[n];
		}
	}
	
	public static void quickSort(int[] arrs, int start, int end) {
		int i = start;
		int j = end;
		int key = arrs[start];
		while(i < j) {
			while(i < j && key < arrs[j]){
				j--;
			}
			if (i < j) {
				arrs[i] = arrs[j];
			}
			
			while(i < j && key > arrs[i]){
				i++;
			}
			if (i < j){
				arrs[j] = arrs[i];
			}
		}
		System.out.println("i:" + i + " j:" + j);
		arrs[i] = key;
		
		if (i - start > 0){
			quickSort(arrs, start, i - 1);
		}
		if (end - i > 0) {
			quickSort(arrs, i+1, end);
		}
	}
	
	
	
	

}
