package com.sunyue.study.prime;

public class PrimeNumber {

	public static boolean isPrime(int number) {
		if (number == 0) {
			return false;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if (PrimeNumber.isPrime(i)) {
				System.out.println(i + " is prime.");
			}
		}
	}

}
