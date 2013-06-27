/**
 * 
 */
package com.sunyue.study.number;

/**
 * @author yuesun00
 * 
 */
public class TwoBigNumberAdd {

	public String add(String number1, String number2) {
		String longNumber, shortNumber;
		if (number1.length() > number2.length()) {
			longNumber = number1;
			shortNumber = number2;
		} else {
			longNumber = number2;
			shortNumber = number1;
		}
		int maxLen = longNumber.length();
		char[] result = new char[maxLen];

		boolean carry = false;

		// 重合数位逐一相加
		for (int i = 1; i <= shortNumber.length(); i++) {
			int s = (int) shortNumber.charAt(shortNumber.length() - i)
					- (int) '0';
			int l = (int) longNumber.charAt(longNumber.length() - i)
					- (int) '0';
			int sum = s + l + (carry ? 1 : 0);
			if (sum >= 10) {
				carry = true;
				sum -= 10;
			} else {
				carry = false;
			}
			result[result.length - i] = String.valueOf(sum).charAt(0);
		}

		// 较长的数字余下的高位只考虑进位
		for (int i = shortNumber.length() + 1; i < longNumber.length() + 1; i++) {
			int l = (int) longNumber.charAt(longNumber.length() - i)
					- (int) '0';
			int sum = l + (carry ? 1 : 0);
			if (sum >= 10) {
				carry = true;
				sum -= 10;
			} else {
				carry = false;
			}
			result[result.length - i] = (char) String.valueOf(sum).charAt(0);
		}

		// 最高位有可能进位
		return carry ? "1" + String.valueOf(result) : String.valueOf(result);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new TwoBigNumberAdd().add("12345", "123"));
		System.out.println(new TwoBigNumberAdd().add("12345", "99123"));
	}

}
