package com.sunyue.study.basic.polymethod;

public class Polymethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a1 = new A();
		B b1 = new B();
		C c1 = new C();
		D d1 = new D();
		d1.m1(a1);
		d1.m1(b1);
		d1.m1(c1);
		d1.m1(d1);
	}

}

class A {
	public void m1(A a) {
		System.out.println("A");
	}
}

class B extends A {
	public void m1(B b) {
		System.out.println("B");
	}
}

class C extends B {
	public void m1(C c) {
		System.out.println("C");
	}
}

class D extends C {
	public void m1(D d) {
		System.out.println("D");
	}
}
