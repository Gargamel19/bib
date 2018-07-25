package trendelenburg.de;

import trendelenburg.de.UI.UI_MainScrean;
import trendelenburg.de.db.DB_Verbindung;
import trendelenburg.de.error.ConnectionError;

public class execute {

	public static void main(String[] args) {
		DB_Verbindung dbv = new DB_Verbindung("jdbc:mysql://localhost:3306/bib?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
		if (dbv.tryConnect()) {
			new UI_MainScrean(dbv);
		}
		else {
			new ConnectionError();
		}
	}
	
}
