/**
 * 
 */
package com.sunyue.study.array;

import com.sunyue.study.Util;

/**
 * @author yuesun00
 * 
 */
public class MaxSumContinuousSequence {

	private int[] array = new int[] { 49, 38, 65, 97, -200, 76, 13, 27 };

	// 最简单暴力的解法, O(N^3)
	public void getMaxSumContinuousSequence() {
		int start = 0;
		int end = 0;
		int maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += array[k];
				}
				if (sum > maxSum) {
					maxSum = sum;
					start = i;
					end = j;
				}
			}
		}
		Util.out("Max sum = " + maxSum);
		Util.displayArray(array, start, end);
	}

	/**
	 * 我们在数组中间找到的连续子序列，可能存在和为负的序列。如果需要找到一个最大的子数组的话，肯定该序列不是在最大子序列当中的。
	 * 
	 * 从数组的开头A[0]开始
	 * ，不断的往后面走，每一步判断是否当前和最大，并保存结果。当发现当前字串和为负数的时候，我们可以直接跳过。假设当前的索引为i的话
	 * ，从0到i这一段的和是负数，可以排除。然后再从当前元素的后面开始找。这样可以得到最终最大子串和以及串的起点和终点。
	 */
	public void getMaxSumContinuousSequence2() {
		int start = 0;
		int end = 0;
		int maxSum = 0;

		int i = 0;
		int sum = 0;
		for (int j = 0; j < array.length; j++) {
			sum += array[j];
			if (sum > maxSum) {
				maxSum = sum;
				start = i;
				end = j;
			}
			if (sum < 0) {
				i = j + 1;
				sum = 0;
			}
		}
		Util.out("Max sum = " + maxSum);
		Util.displayArray(array, start, end);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MaxSumContinuousSequence().getMaxSumContinuousSequence();
		new MaxSumContinuousSequence().getMaxSumContinuousSequence2();
	}

}
