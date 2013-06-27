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

	// ��򵥱����Ľⷨ, O(N^3)
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
	 * �����������м��ҵ������������У����ܴ��ں�Ϊ�������С������Ҫ�ҵ�һ������������Ļ����϶������в�������������е��еġ�
	 * 
	 * ������Ŀ�ͷA[0]��ʼ
	 * �����ϵ��������ߣ�ÿһ���ж��Ƿ�ǰ����󣬲��������������ֵ�ǰ�ִ���Ϊ������ʱ�����ǿ���ֱ�����������赱ǰ������Ϊi�Ļ�
	 * ����0��i��һ�εĺ��Ǹ����������ų���Ȼ���ٴӵ�ǰԪ�صĺ��濪ʼ�ҡ��������Եõ���������Ӵ����Լ����������յ㡣
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
