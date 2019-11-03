package poker.version_graphics.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum HandType {
    HighCard(1), OnePair(2), TwoPair(3), ThreeOfAKind(4), Straight(5), Flush(6), FullHouse(7), FourOfAKind(8), StraightFlush(9);
    
	HandType(int value){
		this.value = value;
	}
	private final Integer value;
	
	public Integer getValue() {
		return this.value;
	}
	
    /**
     * Determine the value of this hand. Note that this does not
     * account for any tie-breaking
     */
    public static HandType evaluateHand(ArrayList<Card> cards) {
        HandType currentEval = HighCard;
        
        if (isOnePair(cards)) currentEval = OnePair;
        if (isTwoPair(cards)) currentEval = TwoPair;
        if (isThreeOfAKind(cards)) currentEval = ThreeOfAKind;
        if (isStraight(cards)) currentEval = Straight;
        if (isFlush(cards)) currentEval = Flush;
        if (isFullHouse(cards)) currentEval = FullHouse;
        if (isFourOfAKind(cards)) currentEval = FourOfAKind;
        if (isStraightFlush(cards)) currentEval = StraightFlush;
        
        return currentEval;
        
        
    }
    
    // Comparing the Handtypes 
    
    
    
    
    
    public static boolean isOnePair(ArrayList<Card> cards) {
        boolean found = false;
        for (int i = 0; i < cards.size() - 1 && !found; i++) {
            for (int j = i+1; j < cards.size() && !found; j++) {
                if (cards.get(i).getRank() == cards.get(j).getRank()) found = true;
            }
        }
        return found;
    }
    
    public static boolean isTwoPair(ArrayList<Card> cards) {
        // Clone the cards, because we will be altering the list
        ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

        // Find the first pair; if found, remove the cards from the list
        boolean firstPairFound = false;
        for (int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
            for (int j = i+1; j < clonedCards.size() && !firstPairFound; j++) {
                if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()) {
                    firstPairFound = true;
                    clonedCards.remove(j);  // Remove the later card
                    clonedCards.remove(i);  // Before the earlier one
                }
            }
        }
        // If a first pair was found, see if there is a second pair
        return firstPairFound && isOnePair(clonedCards);
    }
    
    public static boolean isThreeOfAKind(ArrayList<Card> cards){
    	boolean isThreeOfAKindfound = false;
         for (int i = 0; i < cards.size() - 1 && !isThreeOfAKindfound; i++) {
             for (int j = i+1; j < cards.size() && !isThreeOfAKindfound; j++) {
            	 for (int m = j+1; m < cards.size() && !isThreeOfAKindfound; m++) {
             
                 if (cards.get(i).getRank() == cards.get(j).getRank() && cards.get(j).getRank() == cards.get(m).getRank()) {
                	 isThreeOfAKindfound = true;
                 }
    	
            	 }
             }
         }
         
       
        return isThreeOfAKindfound;
    }
    
    public static boolean isStraight(ArrayList<Card> cards) {
    	boolean isStraightfound = false;
    	
    	cards.sort((c1,c2) -> c1.getRank().compareTo(c2.getRank()));
    	int i =0;
    	while( i < 4 && cards.get(i).getRank().ordinal() + 1 == cards.get(i + 1).getRank().ordinal())
    	{
    		i++;
    	}
    	
    	if( i == 4)  isStraightfound = true;
    	return isStraightfound;
            
    }
    
    
      public static boolean isFlush(ArrayList<Card> cards) {
    	 boolean isFlushfound = false;
         for (int i = 0; i < cards.size() - 1 && !isFlushfound; i++) {
             for (int j = i+1; j < cards.size() && !isFlushfound; j++) {
            	 for(int m = j+1; m < cards.size() && !isFlushfound; m++) {
            		 for(int n = m+1; n < cards.size() && !isFlushfound; n++) {
            			 for(int v = n+1; v < cards.size() && !isFlushfound; v++) {
                 if (cards.get(i).getSuit() == cards.get(j).getSuit() && cards.get(j).getSuit() == cards.get(m).getSuit() && cards.get(m).getSuit() == cards.get(n).getSuit() && cards.get(n).getSuit() == cards.get(v).getSuit() ) isFlushfound = true;
             }
         }
    	
            	 }
            	 
             }
         }
    	        
        return isFlushfound;
    }
    
    public static boolean isFullHouse(ArrayList<Card> cards) {
		ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();
		boolean isThreeOfAKindfound = false;
		for (int i = 0; i < clonedCards.size() - 1 && !isThreeOfAKindfound; i++) {
			for (int j = i + 1; j < clonedCards.size() && !isThreeOfAKindfound; j++) {
				for (int m = j + 1; m < clonedCards.size() && !isThreeOfAKindfound; m++) {

					if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()
							&& clonedCards.get(j).getRank() == clonedCards.get(m).getRank()) {
						isThreeOfAKindfound = true;
						clonedCards.remove(m);
						clonedCards.remove(j);
						clonedCards.remove(i);

					}
				}
			}
		}
    
    boolean firstPairFound = false;
    for (int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
        for (int j = i+1; j < clonedCards.size() && !firstPairFound; j++) {
            if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()) {
                firstPairFound = true;
            }
        }
    }
    
    return firstPairFound && isThreeOfAKindfound;
    
    
     }
    
    public static boolean isFourOfAKind(ArrayList<Card> cards) {
    	
    	boolean isFourOfAKindfound = false;
    	for (int i = 0; i < cards.size() - 1 && !isFourOfAKindfound; i++) {
            for (int j = i+1; j < cards.size() && !isFourOfAKindfound; j++) {
           	 for (int m = j+1; m < cards.size() && !isFourOfAKindfound; m++) {
           		 for (int n = m+1; n < cards.size() && !isFourOfAKindfound; n++) {
            
                if (cards.get(i).getRank() == cards.get(j).getRank() && cards.get(j).getRank() == cards.get(m).getRank() && cards.get(m).getRank() == cards.get(n).getRank() ) isFourOfAKindfound = true;
   	
           	 }
            }
        }
    	}
    	
    	
    	
            
        return isFourOfAKindfound;
    }
    
    public static boolean isStraightFlush(ArrayList<Card> cards) {
    	
boolean isStraightfound = false;
    	
    	cards.sort((x1,x2) -> x1.getRank().compareTo(x2.getRank()));
    	int i =0;
    	while( i < 4 && cards.get(i).getRank().ordinal() + 1 == cards.get(i + 1).getRank().ordinal())
    	{
    		i++;
    	}
    	
    	if( i == 4)  isStraightfound = true;
    	
    	boolean isFlushfound = false;
        for (int c = 0; c < cards.size() - 1 && !isFlushfound; c++) {
            for (int j = c+1; j < cards.size() && !isFlushfound; j++) {
           	 for(int m = j+1; m < cards.size() && !isFlushfound; m++) {
           		 for(int n = m+1; n < cards.size() && !isFlushfound; n++) {
           			 for(int v = n+1; v < cards.size() && !isFlushfound; v++) {
                if (cards.get(c).getSuit() == cards.get(j).getSuit() && cards.get(j).getSuit() == cards.get(m).getSuit() && cards.get(m).getSuit() == cards.get(n).getSuit() && cards.get(n).getSuit() == cards.get(v).getSuit() ) isFlushfound = true;
            }
        }
   	
           	 }
           	 
            }
        }
    	
    	return isStraightfound && isFlushfound;
    	
     }
}
