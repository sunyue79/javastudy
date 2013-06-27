/**
 * 
 */
package com.sunyue.study.tree;

import java.util.Stack;

import com.sunyue.study.Util;

/**
 * @author yuesun00
 * 
 */
public class DeepFirstTravel {

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public void travelRec(TreeNode root) {
		TreeNode node = root;
		if (node != null) {
			visit(node);
			travelRec(node.getLeft());
			travelRec(node.getRight());
		}
	}

	public void travelNoRec(Tree tree) {
		stack.push(tree.getRoot());
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			visit(node);
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
		}
	}

	/**
	 * @param node
	 */
	private void visit(TreeNode node) {
		Util.out(node.getValue().toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Util.out("No recursive:");
		new DeepFirstTravel().travelNoRec(Tree.makeTree());
		Util.out("Recursive:");
		new DeepFirstTravel().travelRec(Tree.makeTree().getRoot());
	}

}
