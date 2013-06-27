package com.sunyue.study.pc;

import java.util.LinkedList;
import java.util.Queue;

public class OldProducer extends Thread {

	public static int QUEUE_SIZE = 3;

	public static int PRODUCT_AMOUNT = 10;

	public static int PRODUCER_COUNT = 3;

	public static int CONSUMER_COUNT = 3;

	public static long PRODUCE_INTERVAL = 1;

	public static String STOP_SIGNAL = "stop";

	private Queue<String> queue;

	public OldProducer(Queue<String> q, String name) {
		super();
		queue = q;
		super.setName(name);
	}

	@Override
	public void run() {
		try {
			System.out.println(super.getName() + " - Started!");
			for (int i = 0; i < PRODUCT_AMOUNT; i++) {
				String product = i == PRODUCT_AMOUNT - 1 ? STOP_SIGNAL : super
						.getName() + "-" + i;
				synchronized (queue) {
					if (queue.size() == QUEUE_SIZE) {
						queue.wait();
					} else {
						queue.offer(product);
						queue.notifyAll();
					}
				}
				System.out.println(super.getName() + " - Produce: " + product);
				super.sleep(PRODUCE_INTERVAL);
			}
			System.out.println(super.getName() + " - Stopped!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		for (int i = 0; i < PRODUCER_COUNT; i++) {
			new OldProducer(q, "P" + i).start();
		}
		for (int i = 0; i < CONSUMER_COUNT; i++) {
			new OldConsumer(q, "C" + i).start();
		}
	}

}