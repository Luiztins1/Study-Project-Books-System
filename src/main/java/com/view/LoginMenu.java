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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginMenu extends Application {

	//ArchoPane
	private AnchorPane loginPane;
	
	//Scene
	private Scene loginScene;
	
	//TextFiel
	private TextField txLoginName;
	
	//PasswordField
	private PasswordField txLoginPassword;
	
	//Buttons
	private Button btLogin;
	private Button btRegisterLogin;

	//Stage
	private Stage stage;

	private EntityManagerFactory emf;
	private EntityManager em;
	private static MenuMainOperations controller;
	private MenuRegister menuRegister;

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
		controller = new MenuMainOperations(this.em);
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
		txLoginPassword = new PasswordField();

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
					try {
						new MenuMain().start(new Stage());
						stage.close();
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Algo Inesperado ocorreu", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				
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
				try {
					new MenuRegister().start(new Stage());
					stage.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo Inesperado ocorreu", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			txLoginName.clear();
			txLoginPassword.clear();
		}

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

	public static MenuMainOperations getController() {
		return controller;
	}

	public static void setController(MenuMainOperations controller) {
		LoginMenu.controller = controller;
	}
	
	

}
