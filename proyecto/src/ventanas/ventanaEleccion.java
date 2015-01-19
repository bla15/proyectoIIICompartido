package ventanas   ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import fondos.logicaFondos;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import logica.logicaFondoJuego;
import logica.logicaPiloto;
import logicaEnemigos.eleccionfotoEnemigo;



public class ventanaEleccion implements KeyListener, ActionListener {

	protected JFrame frame;
	private JTextField txtPonTuNombre;
	
	private JButton btnComenzar ;
	private JRadioButton rdbtnDestino1;
	private JRadioButton rdbtnDestino2;
	private JRadioButton rdbtnDestino3;
	public JRadioButton rdbtnDestino4;
	
	private ButtonGroup grupoBotones;
	
	public  int fondoventanaJuego;
	public int tipoEnemigo;
	
	static ventanaEleccion window;
	
	public static logicaFondoJuego elFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ventanaEleccion();
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
	public ventanaEleccion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		logicaFondos panelInicioFondo = new logicaFondos("/fondos/seleccion.jpg");
		frame.getContentPane().add(panelInicioFondo, BorderLayout.CENTER);
		panelInicioFondo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		panelCentral.setOpaque( false );
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		panelInicioFondo.add(panelCentral, BorderLayout.CENTER);
		
		Component verticalGlue = Box.createVerticalGlue();
		panelCentral.add(verticalGlue);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setOpaque( false );
		panelCentral.add(panelTitulo);
		
