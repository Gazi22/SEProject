package poker.version_graphics.model;

import java.util.ArrayList;

import poker.version_graphics.PokerGame;

public class PokerGameModel {
	public final ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck;
	
	public PokerGameModel() {
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			players.add(new Player("Player " + i));
		}
		
		deck = new DeckOfCards();
		ArrayList<Card> cards1 = new ArrayList<>();
		Card card1 = new Card(Card.Suit.Clubs, Card.Rank.Four);
		Card card2 = new Card(Card.Suit.Diamonds, Card.Rank.Four);
		Card card3 = new Card(Card.Suit.Hearts, Card.Rank.King);
		Card card4 = new Card(Card.Suit.Clubs, Card.Rank.King);
		Card card5 = new Card(Card.Suit.Diamonds, Card.Rank.King);
		cards1.add(card1);
		cards1.add(card2);
		cards1.add(card3);
		cards1.add(card4);
		cards1.add(card5);
		System.out.println(HandType.evaluateHand(cards1));

		
	}
	
	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	public DeckOfCards getDeck() {
		return deck;
	}
}
