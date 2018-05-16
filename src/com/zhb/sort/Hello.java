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
	
	
	// 无序大数组中寻找中位数
	// 1. 对数组进行排序， 快速排序 nlgn
	
	// 2. 类似于快速排序的二分法， 如果选取的中间点正好处于中间
	public static double median2(int[] array) {
	    if(array==null || array.length==0) return 0;
	    int left = 0;
	    int right = array.length-1;
	    int midIndex = right >> 1;
	    int index = -1;
	    while(index != midIndex){
	        index = partition(array, left, right);
	        if(index < midIndex) left = index + 1;
	        else if (index > midIndex) right = index - 1;
	        else break;
	    }
	    return array[index];
	}

	public static int partition(int[] array, int left, int right) {
	    if(left > right) return -1;
	    int pos = right;
	    right--;
	    while(left <= right){
	        while(left<pos && array[left]<=array[pos]) left++;
	        while(right>left && array[right]>array[pos]) right--;
	        if(left >= right) break;
	        swap(array, left, right);
	    }

	    swap(array, left, pos);
	    return left;
	}
	
	public static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static int partition2(int[] array, int left, int right) {
		if (left > right) return -1;
		int key = array[left];
		int i = left;
		int j = right;
		while(i < j){
			while(i < j && array[j] > key){
				j--;
			}
			if(i<j){
				array[i] = array[j];
			}
			while(i<j && array[i] < key){
				i++;
			}
			if(i<j){
				array[j] = array[i];
			}
		}
		array[i] = key;
		return i;
	}
	
	// 最小堆的实现
	
	
	
	
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
		System.out.println();
		long startTime = System.nanoTime();
		System.out.println(median2(dd));
		System.out.println(System.nanoTime() - startTime);
	}
	

}
