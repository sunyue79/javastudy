package com.sunyue.study.pc;

import java.util.Queue;

public class OldConsumer extends Thread {

	private Queue<String> queue;

	public OldConsumer(Queue<String> q, String name) {
		super();
		queue = q;
		super.setName(name);
	}

	@Override
	public void run() {
		String product = null;
		System.out.println(super.getName() + " - Started!");
		try {
			do {
				synchronized (queue) {
					if (queue.isEmpty()) {
						queue.wait();
					} else {
						product = queue.poll();
						queue.notifyAll();
					}
				}
				System.out.println(super.getName() + " - Consume: " + product);
			} while (!Producer.STOP_SIGNAL.equals(product));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(super.getName() + " - Stopped!");
	}
}
