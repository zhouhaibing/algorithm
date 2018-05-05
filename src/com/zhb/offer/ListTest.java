package com.zhb.offer;

public class ListTest {
	public static void main(String[] args){
		int[] aas = new int[]{9,7,5,3,1,100,55,66,77};
		LinkList ll = new LinkList();
		for(int a :aas){
			ll.insertFirst(a);
		}
		ll.printList();
		//Node newHead = ll.reverseList(ll.first);
		//System.out.println();
		//ll.printList2(newHead);
		System.out.println();
		Node target = ll.LastKNode(ll.first, 3);
		System.out.println(target.data);
	}
	
	public static void javaTest(){
		
	}
	
	


}



class LinkList {
	public Node first;
	public int size;
	public void insertFirst(int input){
		Node node = new Node(input);
		node.next = first;
		first = node;
		size++;
	}
	
	public int size(){
		return this.size;
	}
	
	public void printList(){
		Node current = first;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	public void printList2(Node head){
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	//反转一个链表
	public static Node reverseList(Node first){
		Node current = first;
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
	
	// 倒数第K个节点
	public Node LastKNode(Node head, int k){
		if (head == null){
			return null;
		}
		if (k > size){
			return null;
		}
		Node first = head;
		Node end = head;
		for(int i = 0; i < k - 1; i++){
			first = first.next;
		}
		
		while(first.next != null) {
			first = first.next;
			end = end.next;
		}
		
		return end;
		
	}
	
}

class Node {
	public int data;
	public Node next;
	
	public Node(int data){
		this.data = data;
	}
	
	
}

