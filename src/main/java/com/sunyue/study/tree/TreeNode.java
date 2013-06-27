/**
 * 
 */
package com.sunyue.study.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuesun00
 * 
 */
public class TreeNode {

	private Object value;

	private List<TreeNode> children = new ArrayList<TreeNode>(2);

	public TreeNode(Object value) {
		this.value = value;
		children.add(null);
		children.add(null);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public TreeNode getLeft() {
		return children.get(0);
	}

	public void setLeft(TreeNode left) {
		children.set(0, left);
	}

	public TreeNode getRight() {
		return children.get(1);
	}

	public void setRight(TreeNode right) {
		children.set(1, right);
	}

	@Override
	public String toString() {
		return value == null ? "Null" : value.toString();
	}

}
