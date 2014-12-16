package ventanas;

import hilosEnemigos.eleccionHilo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logica.logicaCojuntaMiNave;
import logica.logicaFotoMiNave;
import logicaEnemigos.eleccionfotoEnemigo;
import logicaEnemigos.logicaEnemigosConjunta;
import logicaLaser.laserConjunto;
import logicaLaser.logicaFotoLaser;
import fondos.logicaFondos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.util.ArrayList;

public class ventanaJuego implements ActionListener, KeyListener {

	protected JFrame frame;
	//panel en el que se juega
	public static logicaFondos paneljuego;
	public static int anchoPanelJuego=1362;
	public static int altoPanelJuego=588;
	
	//panel de los corazones
	public static logicaFondos fondoControles;
	
	public static int anchoPanelcontrol=1362;
	public static int altoPanelControl=119;
	
	protected String rutaFondo="";
	protected String nombrePiloto;
	protected int i;
	
	static ventanaJuego window;
	
	boolean teclasMovimientoNave [] = new boolean[3];

	static logicaCojuntaMiNave naveConjunta;
	static laserConjunto unLaser;

	static eleccionHilo hiloEnemigos;
	logicaFotoLaser laser;
	
	//boolean para que funcionen los hilos
	public static boolean funcionar= true;
	
	
	//arrayList de los lasers que voy disparando
	public static ArrayList<laserConjunto> misLasers = new ArrayList<laserConjunto>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Modificar para probar
					window = new ventanaJuego("/fondos/nebulosa.jpg", 4,4);
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
	public ventanaJuego(String ruta, int JoptionPanel, int enemigos) {
		
		
		rutaFondo=ruta;
		
		this.nombrePiloto=nombrePiloto;
		
		naveConjunta = new logicaCojuntaMiNave();
		naveConjunta.setPosX(623);
		naveConjunta.setPosY(500);
		
		if(JoptionPanel==1){
			JOptionPane.showMessageDialog(null,"Hemos detectado perturbaciones en la zona inferior de la ne enbulosa 38.\nTe hemos enviado para que aniquiles a los enemigos.\n Acabas con ellos de manera sigilosa. ","Nebulosa 38", JOptionPane.INFORMATION_MESSAGE);	
			}
		if(JoptionPanel==2)
			JOptionPane.showMessageDialog(null,"Hola\nHoy tu mision consiste en proteger a la Tierra.\nPreparate,¡Estan llegando ya!","La Luna", JOptionPane.INFORMATION_MESSAGE);
		if(JoptionPanel==3)
			JOptionPane.showMessageDialog(null,"Has sido enviado para defendar el Cuadrante Pegaso.\nComo ya sabes esta zona es imprescindible a nuestra supervivencia\nes imperativo que destruyamos la base enemiga \n para así tener la zona bajo nuestro control","Cuadrante Pegaso", JOptionPane.INFORMATION_MESSAGE);//Terminar
		if(JoptionPanel==4)
			JOptionPane.showMessageDialog(null,"Te hemos enviado para la mision mas peligrosa de todas.\nConfiamos en ti y en tus habilidades,\neres el mejor piloto que disponemos.\nSe fuerte y no tengas piedad, que ellos no la tendran. ","Zona negra", JOptionPane.INFORMATION_MESSAGE);
		
		//pone la ventana anterior oculta
		//ventanaEleccion.window.frame.setVisible(false);	
		
		initialize();
		//creamos los hilos
		hiloMiNave miHiloNave = new hiloMiNave(); 
		miHiloNave.start();
		
		hiloLaser hiloLaser = new hiloLaser(); 
		hiloLaser.start();
		
		hiloEnemigos=new eleccionHilo (enemigos);
		
		
		//metodos para recuperar el foco y que las teclas funcionan
		paneljuego.setFocusable(true);
		paneljuego.requestFocus();
		paneljuego.addKeyListener(this);
		paneljuego.addFocusListener( new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				paneljuego.requestFocus();
			}
		});
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, anchoPanelJuego, altoPanelJuego);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(0, 0, 1362, 706);
		frame.getContentPane().add(panelCentral);
		
		paneljuego = new logicaFondos(rutaFondo);
		paneljuego.setBackground(Color.BLACK);
		paneljuego.setBounds(0, 0, anchoPanelJuego, altoPanelJuego);
		paneljuego.setLayout(null);
		paneljuego.requestFocus();
		panelCentral.setLayout(null);
		panelCentral.add(paneljuego);
		
		paneljuego.add(naveConjunta.getFotoNave());
		
		//paneljuego.add(unEnemigo.getFotoEnemigo());
		
		//eleccionfotoEnemigo a= new eleccionfotoEnemigo(1);
		//a.setLocation(200, 200);
		//paneljuego.add(a);

		//laser.setBounds(623, 500, 63,50);
		//paneljuego.add(laser);
		
		fondoControles  = new logicaFondos("/fondos/datos.jpg");
		fondoControles.setBounds(0, 587, anchoPanelcontrol, altoPanelControl);
		panelCentral.add(fondoControles);
		fondoControles.setLayout(null);
		 
		
		
		
		//panel que guardara los corazones y la puntuacion
		JPanel panelCorazones = new JPanel();
		panelCorazones.setBorder(new LineBorder(Color.BLUE, 2));
		panelCorazones.setBounds(20, 52, 190, 60);
		panelCorazones.setOpaque( false );
		fondoControles.add(panelCorazones);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			teclasMovimientoNave[0]=true;
				
		}
			
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			teclasMovimientoNave[1]=true;
		}
			
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			teclasMovimientoNave[2]=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			teclasMovimientoNave[0]=false;
			
		}

		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			teclasMovimientoNave[1]=false;
		}

		if(e.getKeyCode()==KeyEvent.VK_SPACE)
			teclasMovimientoNave[2]=false;
	}
		
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public class hiloMiNave extends Thread{
		
		public void run(){
			while(funcionar){
				
				naveConjunta.mueve(0.040);
				//movimiento de la nave
				if(teclasMovimientoNave[0]==true){
					if(naveConjunta.getMiVelocidad()==0){
						naveConjunta.acelera(-100);
						
					}
					else if(naveConjunta.getMiVelocidad()<-400){
						naveConjunta.acelera(0);
					}
					else if(naveConjunta.getMiVelocidad()>0){
						naveConjunta.acelera(-50);
					}
					else
						naveConjunta.acelera(-35);

					
						
				}
	
				if(teclasMovimientoNave[1]==true){
					if(naveConjunta.getMiVelocidad()==0){
						naveConjunta.acelera(100);
					}
					else if(naveConjunta.getMiVelocidad()>400){
						naveConjunta.acelera(0);
					}
					else if(naveConjunta.getMiVelocidad()<0){
						naveConjunta.acelera(100);
					}
					else
						naveConjunta.acelera(35);
				}
				
				if(teclasMovimientoNave[2]==true){
					
				}
				//para cuando la tecla no esta pulsada
				if(teclasMovimientoNave[1]==false){
					//tiempo=0;;
				}
				
			

				try {
					if (naveConjunta.getPosX() < paneljuego.WIDTH -logicaFotoMiNave.TAMAÑO/2|| naveConjunta.getPosX()>paneljuego.getWidth()-logicaFotoMiNave.TAMAÑO/2 ) {
						naveConjunta.setMiVelocidad(-naveConjunta.getMiVelocidad());
					}

					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	}
	
	//el hilo de los lasers
		public class hiloLaser extends Thread{
			public void run(){
				while(funcionar){
					if(teclasMovimientoNave[2]==true){
						unLaser= new laserConjunto();
						unLaser.setPosX(naveConjunta.getPosX()+13);
						unLaser.setPosY(naveConjunta.getPosY());
						unLaser.setMiVelocidad(300);
						paneljuego.add(unLaser.getFotoLaser());

						//el giro del laser
						if(naveConjunta.getMiVelocidad()>100){
							unLaser.gira(20);	
						}

						else if(naveConjunta.getMiVelocidad()<-100){
							unLaser.gira(-20);

						}

						//lo añadimos al arrayList de lasers
						misLasers.add(unLaser);
						
						paneljuego.repaint();

					}
					for(i=0;i<misLasers.size();i++){
						misLasers.get(i).mueve(0.040);
						if (misLasers.get(i).getPosY() < -logicaFotoMiNave.TAMAÑO/2 || misLasers.get(i).getPosY()>paneljuego.getHeight()-logicaFotoLaser.TAMAÑO/2 ) {
							paneljuego.remove(misLasers.get(i).getFotoLaser());
							misLasers.remove(i);
							
						}


					}
					try {
						hiloLaser.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
}



