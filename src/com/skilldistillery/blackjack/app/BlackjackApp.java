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
	private boolean playerBust;

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
		int chips = 0;
		while(choice != 3) {
			System.out.println("Welcome to Blackjack"
							+"\n--------------------"
							+ "\nPlayer Chips: "+player.getPot().getChips()
							+ "\n1. Play Blackjack"
							+ "\n2. Add Chips"
							+ "\n3. Quit");
			try {
				choice = kb.nextInt();
			} catch (Exception e) {
				System.err.println("ENTER AN INTEGER VALUE FROM 1 THROUGH 2");
				kb.nextLine();
			}
			switch (choice) {
			case 1:
				System.out.println("Enter how many chips you would like bet: ");
				try {
					chips = kb.nextInt();
					if (player.getPot().getChips() - chips >= 0) {
						dealer.setPot(0);
						player.subChips(chips);
						dealer.addChips(chips);	
						chips = 0;
						playHand();
					}
					else {
						System.out.println("Not enough chips.");
					}
					chips = 0;
				} catch (Exception e) {
					System.out.println("Enter and integer value.");
				}
				break;
			case 2:
				System.out.println("Enter how many chips you would like to purchase."
								+ "\n(Notice: Chips cost equivilant soul points at a 1:1 rate."
								+ "\n\tWe are not reponsible for broken souls and/or knees.)");
				try {
					chips = kb.nextInt();
					player.addChips(chips);
					chips = 0;
				} catch (Exception e) {
					System.out.println("Enter and integer value.");
				}
				break;
			case 3:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("UNKOWN COMMAND");
				break;
			}		
		}
	}

	private void playHand() {
		playerBust = false;
		player.getHand().clear();
		dealer.getHand().clear();
//		if(dealer.getDeck().checkDeckSize() < 52 * .75) {
//			dealer.newDeck();
//		}
		dealer.newDeck();
		dealer.shuffle();
		dealer.dealHand(players);
		gameMenu();
		dealerPlay();
		checkWinner();
	}

	private void gameMenu() {
		int choice = 0;
		boolean stay = false;
		while(choice != 4 && !stay) {
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
						+ "\nPot: "+dealer.getPot().getChips()
						+ "\n1. Hit"
						+ "\n2. Stay"
						+ "\n3. Double Down"
						+ "\n4. Fold");
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
					System.out.println("Player Doubles Down!");
					player.subChips(dealer.getPot().getChips());
					dealer.addChips(dealer.getPot().getChips());
					System.out.println("Pot is now "+dealer.getPot().getChips());
					dealer.dealCard(player);
					player.displayHand();
					stay = true;
					if(((BlackjackHand)player.getHand()).isBust()) {
						System.out.println("Bust!");
						playerBust = true;
					}
					else if(((BlackjackHand)player.getHand()).isBlackjack()) {
						System.out.println("Blackjack!");
					}
					break;
				case 4:
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
		System.out.println("Pot: "+dealer.getPot().getChips());
		dealer.displayHand();
		if(((BlackjackHand)dealer.getHand()).isBlackjack()) {
			System.out.println("Blackjack!");
		}
		if(((BlackjackHand)dealer.getHand()).getHandValue() > 16) {
			System.out.println("Dealer Stays!");
		}
		while (!((BlackjackHand)dealer.getHand()).isBust() 
				&& !((BlackjackHand)dealer.getHand()).isBlackjack() 
				&& playerBust == false
				&& dealer.getHand().getHandValue() < 17
//				&& dealer.getHand().getHandValue() < player.getHand().getHandValue() 
				) {
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
			System.out.println("Dealer Wins "+dealer.getPot().getChips()+"!");
		}
		else if(((BlackjackHand)dealer.getHand()).isBust()) {
			System.out.println("Player Wins "+(dealer.getPot().getChips()*2)+"!");
			player.addChips(dealer.getPot().getChips()*2);
		}
		else if(((BlackjackHand)dealer.getHand()).getHandValue() > ((BlackjackHand)player.getHand()).getHandValue()) {
			System.out.println("Dealer Wins "+dealer.getPot().getChips()+"!");
		}
		else if(((BlackjackHand)dealer.getHand()).getHandValue() < ((BlackjackHand)player.getHand()).getHandValue()) {
			System.out.println("Player Wins "+(dealer.getPot().getChips()*2)+"!");
			player.addChips(dealer.getPot().getChips()*2);
		}
//		else if(dealer.getHand().getCards().size() < player.getHand().getCards().size()) {
//			System.out.println("Dealer Wins!");
//		}
//		else if(dealer.getHand().getCards().size() > player.getHand().getCards().size()) {
//			System.out.println("Player Wins!");
//		}
		else {
			System.out.println("Push!");
			player.addChips(dealer.getPot().getChips());
		}
//		player.getHand().clear();
//		dealer.getHand().clear();
		System.out.println();
	}	
}
