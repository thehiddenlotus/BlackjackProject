package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.hands.Hand;

public abstract class Player {
	
	private Hand hand;
	private Pot pot;
	
	public Player() {
		pot = new Pot();
	}
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public Pot getPot() {
		return pot;
	}
	
	public int setPot(int chips) {
		this.pot.setChips(chips);
		return pot.getChips();
	}
	
	public int addChips(int chips) {
		pot.addChips(chips);
		return pot.getChips();
	}

	public int subChips(int chips) {
		pot.subChips(chips);
		return pot.getChips();
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
