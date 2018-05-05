package com.zhb.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author zhb
 * 二叉树
 * 
 */
public class BinaryTree {
	private Node root;
	public BinaryTree(){
		this.root = null;
	}
	
	public void createTree(Node node,int data){
		if(root == null){
			root = new Node(data);
		}else{
			if(data < node.data){
				if(node.lchild == null){
					node.lchild = new Node(data);
				}else{
					createTree(node.lchild,data);
				}
			}else{
				if(node.rchild == null)
					node.rchild = new Node(data);
				else
					createTree(node.rchild,data);
			}
		}			
	}

	//前序遍历
	public void preOrder(Node root){
		if(root != null){
			System.out.print(root.data + " ");
			preOrder(root.lchild);
			preOrder(root.rchild);
		}
	}
	
	//中序遍历
	public void midOrder(Node root){
		if(root != null){
			midOrder(root.lchild);
			System.out.print(root.data + " ");
			midOrder(root.rchild);
		}
	}
	
	//后序遍历
	public void nextOrder(Node node){
		if(node != null){
			nextOrder(node.lchild);
			nextOrder(node.rchild);
			System.out.print(node.data + " ");
		}
	}
	
	//深度优先搜索
	public void depthOrder(Node node){
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		Node current = null;
		while(!stack.isEmpty()){
			current = stack.pop();
			System.out.print(current.data + " ");
			if(current.rchild != null)
				stack.push(current.rchild);
			if(current.lchild != null)
				stack.push(current.lchild);
		}
	}
	//广度优先搜索
	public void widthOrder(Node node){
		Queue<Node> queue = new LinkedList<Node>();
	    queue.offer(node);
		Node current = null;
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current.data + " ");
			if(current.lchild != null)
				queue.offer(current.lchild);
			if(current.rchild != null)
				queue.offer(current.rchild);
		}
	}
	
	//find node
	public Node findNode(int key){
		Node current = root;
		while(current.data != key){
			if(key < current.data){
				current = current.lchild;
			}else{
				current = current.rchild;
			}
			if(current == null)
			   return null;
		}
		return current;
	}
	
	//����һ���ڵ㣬�Ƚ����Ҵ�С���ҵ��սڵ���롣��ʵ�������createTree�ķǵݹ�ʵ��
	public void insertNode(int key){
		Node newNode = new Node(key);
		if(root == null){
			root = newNode;
		}
		Node current = root;
		Node parent;
		while(true){
			parent = current;
			if(key < current.data){
				current = current.lchild;
				if(current == null){
					parent.lchild = newNode;
					return;
				}
			}else{
				current = current.rchild;
				if(current == null){
					parent.rchild = newNode;
					return;
				}
			}
		}
	}
	//����Сֵ
	public Node minNode(){
		Node current = root;
		while(current.lchild != null){
			current = current.lchild;
		}
		return current;
	}
	
	//ɾ���ڵ�
	public boolean deleteNode(int key){
		Node current = root;
		Node parent = null;
		boolean isLeftChild = false;
		while(current.data != key){
			parent = current;
			if(key < current.data){
				isLeftChild=true;
				current = current.lchild;
			}else{
				isLeftChild=false;
				current = current.rchild;
			}
			if(current == null){//�Ҳ���
				return false;
			}
		}
		/*if(current.lchild == null && current.rchild == null){//Ҷ�ӽڵ�
			if(parent.lchild != null && parent.lchild.data == key)
				parent.lchild = null;
			else
				parent.rchild = null;
			//current = null;����ֱ�Ӹ�null�Ǵ���ɾ�����ˣ�����Ҫʹ�ø��ڵ㡣
			return true;
		}else{
			return false;
		}*/
		if(current.lchild == null && current.rchild == null){
			if(current == root)
				current = null;
			else if(isLeftChild)
				parent.lchild = null;
			else
				parent.rchild = null;
			//current = null;����ֱ�Ӹ�null�Ǵ���ɾ�����ˣ�����Ҫʹ�ø��ڵ㡣
		}else if(current.lchild != null && current.rchild != null){
			//Ҫɾ���Ľڵ㶼�����Һ���,�Ƚ��鷳
		}else{//ֻ��һ������
			if(current.lchild == null){
				if(current == root)
					root = current.rchild;
				else if(isLeftChild)
					parent.lchild = current.rchild;
				else
					parent.rchild = current.rchild;
			}else{
				if(current == root)
					root = current.lchild;
				if(isLeftChild)
					parent.lchild = current.lchild;
				else
					parent.rchild = current.lchild;
			}
			
		}
		return true;
		
	}
	/*public static void main(String[] args){
		int[] arrays = {32,24,45,2,6,55,66};
		BinaryTree bTree = new BinaryTree();
		for(int i = 0; i < arrays.length; i++){
			bTree.createTree(bTree.root, arrays[i]);
		}
		System.out.print("前序遍历：");
		bTree.preOrder(bTree.root);
		System.out.println();
		bTree.preorder(bTree.root);
		System.out.print("\n中序遍历：");
		bTree.midOrder(bTree.root);
		System.out.print("\n后序遍历：");
		bTree.nextOrder(bTree.root);
		
		System.out.print("\n深度优先遍历：");
		bTree.depthOrder(bTree.root);
		System.out.println();
		bTree.depthSearch(bTree.root);
		System.out.print("\n广度优先遍历：");
		bTree.widthOrder(bTree.root);
		
		Node findNode = bTree.findNode(55);
		System.out.println("\n"+findNode.data );
		System.out.println("------------insert--------------");
		bTree.insertNode(18);//���ַ�����ʵ��һ���ġ�����������һ�����ϲ���Ĺ���
		//bTree.createTree(bTree.root, 18);
		Node findNode1 = bTree.findNode(18);
		System.out.println("\n"+findNode1.data );
		bTree.depthOrder(bTree.root);System.out.println();
		bTree.widthOrder(bTree.root);
		
		System.out.println("------------find min--------------");
		System.out.println(bTree.minNode().data);
		
		System.out.println("------------delete leaf node-------");
		System.out.println(bTree.deleteNode(24));
		bTree.widthOrder(bTree.root);
	}*/
	
	// 前序遍历
	public void preorder(Node root){
		Node currentNode = root;
		if(currentNode != null){
			System.out.print(currentNode.data + " ");
			preorder(currentNode.lchild);
			preorder(currentNode.rchild);
		}
	}
	
	// 深度优先搜索
	public void depthSearch(Node root){
		Stack<Node> stacks = new Stack<Node>();
		stacks.push(root);
		Node current = null;
		while(!stacks.isEmpty()){
			current = stacks.pop();
			System.out.print(current.data + " ");
			if(current.rchild != null){
				stacks.push(current.rchild);
			}
			if(current.lchild != null){
				stacks.push(current.lchild);
			}
		}
	}
	
	// 根据先序遍历和中序遍历，重建二叉树
	public TreeNode reConstructBinaryTree(int [] preOrders,int [] midOrders) {
        if(preOrders == null || preOrders.length == 0 ||  midOrders == null || midOrders.length == 0){
			return null;
		}
        return constructTree(preOrders,0, preOrders.length - 1, midOrders,0,midOrders.length - 1);
    }
    public TreeNode constructTree(int[] preOrders, int preStart,int preEnd, int[] midOrders, int midStart,int midEnd){
		TreeNode root = new TreeNode(preOrders[preStart]);
		
        if(preStart == preEnd && midStart == midEnd && preOrders[preStart] == midOrders[midStart]){
            return root;
        }
		int midRootIndex = 0;
		for(int i=midStart; i <= midEnd; i++){
			if(midOrders[i] == preOrders[preStart]){
				midRootIndex = i;
			}
		}
		System.out.println(midOrders[midRootIndex]);
		
		int leftEndIndex = preStart + (midRootIndex - midStart);
		
		if(leftEndIndex > preStart){
			root.left = constructTree(preOrders,preStart + 1,leftEndIndex, midOrders, midStart, midRootIndex - 1);
		}
		
		if(leftEndIndex < preEnd){
			root.right = constructTree(preOrders, leftEndIndex + 1, preEnd, midOrders, midRootIndex + 1, midEnd);
		}
		
		return root;
	}
    
    public static void main(String[] args){
    	int[] pres = new int[]{1,2,3,4,5,6,7};
    	int[] mids = new int[]{3,2,4,1,6,5,7};
    	BinaryTree bt = new BinaryTree();
    	bt.reConstructBinaryTree(pres, mids);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

// 节点
class Node{
	public Node(){
		
	}
	public Node(int data){
		this.data = data;
		this.lchild = null;
		this.rchild = null;
	}
	public Node(int data,Node lchild,Node rchild){
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	
	public int data;
	public Node lchild;
	public Node rchild;
}




