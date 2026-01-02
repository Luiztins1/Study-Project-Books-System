package com.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.model.entities.Books;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuMain extends Application {

	// Tables
	private TableView<Books> tbView;
	private TableColumn<Books, Integer> bookId;
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

	// Text
	private Text portoBooks;

	// Buttons
	private Button btSearchBook;
	private Button btBackProgram;

	// Stage
	Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		initComponentsMenuMain();
		initLayoutMenuMain();
		initListenersMenuMain();
		showMenuMain();

	}

	public void showMenuMain() {
		stage.setScene(menuScene);
		stage.setTitle("Porto Books - Menu");
		stage.setResizable(false);
		stage.show();

		menuMain.requestFocus();

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
		registerUser = new MenuItem("Registrar Cliente");

		fileMenu.getItems().addAll(registerBook, deleteBook, registerUser);

		txSearchBookName = new TextField();

		portoBooks = new Text("Porto Books");

		btSearchBook = new Button("Pesquisar");
		btBackProgram = new Button("Sair");

		tbView = new TableView<Books>();
		tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		bookId = new TableColumn<Books, Integer>("Id");
		bookName = new TableColumn<Books, String>("Livro");
		authorBook = new TableColumn<Books, String>("Autor");
		country = new TableColumn<Books, String>("Pais");
		age = new TableColumn<Books, LocalDate>("Ano");
		price = new TableColumn<Books, Double>("Preço");
		priceMarket = new TableColumn<Books, Double>("Preço de Mercado");
		
		bookId.setResizable(false);
		bookId.setReorderable(false);
		
		bookName.setResizable(false);
		bookName.setReorderable(false);
		
		authorBook.setResizable(false);
		authorBook.setReorderable(false);
		
		country.setResizable(false);
		country.setReorderable(false);
		
		age.setResizable(false);
		age.setReorderable(false);
		
		price.setResizable(false);
		price.setReorderable(false);
		
		priceMarket.setResizable(false);
		priceMarket.setReorderable(false);

		bookId.setCellValueFactory(new PropertyValueFactory<Books, Integer>("id"));
		bookName.setCellValueFactory(new PropertyValueFactory<Books, String>("name"));
		authorBook.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
		country.setCellValueFactory(new PropertyValueFactory<Books, String>("country"));
		age.setCellValueFactory(new PropertyValueFactory<Books, LocalDate>("age"));
		price.setCellValueFactory(new PropertyValueFactory<Books, Double>("price"));
		priceMarket.setCellValueFactory(new PropertyValueFactory<Books, Double>("priceMarket"));

		tbView.getColumns().addAll(bookId, bookName, authorBook, country, age, price, priceMarket);

		menuBar.getMenus().addAll(fileMenu, optionMenu, helpMenu);

		menuMain.getChildren().addAll(vbox, tbView, txSearchBookName, btSearchBook, btBackProgram, portoBooks);

	}

	public void initLayoutMenuMain() {
		tbView.setPrefWidth(600);
		tbView.setLayoutX(50);
		tbView.setLayoutY(100);

		txSearchBookName.setPrefWidth(200);
		txSearchBookName.setLayoutX(450);
		txSearchBookName.setLayoutY(60);
		txSearchBookName.setPromptText("Pesquisar livro (nome ou ID)");

		portoBooks.setLayoutX(52);
		portoBooks.setLayoutY(80);

		btSearchBook.setPrefWidth(80);
		btSearchBook.setLayoutX(350);
		btSearchBook.setLayoutY(60);
		
		btBackProgram.setPrefWidth(100);
		btBackProgram.setLayoutX(550);
		btBackProgram.setLayoutY(520);
	}

	public void initListenersMenuMain() {
		registerBook.setOnAction(e -> {
			try {
				new MenuBarRegisterBook().start(new Stage());
				stage.close();
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		});
		
		deleteBook.setOnAction(e ->{
			try {
				new MenuBarDeleteBook().start(new Stage());
				stage.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
		});

		if (txSearchBookName.getText() == null || txSearchBookName.getText().trim().isEmpty()) {
			tbView.setPlaceholder(new Label("Faça um pesquisa"));
		}

		btSearchBook.setOnAction(e -> {
			String search = txSearchBookName.getText().trim();
			List<Books> bList = new ArrayList<>();

			if (search.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Pesquisa inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
				txSearchBookName.clear();
				return;
			}

			if (search.matches("\\d+")) {
				Integer id = Integer.parseInt(search);
				Books booksId = LoginMenu.getController().booksDao.findById(id);

				bList.add(booksId);

				if (booksId != null) {
					listItens.setAll(bList);
				} else {
					listItens.clear();
				}

				txSearchBookName.clear();

			} else {
				List<Books> searchBook = LoginMenu.getController().booksDao.searchBookName(search);	
				listItens.setAll(searchBook);
			}
			
			txSearchBookName.clear();
			tbView.setItems(listItens);

		});
		
		registerUser.setOnAction(e ->{
			try {
				new MenuBarRegisterClient().start(new Stage());
				stage.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
		
		btBackProgram.setOnAction(e ->{
			try {
				stage.close();
				
				System.exit(0);
			} catch (Exception e3) {
				e3.printStackTrace();
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
