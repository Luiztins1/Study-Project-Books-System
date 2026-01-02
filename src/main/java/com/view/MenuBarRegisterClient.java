package com.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuBarRegisterClient extends Application {

	// AnchorPane
	private AnchorPane registerClientPane;

	// TextFields
	private TextField txNameClient, txSurname, txCpf, txDateBirthday, txEmail, telephoNumber;

	// Buttons
	private Button btRegister, btBack;

	// Scene
	private Scene registerClient;

	// Stage
	private Stage stage;

	private DateTimeFormatter fnt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		initComponentsMenuBarRegisterClient();
		initLayoutMenuBarRegisterClient();
		initListenersMenuBarRegisterClient();
		showMenuBarRegisterClient();
	}

	public void initComponentsMenuBarRegisterClient() {
		registerClientPane = new AnchorPane();
		registerClient = new Scene(registerClientPane);

		txNameClient = new TextField();
		txSurname = new TextField();
		txCpf = new TextField();
		txDateBirthday = new TextField();
		txEmail = new TextField();
		telephoNumber = new TextField();

		btRegister = new Button();
		btBack = new Button();

		registerClientPane.getChildren().addAll(txNameClient, txSurname, txCpf, txDateBirthday, txEmail, telephoNumber,
				btRegister, btBack);
	}

	public void initLayoutMenuBarRegisterClient() {
		registerClientPane.setPrefSize(350, 450);

		txNameClient.setPrefWidth(250);
		txNameClient.setLayoutX((350 - 250) / 2);
		txNameClient.setLayoutY(50);
		txNameClient.setPromptText("Digite o primeiro nome");

		txSurname.setPrefWidth(250);
		txSurname.setLayoutX((350 - 250) / 2);
		txSurname.setLayoutY(90);
		txSurname.setPromptText("Digite o sobrenome");

		txCpf.setPrefWidth(250);
		txCpf.setLayoutX((350 - 250) / 2);
		txCpf.setLayoutY(130);
		txCpf.setPromptText("Digite o CPF");

		txDateBirthday.setPrefWidth(250);
		txDateBirthday.setLayoutX((350 - 250) / 2);
		txDateBirthday.setLayoutY(170);
		txDateBirthday.setPromptText("Digite a data de nascimento (dd/MM/yyyy)");

		txEmail.setPrefWidth(250);
		txEmail.setLayoutX((350 - 250) / 2);
		txEmail.setLayoutY(210);
		txEmail.setPromptText("Digite o email");

		telephoNumber.setPrefWidth(250);
		telephoNumber.setLayoutX((350 - 250) / 2);
		telephoNumber.setLayoutY(250);
		telephoNumber.setPromptText("Digite o telefone Ex: (11) 99999-9999");

		btRegister.setPrefWidth(100);
		btRegister.setLayoutX((350 - 100) / 2);
		btRegister.setLayoutY(320);
		btRegister.setText("Registrar");

		btBack.setPrefWidth(100);
		btBack.setLayoutX((350 - 100) / 2);
		btBack.setLayoutY(360);
		btBack.setText("Voltar");

	}

	public void initListenersMenuBarRegisterClient() {

		btRegister.setOnAction(e -> {
			try {
				String name = txNameClient.getText().trim();
				String surname = txSurname.getText().trim();
				String cpf = txCpf.getText().trim();
				String dateBirthday = txDateBirthday.getText().trim();
				String email = txEmail.getText().trim();
				String tel = telephoNumber.getText().trim();

				if (name.length() > 25 || surname.length() > 15 || cpf.length() > 14 || email.length() > 60
						|| tel.length() > 14) {
					JOptionPane.showMessageDialog(null,
							"Nome deve conter 25 letras.\nSobre nome 15 letras.\n CPF 14 letras\nEmail 60 letras\n Telefone 14 letras.",
							"Error", JOptionPane.PLAIN_MESSAGE);
				}

				if (name.isEmpty() || surname.isEmpty() || cpf.isEmpty() || dateBirthday.isEmpty() || email.isEmpty()
						|| tel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.", "Error",
							JOptionPane.PLAIN_MESSAGE);

				} else {
					LoginMenu.getController().registerClient(name, surname, cpf, LocalDate.parse(dateBirthday, fnt),
							email, tel);
					try {
						new MenuMain().start(new Stage());
						stage.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Por favor, insira valores corretamente.");
			} catch (DateTimeParseException ex) {
				JOptionPane.showMessageDialog(null, "Data inválida. Use o formato correto (dd/MM/yyyy).");
			}
			txNameClient.clear();
			txSurname.clear();
			txCpf.clear();
			txDateBirthday.clear();
			txEmail.clear();
			telephoNumber.clear();

		});

		btBack.setOnAction(e -> {
			try {
				new MenuMain().start(new Stage());
				stage.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});
	}

	public void showMenuBarRegisterClient() {
		stage.setScene(registerClient);
		stage.setTitle("Porto Books - Registrar Cliente");
		stage.setResizable(false);
		stage.show();

		btRegister.requestFocus();
	}
}
