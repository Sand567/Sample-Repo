package com.sandeep.other;

import java.util.Arrays;

public class Deck {

	public static void main(String[] args) {
		
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
		int deckLength = ranks.length * suits.length;
		String[] deck = new String[deckLength];
		
		for (int i = 0; i < deck.length; i++) {
			deck[i] = ranks[i % 13] + suits[i % 4];
		}
		
		System.out.println(Arrays.toString(deck));
	}

}
