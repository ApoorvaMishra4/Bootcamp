package com.jda.core.DeckOfCards;

import com.jda.utility.QueueLinkedList;

public class DeckOfCardsUI {
	static QueueLinkedList<Player> allPlayers = new QueueLinkedList<>();

	public static void print() {
		Player player = allPlayers.pop();
		System.out.print("Player: ");
		QueueLinkedList<String> cards = player.playerCards;
		for (int i = 0; i < 9; i++) {
			System.out.print(cards.pop() + " | ");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			Player player = new Player();
			player.pushToQueue();
			allPlayers.push(player);
		}
		for (int i = 0; i < 4; i++) {
			print();
		}
	}
}
