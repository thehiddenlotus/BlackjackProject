package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.hands.Hand;

public abstract class Player {
	
	Hand hand;
	
	protected Hand getHand() {
		return hand;
	}

	protected void setHand(Hand hand) {
		this.hand = hand;
	}
	

}
