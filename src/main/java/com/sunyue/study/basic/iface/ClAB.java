package com.sunyue.study.basic.iface;

/**
 * @author yuesun00
 *
 */
public class ClAB implements IfA,IfB{
	
	int a = 3;

	/* (non-Javadoc)
	 * @see IfA#doit()
	 */
	@Override
	public void doit() {
		System.out.println(a);
		System.out.println(IfA.a);
		System.out.println(IfB.a);
	}
	
	public static void main(String[] args) {
		new ClAB().doit();
	}

}
