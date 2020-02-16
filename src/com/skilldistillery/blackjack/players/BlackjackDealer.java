package com.skilldistillery.blackjack.players;

import java.util.List;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;

public class BlackjackDealer extends BlackjackPlayer {

	private Deck deck;

	public BlackjackDealer() {
		super();
		deck = new Deck();
	}

	public Deck getDeck() {
		return deck;
	}

	public void newDeck() {
		this.deck = new Deck();
	}
	
	public void dealHand(List<Player> players) {
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.getHand().addCard(deck.dealCard());
			}
		}
		
	}
	
	public void dealCard(Player target) {
		target.getHand().getCards().add(deck.dealCard());
	}
	
	public void shuffle() {
		deck.shuffle();
	}
	
	public void displayDealerHand() {
		System.out.println("Dealer Hand"
						+ "\n------------"
						+ "\n\tA face down card "
						+ "\n\tA "+getHand().getCards().get(0).toString());
		System.out.println();
	}
	
	public void displayHand() {
		System.out.println("Dealer Hand"
						+ "\n------------");
		for (Card card : getHand().getCards()) {
			System.out.println("\t"+card.toString());
		}
		System.out.println("Hand Value: "+getHand().getHandValue());
		System.out.println();
	}
	
}
