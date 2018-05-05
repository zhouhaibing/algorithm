package com.zhb.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Administrator
 * ջ:����ȳ�  LIFO
 * ջӦ��ʵ����1.�ַ�������  2.�ָ���ƥ��
 * 
 */
class MyStack {
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public MyStack(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	//��ջ
	public void push(long a){
		if(isFull()){
			System.out.println("the stack is full");
		}else{
			stackArray[++top] = a;
		}
	}
	//��ջ
	public long pop(){
		if(isEmpty()){
			System.out.println("the stack is empty");
		}else{
			return stackArray[top--];
		}
		return 0;
	}
	//ȡջ��
	public long peek(){
		if(isEmpty()){
			System.out.println("the stack is empty");
		}else{
			return stackArray[top];
		}
		return 0;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	public boolean isFull(){
		return (top == maxSize -1);
	}
}

public class StackTest{
	public static void main(String[] args){
		/*MyStack ms = new MyStack(5);
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(6);
		ms.push(7);
		while(!ms.isEmpty()){
			System.out.print(ms.pop() + " ");
		}*/
		
		
		int[] aa = {1,2,3,4,7,8};
		System.out.println(queueOfStack(aa));
		
	}
	
	
	// use two stack to implement a queue
	public static List<Integer> queueOfStack(int[] inputs){
		if(inputs == null || inputs.length == 0){
			return null;
		}
		List<Integer> outputs = new ArrayList<>();
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while(!stack2.isEmpty()){
			outputs.add(stack2.pop());
		}
		for(int i=0;i<inputs.length;i++){
			stack1.push(inputs[i]);
		}
		
		while(!stack1.isEmpty()){
			int ele = stack1.pop();
			stack2.push(ele);
		}
		while(!stack2.isEmpty()){
			outputs.add(stack2.pop());
		}
		return outputs;
	}
	
	//public static void 
}
