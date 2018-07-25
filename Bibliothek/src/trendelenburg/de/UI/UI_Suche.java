package trendelenburg.de.UI;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import trendelenburg.de.be.InventarItem;
import trendelenburg.de.db.DB_Verbindung;

public class UI_Suche implements ActionListener {

	static int bildschirmWidth;
	static int bildschirmHeight;

	static int windowWidth = 800;
	static int windowHeight = 600;

	UI_MainScrean uiM;

	static DB_Verbindung dbv;

	static JFrame window = new JFrame();
	static JLabel lbltext = new JLabel("Bitte geben sie den Beriff ein, nach dem sich suchen!");
	static JLabel lblSucheAutor = new JLabel("Autor:");
	static JLabel lblSucheTitel = new JLabel("Titel:");
	static JLabel lblSucheGenre = new JLabel("Genre:");

	static JTextArea txtergebnisse = new JTextArea("");
	
	static JTextArea txtergebnissID = new JTextArea("");
	static JTextArea txtergebnissTitel = new JTextArea("");
	static JTextArea txtergebnissAutor = new JTextArea("");
	static JTextArea txtergebnissGenre = new JTextArea("");
	static JTextArea txtergebnissVerfuegbar = new JTextArea("");

	static JScrollPane scrollPane = new JScrollPane(txtergebnisse);
	static JPanel panel = new JPanel(new BorderLayout());
	
	static JLabel lblID = new JLabel("ID");
	static JLabel lblTitel = new JLabel("Titel");
	static JLabel lblAutor = new JLabel("Autor");
	static JLabel lblGenre = new JLabel("Genre");
	static JLabel lblVerfuegbar = new JLabel("Auf Lager");

	static JTextField txtSucheAutor = new JTextField();
	static JTextField txtSucheTitel = new JTextField();
	static JTextField txtSucheGenre = new JTextField();
	static JButton btnsuche = new JButton("Suchen!");
	
	static JPanel pnlnix = new JPanel();
	
	
	
	public static boolean angemeldetjn = true;

	public UI_Suche(DB_Verbindung dbv) {

		this.dbv = dbv;

		bildschirmWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		bildschirmHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

		eigenschaften();
		zuweisungen();
		aktionen();
	}

	public static void suchentitel() {
	}

