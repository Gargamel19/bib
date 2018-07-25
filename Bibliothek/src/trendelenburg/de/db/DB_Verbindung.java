package trendelenburg.de.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.ResultSet;

import trendelenburg.de.be.InventarItem;
import trendelenburg.de.error.ConnectionError;
import trendelenburg.de.error.LoginError;

public class DB_Verbindung {

	Connection con;
	Statement myStat;

	String url;
	String user;
	String password;

	public DB_Verbindung(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
		con = null;
	}

	public boolean tryConnect() {
		for (int i = 0; i < 10; i++) {
			try {

				Thread.sleep(100);
				connect();
				return true;
			} catch (SQLException e) {
				System.out.println(i + 1 + "/10 Versuche erfolglos.");
				System.out.println(e);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private void connect() throws SQLException {

		con = DriverManager.getConnection(url, user, password);
		// new Connected();
		System.out.println("Database connected!");

	}

	public boolean checklogin(String name, String passwort) {

		try {
			Statement myStat = con.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * from user");
			while (myRs.next()) {
				if (name.equals(myRs.getString("nutzername")) && passwort.equals(myRs.getString("passwort"))) {
					System.out.println(name + " wurde sicher eingeloggt");

					return true;
				}
			}
			new LoginError();
		} catch (SQLException e) {
			if (tryConnect()) {
				checklogin(name, passwort);
			} else {
				new ConnectionError();
			}
		}

		return false;
	}

	public ArrayList<InventarItem> suche(String target, String type) {

		ArrayList<InventarItem> alos = getListFromDB(target, type);

		System.out.println(alos.get(0));

		return alos;
	}

	public ArrayList<InventarItem> getAllFromDB() {
		ArrayList<InventarItem> alos = new ArrayList<>();

		try {
			Statement myStat = con.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * from inventar");
			while (myRs.next()) {

				InventarItem ii = new InventarItem(myRs.getString("id"), myRs.getString("titel"),
						myRs.getString("autor"), myRs.getString("genre"), myRs.getString("verfügbar"));
				alos.add(ii);

			}
		} catch (SQLException e) {
			if (tryConnect()) {
				getAllFromDB();
			} else {
				new ConnectionError();
			}
		}

		return alos;

	}

	public ArrayList<InventarItem> getListFromDB(String target, String type) {

		ArrayList<InventarItem> alos = new ArrayList<>();

		try {
			Statement myStat = con.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * from inventar");
			while (myRs.next()) {
				String erg = myRs.getString(type).toLowerCase();
				String lowTarget = target.toLowerCase();

				if (lowTarget.equals(erg) || erg.contains(lowTarget)) {
					InventarItem ii = new InventarItem(myRs.getString("id"), myRs.getString("titel"),
							myRs.getString("autor"), myRs.getString("genre"), myRs.getString("verfügbar"));
					System.out.println(myRs.getString("id"));
					alos.add(ii);
				}
			}
		} catch (SQLException e) {
			if (tryConnect()) {
				getListFromDB(target, type);
			} else {
				new ConnectionError();
			}
		}

		return alos;

	}

}