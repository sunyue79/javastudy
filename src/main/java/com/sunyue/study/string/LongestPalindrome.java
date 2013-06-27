/**
 * 
 */
package com.sunyue.study.string;

import com.sunyue.study.Util;

/**
 * @author yuesun00
 * 
 */
public class LongestPalindrome extends LongestCommonContinuousSubString {

	public String getLongestPalindrome(String word) {
		StringBuilder reversed = new StringBuilder(word.length());
		for (int i = word.length() - 1; i >= 0; i--) {
			reversed.append(word.charAt(i));
		}
		Util.out("Reversed word: " + reversed);
		return super.getLongestCommonContinuousSubString(word,
				reversed.toString());
	}

	public String getLongestPalindrome2(String word) {
		int start = 0;
		int end = 0;
		int maxLen = 0;
		for (int i = 1; i < word.length() - 1; i++) {
			int startOfCenter = i;
			int endOfCenter = word.charAt(startOfCenter) == word
					.charAt(startOfCenter + 1) ? startOfCenter + 1
					: startOfCenter;
			int length = startOfCenter == endOfCenter ? 1 : 2;
			for (int j = 1; startOfCenter - j >= 0
					&& endOfCenter + j < word.length(); j++) {
				if (word.charAt(startOfCenter - j) == word.charAt(endOfCenter
						+ j)) {
					length++;
					if (length > maxLen) {
						maxLen = length;
						start = startOfCenter - j;
						end = endOfCenter + j;
					}
				} else {
					break;
				}
			}
		}
		return word.substring(start, end + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Util.out("Method 1:");
		Util.out(new LongestPalindrome().getLongestPalindrome("abcdcefc"));
		Util.out(new LongestPalindrome().getLongestPalindrome("gabcecbaefd"));
		Util.out(new LongestPalindrome().getLongestPalindrome("bbcbaefccfg"));

		Util.out("Method 2:");
		Util.out(new LongestPalindrome().getLongestPalindrome2("abcdcefc"));
		Util.out(new LongestPalindrome().getLongestPalindrome2("gabcecbaefd"));
		Util.out(new LongestPalindrome().getLongestPalindrome2("bbcbaefccfg"));
	}

}
