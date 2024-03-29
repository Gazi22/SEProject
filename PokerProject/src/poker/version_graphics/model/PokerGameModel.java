package poker.version_graphics.model;

import java.util.ArrayList;
import poker.version_graphics.view.PokerGameView;
import poker.version_graphics.PokerGame;

public class PokerGameModel {
	public final ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck;
	
	public PokerGameModel() {
		
		generatePlayers();
		
		// test method for checking if the HandTypes are working
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
		if(players.isEmpty()) {
			generatePlayers();
		}
		return players.get(i);
	}
	
	// method for getting the text from the TextFields and putting them in the labels
	public void generatePlayers() {
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			players.add(new Player(PokerGameView.arrayTextFields[i].getText()));
		}
	}
	
	public DeckOfCards getDeck() {
		return deck;
	}

	// method for evaluating the winner or loser of the round
	public ArrayList<Player> evaluateWinner() {
		ArrayList<Player> highestPlayers = new ArrayList<>();
		for (Player p : players) {
			if (highestPlayers.isEmpty()) {
				highestPlayers.add(p);
			} else {
				if (p.compareTo(highestPlayers.get(0)) > 0) {
					highestPlayers.clear();
					highestPlayers.add(p);
				} else if (p.compareTo(highestPlayers.get(0)) == 0) {
					highestPlayers.add(p);
				}
			}
		}
		return highestPlayers;
	}
}
