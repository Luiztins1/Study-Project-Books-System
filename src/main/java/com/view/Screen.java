package com.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.controller.MenuMainOperations;
import com.model.utils.UtilsObj;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Screen extends Application {

	// AnchorPanes
	private AnchorPane loginPane;
	private AnchorPane menuMain;
	private AnchorPane menuRegister;

	// Scenes
	private Scene menuScene;
	private Scene loginScene;
	private Scene registerScene;

	// TextFields
	private TextField txLoginName;
	private TextField txLoginPassword;

	private TextField txRegisterName;
	private TextField txRegisterPassword;

	private TextField txSearchBookName;

	// Buttons
	private Button btLogin;
	private Button btRegisterLogin;

	private Button btRegisterMenu;
	private Button btExit;

	// Stage
	private Stage stage;

	// JPA/Hibernate managers
	private EntityManagerFactory emf;
	private EntityManager em;
	private MenuMainOperations controller;

	private boolean flag = true;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;

		// Initialize
		initComponentsLoginScene();
		initLayoutLoginScene();
		initListenerLoginScene();
		showLoginScene();

	}

	public void init() {
		this.emf = Persistence.createEntityManagerFactory("books-system");
		this.em = emf.createEntityManager();
		this.controller = new MenuMainOperations(this.em);
	}

	public void showLoginScene() {
		stage.setScene(loginScene);
		stage.setTitle("Porto Books - Login");
		stage.setResizable(false);
		stage.show();

	}

	public void initComponentsLoginScene() {

		loginPane = new AnchorPane();
		loginScene = new Scene(loginPane);

		txLoginName = new TextField();
		txLoginPassword = new TextField();

		btLogin = new Button();
		btRegisterLogin = new Button();

		loginPane.getChildren().addAll(txLoginName, txLoginPassword, btLogin, btRegisterLogin);

	}

	public void initLayoutLoginScene() {
		// Painel
		loginPane.setPrefSize(400, 400);

		// Campos
		txLoginName.setPrefWidth(200);
		txLoginName.setLayoutX((400 - 200) / 2);
		txLoginName.setLayoutY(150);
		txLoginName.setPromptText("Digite seu nome");

		txLoginPassword.setPrefWidth(200);
		txLoginPassword.setLayoutX((400 - 200) / 2);
		txLoginPassword.setLayoutY(190);
		txLoginPassword.setPromptText("Digite sua senha");

		// Botões
		btLogin.setPrefWidth(100);
		btLogin.setLayoutX((400 - 100) / 2);
		btLogin.setLayoutY(250);
		btLogin.setText("Login");

		btRegisterLogin.setPrefWidth(100);
		btRegisterLogin.setLayoutX((400 - 100) / 2);
		btRegisterLogin.setLayoutY(290);
		btRegisterLogin.setText("Registrar");

	}

	public void initListenerLoginScene() {
		btLogin.setOnAction(e -> {
			try {
				String name = txLoginName.getText();
				String password = txLoginPassword.getText();

				if (name.length() > 25 || password.length() > 4) {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				controller.loginVerification(name, Integer.parseInt(password));

				if (UtilsObj.flagUtil) {
					UtilsObj.flagUtil = false;
					stage.close();
					initComponentsMenuMain();
					initLayoutMenuMain();
					showMenuMain();
				}

			} catch (java.lang.NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
			} finally {
				txLoginName.clear();
				txLoginPassword.clear();
			}
		});

		try {
			btRegisterLogin.setOnAction(e -> {
				stage.close();
				initComponentMenuRegister();
				initLayoutMenuRegister();
				initListenerMenuRegister();
				showMenuRegister();
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			txLoginName.clear();
			txLoginPassword.clear();
		}

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
		txRegisterPassword = new TextField();

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

				controller.registerEmployee(name, Integer.parseInt(password));
				
				if (UtilsObj.flagUtil) {
					UtilsObj.flagUtil = false;
					stage.close();
					showLoginScene();
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
				stage.close();
				showLoginScene();
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			txRegisterName.clear();
			txRegisterPassword.clear();
		}

	}

	public void initComponentsMenuMain() {
		menuMain = new AnchorPane();
		menuScene = new Scene(menuMain);

	}

	public void initLayoutMenuMain() {
		menuMain.setPrefSize(600, 600);
	}

	// Método para o menu principal.
	public void showMenuMain() {
		stage.setScene(menuScene);
		stage.setTitle("Porto Books - Menu");
		stage.setResizable(false);
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Encerrando conexões...");
		if (em == null && em.isOpen())
			em.close();
		if (emf == null && emf.isOpen())
			emf.close();
		System.out.println("Sistema fechado com sucesso!");
	}

}
