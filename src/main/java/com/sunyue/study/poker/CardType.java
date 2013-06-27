package com.sunyue.study.poker;

public enum CardType {

	Heart, Diamond, Spade, Club, BigJoker, SmallJoker;

	public static CardType valueOf(int number) {
		switch (number) {
		case 0:
			return Heart;
		case 1:
			return Diamond;
		case 2:
			return Spade;
		case 3:
			return Club;
		case 4:
			return BigJoker;
		case 5:
			return SmallJoker;
		}
		return null;
	}
}
