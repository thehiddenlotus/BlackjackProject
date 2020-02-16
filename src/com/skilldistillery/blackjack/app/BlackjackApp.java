package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.hands.BlackjackHand;
import com.skilldistillery.blackjack.players.*;

public class BlackjackApp {
	
	static private BlackjackApp app;
	private BlackjackDealer dealer;
	private BlackjackPlayer player;
	private List<Player> players;
	static private Scanner kb = new Scanner(System.in);
	private boolean playerBust = false;

	public static void main(String[] args) {
		app = new BlackjackApp();
		app.launch();
	}

	private void launch() {
		players = new ArrayList<>();
		players.add(dealer = new BlackjackDealer());
		players.add(player = new BlackjackPlayer());
		welcomeMenu();		
	}

	private void welcomeMenu() {
		int choice = 0;
		while(choice != 2) {
			System.out.println("Welcome to Blackjack"
					+"\n--------------------"
					+ "\n1. Play Blackjack"
					+ "\n2. Quit");
			try {
				choice = kb.nextInt();
			} catch (Exception e) {
				System.err.println("ENTER AN INTEGER VALUE FROM 1 THROUGH 2");
				kb.nextLine();
			}
			switch (choice) {
			case 1:
				playHand();
				break;
			case 2:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("UNKOWN COMMAND");
				break;
			}		
		}
	}

	private void playHand() {
		player.getHand().clear();
		dealer.getHand().clear();
		dealer.newDeck();
		dealer.dealHand(players);
		gameMenu();
		dealerPlay();
		checkWinner();
	}

	private void gameMenu() {
		int choice = 0;
		boolean stay = false;
		while(choice != 3 && !stay) {
			dealer.displayDealerHand();
			player.displayHand();
			if(((BlackjackHand)player.getHand()).isBust()) {
				System.out.println("Bust!");
				playerBust = true;
				break;
			}
			else if(((BlackjackHand)player.getHand()).isBlackjack()) {
				System.out.println("Blackjack!");
				break;
			}
			else {
				System.out.println("Want do you want to do?"
						+"\n-----------------------"
						+ "\n1. Hit"
						+ "\n2. Stay"
						+ "\n3. Fold");
				try {
					choice = kb.nextInt();
				} catch (Exception e) {
					System.err.println("ENTER AN INTEGER VALUE FROM 1 THROUGH 3");
					kb.nextLine();
				}
				switch (choice) {
				case 1:
					System.out.println("Player Hits!");
					dealer.dealCard(player);
					break;
				case 2:
					System.out.println("Player Stays!");	
					stay = true;
					break;
				case 3:
					welcomeMenu();
					break;
				default:
					System.out.println("UNKOWN COMMAND");
					break;
				}				
			}
		}
	}
	
	private void dealerPlay() {
		dealer.displayHand();
		if(((BlackjackHand)dealer.getHand()).isBlackjack()) {
			System.out.println("Blackjack!");
		}
		if(((BlackjackHand)dealer.getHand()).getHandValue() > 16) {
			System.out.println("Dealer Stays!");
		}
		while (!((BlackjackHand)dealer.getHand()).isBust() 
				&& !((BlackjackHand)dealer.getHand()).isBlackjack() 
				&& !playerBust
				&& dealer.getHand().getHandValue() < 17
				&& dealer.getHand().getHandValue() < player.getHand().getHandValue() ) {
			System.out.println("Dealer Hits!");					
			dealer.getHand().addCard(dealer.getDeck().dealCard());
			dealer.displayHand();
			if(((BlackjackHand)dealer.getHand()).isBust()) {
				System.out.println("Bust!");
				break;
			}
			if(((BlackjackHand)dealer.getHand()).isBlackjack()) {
				System.out.println("Blackjack!");
				break;
			}
			if(((BlackjackHand)dealer.getHand()).getHandValue() > 16) {
				System.out.println("Dealer Stays!");
				break;
			}			
		}
	}

	private void checkWinner() {
		if(((BlackjackHand)player.getHand()).isBust()) {
			System.out.println("Dealer Wins!");
		}
		else if(((BlackjackHand)dealer.getHand()).isBust()) {
			System.out.println("Player Wins!");
		}
		else if(((BlackjackHand)dealer.getHand()).getHandValue() > ((BlackjackHand)player.getHand()).getHandValue()) {
			System.out.println("Dealer Wins!");
		}
		else if(((BlackjackHand)dealer.getHand()).getHandValue() < ((BlackjackHand)player.getHand()).getHandValue()) {
			System.out.println("Player Wins!");
		}
		else if(dealer.getHand().getCards().size() < player.getHand().getCards().size()) {
			System.out.println("Dealer Wins!");
		}
		else if(dealer.getHand().getCards().size() > player.getHand().getCards().size()) {
			System.out.println("Player Wins!");
		}
		else {
			System.out.println("House Wins!");
		}
	}	
}
