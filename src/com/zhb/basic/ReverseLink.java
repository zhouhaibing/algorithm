package com.zhb.basic;

import java.util.Scanner;


public class ReverseLink {
	public static void main(String[] args) {
		reverseLink();
	}

	public static void reverseLink() {
		Node head = initLink();
		System.out.println("print initial link:");
		printLink(head);
		System.out.println("\nprint reversed link:");
		Node end = startReverseLink(head);
		printLink(end);
	}

	public static Node initLink() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入你要输入的数字个数：");
		int num = input.nextInt();
		
		String firstChar = input.next();
		Node head = new Node(firstChar,null);
		
		Node first = head;
		for (int i = 0; i < num -1; i++) {
			Node next = new Node(input.next(), null);
			first.next = next;
			first = next;
		}
		return head;
	}

	public static Node startReverseLink(Node current) {
		Node pre = null;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = pre;

			pre = current;
			current = next;
		}
		return pre;

	}

	public static void printLink(Node head) {
		
		Node first = head;
		while (first != null) {
			System.out.print(first.value + " ");
			first = first.next;
		}
	}

	static class Node {
		String value;
		Node next;

		public Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

}
