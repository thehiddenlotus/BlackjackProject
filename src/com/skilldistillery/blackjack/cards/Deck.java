package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> deck;
	Suit[] suits;
	Rank[] ranks;

	public Deck() {
		deck = new ArrayList<>();
		suits = Suit.values();
		ranks = Rank.values();
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				deck.add(new Card(suit, rank));
			}
		}
		shuffle();
//		System.out.println(checkDeckSize());
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
//		System.out.println("Deck Shuffled");
	}
	
	public void printDeck() {
		for (Card card : deck) {
			card.toString();
		}
	}
}
