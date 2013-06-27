/**
 * 
 */
package com.sunyue.study.number;

import com.sunyue.study.Util;

/**
 * @author yuesun00
 * 
 *         a(n) = ：(1/√5)*{[(1+√5)/2]^n - [(1-√5)/2]^n}
 *         Sn=a(n+2)-1=(r^(n+2)-s^(n+2))/(r-s) - 1, 其中r,s=(1±√5)/2,附:r-s=√5
 * 
 * 
 * 
 */
public class Fibonacci {

	public int fibo(int n) {
		switch (n) {
		case 1:
			return 1;
		case 2:
			return 1;
		default:
			return fibo(n - 1) + fibo(n - 2);
		}
	}

	public int sumN(int n) {
		switch (n) {
		case 1:
			return 1;
		case 2:
			return 2;
		default:
			return fibo(n) + sumN(n - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		for (int i = 1; i <= 40; i++) {
			Util.out(f.fibo(i));
		}
		Util.out("Sum40 = " + new Fibonacci().sumN(40));
	}

}
