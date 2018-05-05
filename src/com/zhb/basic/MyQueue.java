package com.zhb.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Administrator
 * 队列:先进先出  FIFO
 * 优先队列：priorityQ 删除数据项小的数，实现：在队尾插入的时候，插入到指定的位置，
 * 相当于是插入排序了
 */
public class MyQueue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	
	public MyQueue(int s){
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long a){
		if(isFull()){
			System.out.println("the queue is full");
		}else{
			if(rear == maxSize - 1)
				rear = -1;
			queArray[++rear] = a;
			nItems++;
		}
	}
	
	public long remove(){
		if(isEmpty()){
			System.out.println("the queue is empty");
		}else{
			if(front == maxSize)
				front = 0;
			nItems--;
			return queArray[front++];
		}
		return 0;
	}
	
	public long peekFront(){
		return queArray[front];
	}
	
	public boolean isFull(){
		if(nItems == maxSize - 1){
			return true;
		}else{
			return false;
		}
	}
	public boolean isEmpty(){
		if(nItems == 0){
			return true;
		}else{
			return false;
		}
	}
	public int size(){
		return nItems;
	}
}

class QueueTest{
	public static void main(String[] args){
		//MyQueue test
		myQueueTest();
		
		//interface queue test
		Queue<String> queue = new LinkedList<String>();
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		System.out.println("\n--interface queue test--\n"+queue.size());
		for(String s : queue){
			System.out.println(s);
		}
		
	}
	
	public static void myQueueTest(){
		MyQueue mq = new MyQueue(5);
		mq.insert(100);
		mq.insert(101);
		mq.insert(102);
		
		mq.remove();
		mq.insert(300);
		mq.insert(301);
		
		while(!mq.isEmpty()){
			System.out.print(mq.remove() + " ");
		}
	}
}
