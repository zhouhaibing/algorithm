package com.zhb.sort;

public class Hello {
	
	
	public static void bubbleSort(int[] array){
		for(int i=0; i < array.length - 1; i++){
			for(int j=0; j < array.length - i -1; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	public static void selectSort(int[] array){
		for(int i=0; i < array.length - 1; i++){
			int minIndex = i;
			int minValue = array[i];
			for(int j=i+1; j < array.length;j++){
				if(minValue > array[j]){
					minIndex = j;
					minValue = array[j];
				}
			}
			if(minIndex != i){
				int temp = array[i];
				array[i] = minValue;
				array[minIndex] = temp;
			}
		}
	}
	
	
	public static void quickSort(int[] array,int start, int end){
		int i = start;
		int j = end;
		int target = array[i];
		while(i < j){
			while(i < j && target <= array[j]){
				j--;
			}
			if(i < j){
				array[i] = array[j];
			}
			while(i < j && target >= array[i]){
				i++;
			}
			if(i < j){
				array[j] = array[i];
			}
		}
		array[i] = target;
		if(i - start > 1){
			quickSort(array, start, i-1);
		}
		if(end - j > 1){
			quickSort(array, j+1, end);
		}
	}
	
	public static void mergeSort(int[] array, int start, int end){
		int mid = (start + end) / 2;
		if(start < end){
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			merge(array, start, mid, end);
		}
	}
	
	public static void merge(int[] array, int start, int mid, int end){
		int[] newArray = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= end){
			if(array[i] <= array[j]){
				newArray[k++] = array[i++];
			}else {
				newArray[k++] = array[j++];
			}
		}
		while(i <= mid){
			newArray[k++] = array[i++];
		}
		while(j <= end){
			newArray[k++] = array[j++];
		}
		
		for(int k2=0; k2 < newArray.length; k2++){
			array[start + k2] = newArray[k2];
		}
	}
	
	public static void insertSort(int[] array){
		for(int i=1; i < array.length;i++){
			int temp = array[i];
			int j;
			for(j = i;j > 0; j--){
				if(temp < array[j-1]){
					array[j] = array[j-1];
				}else{
					break;
				}
			}
			array[j] = temp;
		}
	}
	
	
	
	public static void main(String[] args){
		int[] dd = {5,7,3,8,1,9,20,4,111, 23, 34};
		//bubbleSort(dd);
		//selectSort(dd);
		//quickSort(dd, 0, dd.length - 1);
		//mergeSort(dd,0, dd.length - 1);
		insertSort(dd);
		for(int i : dd){
			System.out.print(i + " ");
		}
	}
	

}
