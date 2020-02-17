package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.hands.BlackjackHand;

public class BlackjackPlayer extends Player {

	public BlackjackPlayer() {
		super();
		setHand(new BlackjackHand());
	}
	
	
}
