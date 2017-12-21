package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Model {

	// Classe verification nom et mots de passe existantds dans la BDD
	public static boolean estValide(String nomU, String mdpU) throws SQLException {
		CO.getConnection();
		String veri = "";
		PreparedStatement ndc = CO.com.prepareStatement("SELECT login FROM User");
		ResultSet ndc1 = ndc.executeQuery();
		PreparedStatement mdp = CO.com.prepareStatement("SELECT mdp FROM User");
		ResultSet mdp1 = mdp.executeQuery();
		while (ndc1.next() && mdp1.next()) {
			int i = 1;
			String ndcTmp = ndc1.getObject(i).toString();
			String mdpTmp = mdp1.getObject(i).toString();
			if (nomU.equals(ndcTmp) && (mdpU.equals(mdpTmp))) {
				veri = "ok";
				break;
			}
			i++;
		}
		if (veri != "ok") {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean mdpValide(String mdp1, String mdp2) {
		if (mdp1.equals(mdp2)) {
			return true;	
		} else {
			return false;
		}
	}

	public static void inscription(String nom, String mdp, String mail) throws SQLException {
		CO.getConnection();
		PreparedStatement req = CO.com.prepareStatement("INSERT INTO User (login, mdp, mail) VALUES ( " + "\"" + nom
				+ "\"" + "," + "\"" + mdp + "\"" + "," + "\"" + mail + "\"" + ")");

		req.executeUpdate();
		req.close();
		System.out.println(nom);
	}

}
