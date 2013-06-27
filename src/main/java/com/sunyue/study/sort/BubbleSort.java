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

	public void sort() {
		displayArray();
		Util.split();
		for (int i = numbers.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					Util.swap(numbers, j, j + 1);
					displayArray();
				}
			}
			Util.split();
		}
		Util.split();
		displayArray();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BubbleSort().sort();
	}

}
