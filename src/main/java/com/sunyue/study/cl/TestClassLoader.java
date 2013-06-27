package com.sunyue.study.cl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestClassLoader {
	
	public void testClassLoader(long repeat) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
		final File f = new File("C:\\Users\\essnyye\\work\\codes\\study\\bin");
		for(int i=0;/*i<repeat*/true;i++) {
			/*ClassLoader cl = new URLClassLoader(new URL[]{f.toURI().toURL()});*/
			Thread t = new Thread(){

				@Override
				public void run() {
					try {
						ClassLoader cl = new URLClassLoader(new URL[]{f.toURI().toURL()});this.setContextClassLoader(cl);
						Class<?> clazz = this.getContextClassLoader().loadClass("com.sunyue.study.cl.ObjectWithStatic");
						System.out.println(clazz);
						System.out.println(clazz.newInstance());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			};
			//t.setContextClassLoader(cl);
			t.start();
			Thread.currentThread().sleep(1000);
			/*Class<?> clazz = cl.loadClass("com.sunyue.study.cl.ObjectWithStatic");
			System.out.println(clazz);
			System.out.println(clazz.newInstance());*/
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new TestClassLoader().testClassLoader(1000);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
