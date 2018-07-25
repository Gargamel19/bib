package trendelenburg.de.UI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import trendelenburg.de.db.DB_Verbindung;

public class UI_Anmelden extends JFrame implements ActionListener {

	private static final long serialVersionUID = -4424161633719726854L;
	
	static int bildschirmWidth;
	static int bildschirmHeight;
	
	static int windowWidth = 350;
	static int windowHeight = 200;
	
	UI_MainScrean uiM;
	
	DB_Verbindung dbv;
	
	static JFrame window = new JFrame();
	static JLabel lblnutzername = new JLabel("Nutzername:");
	static JLabel lblpasswort = new JLabel("Passwort:");
	static JLabel lblnix = new JLabel("");
	static JTextField txtnutzername = new JTextField();
	static JTextField txtpasswort = new JPasswordField();
	static String name = "Ferdinand";
	static String passwort = "Passwort";
	static boolean name_passwort_richtig = false;
	static JButton btnlogin = new JButton("Login");
	static JButton btnregister = new JButton("Registrieren");
	
	
	
	public UI_Anmelden(DB_Verbindung dbv, UI_MainScrean uiM) {
		
		this.uiM = uiM;
		this.dbv = dbv;
		
		bildschirmWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		bildschirmHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		eigenschaften();
		zuweisungen();
		actionHandler();
	}
	
	private void actionHandler() {
		
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtnutzername.getText());
				System.out.println(txtpasswort.getText());
				if (dbv.checklogin(txtnutzername.getText(), txtpasswort.getText())) {
					window.setVisible(false);
					uiM.setUsername(txtnutzername.getText());
					uiM.angemeldet();
				}
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	public static void eigenschaften() {
		
		//settings
		window.setTitle("Anmelden");
		window.setBounds(bildschirmWidth/2-windowWidth/2, bildschirmHeight/2-windowHeight/2 ,windowWidth, windowHeight);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
		
		//setBounds
		lblnutzername.setBounds(10, 10, 130, 20);
		lblpasswort.setBounds(10, 60, 130, 20);
		btnlogin.setBounds(10, 110, 130, 20);
		btnregister.setBounds(160, 110, 130, 20);
		txtnutzername.setBounds(160, 10, 130, 20);
		txtpasswort.setBounds(160, 60, 130, 20);
	}

	public static void zuweisungen() {
		window.add(lblnutzername);
		window.add(txtnutzername);
		window.add(lblpasswort);
		window.add(txtpasswort);
		window.add(btnlogin);
		window.add(btnregister);
		window.add(lblnix);
	}
	
}
