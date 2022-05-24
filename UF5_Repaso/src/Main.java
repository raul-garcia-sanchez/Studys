import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		new Juego();

	}

}

class Juego{
	
	private BufferedImage img0,img1,img2;
	private int coinsNumber,points,random,count1,count2,count3;
	private JLabel[] arrayImagenes;
	private char t;
	private String userGuardado;
	private boolean userNotContainsNumber, userSaved;
	private JFrame frame1,frame2;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10, panel11, panel12;
	private JLabel textName, exception, hello, semaforo0, semaforo1, semaforo2, coins, winLoose;
	private JTextField writeName;
	private JButton saveName, start, exit, play, finish;
	
	public Juego() {
		coinsNumber = 0;
		arrayImagenes = new JLabel[3];
		frame1 = new JFrame();
		frame2 = new JFrame();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel11 = new JPanel();
		panel12 = new JPanel();
		textName = new JLabel("Write your username (only letters are allowed):");
		exception = new JLabel("");
		writeName = new JTextField(10);
		saveName = new JButton("Save name");
		hello = new JLabel("Hello");
		coins = new JLabel("Coins: "+ coinsNumber);
		winLoose = new JLabel("You win 0 points");
		play = new JButton("Play");
		finish = new JButton("Finish game");
		finish.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		try {
			img0 = ImageIO.read(new File("0.jpg"));
			arrayImagenes[0] = new JLabel();
			arrayImagenes[0].setIcon(new ImageIcon(img0));
			img1 = ImageIO.read(new File("1.jpg"));
			arrayImagenes[1] = new JLabel();
			arrayImagenes[1].setIcon(new ImageIcon(img1));
			img2 = ImageIO.read(new File("2.jpg"));
			arrayImagenes[2] = new JLabel();
			arrayImagenes[2].setIcon(new ImageIcon(img2));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		play.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				count1 = 0;
				count2 = 0;
				count3 = 0;
				for (int i = 0; i < arrayImagenes.length; i++) {
					random = (int) (Math.random()*3);
					if (random == 0) {
						arrayImagenes[i].setIcon(new ImageIcon(img0));
						count1 += 1;
					}
					else if (random == 1) {
						arrayImagenes[i].setIcon(new ImageIcon(img1));
						count2 += 1;
					}
					else {
						arrayImagenes[i].setIcon(new ImageIcon(img2));
						count3 += 1;
					}
				}
				
				if (count1 == 3 || count2 == 3 || count3 == 3) {
					coinsNumber += 4;
					winLoose.setText("You win 4 coins");
					coins.setText("Coins: "+coinsNumber);
				}
				else if (count1 == 2|| count2 == 2|| count3==2) {
					coinsNumber += 1;
					winLoose.setText("You win 1 coins");
					coins.setText("Coins: "+coinsNumber);
				}
				else {
					coinsNumber -= 5;
					coins.setText("Coins: "+coinsNumber);
					if (coinsNumber > 0) {
						winLoose.setText("You loose 5 coins");
					}
					else {
						winLoose.setText("<html>You loose 5 points.<br>You have run out of coins</html>");
						play.setVisible(false);
						finish.setVisible(true);
						
					}
					
				}
				
				
				
			}
		});
		saveName.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				userSaved = false;
				userNotContainsNumber = true;
				userGuardado = "";
				for (int i = 0; i < writeName.getText().length(); i++) {
					t = writeName.getText().charAt(i);
					if (!((writeName.getText().charAt(i) >= 'a' && writeName.getText().charAt(i) <= 'z') || (writeName.getText().charAt(i) >= 'A' && writeName.getText().charAt(i) <= 'Z'))) {
					userNotContainsNumber = false;
					}
					}
				try {
					if (writeName.getText().length() <= 0) {
						throw new MyException("Exception: Empty name not allowed");
					}
					else if (userNotContainsNumber == false) {
						throw new MyException("Exception: The name entered is not valid");
					}
					else {
						exception.setText("");
						userSaved = true;
						userGuardado = writeName.getText();
						hello.setText("Hello "+userGuardado);
					}
				} catch (MyException e1) {
					exception.setText(e1.getMessage());
				}
				
				
				
			}
		});
		start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (userSaved == false) {
						throw new MyException("Exception: Missing save username");
					}
					else {
						frame1.setVisible(false);
						frame2.setVisible(true);
						frame1.dispose();
					}
				} catch (MyException e2) {
					exception.setText(e2.getMessage());
				}
				
							
			}
		});
		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		
		frame2.setSize(400,300);
		frame2.setLocationRelativeTo(null);
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		frame1.setSize(400,300);
		frame1.setLocationRelativeTo(null);
		frame1.add(panel1);
		panel2.add(textName);
		panel1.add(panel2);
		panel3.add(writeName);
		panel1.add(panel3);
		panel4.add(saveName);
		panel4.add(start);
		panel1.add(panel4);
		panel5.add(exception);
		panel1.add(panel5);
		panel6.add(exit);
		panel1.add(panel6);
		
		frame1.setVisible(true);
		
		frame2.add(panel7);
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));
		panel8.add(hello);
		panel7.add(panel8);
		panel9.add(coins);
		panel7.add(panel9);
		panel10.add(arrayImagenes[0]);
		panel10.add(arrayImagenes[1]);
		panel10.add(arrayImagenes[2]);
		panel7.add(panel10);
		panel11.add(winLoose);
		panel7.add(panel11);
		panel12.add(play);
		panel12.add(finish);
		finish.setVisible(false);
		panel7.add(panel12);

	}
		
	
}
class MyException extends Exception{

	public MyException() {
		super();
		
	}

	public MyException(String message) {
		super(message);
		
	}
	
	
	
}
