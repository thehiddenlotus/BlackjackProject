package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hands.BlackjackHand;

public class BlackjackDealer extends BlackjackPlayer {

	private Deck deck;

	public BlackjackDealer() {
		deck = new Deck();
		hand = new BlackjackHand();
	}

	protected Deck getDeck() {
		return deck;
	}

	protected void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
}
