package com.sunyue.study.sort;

import com.sunyue.study.Util;

public class HeapSort extends AbstractSort {

	private int[] array = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5,
			4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	private int[] array2 = { 26, 5, 77, 1, 61, 11, 59, 15, 48, 79 };

	public void sortAsc() {
		for (int i = 1; i < array.length; i++) {
			buildMaxRootHeap(array, array.length - i);
			Util.displayArray(array);
			Util.swap(array, 0, array.length - i);
			Util.displayArray(array);
			Util.split();
		}
	}

	private void buildMaxRootHeap(int[] data, int lastIndex) {
		for (int i = (lastIndex) / 2; i >= 0; i--) {
			int bigChild = -1;
			int leftChild = i * 2 + 1;
			if (leftChild <= lastIndex) {
				bigChild = leftChild;
			}
			int rightChild = i * 2 + 2;
			if (rightChild <= lastIndex && data[leftChild] < data[rightChild]) {
				bigChild = rightChild;
			}
			if (bigChild >= 0 && data[i] < data[bigChild]) {
				Util.swap(data, i, bigChild);
			}
		}
	}

	public void sortDesc() {
		for (int i = 1; i < array.length; i++) {
			buildMinRootHeap(array, array.length - i);
			Util.displayArray(array);
			Util.swap(array, 0, array.length - i);
			Util.displayArray(array);
			Util.split();
		}
	}

	private void buildMinRootHeap(int[] data, int lastIndex) {
		for (int i = (lastIndex) / 2; i >= 0; i--) {
			int smallChild = -1;
			int leftChild = i * 2 + 1;
			if (leftChild <= lastIndex) {
				smallChild = leftChild;
			}
			int rightChild = i * 2 + 2;
			if (rightChild <= lastIndex && data[leftChild] > data[rightChild]) {
				smallChild = rightChild;
			}
			if (smallChild >= 0 && data[i] > data[smallChild]) {
				Util.swap(data, i, smallChild);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Util.out("ASC:");
		new HeapSort().sortAsc();
		Util.out("DESC:");
		new HeapSort().sortDesc();
	}

}
