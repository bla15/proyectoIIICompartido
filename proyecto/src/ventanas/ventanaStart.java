package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

import fondos.logicaFondos;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import logica.logicaPiloto;

public class ventanaStart  implements KeyListener, ActionListener{

	JFrame frame;
	private logicaFondos panelInicioFondo;
	private JButton botonStart;

	static ventanaStart window;
	
	static LinkedList<logicaPiloto>registro=new LinkedList<logicaPiloto>();
	static logicaPiloto contenedor;
	
	//tamaño del frame por defecto
	int anchoFrame=450;
	int altoFrame=300;	
	
	//tamaño botones estandar
	int anchoBoton=100;
	int altoBoton=25;
	int tamañoLetraBoton =14;

	private JLabel JlabelTitulo;
	//tamaño titulo estandar
	int anchoTitulo=320;
	int altoTitulo=50;
	int tamañoLetraTitulo =30;
	
	private JLabel JlabelNombreCreadores;
	//tamaño creadores
	int anchoCreadores=180;
	int altoCreadores=50;
	int tamañoLetraCreadores =12;
	int xCreadores=10;
	int yCreadores=230;
	
	
	
	//tamañoPuntuaciones
	int anchoTituloPuntuaciones=131;
	int altoTituloPuntuaciones=32;
	int tamañoLetraTituloPuntuaciones=15;
	int xTituloPuntuaciones=293;
	int ytituloPuntuaciones=98;
	int tamañoBorde=2;

	//uno
	int anchoPuntuacionesUno=106;
	int altoPuntuacionesUno=19;
	int tamañoLetraTituloUno=10;
	int xPuntuacionesUno=318;
	int yPuntuacionesUno=134; 
	//dos
	int anchoPuntuacionesDos=106;
	int altoPuntuacionesDos=25;
	int tamañoLetraTituloDos=10;
	int xPuntuacionesDos=318;
	int yPuntuacionesDos=159;
	//tres
	int anchoPuntuacionesTres=106;
	int altoPuntuacionesTres=25;
	int tamañoLetraTituloTres=10;
	int xPuntuacionesTres=318;
	int yPuntuacionesTres=190;
	//marco puntuaciones
	int anchoMarcoPuntuaciones=121;
	int altoMarcoPuntuaciones=81;
	int xMarcoPuntuaciones=303;
	int yMarcoPuntuaciones=134; 
	
