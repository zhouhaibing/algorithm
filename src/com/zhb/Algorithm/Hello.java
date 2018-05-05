package com.zhb.Algorithm;


public class Hello {
	public static void main(String[] args) throws Exception {
		
		System.out.println(getMaxAfterCutting(8));
		System.out.println(getMaxAfterCutting2(8));
		
		/*int[] arrs = {-2,11,-4,13,-5,-2};
		System.out.println(getSubSeqSum2(arrs));
		System.out.println(getSubSeqSum3(arrs));
		int[] returns = getSubSeqSum3(arrs);
		for(int i=0;i<returns.length;i++){
			System.out.print(returns[i] + " ");
		}
		
		bubbleSort(arrs);
		for(int i=0;i<arrs.length;i++){
			System.out.print(arrs[i] + " ");
		}
		int[] sum = new int[]{};
		//sum[0] = 3;
		System.out.println( " " + sum.length);*/
	}
	
	
	
	
	
	//剪绳子   贪心算法  O(1) O(1)  
	public static int getMaxAfterCutting2(int len) throws Exception {
		if(len < 0) throw new Exception();
		if(len < 2){
			return 0;
		}
		if(len == 2){
			return 1;
		}
		if(len == 3){
			return 2;
		}
		int timesOf3 = len / 3;
		if(len - timesOf3 * 3 == 1){
			timesOf3 -= 1;
		}
		int timeOf2 = (len - timesOf3 * 3) / 2;
		return (int)Math.pow(2, timeOf2) * (int)Math.pow(3, timesOf3);
					
	}
	
	
	
	// 剪绳子问题。   f(n) = max(f(1)f(2)..f(n-1)) 问题. 这个公式是自上而下的，我们可以自下而上。先求出f(1),f(2).... 一直到f(n)
	// 子问题的最优解存储在f数组中，数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。  
	// 空间/时间效率 O(n)  O(n^2)
	public static int getMaxAfterCutting(int len) throws Exception{
		if(len < 0) throw new Exception();
		if(len < 2){
			return 0;
		}
		if(len == 2){
			return 1;
		}
		if(len == 3){
			return 2;
		}
		int[] cuts = new int[len+1];
		cuts[0]=0;
		cuts[1]=1;
		cuts[2]=2;
		cuts[3]=3;
		for(int i=4;i<=len;i++){
			int max = 0;
			for(int j=1;j<=i/2;j++){
				int temp = cuts[j] * cuts[i-j];
				if(temp > max){
					max = temp;
				}
			}
			cuts[i] = max;
		}
		int result = cuts[len];
		return result;
	}
	
	/*
	 *  arr = [1, 7 ,3 ]
		n = 1234
		用arr中的数组成比n大的最小的数。 可以重复使用。
	 */
	public int getNumCompareN(int[] arrs, int n){
		
	}
	
	// [2,30,5, 23, 13,67, 12]  股票买入卖出， 一次交易
	public int getMax(int[] prices) {
		int i = 0;
		int min = Integer.MAX_VALUE;
		int maxVal = 0;
		while(i < prices.length){
			if(prices[i] < min){
				min = prices[i];
			}
			int gap = prices[i] - min;
			if (gap > maxVal){
				maxVal = gap;
			}
		}
		return maxVal;
	}
	
	// 多次交易. 到最后面相当于是一个求最大字段和的问题了
	public int getMax2(int[] prices){
		int[] sum = new int[prices.length -1];
		sum[0] = prices[1] - prices[0];
		int max = sum[0];
		for(int i=1;i<prices.length-1;i++){
			if(sum[i -1] > 0){
				sum[i] = sum[i-1] + (prices[i+1]-prices[i]);
			} else {
				sum[i] = (prices[i+1]-prices[i]);
			}
			if(sum[i] > max){
				max = sum[i];
			}
		}
		return max;
	}
	
	
	
	// 最大字段和 O(n^3)
	public static int getSubSeqSum(int[] arrs){
		int max =0;
		for(int i=0;i<arrs.length -1;i++){
			for(int j=i+1;j<arrs.length;j++){
				int tmpSum = 0;
				for(int k=i;k<=j;k++){
					tmpSum += arrs[k];
				}
				if (tmpSum > max) {
					max = tmpSum;
				}
			}
		}
		return max;
	}
	
	// O(n) b[j] = max(b[j-1]+a[j],a[j])
	public static int getSubSeqSum2(int[] arrs){
		int[] sum = new int[arrs.length];
		sum[0] = arrs[0];
		int max= sum[0];
		for(int i=1;i<arrs.length;i++){
			if(sum[i-1] > 0){
				sum[i] = sum[i-1] + arrs[i];
			}else{
				sum[i] = arrs[i];
			}
			if(sum[i] > max){
				max = sum[i];
			}
		}
		return max;
	}
	
	// O(n) b[j] = max(b[j-1]+a[j],a[j]), return int[], first max, second startIndex, third endIndex
	public static int[] getSubSeqSum3(int[] arrs){
		int[] sum = new int[arrs.length];
		int[] returns = new int[3];
		sum[0] = arrs[0];
		returns[0]= sum[0];
		for(int i=1;i<arrs.length;i++){
			if(sum[i-1] > 0){
				sum[i] = sum[i-1] + arrs[i];
			}else{
				sum[i] = arrs[i];
				returns[1] = i;
			}
			if(sum[i] > returns[0]){
				returns[0] = sum[i];
				returns[2] = i;
			}
		}
		return returns;
	}
	
	public static void bubbleSort(int[] arrs){
		for(int i=0;i<arrs.length-1;i++){
			for(int j=0;j<arrs.length-i-1;j++){
				if(arrs[j] > arrs[j+1]){
					int temp = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = temp;
				}
			}
		}
	}
	

}
