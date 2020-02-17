package com.skilldistillery.blackjack.players;

public class Pot {
	int chips;
	
	public Pot() {
		this.chips = 0;
	}
	public Pot(int chips) {
		this.chips = chips;
	}
	public int getChips() {
		return chips;
	}
	public void setChips(int chips) {
		this.chips = chips;
	}
	public void addChips(int chips) {
		this.chips += chips;
	}
	public void subChips(int chips) {
		this.chips -= chips;
	}
}