	private JLabel tituloPuntuaciones;
	private JLabel puestoUnoJlabel;
	private JLabel puestoDosJlabel;
	private JLabel puestoTresJlabel;
	private JLabel marcoPuntucionesJlabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ventanaStart();
					window.frame.setVisible(true);
					System.out.println(window.frame.getWidth());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaStart() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				//calculamos el tamaño de los botones mediante reglas de tres
				botonStart.setBounds((frame.getWidth()/2)-((frame.getWidth()*anchoBoton)/anchoFrame/2), (frame.getHeight()/2)-(((frame.getHeight()*altoBoton)/altoFrame)/2), (frame.getWidth()*anchoBoton)/anchoFrame, (frame.getHeight()*altoBoton)/altoFrame);
				botonStart.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoLetraBoton/(anchoFrame+altoFrame)));
				
				//calculamos el tamaño del titulo
				JlabelTitulo.setBounds((frame.getWidth()/2)-((frame.getWidth()*anchoTitulo)/anchoFrame/2), ((frame.getHeight()/2)-(((frame.getHeight()*altoTitulo)/altoFrame)/2))/7, (frame.getWidth()*anchoTitulo)/anchoFrame, (frame.getHeight()*altoTitulo)/altoFrame);
				JlabelTitulo.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoLetraTitulo/(anchoFrame+altoFrame)));
				
				//calculamos el tamaño del creadores
				JlabelNombreCreadores.setBounds(frame.getWidth()*xCreadores/anchoFrame,frame.getHeight()*yCreadores/altoFrame, (frame.getWidth()*anchoCreadores)/anchoFrame, (frame.getHeight()*altoCreadores)/altoFrame);
				JlabelNombreCreadores.setFont(new Font("Tahoma", Font.PLAIN, (frame.getHeight()+frame.getWidth())*tamañoLetraCreadores/(anchoFrame+altoFrame)));
				
				//calculamos tamaño del titulo puntuaciones
				tituloPuntuaciones.setBounds(frame.getWidth()*xTituloPuntuaciones/anchoFrame,frame.getHeight()*ytituloPuntuaciones/altoFrame,frame.getWidth()*anchoTituloPuntuaciones/anchoFrame,frame.getHeight()*altoTituloPuntuaciones/altoFrame );
				tituloPuntuaciones.setFont(new Font("Stencil", Font.BOLD, (frame.getHeight()+frame.getWidth())*tamañoLetraTituloPuntuaciones/(anchoFrame+altoFrame)));
				tituloPuntuaciones.setBorder(new LineBorder(Color.RED, ((frame.getHeight()+frame.getWidth())*tamañoBorde/(anchoFrame+altoFrame))));
				
				//calculamos el tamaño de la puntuacion uno
				puestoUnoJlabel.setBounds(frame.getWidth()*xPuntuacionesUno/anchoFrame,frame.getHeight()*yPuntuacionesUno/altoFrame,frame.getWidth()*anchoPuntuacionesUno/anchoFrame,frame.getHeight()*altoPuntuacionesUno/altoFrame );
				puestoUnoJlabel.setFont(new Font("Stencil", Font.BOLD, (frame.getHeight()+frame.getWidth())*tamañoLetraTituloUno/(anchoFrame+altoFrame)));
				
				//calculamos el tamaño de la puntuacion dos
				puestoDosJlabel.setBounds(frame.getWidth()*xPuntuacionesDos/anchoFrame,frame.getHeight()*yPuntuacionesDos/altoFrame,frame.getWidth()*anchoPuntuacionesDos/anchoFrame,frame.getHeight()*altoPuntuacionesDos/altoFrame );
				puestoDosJlabel.setFont(new Font("Stencil", Font.BOLD, (frame.getHeight()+frame.getWidth())*tamañoLetraTituloDos/(anchoFrame+altoFrame)));
				
				//calculamos el tamaño de la puntuacion tres
				puestoTresJlabel.setBounds(frame.getWidth()*xPuntuacionesTres/anchoFrame,frame.getHeight()*yPuntuacionesTres/altoFrame,frame.getWidth()*anchoPuntuacionesTres/anchoFrame,frame.getHeight()*altoPuntuacionesTres/altoFrame );
				puestoTresJlabel.setFont(new Font("Stencil", Font.BOLD, (frame.getHeight()+frame.getWidth())*tamañoLetraTituloTres/(anchoFrame+altoFrame)));
				
				//calculamos el marco de las puntuaciones
				marcoPuntucionesJlabel.setBounds(frame.getWidth()*xMarcoPuntuaciones/anchoFrame,frame.getHeight()*yMarcoPuntuaciones/altoFrame,frame.getWidth()*anchoMarcoPuntuaciones/anchoFrame,frame.getHeight()*altoMarcoPuntuaciones/altoFrame );
				
			}
		});
		frame.setBounds(100, 100, anchoFrame, altoFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelInicioFondo = new logicaFondos("/fondos/inicio.jpg");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setLayout(null);
		
		botonStart= new JButton("START");
		botonStart.setForeground(Color.GREEN);
		botonStart.setBounds((frame.getWidth()/2)-(89/2), (frame.getHeight()/2)-(23/2), (frame.getWidth()*anchoBoton)/anchoFrame, (frame.getHeight()*altoBoton)/altoFrame);
		botonStart.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoLetraBoton/(anchoFrame+altoFrame)));
		botonStart.addActionListener(this);
		panelInicioFondo.add(botonStart);
		
		JlabelTitulo = new JLabel("SPACE ATTACK");
		JlabelTitulo.setForeground(Color.RED);
		JlabelTitulo.setBounds((frame.getWidth()/2)-((frame.getWidth()*anchoTitulo)/anchoFrame/2), ((frame.getHeight()/2)-(((frame.getHeight()*altoTitulo)/altoFrame)/2))/7, (frame.getWidth()*anchoTitulo)/anchoFrame, (frame.getHeight()*altoTitulo)/altoFrame);
		JlabelTitulo.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, (frame.getHeight()+frame.getWidth())*tamañoLetraTitulo/(anchoFrame+altoFrame)));

		panelInicioFondo.add(JlabelTitulo);
		
		JlabelNombreCreadores = new JLabel("Por: Bastien L\u00F3pez y Borja L\u00F3pez");
		JlabelNombreCreadores.setForeground(Color.WHITE);
		JlabelNombreCreadores.setFont(new Font("Tahoma", Font.PLAIN, tamañoLetraCreadores));
		JlabelNombreCreadores.setBounds(10, 202, anchoCreadores, altoCreadores);
		panelInicioFondo.add(JlabelNombreCreadores);
		
		tituloPuntuaciones = new JLabel("Puntuaciones");
		tituloPuntuaciones.setForeground(Color.RED);
		tituloPuntuaciones.setFont(new Font("Stencil", Font.BOLD, tamañoLetraTituloPuntuaciones));
		tituloPuntuaciones.setBorder(new LineBorder(Color.RED, tamañoBorde));
		tituloPuntuaciones.setBounds(xTituloPuntuaciones, ytituloPuntuaciones, anchoTituloPuntuaciones, altoTituloPuntuaciones);
		panelInicioFondo.add(tituloPuntuaciones);
		
		marcoPuntucionesJlabel = new JLabel("");
		marcoPuntucionesJlabel.setBorder(new LineBorder(Color.GREEN));
		marcoPuntucionesJlabel.setBounds(xMarcoPuntuaciones, yMarcoPuntuaciones, anchoMarcoPuntuaciones, altoMarcoPuntuaciones);
		panelInicioFondo.add(marcoPuntucionesJlabel);
		
		puestoUnoJlabel = new JLabel("PEPE: 1111111");
		puestoUnoJlabel.setForeground(Color.GREEN);
		puestoUnoJlabel.setFont(new Font("Snap ITC", Font.BOLD, tamañoLetraTituloUno));
		puestoUnoJlabel.setBounds(xPuntuacionesUno, yPuntuacionesUno, anchoPuntuacionesUno, altoPuntuacionesUno);
		panelInicioFondo.add(puestoUnoJlabel);
		
		puestoDosJlabel = new JLabel("PEPE: 1111111");
		puestoDosJlabel.setForeground(Color.GREEN);
		puestoDosJlabel.setFont(new Font("Snap ITC", Font.BOLD, tamañoLetraTituloDos));
		puestoDosJlabel.setBounds(xPuntuacionesDos, yPuntuacionesDos, anchoPuntuacionesDos, altoPuntuacionesDos);
		panelInicioFondo.add(puestoDosJlabel);
		
		puestoTresJlabel = new JLabel("PEPE: 1111111");
		puestoTresJlabel.setForeground(Color.GREEN);
		puestoTresJlabel.setFont(new Font("Snap ITC", Font.BOLD, tamañoLetraTituloTres));
		puestoTresJlabel.setBounds(xPuntuacionesTres, yPuntuacionesTres, anchoPuntuacionesTres, altoPuntuacionesTres);
		panelInicioFondo.add(puestoTresJlabel);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==botonStart) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						ventanaInformacion.window = new ventanaInformacion();
						ventanaInformacion.window.frame.setVisible(true);
					
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
