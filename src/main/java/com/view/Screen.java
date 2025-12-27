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

	@Override
	public void start(Stage primaryStage) throws Exception {
		initComponents();
		this.stage = primaryStage;

		showLoginScene();
	}

	// Método responsável por iniciar a conexão ao banco de dados com JavafX.
	public void init() {
		this.emf = Persistence.createEntityManagerFactory("books-system");
		this.em = emf.createEntityManager();
		this.controller = new MenuMainOperations(this.em);
	}

	public void initComponents() {

		// LoginMenu
		loginPane = new AnchorPane();
		loginScene = new Scene(loginPane);
		txLoginName = new TextField();
		txLoginPassword = new TextField();
		btLogin = new Button();
		btRegisterLogin = new Button();

		loginPane.getChildren().addAll(txLoginName, txLoginPassword, btLogin, btRegisterLogin);

		// MenuMain
		menuMain = new AnchorPane();
		menuScene = new Scene(menuMain);

		// MenuRegister
		menuRegister = new AnchorPane();
		registerScene = new Scene(menuRegister);
		btRegisterMenu = new Button();
		btExit = new Button();
		txRegisterName = new TextField();
		txRegisterPassword = new TextField();
		menuRegister.getChildren().addAll(btRegisterMenu, btExit, txRegisterName, txRegisterPassword);

	}

	// Método de para tela de login.
	public void showLoginScene() {

		// Painel
		loginPane.setPrefSize(400, 400);

		stage.setScene(loginScene);
		stage.setTitle("Porto Books - Login");
		stage.setResizable(false);
		stage.show();

		// Campos
		txLoginName.setLayoutX((loginPane.getWidth() - txLoginName.getWidth()) / 2);
		txLoginName.setLayoutY(150);
		txLoginName.setPromptText("Digite seu nome");

		txLoginPassword.setPromptText("Digite sua senha");
		txLoginPassword.setLayoutX((loginPane.getWidth() - txLoginPassword.getWidth()) / 2);
		txLoginPassword.setLayoutY(190);

		// Botões
		btLogin.setLayoutX((loginPane.getWidth() - btLogin.getWidth()) / 2);
		btLogin.setLayoutY(270);
		btLogin.setText("Login");

		btRegisterLogin.setText("Registrar");
		btRegisterLogin.setLayoutX((loginPane.getWidth() - btRegisterLogin.getWidth()) / 2);
		btRegisterLogin.setLayoutY(310);

		// Ações Button
		btLogin.setOnAction(e -> {
			try {
				String name = txLoginName.getText();
				String password = txLoginPassword.getText();

				if(name.length() > 50){
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(password.length() > 10) {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error", JOptionPane.ERROR_MESSAGE);	
				}
				
				//Realiza a verificação de login e converter a senha em Integer.
				controller.loginVerification(name, Integer.parseInt(password));

				if (UtilsObj.flagUtil) {
					showMenuMain();
				}

			} catch (java.lang.NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
			} finally {
				txLoginName.clear();
				txLoginPassword.clear();
			}

		});

		btRegisterLogin.setOnAction(e -> {
			showMenuRegister();
		});

	}

	// Método para o menu principal.
	public void showMenuMain() {

		menuMain.setPrefSize(400, 400);

		stage.setScene(menuScene);
		stage.show();
	}

	// Método para o menu de registro de usuário.
	public void showMenuRegister() {

		menuRegister.setPrefSize(400, 400);

		stage.setScene(registerScene);
		stage.setResizable(false);
		stage.show();

		// Campos
		txRegisterName.setLayoutX((menuRegister.getWidth() - txRegisterName.getWidth()) / 2);
		txRegisterName.setLayoutY(150);

		txRegisterPassword.setLayoutX((menuRegister.getWidth() - txRegisterPassword.getWidth()) / 2);
		txRegisterPassword.setLayoutY(190);

		txRegisterName.setPromptText("Digite seu nome");
		txRegisterPassword.setPromptText("Digite uma senha");

		// Botões
		btRegisterMenu.setPrefSize(150, 0);
		btRegisterMenu.setLayoutX((menuRegister.getWidth() - btRegisterMenu.getWidth()) / 2);
		btRegisterMenu.setLayoutY(270);
		btRegisterMenu.setText("Criar conta");

		btExit.setPrefSize(150, 0);
		btExit.setLayoutX((menuRegister.getWidth() - btExit.getWidth()) / 2);
		btExit.setLayoutY(310);
		btExit.setText("Voltar ao menu");

		// Ações Botões
		btRegisterMenu.setOnAction(e -> {
			try {
				String name = txRegisterName.getText();
				String password = txRegisterPassword.getText();
				
				if(name.length() > 50){
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(password.length() > 10) {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error", JOptionPane.ERROR_MESSAGE);	
				}

				controller.registerEmployee(name, Integer.parseInt(password));
				showLoginScene();
				
			} catch (java.lang.NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
			} finally {
				txRegisterName.clear();
				txRegisterPassword.clear();
			}

		});

		btExit.setOnAction(e -> {
			showLoginScene();
		});

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
