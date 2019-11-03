package poker.version_graphics.model;

import java.util.Collections;

public class Card {
    public enum Suit { Clubs, Diamonds, Hearts, Spades;
        @Override
        public String toString() {
            String suit = "";
            switch (this) {
            case Clubs: suit = "clubs"; break;
            case Diamonds: suit = "diamonds"; break;
            case Hearts: suit = "hearts"; break;
            case Spades: suit = "spades"; break;
            }
            return suit;
        }
    };
    
    public enum Rank { Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13), Ace(14);
    	
    
        @Override
        public String toString() {
            String str = "ace";  // Assume we have an ace, then cover all other cases
            // Get ordinal value, which ranges from 0 to 12
            int ordinal = this.ordinal();
            if (ordinal <= 8) {
                str = Integer.toString(ordinal+2);
            } else if (ordinal == 9) { // Jack
                str = "jack";
            } else if (ordinal == 10) { // Queen
                str = "queen";
            } else if (ordinal == 11) { // King
                str = "king";
            }
            return str;
        }
        
        private final int value;
        private Rank (final int value) {
        	this.value = value;
        }
      
        };
        
    private final Suit suit;
    private final Rank rank;
    
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
      
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
    
    
    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }
}
