package trendelenburg.de.error;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Massage {
	
	static int windowWidth = 250;
	static int windowHeight = 100;
	
	static int bildschirmWidth;
	static int bildschirmHeight;
	
	public Massage(String text){
		
		bildschirmWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		bildschirmHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		JFrame error = new JFrame("Error");
		JButton ok = new JButton("ok");
		JLabel nicht = new JLabel(text);
		error.setLayout(new FlowLayout());
		nicht.setBounds(10, 10, 100, 30);
		ok.setBounds(10, 60, 30, 10);
		error.setBounds(bildschirmWidth/2-windowWidth/2, bildschirmHeight/2-windowHeight/2 ,windowWidth, windowHeight);
		error.add(nicht);
		error.add(ok);
		error.setVisible(true);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				error.setVisible(false);
			}
		});
	}
}
