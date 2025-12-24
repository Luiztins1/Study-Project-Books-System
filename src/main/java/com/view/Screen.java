package com.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.controller.MenuMainOperations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Screen extends Application {

	private EntityManagerFactory emf;
	private EntityManager em;
	private Stage stage;
	private MenuMainOperations controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		showLoginScene();
	}

	// Método responsável por iniciar a conexão ao banco de dados com JavafX.
	public void init() {
		this.emf = Persistence.createEntityManagerFactory("books-system");
		this.em = emf.createEntityManager();
		this.controller = new MenuMainOperations(this.em);
	}

	// Método de para tela de login.
	public void showLoginScene() {
		AnchorPane loginPane = new AnchorPane();
		Scene loginScene = new Scene(loginPane);

		TextField txLoginName = new TextField();
		TextField txLoginPassword = new TextField();

		Button btLogin = new Button();
		Button btRegister = new Button();

		// Painel
		loginPane.setPrefSize(400, 400);
		loginPane.getChildren().addAll(txLoginName, txLoginPassword, btLogin, btRegister);

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

		btRegister.setText("Registrar");
		btRegister.setLayoutX((loginPane.getWidth() - btRegister.getWidth()) / 2);
		btRegister.setLayoutY(310);

		// Ações Button
		btLogin.setOnAction(e -> {
			String name = txLoginName.getText();
			Integer password = Integer.parseInt(txLoginPassword.getText());
			
			controller.loginVerification(name, password);
		});

		btRegister.setOnAction(e -> {
			showMenuRegister();
		});

	}

	// Método para o menu principal.
	public void showMenuMain() {
		AnchorPane menuMain = new AnchorPane();
		Scene menuScene = new Scene(menuMain);

		menuMain.setPrefSize(400, 400);

		stage.setScene(menuScene);
		stage.show();
	}

	// Método para o menu de registro de usuário.
	public void showMenuRegister() {
		AnchorPane menuRegister = new AnchorPane();
		Scene registerScene = new Scene(menuRegister);

		Button btRegister = new Button();
		Button btExit = new Button();

		TextField txRegisterName = new TextField();
		TextField txRegisterPassword = new TextField();

		menuRegister.setPrefSize(400, 400);
		menuRegister.getChildren().addAll(btRegister, btExit, txRegisterName, txRegisterPassword);

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
		btRegister.setPrefSize(150, 0);
		btRegister.setLayoutX((menuRegister.getWidth() - btRegister.getWidth()) / 2);
		btRegister.setLayoutY(270);
		btRegister.setText("Criar conta");

		btExit.setPrefSize(150, 0);
		btExit.setLayoutX((menuRegister.getWidth() - btExit.getWidth()) / 2);
		btExit.setLayoutY(310);
		btExit.setText("Voltar ao menu");

		// Ações Botões
		btRegister.setOnAction(e ->{
			String name = txRegisterName.getText();
			Integer password = Integer.parseInt(txRegisterPassword.getText());
			
			controller.registerEmployee(name, password);
			System.out.println("Usuário criado com sucesso.");
			showLoginScene();
		});
		
		btExit.setOnAction(e -> {
			showLoginScene();
		});
	}
	
	@Override
	public void stop() throws Exception{
		System.out.println("Encerrando conexões...");
		if(em == null && em.isOpen()) em.close();
		if(emf == null && emf.isOpen()) emf.close();
		System.out.println("Sistema fechado com sucesso!");
	}

}
