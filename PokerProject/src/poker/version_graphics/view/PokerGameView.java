package poker.version_graphics.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
	
	public PokerGameView(Stage stage, PokerGameModel model) throws FileNotFoundException {
		this.stage = stage;
		this.model = model;
		
		// Create all of the player panes we need, and put them into an HBox
		players = new HBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
		}
		
		// Creation of the Setup scene
		Label lb = new Label("");
		Label lbs = new Label("Welcome to the SE Poker Miniproject!");
		Label lbs2 = new Label("Four players max!");
		Label lbs3 = new Label("How many players are you?");
        final Region spacer1 = new Region();
		Button chng = new Button ("Start!");
		
		lbs.setTextFill(Color.GOLD);
		lbs2.setTextFill(Color.BLACK);
		lbs3.setTextFill(Color.GOLD);
		spacer1.setMinHeight(125);
		
		
		BorderPane boot = new BorderPane();
		
        boot.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
		
		VBox h = new VBox(spacer1,lbs,lbs2,lbs3);
        h.getStyleClass().add("vboxscene"); // CSS style class
        
        //add to Pane
        boot.setTop(spacer1);
        boot.setCenter(h);
        boot.setBottom(chng);
        
        
        //Set background
        Image image1 = new Image(new FileInputStream("C:\\Users\\visnu\\git\\SEProject\\PokerProject\\src\\poker\\version_graphics\\view\\PokerStartScene.jpg"));
        BackgroundSize bSize = new BackgroundSize (500,500,false,false,true,false);
		boot.setBackground(new Background(new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,bSize)));
		
		this.scene1 = new Scene(boot, 500, 500);
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
        sce.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        this.stage.setTitle("Poker Miniproject");
        this.stage.setScene(this.scene1);
        this.stage.show();	
		
        // Switching to the main Scene

		
		players2.setOnAction(e -> {
			
			stage.setScene(sce);
			
		});
	
		
		players3.setOnAction(e -> {
			
			stage.setScene(sce);	
			
		});


		players4.setOnAction(e -> {
			
			stage.setScene(sce);
		
		});


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
