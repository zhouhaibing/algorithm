package com.zhb.sort;


public class Sort {
	public static void main1(String[] args){
		System.out.println("hello world!");
		int[] a ={1,66,4,5,8,20,3,77,100,34};
		System.out.println(a.length);
		Sort.quickSort11(a, 0, a.length - 1);
		for(int i : a){
			System.out.print(i + " ");
		}
		/*简单的冒泡排序
		for(int i = 0; i < a.length - 1; i++){
			for(int j = 0; j < a.length - 1- i; j++ ){
				if(a[j] > a[j+1]){
					int temp = 0;
					temp = a[j];
				    a[j] = a[j + 1];
				    a[j+1] = temp;
				}
				
			}
		}
		
		
		}
		
		
		//选择排序
		for(int i = 0; i < a.length - 1; i++){
			int min = a[i];
			int minIndex = i;
			for(int j = i + 1; j < a.length - 1; j++){
				if(a[j] < min){
					min = a[j];
					minIndex = j;
				}
			}
			if(a[i] > min){
				int temp = a[i];
				a[i] = min;
				a[minIndex] = temp;
			}
		}
		
		*/
		
		//快速排序，交换次数比较多
		//quickSort(a,0,9);
		
		//Sort hw = new Sort();
		//hw.myQuickSort(a, 0, 9);
		//hw.quickSort(a,0,9);
		
		//for(Integer v:a){
			//System.out.print(v + " ");
		//}
		
	}
	
	//快排算法，交换次数比较多
	public static void quickSort(int a[], int start, int end)
	{        int i,j;
	         i = start;
	         j = end;
	         if((a==null)||(a.length==0))
	             return;
	         while(i<j){
	             while(i<j && a[i]<=a[j])     //以数组start下标的数据为key，右侧扫描
	             j--;
	             if(i<j){                   //右侧扫描，找出第一个比key小的，交换位置
	                 int temp = a[i];
	                 a[i] = a[j];
	                 a[j] = temp;
	             }
	             while(i<j&&a[i]<a[j])    //左侧扫描（此时a[j]中存储着key值）
	                 i++;
	             if(i<j){                 //找出第一个比key大的，交换位置
	                 int temp = a[i];
	                 a[i] = a[j];
	                 a[j] = temp;
	             }
	        }
	        if(i - start > 1) {
	             //递归调用，把key前面的完成排序
	            quickSort(a,0,i-1);
	        }
	        if(end - j > 1){
	            quickSort(a,j+1,end);    //递归调用，把key后面的完成排序
	        }
	}
	
	
	//排序算法，交换次数少，效率高
	private  <T extends Comparable<? super T>> void quickSort(T[] targetArr,
            int start, int end) {
       int i =  start, j = end;
       T key = targetArr[start];
        
       while(i < j) {
           //按 j -- 方向遍历目标数组，直到比 key 小的值为止
           while(j > i && targetArr[j].compareTo(key) >= 0) {
               j --;
           }
           if(i < j) {
               // targetArr[i] 已经保存在key中，可将后面的数填入
               targetArr[i] = targetArr[j];
           }
           //按 i ++ 方向遍历目标数组，直到比 key 大的值为止
           while(i < j && targetArr[i].compareTo(key) < 0) {
               i ++;
           }
           if(i < j) {
               // targetArr[j] 已保存在targetArr[i]中，可将前面的值填入
               targetArr[j] = targetArr[i];
           }
       }
       // 此时 i == j
       targetArr[i] = key;
        
       if(i - start > 1) {
           // 递归调用，把key前面的完成排序
           this.quickSort(targetArr, start, i - 1);
       }
       if(end - j > 1) {
           // 递归调用，把key后面的完成排序
           this.quickSort(targetArr, j + 1, end);
       }
   }


    private <T extends Comparable<? super T>> void myQuickSort(T[] list,int start,int end){
    	int i = start;
    	int j = end;
    	T key = list[i];
    	
    	while(i < j){
    		while(i < j && key.compareTo(list[j]) <= 0){
    			j--;
    		}
    		if(i < j ){
    			list[i] = list[j];//list[i]的值已经赋值给key了
    		}
    
    	
    	while(i < j && key.compareTo(list[i]) > 0){
    		i++;
    	}
    	if(i < j){
    		list[j] = list[i];
    	}
    }
    list[i] = key;
    
    //此时I和j是相等的
    if(i - start > 1){
    	this.myQuickSort(list,0,i - 1);
    }
    if(end - j > 1){
    	this.myQuickSort(list,j + 1,end);
    }
    
  
}
    
	public static void quickSort11(int[] array,int start,int end){		
			int i = start;
			int j = end;
			int key = array[i];
			while(i < j){
				while(i < j && key < array[j])
					j--;
				if(i < j)
					array[i] = array[j];
				while(i < j && key > array[i])
					i++;
				if(i < j)
					array[j] = array[i];
			}
			array[i] = key;//i和j处于相等
			if(i-start > 1)
				quickSort(array,start,i-1);
			if(end-i > 1)
				quickSort(array,i+1,end);
	}
	
	
	
	// 插入排序
	public static void insertSort(int[] array){
		for(int i=1; i < array.length; i++){
			int temp = array[i];
			int j;
			for(j = i; j > 0;j--){
				if(temp < array[j - 1]){
					array[j] = array[j - 1];
				} else {
					break;
				}
			}
			array[j] = temp;
			
		}
	}
	
	public static void main(String[] args){
		int[] array = new int[]{5,3,2,9,23,7,1};
		insertSort(array);
		for(int i : array){
			System.out.print(i + " ");
		}
	}


	
}

