package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import fondos.logicaFondos;

import java.awt.BorderLayout;

import logicaAlertaJlabel.logicaFotoAlerta;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ventanaInformacion  {

	private JFrame frame;
	static ventanaInformacion window;
	
	static logicaFotoAlerta cartel;
	
	JPanel panel;
	

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
		cartel.setLocation(100, 20);

		initialize();
		panel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				window.frame.dispose();
			}	
		});
		panel.setFocusable(true);
		panel.requestFocus();

		panel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				panel.requestFocus();
			}
		});
	  
		
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setSize(600,350); 
		frame.setResizable(false); 
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		panel.add(cartel);
		
		JLabel labelEnunciado = new JLabel("Atencion nota importante:");
		labelEnunciado.setForeground(Color.RED);
		labelEnunciado.setFont(new Font("Lucida Console", Font.BOLD, 20));
		labelEnunciado.setBounds(147, 110, 348, 47);
		panel.add(labelEnunciado);

		
		JButton botonAceptar = new JButton("OK");
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.frame.dispose();
			}
		});
		botonAceptar.setForeground(Color.BLUE);
		botonAceptar.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		botonAceptar.setBounds(272, 304, 89, 23);
		panel.add(botonAceptar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 156, 362, 105);
		panel.add(scrollPane);
		
		JTextPane textoImportante = new JTextPane();
		textoImportante.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		textoImportante.setEditable(true);
		scrollPane.setViewportView(textoImportante);
		textoImportante.setText("Los desarroladores advierten que para obtener puntuacion y as\u00ED poder puntuar, es necesario que se selecione el mundo de destino numero cuatro. Si es tu primera vez es recomendable jugar a los mundos anteriores para coger experiencia. Suerte reclutA");
	}



}
