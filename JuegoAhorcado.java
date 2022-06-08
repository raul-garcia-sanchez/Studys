import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JuegoAhorcado {

	public static void main(String[] args) {
		new Ahorcado();
	}

}
class Ahorcado {
	
	private JFrame frame1,frame2;
	private JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panel9,panel10;
	private int vidas,random;
	private JLabel saludoUser,startGame,labelVidas,labelEscribirLetra,labelPalabraAdivinar,labelExcepcion;
	private JButton botonJugar,botonSalir,botonComprobar,botonFinalizar;
	private JTextField escribirLetra;
	private String[] palabras;
	private String palabraAAdivinar,guiones;
	private ArrayList<Character> guionesPalabra,letrasPalabra,letrasYaPuestas;
	private boolean acabar;
	
	public Ahorcado() {
		String[] palabras = {"RAUL","PROGRAMAR","JAVA","PYTHON"};
		vidas = 10;
		guionesPalabra = new ArrayList<Character>();
		letrasPalabra = new ArrayList<Character>();
		letrasYaPuestas = new ArrayList<Character>();
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
		labelVidas = new JLabel("Vidas: "+vidas);
		labelEscribirLetra = new JLabel("Escriba letra:");
		escribirLetra = new JTextField(5);
		botonFinalizar = new JButton("FINALIZAR");
		botonFinalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		botonComprobar = new JButton("COMPROBAR");
		botonComprobar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				labelExcepcion.setText("");
				acabar = false;
				try {
					if (escribirLetra.getText().length() > 1) {
						throw new Excepcion("Solo puedes poner 1 letra!");
					}
					else if (escribirLetra.getText().length() == 0) {
						throw new Excepcion("No has puesto ningun caracter para comprobar");
					}
					else if (letrasYaPuestas.contains((char)escribirLetra.getText().toUpperCase().charAt(0))) {
						throw new Excepcion("Letra ya puesta");
					}
					else {
						for (int i = 0; i < letrasPalabra.size(); i++) {
							if (letrasPalabra.get(i) == (char)escribirLetra.getText().toUpperCase().charAt(0)) {
								guionesPalabra.set(i, (char)escribirLetra.getText().toUpperCase().charAt(0));
								letrasYaPuestas.add(letrasPalabra.get(i));
							}
							
							
						}
						guiones = "";
						for (int i = 0; i < guionesPalabra.size(); i++) {
							guiones += guionesPalabra.get(i) + " ";
						}
						labelPalabraAdivinar.setText(guiones);
						
						
						if (letrasPalabra.contains((char)escribirLetra.getText().toUpperCase().charAt(0)) == false) {
							vidas -= 1;
							labelVidas.setText("Vidas: "+vidas);
						}
						
						if (vidas == 0) {
							panel10.setVisible(true);
						}
						
						if (!guionesPalabra.contains('_')) {
							panel10.setVisible(true);
						}
						
						
					}
					escribirLetra.setText("");
				}
				catch (Excepcion exc) {
					labelExcepcion.setText(exc.getMessage());
				}
				
			}
		});
		labelPalabraAdivinar = new JLabel("");
		labelExcepcion = new JLabel("");
		saludoUser = new JLabel("Hola User!");
		startGame = new JLabel("Desea empezar a jugar?");
		botonJugar = new JButton("JUGAR");
		botonJugar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame1.dispose();
				frame2.setVisible(true);
				random = (int) (Math.random()*palabras.length);
				palabraAAdivinar = palabras[random];

				for (int i = 0; i < palabraAAdivinar.length(); i++) {
					letrasPalabra.add(palabraAAdivinar.charAt(i));
					
				}
				
				
				for (int i = 0; i < palabraAAdivinar.length(); i++) {
					guionesPalabra.add('_');
				}
				
				guiones = "";
				for (int i = 0; i < guionesPalabra.size(); i++) {
					guiones += guionesPalabra.get(i) + " ";
				}
				labelPalabraAdivinar.setText(guiones);
			}
		});
		botonSalir = new JButton("SALIR");
		botonSalir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame1.add(panel1);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel2.add(saludoUser);
		panel3.add(startGame);
		panel4.add(botonJugar);
		panel4.add(botonSalir);
		panel1.add(panel2);
		panel1.add(panel3);
		panel1.add(panel4);
		frame1.setTitle("AHORCADO");
		frame1.setSize(300, 300);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		frame2.add(panel5);
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
		frame2.setTitle("AHORCADO");
		panel6.add(labelVidas);
		panel7.add(labelEscribirLetra);
		panel7.add(escribirLetra);
		panel7.add(botonComprobar);
		panel8.add(labelPalabraAdivinar);
		panel9.add(labelExcepcion);
		panel10.add(botonFinalizar);
		panel10.setVisible(false);
		panel5.add(panel6);
		panel5.add(panel7);
		panel5.add(panel8);
		panel5.add(panel9);
		panel5.add(panel10);
		frame2.setSize(300, 300);
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
		frame2.setVisible(false);
		
		
	}

}

class Excepcion extends Exception{

	public Excepcion() {
		super();
	}

	public Excepcion(String message) {
		super(message);
	}
	
	
}
