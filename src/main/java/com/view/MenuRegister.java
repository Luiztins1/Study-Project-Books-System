package com.view;

import javax.swing.JOptionPane;

import com.model.utils.UtilsObj;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuRegister extends Application {

	//AnchorPane
	private AnchorPane menuRegister;
	
	//Scene
	private Scene registerScene;
	
	//TextField
	private TextField txRegisterName;
	
	//PasswordField
	private PasswordField txRegisterPassword;
	
	//Buttons
	private Button btRegisterMenu;
	private Button btExit;
	
	//Stage
	private Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		initComponentMenuRegister();
		initLayoutMenuRegister();
		initListenerMenuRegister();
		showMenuRegister();

	}

	public void showMenuRegister() {
		stage.setScene(registerScene);
		stage.setTitle("Porto Books - Registrar");
		stage.setResizable(false);
		stage.show();

	}

	public void initComponentMenuRegister() {
		menuRegister = new AnchorPane();
		registerScene = new Scene(menuRegister);
		btRegisterMenu = new Button();
		btExit = new Button();
		txRegisterName = new TextField();
		txRegisterPassword = new PasswordField();

		menuRegister.getChildren().addAll(btRegisterMenu, btExit, txRegisterName, txRegisterPassword);

	}

	public void initLayoutMenuRegister() {
		menuRegister.setPrefSize(400, 400);

		// Campos
		txRegisterName.setPrefWidth(200);
		txRegisterName.setLayoutX((400 - 200) / 2);
		txRegisterName.setLayoutY(150);
		txRegisterName.setPromptText("Digite seu nome");

		txRegisterPassword.setPrefWidth(200);
		txRegisterPassword.setLayoutX((400 - 200) / 2);
		txRegisterPassword.setLayoutY(190);
		txRegisterPassword.setPromptText("Digite uma senha");

		// Botões
		btRegisterMenu.setPrefWidth(100);
		btRegisterMenu.setLayoutX((400 - 100) / 2);
		btRegisterMenu.setLayoutY(270);
		btRegisterMenu.setText("Criar conta");

		btExit.setPrefWidth(100);
		btExit.setLayoutX((400 - 100) / 2);
		btExit.setLayoutY(310);
		btExit.setText("Voltar ao menu");

	}

	public void initListenerMenuRegister() {
		btRegisterMenu.setOnAction(e -> {
			try {
				String name = txRegisterName.getText();
				String password = txRegisterPassword.getText();

				if (name.length() > 25 || password.length() > 4) {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				LoginMenu.getController().registerEmployee(name, Integer.parseInt(password));

				if (UtilsObj.flagUtil) {
					UtilsObj.flagUtil = false;
					try {
						new LoginMenu().start(new Stage());
						stage.close();
					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "Algo Inesperado ocorreu", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}

			} catch (java.lang.NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
			} finally {
				txRegisterName.clear();
				txRegisterPassword.clear();
			}

		});

		try {
			btExit.setOnAction(e -> {
				try {
					new LoginMenu().start(new Stage());
					stage.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo Inesperado ocorreu", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			txRegisterName.clear();
			txRegisterPassword.clear();
		}

	}

}
