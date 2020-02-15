package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.players.*;

public class BlackjackApp {
	
	static private BlackjackApp app;
	BlackjackDealer dealer;
	BlackjackPlayer player;

	public static void main(String[] args) {
		app = new BlackjackApp();
		app.launch();
	}

	private void launch() {
		dealer = new BlackjackDealer();
		player = new BlackjackPlayer();
		System.out.println("Welcome to Blackjack"
						+"(Choose and option from the menu below)");
	}

}
