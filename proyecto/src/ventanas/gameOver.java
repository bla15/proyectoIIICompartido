package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;




import logica.BD;
import fondos.logicaFondos;


public class gameOver implements  ActionListener{
	
public static gameOver window;
	
	//frame de la ventana
	public JDialog frame;
	//los botones
	JButton botonNext;
	JButton botonAdelante;
	private JPanel panelPuntuaciones;
	private JLabel enunciadoPuntuaciones;
	private JLabel puntuaciones;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					window = new gameOver();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public gameOver(String nombreJugador, int puntuacion, int nivel) {
		initialize(nombreJugador, puntuacion, nivel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nombreJugador, int puntuacion, int nivel) {
		frame = new JDialog(ventanaJuego.frame);
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setSize(600,350); 
		frame.setResizable(false); 
		
		
		
		logicaFondos panelInicioFondo = new logicaFondos("/fondos/gameover3.png");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setLayout(null);	
		
		JLabel panelRepetir = new JLabel("<html><body>Para volver a jugar<br> inicia otra vez, <br>el programa desde tu PC </body></html>");
		panelRepetir.setHorizontalAlignment(SwingConstants.CENTER);
		panelRepetir.setForeground(new Color(255, 255, 255));
		panelRepetir.setFont(new Font("Simplified Arabic Fixed", Font.BOLD | Font.ITALIC, 11));
		panelRepetir.setBounds(32, 241, 220, 98);
		panelRepetir.setOpaque( false );
		panelInicioFondo.add(panelRepetir);
		
		botonAdelante= new JButton("Salir");
		botonAdelante.setFont(new Font("Impact", Font.PLAIN, 30));
		botonAdelante.setForeground(Color.BLACK);
		//btnNewButton.setOpaque(false);
		//btnNewButton.setContentAreaFilled(false);
		botonAdelante.setBounds(333, 277, 117, 40);
		botonAdelante.addActionListener(this);
		panelInicioFondo.add(botonAdelante);
		
		panelPuntuaciones = new JPanel();
		panelPuntuaciones.setBorder(new LineBorder(Color.GREEN));
		panelPuntuaciones.setBounds(155, 11, 248, 74);
		panelPuntuaciones.setOpaque( false );
		panelInicioFondo.add(panelPuntuaciones);
		panelPuntuaciones.setLayout(null);
		
		enunciadoPuntuaciones = new JLabel("Tu puntuacion es:  ");
		enunciadoPuntuaciones.setForeground(Color.GREEN);
		enunciadoPuntuaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enunciadoPuntuaciones.setBounds(10, 22, 133, 26);
		panelPuntuaciones.add(enunciadoPuntuaciones);
		
		puntuaciones = new JLabel();
		puntuaciones.setForeground(Color.GREEN);
		puntuaciones.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 20));
		puntuaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		puntuaciones.setBounds(142, 11, 96, 52);
		puntuaciones.setText(""+puntuacion);
		panelPuntuaciones.add(puntuaciones);
		
		//Insertamos en la base de datos solo si es del nivel 4
		if (nivel == 4)
		BD.insertAccion(nombreJugador, puntuacion);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==botonAdelante){
			//Cerramos la BD
			BD.finConexion();
			System.exit( 0 ); 
		}
		
	}

}
