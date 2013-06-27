package com.sunyue.study.poker;

public class Card {

	private CardType cardType;

	private int number;

	public Card(CardType cardType, int number) {
		this.cardType = cardType;
		this.number = number;
	}

	public CardType getCardType() {
		return cardType;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Card [cardType=" + cardType + ", number=" + number + "]";
	}

}
