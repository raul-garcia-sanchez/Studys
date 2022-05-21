import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
	
	private char t;
	private String userGuardado;
	private boolean userNotContainsNumber, userSaved;
	private JFrame frame1,frame2;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
	private JLabel textName, exception;
	private JTextField writeName;
	private JButton saveName, start, exit;
	
	public Juego() {
		frame1 = new JFrame();
		frame2 = new JFrame();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		textName = new JLabel("Write your username (only letters are allowed):");
		exception = new JLabel("");
		writeName = new JTextField(10);
		saveName = new JButton("Save name");
		saveName.addActionListener(new ActionListener() {
			
			@Override
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
						userGuardado = writeName.getText();
						exception.setText("");
						userSaved = true;
					}
				} catch (MyException e1) {
					// TODO Auto-generated catch block
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
			
			@Override
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
