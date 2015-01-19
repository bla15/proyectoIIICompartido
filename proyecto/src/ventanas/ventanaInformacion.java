package ventanas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import fondos.logicaFondos;

import java.awt.BorderLayout;

import logica.logicaPiloto;
import logicaAlertaJlabel.logicaFotoAlerta;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ventanaInformacion  implements  ActionListener{

	public JDialog frame;
	public static ventanaInformacion window;
	
	static logicaFotoAlerta cartel;
	private logicaFondos panelInicioFondo;
	
	//botones
	JButton botonAceptar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ventanaInformacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaInformacion() {

		cartel = new logicaFotoAlerta();
		cartel.setLocation(100, 25);

		initialize();
		panelInicioFondo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				window.frame.dispose();
			}	
		});
		panelInicioFondo.setFocusable(true);
		panelInicioFondo.requestFocus();

		panelInicioFondo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				panelInicioFondo.requestFocus();
			}
		});
	  
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setBounds(100, 100, 450, 300);
		
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setSize(600,350); 
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		panelInicioFondo = new logicaFondos("/fondos/azul.jpg");
		frame.getContentPane().add(panelInicioFondo);
		panelInicioFondo.setLayout(null);
		
		
		panelInicioFondo.add(cartel);
		
		JLabel labelEnunciado = new JLabel("Atencion nota importante:");
		labelEnunciado.setForeground(Color.RED);
		labelEnunciado.setFont(new Font("Lucida Console", Font.BOLD, 20));
		labelEnunciado.setBounds(147, 110, 348, 47);
		panelInicioFondo.add(labelEnunciado);

		
		botonAceptar= new JButton("OK");
		botonAceptar.setForeground(Color.BLUE);
		botonAceptar.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		botonAceptar.setBounds(272, 304, 89, 23);
		botonAceptar.addActionListener(this);
		panelInicioFondo.add(botonAceptar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 156, 362, 105);
		panelInicioFondo.add(scrollPane);
		
		JTextPane textoImportante = new JTextPane();
		textoImportante.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		textoImportante.setEditable(false);
		scrollPane.setViewportView(textoImportante);
		textoImportante.setText("Los desarroladores advierten que para obtener puntuacion y as\u00ED poder puntuar, es necesario que se selecione el mundo de destino numero cuatro. Si es tu primera vez es recomendable jugar a los mundos anteriores para coger experiencia. Suerte reclutA");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==botonAceptar){
			this.window.frame.dispose();
			ventanaStart.window.frame.dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						ventanaEleccion.window = new ventanaEleccion();
						ventanaEleccion.window.frame.setVisible(true);
					
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
	}



}
