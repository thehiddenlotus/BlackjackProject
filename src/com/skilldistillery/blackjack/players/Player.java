package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.hands.Hand;

public abstract class Player {
	
	private Hand hand;
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public void displayHand() {
		System.out.println("Player Hand"
						+ "\n------------");
		for (Card card : hand.getCards()) {
			System.out.println("\t"+card.toString());
		}
		System.out.println("Hand Value: "+hand.getHandValue());
		System.out.println();
	}

}
