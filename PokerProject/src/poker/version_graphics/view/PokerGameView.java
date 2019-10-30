package poker.version_graphics.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.PokerGameModel;

public class PokerGameView {
	private HBox players;
	private ControlArea controls;
	
	private PokerGameModel model;
	
	public PokerGameView(Stage stage, PokerGameModel model) {
		this.model = model;
		
		// Create all of the player panes we need, and put them into an HBox
		players = new HBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
		}
		
		// Creation of the Setup scene
		
		Label lbs = new Label("Welcome to the FHNW SE Poker Miniproject!");
		Label lbs2 = new Label("Four players max!");
		Label lbs3 = new Label("How many players are you?");
		
		Button chng = new Button ("Start!");
		
		BorderPane boot = new BorderPane();
		VBox h = new VBox(lbs,lbs2,lbs3, chng);
		boot.getStylesheets().add(
                getClass().getResource("titlepage.css").toExternalForm());
		boot.setCenter(h);
		
		
		
		Scene scene1 = new Scene(boot, 400, 400);
		stage.setTitle("Poker");
		stage.setScene(scene1);
		stage.show();
		
		
		
		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic
		
		// Put players and controls into a BorderPane
		BorderPane root = new BorderPane();
		root.setCenter(players);
		root.setBottom(controls);
		
		// Disallow resizing - which is difficult to get right with images
		stage.setResizable(false);

        // Create the scene using our layout; then display it
        Scene sce = new Scene(root);
        sce.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        stage.setTitle("Poker Miniproject");
        stage.setScene(scene1);
        stage.show();	
        
        // Switching to the main Scene
        chng.setOnAction(e-> stage.setScene(sce));
	}
	
	public PlayerPane getPlayerPane(int i) {
		return (PlayerPane) players.getChildren().get(i);
	}
	
	public Button getShuffleButton() {
		return controls.btnShuffle;
	}
	
	public Button getDealButton() {
		return controls.btnDeal;
	}
	
	public Button getBackButton() {
		return controls.btnBack;
	}
	
	public Button getAddButton() {
	return controls.btnAdd;
	}
	
}
