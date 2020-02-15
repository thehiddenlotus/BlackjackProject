package com.skilldistillery.blackjack.hands;

import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.blackjack.cards.*;

public abstract class Hand {
	
	private List<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public void clear() {
		cards = new ArrayList<Card>();
	}
	
	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
	
	public List<Card> getHand(){
		return cards;
	}

	public abstract int getHandValue();
}
