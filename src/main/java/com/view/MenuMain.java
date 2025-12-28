package com.view;

import com.model.entities.ItensProperty;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuMain extends Application {

	// Tables
	private TableView<ItensProperty> tbView;
	private TableColumn<ItensProperty, String> bookName;
	private TableColumn<ItensProperty, String> authorBook;
	private TableColumn<ItensProperty, String> country;
	private TableColumn<ItensProperty, Integer> age;
	private TableColumn<ItensProperty, Double> price;
	private TableColumn<ItensProperty, Double> priceMarket;
	private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();

	// Menu
	VBox vbox;
	private Menu fileMenu;
	private Menu optionMenu;
	private Menu helpMenu;

	private MenuBar menuBar;

	private MenuItem searchBook;
	private MenuItem deleteBook;
	private MenuItem registerUser;

	// AnchorPane
	private AnchorPane menuMain;

	// Scenes
	private Scene menuScene;

	// TextField
	private TextField txSearchBookName;

	// Buttons
	private Button btDeleteBook;
	private Button btRegisterBook;

	// Stage
	Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		initComponentsMenuMain();
		initLayoutMenuMain();
		showMenuMain();

	}

	public void showMenuMain() {
		stage.setScene(menuScene);
		stage.setTitle("Porto Books - Menu");
		stage.setResizable(false);
		stage.show();

	}

	@SuppressWarnings("unchecked")
	public void initComponentsMenuMain() {
		menuMain = new AnchorPane();
		menuScene = new Scene(menuMain);

		menuBar = new MenuBar();
		vbox = new VBox(menuBar);

		vbox.setPrefSize(700, 200);
		menuMain.setPrefSize(700, 600);

		fileMenu = new Menu("Utilitários");
		optionMenu = new Menu("Opções");
		helpMenu = new Menu("Ajuda");

		searchBook = new MenuItem("Pesquisar Livro");
		deleteBook = new MenuItem("Deletar Livro");
		registerUser = new MenuItem("Registrar Usuário");

		fileMenu.getItems().addAll(searchBook, deleteBook, registerUser);

		txSearchBookName = new TextField();

		btDeleteBook = new Button();
		btRegisterBook = new Button();

		tbView = new TableView<ItensProperty>();
		tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		bookName = new TableColumn<ItensProperty, String>("Livro");
		authorBook = new TableColumn<ItensProperty, String>("Autor");
		country = new TableColumn<ItensProperty, String>("Pais");
		age = new TableColumn<ItensProperty, Integer>("Ano");
		price = new TableColumn<ItensProperty, Double>("Preço");
		priceMarket = new TableColumn<ItensProperty, Double>("Preço de Mercado");

		bookName.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("Livro"));
		authorBook.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("Autor"));
		country.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("Pais"));
		age.setCellValueFactory(new PropertyValueFactory<ItensProperty, Integer>("Ano"));
		price.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>("Preço"));
		priceMarket.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>("Preço de Mercado"));

		tbView.getColumns().addAll(bookName, authorBook, country, age, price, priceMarket);

		menuBar.getMenus().addAll(fileMenu, optionMenu, helpMenu);

		menuMain.getChildren().addAll(vbox, tbView);

	}

	
	public void initLayoutMenuMain() {
		tbView.setPrefWidth(600);
		tbView.setLayoutX(50);
		tbView.setLayoutY(100);
	}

}
