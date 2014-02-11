/**
 * 
 */
package com.sunyue.study.sort;

import com.sunyue.study.Util;

/**
 * @author yuesun00
 * 
 */
public class BubbleSort extends AbstractSort {

	private int[] theNumbers = new int[] { 24, 19, 26, 39, 36, 7, 31, 29, 38,
			23 };

	public void sort() {
		Util.displayArray(theNumbers);
		Util.split();
		for (int i = theNumbers.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (theNumbers[j] > theNumbers[j + 1]) {
					Util.swap(theNumbers, j, j + 1);
					Util.displayArray(theNumbers);
				}
			}
			Util.split();
		}
		Util.split();
		Util.displayArray(theNumbers);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BubbleSort().sort();
	}

}
