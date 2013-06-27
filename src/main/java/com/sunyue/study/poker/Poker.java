package com.sunyue.study.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sunyue.study.Util;

public class Poker {

	private List<Card> cards;

	public Poker(int suiteNumber) {
		generateCards(suiteNumber);
	}

	public Poker() {
		this(1);
	}

	private void generateCards(int suiteNumber) {
		cards = new ArrayList<Card>(54 * suiteNumber);
		for (int suite = 0; suite < suiteNumber; suite++) {
			for (int i = 0; i < 52; i++) {
				cards.add(new Card(CardType.valueOf(i / 13), i % 13 + 1));
			}
			cards.add(new Card(CardType.BigJoker, 0));
			cards.add(new Card(CardType.SmallJoker, 0));
		}
	}

	public List<Card> getCards() {
		return cards;
	}

	public List<Card> shuffle() {
		Random random = new Random();
		for (int i = 0; i < cards.size(); i++) {
			// 索引牌只和剩下还没有洗的牌进行交换
			int index = i + random.nextInt(cards.size() - i);
			Card buffer = cards.get(i);
			cards.set(i, cards.get(index));
			cards.set(index, buffer);
		}
		return cards;
	}

	public static void display(List<Card> cards) {
		int i = 1;
		for (Card card : cards) {
			System.out.println(i++ + " : " + card);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Poker poker = new Poker();
		Util.split();
		Poker.display(poker.getCards());
		Util.split();
		Poker.display(poker.shuffle());

		poker = new Poker(2);
		Util.split();
		Poker.display(poker.getCards());
		Util.split();
		Poker.display(poker.shuffle());
	}

}
