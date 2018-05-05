package com.zhb.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Administrator
 * 反转一个栈或链表
 */
public class ReverseStackOrLink {
	public static void main(String[] args){
		Stack<String> stack = new Stack<String>();
		stack.push("zhou");
		stack.push("hai");
		stack.push("bing");
		stack.push("haha");
		//displayStack(stack);
		reverseStack(stack);
		displayStack(stack);
		
		System.out.println("-------------------");
		reverseLink();
	}
	
	public static void displayStack(Stack<String> stack){
		while(stack.size() > 0)
			System.out.print(stack.pop() + " ");
	}
	
	public static void reverseStack(Stack<String> stack){
		Queue<String> queue = new LinkedList<String>();
		while(stack.size() > 0){
			queue.offer(String.valueOf(stack.pop()));
		}
		while(queue.size() > 0){
			stack.push(String.valueOf(queue.poll()));
		}
	}
	
	public static void reverseLink(){
		Node head = initLink();
		System.out.println("print link:");
		printLink(head);
		Node end = startReverseLink(head);
		System.out.println("print link:");
		printLink(end);
	}
	public static Node initLink(){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入你要输入的数字个数：");
		int num = input.nextInt();
		
		String firstChar = input.next();
		Node head = new Node(firstChar,null);
		Node first = head;
		for(int i=0;i<num-1;i++){			
			Node next = new Node(input.next(),null);
			first.next = next;
			first = next;
		}
		return head;
	}
	public static Node startReverseLink(Node current){
		Node pre = null;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = pre;
			
			pre = current;
			current = next;
		}
		return pre;
		
	}
	public static void printLink(Node head){
		
		Node first = head;
		while(first != null){
			System.out.print(first.value  + " ");
			first = first.next;
		}
	}
	static class Node{
		String value;
		Node next;
		public Node(String value,Node next){
			this.value = value;
			this.next = next;
		}
	}
	
}


