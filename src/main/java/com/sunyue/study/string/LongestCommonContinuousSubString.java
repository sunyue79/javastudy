/**
 * 
 */
package com.sunyue.study.string;

import com.sunyue.study.Util;

//   r e p u t a t i o n
// i 0 0 0 0 0 0 0 1 0 0
// n 0 0 0 0 0 0 0 0 0 1
// p 0 0 1 0 0 0 0 0 0 0
// u 0 0 0 2 0 0 0 0 0 0
// t 0 0 0 0 3 0 0 0 0 0
public class LongestCommonContinuousSubString {

	public String getLongestCommonContinuousSubString(String s1, String s2) {
		int[][] matrix = new int[s1.length()][s2.length()];
		int maxLen = 0;
		int index1 = 0; // common substring end in s1
		int index2 = 0; // common substring end in s2
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i > 0 && j > 0) {
						matrix[i][j] = matrix[i - 1][j - 1] + 1;
					} else {
						matrix[i][j] = 1;
					}
					if (matrix[i][j] > maxLen) {
						maxLen = matrix[i][j];
						index1 = i;
						index2 = j;
					}
				}
			}
		}
		String c1 = s1.substring(index1 - maxLen + 1, index1 + 1);
		String c2 = s2.substring(index2 - maxLen + 1, index2 + 1);
		Util.out(c1.equals(c2) ? "OK" : "Fail");
		return c1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Util.out(new LongestCommonContinuousSubString()
				.getLongestCommonContinuousSubString("input", "reputation"));
		Util.out(new LongestCommonContinuousSubString()
				.getLongestCommonContinuousSubString(
						"123456789abcdefghijklmn2131.dfdfdf",
						"123456sdkk123456789abcddkfdfkd123456789abcde"));
	}

}
