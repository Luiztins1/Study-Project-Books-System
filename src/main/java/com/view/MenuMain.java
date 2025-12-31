package com.view;

import java.time.LocalDate;
import java.util.List;

import com.model.entities.Books;

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
	private TableView<Books> tbView;
	private TableColumn<Books, String> bookName;
	private TableColumn<Books, String> authorBook;
	private TableColumn<Books, String> country;
	private TableColumn<Books, LocalDate> age;
	private TableColumn<Books, Double> price;
	private TableColumn<Books, Double> priceMarket;
	private static ObservableList<Books> listItens = FXCollections.observableArrayList();

	// Menu
	VBox vbox;
	private Menu fileMenu;
	private Menu optionMenu;
	private Menu helpMenu;

	private MenuBar menuBar;

	private MenuItem registerBook;
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
		initListenersMenuMain();
		showMenuMain();
		 initItensTable();

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

		registerBook = new MenuItem("Registrar Livro");
		deleteBook = new MenuItem("Deletar Livro");
		registerUser = new MenuItem("Registrar Usuário");

		fileMenu.getItems().addAll(registerBook, deleteBook, registerUser);

		txSearchBookName = new TextField();

		btDeleteBook = new Button();
		btRegisterBook = new Button();

		tbView = new TableView<Books>();
		tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		bookName = new TableColumn<Books, String>("Livro");
		authorBook = new TableColumn<Books, String>("Autor");
		country = new TableColumn<Books, String>("Pais");
		age = new TableColumn<Books, LocalDate>("Ano");
		price = new TableColumn<Books, Double>("Preço");
		priceMarket = new TableColumn<Books, Double>("Preço de Mercado");

		bookName.setCellValueFactory(new PropertyValueFactory<Books, String>("name"));
		authorBook.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
		country.setCellValueFactory(new PropertyValueFactory<Books, String>("country"));
		age.setCellValueFactory(new PropertyValueFactory<Books, LocalDate>("age"));
		price.setCellValueFactory(new PropertyValueFactory<Books, Double>("price"));
		priceMarket.setCellValueFactory(new PropertyValueFactory<Books, Double>("priceMarket"));

		tbView.getColumns().addAll(bookName, authorBook, country, age, price, priceMarket);

		menuBar.getMenus().addAll(fileMenu, optionMenu, helpMenu);

		menuMain.getChildren().addAll(vbox, tbView);

	}

	
	public void initLayoutMenuMain() {
		tbView.setPrefWidth(600);
		tbView.setLayoutX(50);
		tbView.setLayoutY(100);
	}
	
	public void initListenersMenuMain() {
		registerBook.setOnAction(e ->{
			try {
				new MenuBarRegisterBook().start(new Stage());
				stage.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
		});
	}
	
	public void initItensTable() {
		listItens.clear();
		List<Books> bkList = LoginMenu.getController().addItensInViewTable();
		
		listItens.setAll(bkList);
		
		tbView.setItems(listItens);
		
	}

}
