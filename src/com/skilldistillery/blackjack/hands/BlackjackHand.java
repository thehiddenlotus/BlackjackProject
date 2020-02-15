package com.skilldistillery.blackjack.hands;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : this.getHand()) {
			value += card.getRank().getValue();
		}
		return value;
	}
	
	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;
	}
}
