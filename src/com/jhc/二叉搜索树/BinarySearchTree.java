package com.jhc.二叉搜索树;

public class BinarySearchTree<T extends Comparable<T>> {
	private class Node<T>{
		public T data;
		public Node<T> left;
		public Node<T> right;
		public Node(T data1){
			this(data1,null,null);
		}
		public Node(T data,Node<T> left,Node<T> right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	private Node<T> root;
	/**
	 * 没有参数默认初始化为null
	 */
	public BinarySearchTree(){
		this.root = null;
	}
	public void makeEmpty(){
		this.root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean contains(T value){
		return contains(root,value);
	}
	public boolean contains(Node<T> root,T value){
		if(root == null){
			return false;
		}
		int result = value.compareTo(root.data);
		if(result < 0){
			return contains(root.left,value);
		}else if(result > 0){
			return contains(root.right,value);
		}else{
			return true;
		}		
	}
	/**
	 * 查找最小值分为两个方法一个是用来查找最小的值
	 * 一个用来查找最小的节点
	 * 查找最小的节点先判断根节点是不是为null
	 * 如果判断不为null 然后去判断是否含有左结点
	 * @return
	 */
	public T findMin(){
		return findMin(root).data;
	}
	public Node<T> findMin(Node<T> root){
		if(root == null){
			return null;
		}else if(root.left == null){
			return root;
		}
		return findMin(root.left);
	}
	public T findMax(){
		return findMax(root).data;
	}
	public Node<T> findMax(Node<T> root) {
		if(root == null){
			return null;
		}else if(root.right == null){
			return root;
		}
		
		return findMax(root.right);
	}
	/**
	 * 插入值 返回的是根节点
	 */
	public void insert(T value){
		root = insert( value,root);
	}
	public Node<T> insert(T value,Node<T> root){
		if(root == null){
			return new Node(value,null,null);
		}
		int result = value.compareTo(root.data);
		if(result < 0){
			root.left = insert(value,root.left);
		}else if(result > 0){
			root.right = insert(value,root.right);
		}
		return root;
	}
	/**
	 * 删除节点
	 * 首先确定节点的位置
	 * 确定完位置以后的基础之上在去判断如果只有一个结点或者没有子节点直接删除就可以了赋值为null
	 * 如果有两个结点 
	 * 首先赋值把当前值改成右子树最小的值 然后在右子树中删除那个值
	 * 
	 * @param value
	 */
	public void remove(T value){
		root = remove(root,value);
	}
//	private Node<T> remove(T value, Node<T> t) {
//		         if(t==null){
//		            return t;
//		         }
//		        
//		         int result=value.compareTo(t.data);
//		         if(result<0){
//		             t.left=remove(value,t.left);
//	         }else if(result>0){
//		             t.right=remove(value,t.right);
//	         }else if(t.left!=null&&t.right!=null){//如果被删除节点有两个儿子
//		            //1.当前节点值被其右子树的最小值代替
//		             t.data=findMin(t.right).data;
//		             //将右子树的最小值删除
//	             t.right=remove(t.data, t.right);
//	         }else{
//	            //如果被删除节点是一个叶子 或只有一个儿子
//	            t=(t.left!=null)?t.left:t.right;
//		         }
//	       
//	        return t;
//		     }
	private Node<T> remove(Node<T> root,T value){
		if(root == null){
			return root;
		}
		int result = value.compareTo(root.data);
		if(result < 0){
			root.left = remove(root.left,value);
		}else if(result > 0){
			root.right = remove(root.right,value);
		}else if(root.left != null && root.right != null){
			root.data = findMin(root.right).data;
			root.right = remove(root.right,root.data);
		}else{
			root = (root.left!=null)?root.left:root.right;
		}
		return root;
	}
	/**
	 * 中序遍历
	 */
	public void LDRTree(){	
		LDRTree(root);
	}
	private void LDRTree(Node<T> root){
		if(root!=null){
			LDRTree(root.left);
			System.out.println(root.data);
			LDRTree(root.right);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
