package trendelenburg.de.UI;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import trendelenburg.de.db.DB_Verbindung;

public class UI_MainScrean extends JFrame {
	
	private static final long serialVersionUID = 1L;


	static DB_Verbindung dbv;
	
	
	static int bildschirmWidth;
	static int bildschirmHeight;
	
	static int windowWidth = 800;
	static int windowHeight = 600;
	
	//UI
	static JFrame window = new JFrame();
	static JMenuBar mnuBar = new JMenuBar();
	static JMenu mnuKontakt = new JMenu("Kontakt");
	static JMenu mnudata = new JMenu("Datei");
	static JMenu mnuprogramme = new JMenu("Programme");
	static JLabel lblNewLabel = new JLabel("");
	static JMenuItem mnuI_registrieren = new JMenuItem("Registrieren");
	static JMenuItem mnuI_schliessen = new JMenuItem("Schlieﬂen");
	static JMenuItem mnuI_suche = new JMenuItem("Suche");
	static JMenuItem mnuI_Inet = new JMenuItem("Internet");
	
	
	public UI_MainScrean(DB_Verbindung dbv) {
		
		this.dbv = dbv;
		
		new UI_Anmelden(this.dbv, this);
		
		bildschirmWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		bildschirmHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		 
		
		eigenschaften();
		zuweisungen();
		aktionen();
	}
	
	public void setUsername(String username){
		
	}
	
	public void angemeldet() {
		window.setVisible(true);
	}
	

	private static void eigenschaften() {
		window.setTitle("Willkommen");
		window.setBounds(bildschirmWidth/2-windowWidth/2, bildschirmHeight/2-windowHeight/2 ,windowWidth, windowHeight);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		lblNewLabel.setIcon(new ImageIcon("res/Hintergrund.png"));
		lblNewLabel.setBounds(0, 0, 800, 600);
	}
	
	
	private static void zuweisungen() {
		window.add(lblNewLabel);
		window.setJMenuBar(mnuBar);
		mnuBar.add(mnudata);
		mnuBar.add(mnuprogramme);
		mnuBar.add(mnuKontakt);
		mnudata.add(mnuI_schliessen);
		mnuprogramme.add(mnuI_suche);
		mnuKontakt.add(mnuI_Inet);
		//mnuanmeldung.add(mnuI_registrieren);
	}	
	
	private void aktionen() {
		mnuI_schliessen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});

		mnuI_Inet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				URI uri;
				try {
					uri = new URI("http://www.sub.uni-hamburg.de/startseite.html");
					desktop.browse(uri);
				} catch (Exception oError) {
					// Hier Fehler abfangen
					System.out.println("Error:" + oError);
				}
			}
		});
		mnuI_suche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UI_Suche(dbv);

			}
		});
	}


	
	
}
