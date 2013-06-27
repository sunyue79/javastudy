/**
 * 
 */
package com.sunyue.study.tree;

/**
 * @author yuesun00
 *
 */
public class Tree {

	private TreeNode root;

	public Tree(TreeNode root) {
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}
	
	/** 
	 *                  13
	 *                 /  \
	 *               65    5
	 *              /  \    \
	 *             97  25   37
	 *            /    /\   /
	 *           22   4 28 32
	 */
	public static Tree makeTree() {
		TreeNode n13=new TreeNode(13);
		TreeNode n65=new TreeNode(65);
		TreeNode n5=new TreeNode(5);
		TreeNode n97=new TreeNode(97);
		TreeNode n25=new TreeNode(25);
		TreeNode n37=new TreeNode(37);
		TreeNode n22=new TreeNode(22);
		TreeNode n4=new TreeNode(4);
		TreeNode n28=new TreeNode(28);
		TreeNode n32=new TreeNode(32);
		
		n13.setLeft(n65);
		n13.setRight(n5);
		
		n65.setLeft(n97);
		n65.setRight(n25);
		
		n5.setRight(n37);
		
		n97.setLeft(n22);
		
		n25.setLeft(n4);
		n25.setRight(n28);
		
		n37.setLeft(n32);
		
		return new Tree(n13);
	}
	
}
