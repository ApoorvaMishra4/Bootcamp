package com.jda.core.DeckOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

	static boolean[][] allCards = new boolean[13][4];

	static List<String> cardsDistributed = new ArrayList<>();

	public static int randomCardNumber() {
		Random random = new Random();
		return random.nextInt(13);
	}

	public static int randomCardType() {
		Random random = new Random();
		return random.nextInt(4);
	}

	public static String mapCardNumber(int cardNumber) {
		switch (cardNumber) {
		case 9: {
			return "Jack ";
		}
		case 10: {
			return "Queen ";
		}
		case 11: {
			return "King ";
		}
		case 12: {
			return "Ace ";
		}
		default: {
			return Integer.toString(cardNumber + 1) + " ";
		}
		}
	}

	public static String mapCardType(int cardType) {
		switch (cardType) {
		case 0: {
			return "Clubs";
		}
		case 1: {
			return "Diamonds";
		}
		case 2: {
			return "Hearts";
		}
		case 3: {
			return "Spades";
		}
		}
		return null;
	}

	public static boolean randomExists(int cardNumber, int cardType) {
		if (allCards[cardNumber][cardType] == true) {
			return true;
		}
		return false;
	}

	public static List<String> distributeCards() {
		cardsDistributed = new ArrayList<>();
		for (int j = 0; j < 9; j++) {
			int cardNumber = randomCardNumber();
			int cardType = randomCardType();
			while (randomExists(cardNumber, cardType)) {
				cardNumber = randomCardNumber();
				cardType = randomCardType();
			}
			allCards[cardNumber][cardType] = true;
			String card = mapCardNumber(cardNumber) + "of " + mapCardType(cardType);
			cardsDistributed.add(card);
		}
		return cardsDistributed;
	}

}
