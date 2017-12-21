package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ResourceBundle;

public class Controller {

	// Initialisation des variables lié aux vues

	@FXML
	private Label bienvenue;

	@FXML
	private TextField ndc;

	@FXML
	private PasswordField mdp;

	@FXML
	private String ndcSave;

	@FXML
	private javafx.scene.control.Button handleButton;

	@FXML
	private javafx.scene.control.Button etatFenetreInscription;

	@FXML
	private ToggleGroup toggleGroup;

	@FXML
	private ToggleGroup loginOrSignup;

	@FXML
	private Label header;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private AnchorPane bienvenuePane;

	@FXML
	private TextField ndcInscription;

	@FXML
	private PasswordField mdpInscription;

	@FXML
	private PasswordField mdpInscriptionValider;

	@FXML
	private TextField mailInscription;

	// Action du bouton Inscription
	@FXML
	private void buttonInscription(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Insc.fxml"));
		bienvenuePane.getChildren().setAll(pane);
	}

	// Action du bouton Connexion
	@FXML
	private void buttonConnexion(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
		bienvenuePane.getChildren().setAll(pane);
	}

	// Action du bouton Tableau de bord
	@FXML
	private void buttonBord(ActionEvent event) throws IOException {
		header.setText("Tableau de Bord");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("tabord.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	// Action du bouton Fichiers
	@FXML
	private void buttonFiles(ActionEvent event) throws IOException {
		header.setText("Gestion des fichiers");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("gesfi.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	// Action du bouton Calendrier
	@FXML
	private void buttonCalendar(ActionEvent event) throws IOException {
		header.setText("Calendrier");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("cal.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	// Action du bouton Messagerie
	@FXML
	private void buttonInbox(ActionEvent event) throws IOException {
		header.setText("Messagerie");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Messagerie.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	// Action du bouton Projet
	@FXML
	private void buttonProjet(ActionEvent event) throws IOException {
		header.setText("Projet");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("proj.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	// Action du bouton Profil
	@FXML
	private void buttonProfil(ActionEvent event) throws IOException {
		header.setText("Profil");
		AnchorPane pane = FXMLLoader.load(getClass().getResource("prof.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	// Action du bouton "Se connecter" de la vue principal
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
		// Si les identifiants correspondent
		if (Model.estValide(ndc.getText(), mdp.getText())) {
			// Appel de la classe changer de scene
			ChangeScene();
		} else {
			// Afficher une alerte si les identifiants ne correspondent
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setHeaderText(null);
			alert.setContentText("Mauvais nom de compte et/ou mot de passe");
			alert.showAndWait();
		}

	}

	// Action du bouton "Inscription" de la vue principal
	@FXML
	private void handleInscription(ActionEvent event) throws IOException, SQLException {
		if (Model.mdpValide(mdpInscription.getText(), mdpInscriptionValider.getText())) {
			// Appel de la classe inscription
			Model.inscription(ndcInscription.getText(), mdpInscription.getText(), mailInscription.getText());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Bienvenue");
			alert.setHeaderText(null);
			alert.setContentText("Bienvenue chez TaskSpace '"+ ndcInscription.getText() +"'");
			alert.showAndWait();
		}
		else {
			// Afficher une alerte si les mots de passe ne correspondent pas
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setHeaderText(null);
			alert.setContentText("Les mots de passe ne correspondent pas");
			alert.showAndWait();
		}
	}

	private void ChangeScene() throws IOException {
		Stage stage = (Stage) handleButton.getScene().getWindow();
		stage.close();
		Parent scene = FXMLLoader.load(getClass().getResource("/application/accueil.fxml"));
		Stage secondStage = new Stage();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		secondStage.setScene(new Scene(scene));
		secondStage.show();
		secondStage.setTitle("TaskSpace @ Bienvenue");
		secondStage.setResizable(false);
	}

	@FXML

	private void mdpOublier(ActionEvent event) {

		try {
			URI uri = URI.create("http://www.google.com");
			Desktop.getDesktop().browse(uri);
			System.out.println("Ouverture réussi");
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ouverture échoué");
		}
	}

	@FXML
	private void ouvrirConnexion(ActionEvent event) {
		try {
			Stage stage = (Stage) etatFenetreInscription.getScene().getWindow();
			stage.close();
			Parent scene = FXMLLoader.load(getClass().getResource("/application/Vue.fxml"));
			Stage secondStage = new Stage();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondStage.setScene(new Scene(scene));
			secondStage.show();
			secondStage.setTitle("TaskSpace @ Bienvenue");
			secondStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
