package poker.version_graphics.model;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HandTypeTest {
	// We define the hands using abbreviations. The code at the bottom
	// of this class can translate one of these strings into a card.
	//
	// Another method takes a set of five cards, and translates the whole hand
	//
	// Yet another method does this for a whole set of hands
	private static String[][] highCards = {
			{ "2S", "9C", "3H", "5D", "7H" },
			{ "7S", "5C", "AH", "JD", "6H" },
			{ "2S", "3S", "4S", "5H", "7S" },
			{ "AS", "KC", "QH", "JD", "2H" }
			};
	
	private static String[][] pairs = {
			{ "2S", "2C", "3H", "5D", "7H" },
			{ "2S", "AC", "3H", "5D", "AH" },
			{ "3S", "2C", "3H", "KD", "QH" },
			{ "9S", "2C", "2H", "5D", "7H" }
			};

	private static String[][] twoPairs = {
			{ "2S", "2C", "7H", "5D", "7H" },
			{ "2S", "AC", "5H", "5D", "AH" },
			{ "3S", "2C", "3H", "2D", "QH" },
			{ "9S", "2C", "2H", "5D", "5H" }
			};
	
	private static String[][] straight = {
			{"4H","5C","6S","7D","8H"},
			{"6S","7D","9C","8H","TH"},
	};
	
	private static String[][] threeofakind = {
			{ "2S", "2C", "2H", "5D", "7H" },
			{ "2S", "AC", "AH", "5D", "AD" },
			{ "3S", "KC", "KH", "KD", "QS" },
			{ "9S", "9C", "2H", "5D", "9H" }
			};
	
	private static String[][] flush = {
			{ "2S", "4S", "8S", "5S", "7S" },
			{ "2C", "AC", "TC", "5C", "QC" },
			{ "3D", "KD", "2D", "QD", "JD" },
			{ "9H", "2H", "8H", "5H", "7H" }
			};
	
	private static String[][] fullhouse = {
			{ "2S", "2C", "5H", "5D", "5S" },
			{ "AS", "AC", "3H", "3D", "3S" },
			{ "KS", "KC", "3H", "3D", "3S" },
			{ "9S", "9C", "3C", "3D", "3H" }
			};
	
	private static String[][] fourofakind = {
			{ "2S", "2C", "2H", "2D", "7H" },
			{ "AS", "AC", "AH", "5D", "AD" },
			{ "5S", "2C", "5H", "5D", "5C" },
			{ "9S", "9C", "9H", "5D", "9D" }
			};
	
	private static String[][] straightflush = {
			{ "2S", "3S", "4S", "5S", "6S" },
			{ "KC", "AC", "JC", "QC", "TC" },
			{ "7H", "8H", "9H", "TH", "JH" },
			{ "5D", "6D", "7D", "8D", "9D" }
			};
	
	// This is where we store the translated hands
	ArrayList<ArrayList<Card>> highCardHands;
	ArrayList<ArrayList<Card>> pairHands;
	ArrayList<ArrayList<Card>> twoPairHands;
	ArrayList<ArrayList<Card>> straightHands;
	ArrayList<ArrayList<Card>> threeofakindHands;
	ArrayList<ArrayList<Card>> flushHands;
	ArrayList<ArrayList<Card>> fullhouseHands;
	ArrayList<ArrayList<Card>> fourofakindHands;
	ArrayList<ArrayList<Card>> straightflushHands;
	
	/**
	 * The makeHands method is called before each test method,
	 * and prepares the translated hands. We recreate these for
	 * each test method, in case the test method damages the data.
	 */
	@Before
	public void makeHands() {
		highCardHands = makeHands(highCards);
		pairHands = makeHands(pairs);
		twoPairHands = makeHands(twoPairs);
		straightHands = makeHands(straight);
		threeofakindHands = makeHands(threeofakind);
		flushHands = makeHands(flush);
		fullhouseHands = makeHands(fullhouse);
		fourofakindHands = makeHands(fourofakind);
		straightflushHands = makeHands(straightflush);
	}

	/**
	 * This is a test method for the isOnePair method in HandType.
	 * We expect all HighCard hands to be false, all OnePair hands to
	 * be true, all TwoPair hands to be true, etc.
	 */
	@Test
	public void testIsOnePair() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertTrue(HandType.isOnePair(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertTrue(HandType.isOnePair(hand)); // Two-pair contains a pair
		}
	
		
	}

	/**
	 * This is the test method for the isTwoPair in HandType.
	 */
	@Test
	public void testIsTwoPair() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isTwoPair(hand));
		}
		for (ArrayList<Card> hand : twoPairHands) {
			assertTrue(HandType.isTwoPair(hand));
		}
		
	}
	@Test
	public void testIsStraight() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isStraight(hand));
		}
		
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isStraight(hand));
		}
		
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isStraight(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertTrue(HandType.isStraight(hand));
		}
		
	}
	
	
	@Test
	public void testIsThreeOfKind() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isThreeOfAKind(hand));
		}
		
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isThreeOfAKind(hand));
		}
		
		for (ArrayList<Card> hand : fullhouseHands) {
			assertTrue(HandType.isThreeOfAKind(hand));
		}
		for (ArrayList<Card> hand : threeofakindHands) {
			assertTrue(HandType.isThreeOfAKind(hand));
		}
		
	}
	
	
	
	
	
	@Test
	public void testIsFlush() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isFlush(hand));
		}
		
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isFlush(hand));
		}
		
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isFlush(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isFlush(hand));
		}
		
		for (ArrayList<Card> hand : flushHands) {
			assertTrue(HandType.isFlush(hand));
		}
		
	}
	
	@Test
	public void testIsFullhouse() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		
		
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		
		for (ArrayList<Card> hand : threeofakindHands) {
			assertFalse(HandType.isFullHouse(hand));
		}
		
		for (ArrayList<Card> hand : fullhouseHands) {
			assertTrue(HandType.isFullHouse(hand));
		}
		
	}
	
	@Test
	public void testIsFourOfAKind() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		
		for (ArrayList<Card> hand : fullhouseHands) {
			assertFalse(HandType.isFourOfAKind(hand));
		}
		
		for (ArrayList<Card> hand : fourofakindHands) {
			assertTrue(HandType.isFourOfAKind(hand));
		}
		
	}
	
	@Test
	public void testIsStraightFlush() {
		for (ArrayList<Card> hand : highCardHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		
		for (ArrayList<Card> hand : pairHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		
		for (ArrayList<Card> hand : twoPairHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		for (ArrayList<Card> hand : straightHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		
		for (ArrayList<Card> hand : flushHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		
		for (ArrayList<Card> hand : fullhouseHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		
		for (ArrayList<Card> hand : fourofakindHands) {
			assertFalse(HandType.isStraightFlush(hand));
		}
		
		for (ArrayList<Card> hand : straightflushHands) {
			assertTrue(HandType.isStraightFlush(hand));
		}
		
	}
	
	/**
	 * Make an ArrayList of hands from an array of string-arrays
	 */
	private ArrayList<ArrayList<Card>> makeHands(String[][] handsIn) {
		ArrayList<ArrayList<Card>> handsOut = new ArrayList<>();
		for (String[] hand : handsIn) {
			handsOut.add(makeHand(hand));
		}
		return handsOut;
	}
	
	/**
	 * Make a hand (ArrayList<Card>) from an array of 5 strings
	 */
	private ArrayList<Card> makeHand(String[] inStrings) {
		ArrayList<Card> hand = new ArrayList<>();
		for (String in : inStrings) {
			hand.add(makeCard(in));
		}
		return hand;
	}
	
	/**
	 * Create a card from a 2-character String.
	 * First character is the rank (2-9, T, J, Q, K, A) 
	 * Second character is the suit (C, D, H, S)
	 * 
	 * No validation or error handling!
	 */
	private Card makeCard(String in) {
		char r = in.charAt(0);
		Card.Rank rank = null;
		if (r <= '9') rank = Card.Rank.values()[r-'0' - 2];
		else if (r == 'T') rank = Card.Rank.Ten;
		else if (r == 'J') rank = Card.Rank.Jack;
		else if (r == 'Q') rank = Card.Rank.Queen;
		else if (r == 'K') rank = Card.Rank.King;
		else if (r == 'A') rank = Card.Rank.Ace;
		
		char s = in.charAt(1);
		Card.Suit suit = null;
		if (s == 'C') suit = Card.Suit.Clubs;
		if (s == 'D') suit = Card.Suit.Diamonds;
		if (s == 'H') suit = Card.Suit.Hearts;
		if (s == 'S') suit = Card.Suit.Spades;

		return new Card(suit, rank);
	}
}
