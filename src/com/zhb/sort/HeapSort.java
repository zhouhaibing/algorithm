package com.zhb.sort;

public class HeapSort {

	public void minHeapIfy(int[] array, int len, int i) { // 维护
		int left = 2 * i;
		int right = left + 1;
		int father = i;
		if (left <= len && array[left] < array[father]) {
			father = left;
		}
		if (right <= len && array[right] < array[father]) {// 右边的最小
			father = right;
		}
		if (father != i) {
			int temp = array[i];
			array[i] = array[father];
			array[father] = temp;
			minHeapIfy(array, len, father);
		}
	}

	public void buildMinHeap(int[] array, int len) {
		for (int i = (len - 1) / 2; i >= 0; i--) {
			minHeapIfy(array, len, i);
		}
	}

	public void heapSort(int[] array, int len) {
		buildMinHeap(array, len - 1);// 先构建最小堆
		for (int i = 0; i < len; i++) {
			System.out.print(array[i] + " ");
		}
		for (int i = len - 1; i >= 0;) {// 第一个数是最小的
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			i--;
			minHeapIfy(array, i, 0);
		}
	}

	public static void main(String[] args) {
		int[] dd = {5,7,3,8,1,9,20,4,111, 23, 34};
		HeapSort hs = new HeapSort();
		hs.heapSort(dd, 11);
		System.out.println();
		for(int i : dd){
			System.out.print(i + " ");
		}
	}

}
