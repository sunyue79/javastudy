package com.sunyue.study.pc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer extends Thread {

	public static int QUEUE_SIZE = 3;

	public static int PRODUCT_AMOUNT = 10;

	public static int PRODUCER_COUNT = 3;

	public static int CONSUMER_COUNT = 3;

	public static long PRODUCE_INTERVAL = 1;

	public static String STOP_SIGNAL = "stop";

	private BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> q, String name) {
		super();
		queue = q;
		super.setName(name);
	}

	@Override
	public void run() {
		try {
			System.out.println(super.getName() + " - Started!");
			for (int i = 0; i < PRODUCT_AMOUNT; i++) {
				String product = super.getName() + " " + i;
				queue.put(product);
				System.out.println(super.getName() + " - Produce: " + product);
				super.sleep(PRODUCE_INTERVAL);
			}
			System.out.println(super.getName() + " - Stopped!");
			queue.put(STOP_SIGNAL);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> q = new LinkedBlockingQueue<String>(QUEUE_SIZE);
		for (int i = 0; i < PRODUCER_COUNT; i++) {
			new Producer(q, "P" + i).start();
		}
		for (int i = 0; i < CONSUMER_COUNT; i++) {
			new Consumer(q, "C" + i).start();
		}
	}

}