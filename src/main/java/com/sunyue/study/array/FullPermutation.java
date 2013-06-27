package com.sunyue.study.array;

import com.sunyue.study.Util;

public class FullPermutation {

	private static int[] array = new int[] { 1, 2, 3, 4 };

	public void permutation(int[] array, int start, int end) {
		if (start == end) {
			Util.displayArray(array);
			return;
		}
		for (int i = start; i <= end; i++) {
			Util.swap(array, i, start);
			permutation(array, start + 1, end);
			Util.swap(array, i, start);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FullPermutation().permutation(array, 0, array.length - 1);
	}

}
