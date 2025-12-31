package com.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuBarRegisterBook extends Application {

	// AnchorPane
	private AnchorPane paneMenuBar;

	// TextField
	private TextField txNameBook;
	private TextField txAuthorBook;
	private TextField txCountryBook;
	private TextField txAgeBook;
	private TextField txPriceBook;
	private TextField txNamePriceMarketBook;

	// Buttons
	private Button registerBook;
	private Button backMenu;

	// Scene
	private Scene sceneMenuBar;

	// Stage
	private Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		initComponentsMenuBarRegisterBook();
		initLayoutMenuBarRegisterBook();
		initListenersMenuBarRegisterBook();
		showMenuBarRegisterBook();
	}

	public void initComponentsMenuBarRegisterBook() {
		paneMenuBar = new AnchorPane();
		sceneMenuBar = new Scene(paneMenuBar);

		txNameBook = new TextField();
		txAuthorBook = new TextField();
		txCountryBook = new TextField();
		txAgeBook = new TextField();
		txPriceBook = new TextField();
		txNamePriceMarketBook = new TextField();

		registerBook = new Button("Cadastrar");
		backMenu = new Button("Voltar");

		paneMenuBar.getChildren().addAll(txNameBook, txAuthorBook, txCountryBook, txAgeBook, txPriceBook,
				txNamePriceMarketBook, registerBook, backMenu);

	}

	public void initLayoutMenuBarRegisterBook() {
		paneMenuBar.setPrefSize(400, 400);

		txNameBook.setPrefWidth(200);
		txNameBook.setLayoutX((400 - 200) / 2);
		txNameBook.setLayoutY(20);
		txNameBook.setPromptText("Digite o nome do livro");

		txAuthorBook.setPrefWidth(200);
		txAuthorBook.setLayoutX((400 - 200) / 2);
		txAuthorBook.setLayoutY(60);
		txAuthorBook.setPromptText("Digite o nome do autor");

		txCountryBook.setPrefWidth(200);
		txCountryBook.setLayoutX((400 - 200) / 2);
		txCountryBook.setLayoutY(100);
		txCountryBook.setPromptText("Digite o país");

		txAgeBook.setPrefWidth(200);
		txAgeBook.setLayoutX((400 - 200) / 2);
		txAgeBook.setLayoutY(140);
		txAgeBook.setPromptText("Digite o ano de publicação");

		txPriceBook.setPrefWidth(200);
		txPriceBook.setLayoutX((400 - 200) / 2);
		txPriceBook.setLayoutY(180);
		txPriceBook.setPromptText("Digite o preço");

		txNamePriceMarketBook.setPrefWidth(200);
		txNamePriceMarketBook.setLayoutX((400 - 200) / 2);
		txNamePriceMarketBook.setLayoutY(220);
		txNamePriceMarketBook.setPromptText("Digite o preço de mercado");

		registerBook.setPrefWidth(100);
		registerBook.setLayoutX((400 - 100) / 2);
		registerBook.setLayoutY(280);

		backMenu.setPrefWidth(100);
		backMenu.setLayoutX((400 - 100) / 2);
		backMenu.setLayoutY(320);
	}

	public void initListenersMenuBarRegisterBook() {
		try {
			
		} catch (Exception e) {
			
		}
		registerBook.setOnAction(e ->{
			
		});
		
		backMenu.setOnAction(e ->{
			try {
				new MenuMain().start(new Stage());
				stage.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		});
	}

	public void showMenuBarRegisterBook() {
		stage.setScene(sceneMenuBar);
		stage.setTitle("Posto Books - Registrar Livro");
		stage.setResizable(false);
		stage.show();
	}

}
