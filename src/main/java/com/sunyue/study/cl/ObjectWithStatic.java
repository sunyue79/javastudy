package com.sunyue.study.cl;

import java.util.Date;

public class ObjectWithStatic {

	private static long time;
	
	static {
		time = System.currentTimeMillis();
		System.out.println(new Date(time));
	}
}
