package com.sunyue.study.array;

import com.sunyue.study.Util;

public class MaxProductContinusSequence {

	public static void maxProductContinuousSequence(long[] array) {
		int tmpMaxStart = 0;
		int tmpMinStart = 0;
		long tmpMax = 1;
		long tmpMin = 1;
		long max = 1;
		int maxStart = 0;
		int maxEnd = 0;
		for (int i = 0; i < array.length; i++) {
			long product1 = tmpMax * array[i];
			long product2 = tmpMin * array[i];
			if (product1 > product2) {
				tmpMax = product1;
				tmpMin = product2;
			} else {
				tmpMax = product2;
				tmpMin = product1;
				// swap start
				int tmp = tmpMaxStart;
				tmpMaxStart = tmpMinStart;
				tmpMinStart = tmp;
			}
			if (tmpMax < array[i]) {
				tmpMax = array[i];
				tmpMaxStart = i;
			}
			if (tmpMin > array[i]) {
				tmpMin = array[i];
				tmpMinStart = i;
			}
			if (tmpMax > max) {
				max = tmpMax;
				maxStart = tmpMaxStart;
				maxEnd = i;
			}
		}
		Util.split();
		Util.displayArray(array);
		Util.out("Max product = " + max);
		Util.displayArray(array, maxStart, maxEnd);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maxProductContinuousSequence(new long[] { 0, -1, 3, -4, 8, 0, -5, 2, 6,
				-7 });
		maxProductContinuousSequence(new long[] { 3, -4, 8, -5, 2, 6, -7 });
	}

}
