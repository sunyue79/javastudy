/**
 * 
 */
package com.sunyue.study.sort;

import com.sunyue.study.Util;

/**
 * @author yuesun00
 * 
 */
public class MergeSort extends AbstractSort {

	public void sort() {
		Util.displayArray(mergeSort(numbers, 0, numbers.length - 1));
	}

	public int[] mergeSort(int[] array, int start, int end) {
		if (start == end) {
			return new int[] { array[start] };
		}
		int mid = (start + end) / 2;
		int[] left = mergeSort(array, start, mid);
		int[] right = mergeSort(array, mid + 1, end);
		return merge(left, right);
	}

	/**
	 * @param left
	 * @param right
	 * @return
	 */
	private int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftIdx = 0;
		int rightIdx = 0;
		int resultIdx = 0;
		while (leftIdx < left.length && rightIdx < right.length) {
			if (left[leftIdx] <= right[rightIdx]) {
				result[resultIdx++] = left[leftIdx++];
			} else {
				result[resultIdx++] = right[rightIdx++];
			}
		}
		while (leftIdx < left.length) {
			result[resultIdx++] = left[leftIdx++];
		}
		while (rightIdx < right.length) {
			result[resultIdx++] = right[rightIdx++];
		}
		Util.displayArray(result);
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MergeSort().sort();
	}

}
