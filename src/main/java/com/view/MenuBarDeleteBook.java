package com.view;

import javax.swing.JOptionPane;

import com.model.entities.Books;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuBarDeleteBook extends Application {

	// AnchorPanes
	private AnchorPane paneDeleteBook;

	// TextFields
	private TextField txIdBook;

	// Button
	private Button deleteBook;

	// Scene
	Scene sceneDeleteBook;

	// Stage
	private Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		initComponentsMenuBarDeleteBook();
		initLayoutComponentsMenuBarDeleteBook();
		initListenersMenuBarDeleteBook();
		showMenuBarDeleteBook();

	}

	public void initComponentsMenuBarDeleteBook() {
		paneDeleteBook = new AnchorPane();
		sceneDeleteBook = new Scene(paneDeleteBook);

		txIdBook = new TextField();

		deleteBook = new Button();

		paneDeleteBook.getChildren().addAll(txIdBook, deleteBook);

	}

	public void initLayoutComponentsMenuBarDeleteBook() {
		paneDeleteBook.setPrefSize(320, 300);

		txIdBook.setPrefWidth(200);
		txIdBook.setLayoutX((320 - 200) / 2);
		txIdBook.setLayoutY(90);
		txIdBook.setPromptText("Digite o ID");

		deleteBook.setPrefWidth(100);
		deleteBook.setLayoutX((320 - 100) / 2);
		deleteBook.setLayoutY(200);
		deleteBook.setText("Deletar");
	}

	public void initListenersMenuBarDeleteBook() {
		deleteBook.setOnAction(e -> {
			String idBook = txIdBook.getText();

			if (idBook.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.", "Error",
						JOptionPane.PLAIN_MESSAGE);
				return;
			} else {
				Integer id = Integer.parseInt(idBook);
				LoginMenu.getController().booksDao.delete(id);
				try {
					new MenuMain().start(new Stage());
					
					stage.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
			
		});
	}

	public void showMenuBarDeleteBook() {
		stage.setScene(sceneDeleteBook);
		stage.setTitle("Porto Books - Deletar Livro");
		stage.setResizable(false);
		stage.show();

		deleteBook.requestFocus();
	}

}
