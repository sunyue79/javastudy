/**
 * 
 */
package com.sunyue.study;

/**
 * @author yuesun00
 * 
 */
public abstract class Util {

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void displayArray(int[] array, int start, int end) {
		System.out.print("[");
		for (int i = start; i <= end; i++) {
			System.out.print(array[i]);
			if (i < end) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	public static void displayArray(long[] array, int start, int end) {
		System.out.print("[");
		for (int i = start; i <= end; i++) {
			System.out.print(array[i]);
			if (i < end) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	public static void displayArray(int[] array) {
		displayArray(array, 0, array.length - 1);
	}

	public static void displayArray(long[] array) {
		displayArray(array, 0, array.length - 1);
	}

	public static void split() {
		System.out.println("------------------------------------");
	}
	
	public static void out(Object text) {
		System.out.println(text);
	}
}
