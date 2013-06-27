/**
 * 
 */
package com.sunyue.study.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sunyue.study.Util;

/**
 * @author yuesun00
 *
 */
public class WideFirstTravel {

	private Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();

	public void travelRec(TreeNode root) {

	}

	public void travelNoRec(Tree tree) {
		queue.offer(tree.getRoot());
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			visit(node);
			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.offer(node.getRight());
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
		new WideFirstTravel().travelNoRec(Tree.makeTree());
		Util.out("Recursive:");
		//new DeepFirstTravel().travelRec(Tree.makeTree().getRoot());
	}

}
