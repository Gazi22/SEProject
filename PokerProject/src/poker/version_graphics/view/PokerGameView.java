package poker.version_graphics.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.Player;
import poker.version_graphics.model.PokerGameModel;
import poker.version_graphics.view.PlayerPane;

public class PokerGameView {
	
	private HBox players;
	private ControlArea controls;

	private PokerGameModel model;

	public Stage stage;
	public Scene scene1;
	// Create TextFields for names
	public static TextField name1 = new TextField();
	public static TextField name2 = new TextField();
	public static TextField name3 = new TextField();
	public static TextField name4 = new TextField();
	public static TextField[] arrayTextFields = { name1, name2, name3, name4 };

	public PokerGameView(Stage stage, PokerGameModel model) {
		this.stage = stage;
		this.model = model;

		// Create all of the player panes we need, and put them into an HBox
		players = new HBox();

		// Create Labels for first scene
		Label lb = new Label("");
		Label lbs = new Label("Welcome to the SE Poker Miniproject!");
		Label lbs2 = new Label("Four players max!");

		// Create transparent text
		name1.setPromptText("Please enter Name of Player 1");
		name2.setPromptText("Please enter Name of Player 2");
		name3.setPromptText("Please enter Name of Player 3");
		name4.setPromptText("Please enter Name of Player 4");

		// Set size of TextFields
		name1.setPrefSize(10, 10);
		name2.setPrefSize(10, 10);
		name3.setPrefSize(10, 10);
		name4.setPrefSize(10, 10);

		// Create buttons which sets the numbers of players
		Button players2 = new Button("Start with 2 Players!");
		Button players3 = new Button("Start with 3 Players!");
		Button players4 = new Button("Start with 4 Players!");

		BorderPane boot = new BorderPane();

		// Put all labels in the first VBox and put all TextFields and Buttons in the second VBox
		VBox v1 = new VBox(lb, lbs, lbs2);
		VBox v2 = new VBox(name1, name2, players2, name3, players3, name4, players4);

		v1.getStyleClass().add("vbox");
		
		
		v1.setAlignment(Pos.CENTER);
		v2.setAlignment(Pos.CENTER);

		boot.setTop(v1);
		boot.setCenter(v2);

		this.scene1 = new Scene(boot, 400, 400);
		
		scene1.getStylesheets().add(getClass().getResource("poker.css").toExternalForm());
		stage.setTitle("Poker");

		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic

		// Put players and controls into a BorderPane
		BorderPane root = new BorderPane();
		root.setCenter(players);
		root.setBottom(controls);
		
		
		// Disallow resizing - which is difficult to get right with images
		this.stage.setResizable(false);

		// Create the scene using our layout; then display it
		Scene sce = new Scene(root);
		sce.getStylesheets().add(getClass().getResource("poker.css").toExternalForm());
		this.stage.setTitle("Poker Miniproject");
		this.stage.setScene(this.scene1);
		this.stage.show();

		// Switching to the main (second) Scene and select how many players are playing
		players2.setOnAction(e -> {
			PokerGame.NUM_PLAYERS = 2;
			clearScene();
			startGame();
			stage.setScene(sce);

		});

		players3.setOnAction(e -> {
			PokerGame.NUM_PLAYERS = 3;
			clearScene();
			startGame();
			stage.setScene(sce);

		});

		players4.setOnAction(e -> {
			PokerGame.NUM_PLAYERS = 4;
			clearScene();
			startGame();
			stage.setScene(sce);

		});

	}
		// Create player panes
	public void startGame() {
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
		}
	}

	// method for clearing the scene 
	public void clearScene() {
		model.players.clear();
		players.getChildren().clear();
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
	

		
	

}