	public static void eigenschaften() {
		window.setTitle("Suche");
		window.setBounds(bildschirmWidth / 2 - windowWidth / 2, bildschirmHeight / 2 - windowHeight / 2, windowWidth,
				windowHeight);
		window.setVisible(true);

		lbltext.setBounds(windowWidth / 2 - 300, 40, 600, 20);

		lblSucheTitel.setBounds(windowWidth / 2 - 300, 70, 200, 20);
		lblSucheAutor.setBounds(windowWidth / 2 - 300 + 200, 70, 200, 20);
		lblSucheGenre.setBounds(windowWidth / 2 - 300 + 200 + 200, 70, 200, 20);

		txtSucheTitel.setBounds(windowWidth / 2 - 300, 90, 150, 20);
		txtSucheAutor.setBounds(windowWidth / 2 - 300 + 200, 90, 150, 20);
		txtSucheGenre.setBounds(windowWidth / 2 - 300 + 200 + 200, 90, 150, 20);

		btnsuche.setBounds(windowWidth / 2 - 100, windowHeight-100, 200, 30);
		pnlnix.setBounds(700, 500, 0, 0);

		lblID.setBounds(0, 0, 50, 20);
		lblTitel.setBounds(50, 0, 170, 20);
		lblAutor.setBounds(220, 0, 170, 20);
		lblGenre.setBounds(390, 0, 100, 20);
		lblVerfuegbar.setBounds(490, 0, 70, 20);

		txtergebnissID.setBounds(0, 20, 50, 1080);
		txtergebnissTitel.setBounds(50, 20, 170, 1080);
		txtergebnissAutor.setBounds(220, 20, 170, 1080);
		txtergebnissGenre.setBounds(390, 20, 100, 1080);
		txtergebnissVerfuegbar.setBounds(490, 20, 70, 1080);

		txtergebnisse.setBounds(100, 130, 600, 2000);
		scrollPane.setBounds(100, 130, 600, 2000);
		panel.setBounds(100, 130, 600, 350);

		txtergebnisse.setLineWrap(true);
		txtergebnisse.setWrapStyleWord(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		
		// txtergebnisse.setVisible(false);
	}

	public static void zuweisungen() {
		window.add(lbltext);
		window.add(lblSucheAutor);
		window.add(lblSucheTitel);
		window.add(lblSucheGenre);
		window.add(txtSucheAutor);
		window.add(txtSucheTitel);
		window.add(txtSucheGenre);
		
		panel.add(scrollPane);
		
		window.add(panel);
		
		txtergebnisse.add(lblID);
		txtergebnisse.add(lblTitel);
		txtergebnisse.add(lblAutor);
		txtergebnisse.add(lblGenre);
		txtergebnisse.add(lblVerfuegbar);

		txtergebnisse.add(txtergebnissID);
		txtergebnisse.add(txtergebnissTitel);
		txtergebnisse.add(txtergebnissAutor);
		txtergebnisse.add(txtergebnissGenre);
		txtergebnisse.add(txtergebnissVerfuegbar);

		
		window.add(btnsuche);
		window.add(pnlnix);

	}

	public static void aktionen() {
		btnsuche.addActionListener(new ActionListener() {

			ArrayList<InventarItem> aoT;
			ArrayList<InventarItem> aoA;
			ArrayList<InventarItem> aoG;

			ArrayList<InventarItem> erg;

			String outID = "";
			String outTitel = "";
			String outAutor = "";
			String outGenre = "";
			String outVerfuegbar = "";

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtSucheTitel.getText().equals("")) {
					aoT = dbv.getListFromDB(txtSucheTitel.getText(), "titel");
				}
				if (!txtSucheAutor.getText().equals("")) {
					aoA = dbv.getListFromDB(txtSucheAutor.getText(), "autor");
				}
				if (!txtSucheGenre.getText().equals("")) {
					aoG = dbv.getListFromDB(txtSucheGenre.getText(), "genre");
				}
				if ((!txtSucheTitel.getText().equals("")) && (!txtSucheAutor.getText().equals(""))
						&& (!txtSucheGenre.getText().equals(""))) {

				} else if ((!txtSucheTitel.getText().equals("")) && (!txtSucheAutor.getText().equals(""))) {

					for (int j = 0; j < aoT.size(); j++) {
						if (aoA.contains(aoT.get(j))) {
							erg.add(aoT.get(j));
						}
					}

				} else if ((!txtSucheAutor.getText().equals("")) && (!txtSucheGenre.getText().equals(""))) {

					for (int j = 0; j < aoA.size(); j++) {
						if (aoG.contains(aoA.get(j))) {
							erg.add(aoA.get(j));
						}
					}

				} else if ((!txtSucheTitel.getText().equals("")) && (!txtSucheGenre.getText().equals(""))) {

					for (int j = 0; j < aoT.size(); j++) {
						if (aoG.contains(aoT.get(j))) {
							erg.add(aoT.get(j));
						}
					}

				} else if (!txtSucheTitel.getText().equals("")) {

					erg = aoT;

				} else if (!txtSucheAutor.getText().equals("")) {

					erg = aoA;

				} else if (!txtSucheGenre.getText().equals("")) {

					erg = aoG;

				}else {
					erg = dbv.getAllFromDB();
				}

				for (int i = 0; i < erg.size(); i++) {
					InventarItem ii = erg.get(i);

					outID += ii.getId() + "\n";
					outTitel += ii.getTitel() + "\n";
					outAutor += ii.getAutor() + "\n";
					outGenre += ii.getGenre() + "\n";
					outVerfuegbar += ii.getVerfuegbar() + "\n";
				}
				
				System.out.println(outID);
				txtergebnissID.setText(outID);
				txtergebnissTitel.setText(outTitel);
				txtergebnissAutor.setText(outAutor);
				txtergebnissGenre.setText(outGenre);
				txtergebnissVerfuegbar.setText(outVerfuegbar);
				
				
				
				outID = "";
				outTitel = "";
				outAutor = "";
				outGenre = "";
				outVerfuegbar = "";
				
				erg.clear();
			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}