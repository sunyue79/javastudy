package com.sunyue.study.link;

public class ReverseOnewayLink {

	public static Node reverse(Node head) {
		Node left = head;
		Node center = left.next;
		Node right = center.next;
		left.next = null;
		while (center != null) {
			center.next = left;
			left = center;
			center = right;
			right = right != null ? right.next : null;
		}
		return left;
	}

	public static void display(Node head) {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
		System.out.println(" null ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = null;
		Node pre = null;
		for (int i = 0; i < 5; i++) {
			Node node = new Node(i, null);
			if (head == null) {
				head = node;
			}
			if (pre != null) {
				pre.next = node;
			}
			pre = node;
		}
		display(head);
		display(reverse(head));
	}

}

class Node {

	int value;

	Node next;

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
}