		JLabel lblNewLabel = new JLabel("<html><body>Piloto pon tu nombre <br>destino y  <br> cuando acabes <br> pulsa el boton</body></html>");
		lblNewLabel.setFont(new Font("Snap ITC", Font.ITALIC, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setOpaque( false );
		lblNewLabel.setBorder(null);
		panelTitulo.add(lblNewLabel);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panelCentral.add(verticalGlue_1);
		
		JPanel panelDestino = new JPanel();
		panelDestino.setOpaque( false );
		panelInicioFondo.add(panelDestino, BorderLayout.WEST);
		panelDestino.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDestinos = new JPanel();
		panelDestinos.setOpaque( false );
		panelDestinos.setLayout(new BoxLayout(panelDestinos, BoxLayout.Y_AXIS));
		panelDestino.add(panelDestinos, BorderLayout.SOUTH);
		
		JPanel panelTituloDestino = new JPanel();
		panelTituloDestino.setOpaque( false );
		panelDestinos.add(panelTituloDestino);
		panelTituloDestino.setLayout(new BoxLayout(panelTituloDestino, BoxLayout.X_AXIS));
		
		JLabel JlabelTituloDestino = new JLabel("Tus destinos son:");
		panelTituloDestino.add(JlabelTituloDestino);
		JlabelTituloDestino.setForeground(Color.WHITE);
		JlabelTituloDestino.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		JlabelTituloDestino.setOpaque( false );
		JlabelTituloDestino.setBorder(null);
		
		JPanel panelDestino1y2 = new JPanel();
		panelDestino1y2.setOpaque( false );
		panelDestinos.add(panelDestino1y2);
		
		grupoBotones  = new ButtonGroup();
		
		rdbtnDestino1 = new JRadioButton("Destino nebulosa 38");
		rdbtnDestino1.setForeground(Color.WHITE);
		rdbtnDestino1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDestino1.setContentAreaFilled(false);
		grupoBotones.add(rdbtnDestino1);
		panelDestino1y2.add(rdbtnDestino1);
		
		rdbtnDestino2 = new JRadioButton("Destino la Luna");
		rdbtnDestino2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		rdbtnDestino2.setForeground(Color.WHITE);
		rdbtnDestino2.setToolTipText("");
		rdbtnDestino2.setContentAreaFilled(false);
		grupoBotones.add(rdbtnDestino2);
		panelDestino1y2.add(rdbtnDestino2);
		
		JPanel panelDestino3y4 = new JPanel();
		panelDestino3y4.setOpaque( false );
		panelDestinos.add(panelDestino3y4);
		
		rdbtnDestino3 = new JRadioButton("Destino cuadrante Pegaso");
		rdbtnDestino3.setForeground(Color.WHITE);
		rdbtnDestino3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDestino3.setContentAreaFilled(false);
		grupoBotones.add(rdbtnDestino3);
		panelDestino3y4.add(rdbtnDestino3);
		
		rdbtnDestino4= new JRadioButton("Zona negra");
		rdbtnDestino4.setForeground(Color.WHITE);
		rdbtnDestino4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnDestino4.setContentAreaFilled(false);
		grupoBotones.add(rdbtnDestino4);
		panelDestino3y4.add(rdbtnDestino4);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelDestinos.add(verticalStrut);
		
		JPanel panelNick = new JPanel();
		panelNick.setOpaque( false );
		panelInicioFondo.add(panelNick, BorderLayout.EAST);
		panelNick.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNickTitulo = new JPanel();
		panelNickTitulo.setOpaque( false );
		panelNickTitulo.setLayout(new BoxLayout(panelNickTitulo, BoxLayout.Y_AXIS));
		panelNick.add(panelNickTitulo, BorderLayout.SOUTH);
		
		txtPonTuNombre = new JTextField();
		txtPonTuNombre.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		txtPonTuNombre.setText("Pon tu nombre, Recluta");
		panelNickTitulo.add(txtPonTuNombre);
		txtPonTuNombre.setColumns(20);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panelNickTitulo.add(verticalStrut_1);
		
		JPanel panelBotnoComenzar = new JPanel();
		panelBotnoComenzar.setOpaque( false );
		panelInicioFondo.add(panelBotnoComenzar, BorderLayout.SOUTH);
		panelBotnoComenzar.setLayout(new BoxLayout(panelBotnoComenzar, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panelBotnoComenzar.add(horizontalGlue);
		
		btnComenzar = new JButton("A darle ca\u00F1a!!!!");
		btnComenzar.setForeground(Color.WHITE);
		btnComenzar.setBackground(Color.ORANGE);
		btnComenzar.setFont(new Font("Snap ITC", Font.BOLD, 20));
		btnComenzar.addActionListener(this);
		panelBotnoComenzar.add(btnComenzar);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panelBotnoComenzar.add(horizontalGlue_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//metodo para que funcionen las teclas.
		if(e.getSource()==btnComenzar){
			//Este if mira que hayamos escojido bien la seleccion
			if(!txtPonTuNombre.getText().equals("")&&!txtPonTuNombre.getText().equals("Pon tu nombre, Recluta")&&(rdbtnDestino1.isSelected()||rdbtnDestino2.isSelected()||rdbtnDestino3.isSelected()||rdbtnDestino4.isSelected())){
				
				if(rdbtnDestino1.isSelected()){
					fondoventanaJuego=1;
					tipoEnemigo=1;
				}
				else if(rdbtnDestino2.isSelected()){
					fondoventanaJuego=2;
					tipoEnemigo=2;
				}
				else if(rdbtnDestino3.isSelected()){
					fondoventanaJuego=3;
					tipoEnemigo=3;
				}
				else{
					fondoventanaJuego=4;
					tipoEnemigo=4;
				}
				
		
				elFondo = new logicaFondoJuego(fondoventanaJuego);
				this.window.frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							//metemos el nombre del piloto en contenedor
							ventanaStart.contenedor= new logicaPiloto(0, txtPonTuNombre.getText());
						
							ventanaJuego.window = new ventanaJuego(elFondo.getRutaFondo(), elFondo.getJoptionPanel(), tipoEnemigo);
							ventanaJuego.window.frame.setVisible(true);
						
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
			else if(txtPonTuNombre.getText().equals("")||txtPonTuNombre.getText().equals("Pon tu nombre, Recluta")){
				JOptionPane.showMessageDialog(null,"Pon tu nick","ERROR", JOptionPane.ERROR_MESSAGE);
				
			}
			
			else if(!rdbtnDestino1.isSelected()||!rdbtnDestino2.isSelected()||!rdbtnDestino3.isSelected()||!rdbtnDestino4.isSelected())
				JOptionPane.showMessageDialog(null,"Selecciona tu destino, recluta PATOSO!!!","ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




}
