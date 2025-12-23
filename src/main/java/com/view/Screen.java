package com.view;

import com.controller.MenuMainOperations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Screen extends Application{

	
	private Stage stage;
	private MenuMainOperations controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		this.controller = new MenuMainOperations();
		showLoginScene();
	}
	
	public void showLoginScene() {
		AnchorPane loginPane = new AnchorPane();
		Scene loginScene = new Scene(loginPane);
		
		TextField txLoginName = new TextField();
		TextField txLoginPassword = new TextField();
		TextField txLoginCode = new TextField();
		
		
		Button btLogin = new Button();
		Button btRegister = new Button();
		
		//Botões
		btLogin.setText("Login");
		btRegister.setText("Registrar");
		
		//Campo
		txLoginName.setPromptText("Digite seu nome");
		txLoginPassword.setPromptText("Digite sua senha");
		txLoginCode.setPromptText("Digite seu código de acesso");
		
		//Painel
		loginPane.setPrefSize(400, 400);
		loginPane.getChildren().addAll(btLogin, btRegister, txLoginName, txLoginPassword, txLoginCode);
		
		stage.setScene(loginScene);
		stage.setTitle("Porto Books - Login");
		stage.show();
		
		//Campos
		txLoginName.setLayoutX((loginPane.getWidth() - txLoginName.getWidth()) / 2);
		txLoginName.setLayoutY(150);
		
		txLoginPassword.setLayoutX((loginPane.getWidth() - txLoginPassword.getWidth()) / 2);
		txLoginPassword.setLayoutY(190);
		
		txLoginCode.setLayoutX((loginPane.getWidth() - txLoginCode.getWidth()) / 2);
		txLoginCode.setLayoutY(230);
		
		//Botões
		btLogin.setLayoutX((loginPane.getWidth() - btLogin.getWidth()) / 2);
		btLogin.setLayoutY(270);
		btRegister.setLayoutX((loginPane.getWidth() - btRegister.getWidth()) / 2);
		btRegister.setLayoutY(310);
		
	}

}
