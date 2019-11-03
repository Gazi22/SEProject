package poker.version_graphics.view;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.Card;
import poker.version_graphics.model.HandType;
import poker.version_graphics.model.Player;
import poker.version_graphics.view.PokerGameView;

public class PlayerPane extends VBox {
    private Label lblName = new Label();
    private HBox hboxCards = new HBox();
    private Label lblDeter = new Label("--");
    private Label lblEvaluation = new Label("--");
    
    // Link to player object
    private Player player;
    
    public PlayerPane() {
        super(); // Always call super-constructor first !!
        this.getStyleClass().add("player"); // CSS style class
        
        // Add child nodes
        this.getChildren().addAll(lblName, hboxCards, lblEvaluation, lblDeter);
        
        // Add CardLabels for the cards
        for (int i = 0; i < 5; i++) {
            Label lblCard = new CardLabel();
            
            lblCard.setTextFill(Color.RED);
            lblCard.getStyleClass().add("player-name");
            hboxCards.getChildren().add(lblCard);
            hboxCards.setSpacing(2);

        }
    }
    
    public void setPlayer(Player player) {
    	this.player = player;
    	updatePlayerDisplay(); // Immediately display the player information
    }
    
    public void updatePlayerDisplay() {
    	lblName.setText(player.getPlayerName());
    	lblName.setOpacity(1);
    	lblName.setTextFill(Color.GOLD);
    	
    	for (int i = 0; i < Player.HAND_SIZE; i++) {
    		Card card = null;
    		if (player.getCards().size() > i) card = player.getCards().get(i);
    		CardLabel cl = (CardLabel) hboxCards.getChildren().get(i);
    		cl.setCard(card);
    		HandType evaluation = player.evaluateHand();
    		if (evaluation != null)
    			lblEvaluation.setText(evaluation.toString());
    		else
    			lblEvaluation.setText("--");
    	
    	}

    }
    
	// method to display the winner or loser of the round
	public void updateWinners(ArrayList<Player> winnerList) {
		if (winnerList != null) {
			if (winnerList.contains(this.player)) {
				lblDeter.setText("Winner");
			} else {
				lblDeter.setText("Loser");
			}
		}
	}
}
