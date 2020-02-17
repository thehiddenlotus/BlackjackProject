package com.skilldistillery.blackjack.hands;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Rank;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : this.getCards()) {
			value += card.getRank().getValue();
		}
		for (Card card : this.getCards()) {
			if(card.getRank().equals(Rank.ACE)) {
				if(value + 10 < 22) {
					value += 10;
				}
			}
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
