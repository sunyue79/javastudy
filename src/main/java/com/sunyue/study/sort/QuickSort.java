/**
 * 
 */
package com.sunyue.study.sort;

import com.sunyue.study.Util;

/**
 * @author yuesun00
 * 
 */
public class QuickSort extends AbstractSort {

	public void sort() {
		displayArray();
		Util.split();
		quicksort(numbers, 0, numbers.length - 1);
		Util.split();
		displayArray();
	}

	private void quicksort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = array[start];
		int pivotIndex = start;
		Util.out("Pivot = " + pivot);
		Util.split();
		int left = start;
		int right = end;
		while (left < right) {
			while (array[right] > pivot) {
				right--;
			}
			// 右边第一个小于pivot的
			if (pivotIndex < right) {
				Util.swap(array, pivotIndex, right);
				Util.displayArray(array, start, end);
				pivotIndex = right;
			}
			while (array[left] < pivot) {
				left++;
			}
			// 左边边第一个大于pivot的
			if (left < pivotIndex) {
				Util.swap(array, pivotIndex, left);
				Util.displayArray(array, start, end);
				pivotIndex = left;
			}
		}
		Util.split();
		Util.displayArray(array, start, pivotIndex - 1);
		quicksort(array, start, pivotIndex - 1);
		Util.split();
		Util.displayArray(array, pivotIndex + 1, end);
		quicksort(array, pivotIndex + 1, end);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new QuickSort().sort();
	}

}
