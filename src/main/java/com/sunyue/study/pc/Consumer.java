package com.sunyue.study.pc;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	private BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> q, String name) {
		super();
		queue = q;
		super.setName(name);
	}

	@Override
	public void run() {
		try {
			String product = null;
			System.out.println(super.getName() + " - Started!");
			do {
				product = queue.take();
				System.out.println(super.getName() + " - Consume: " + product);
			} while (!Producer.STOP_SIGNAL.equals(product));
			System.out.println(super.getName() + " - Stopped!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
