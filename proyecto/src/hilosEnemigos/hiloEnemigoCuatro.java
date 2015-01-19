package hilosEnemigos;

import java.awt.EventQueue;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import fondos.logicaFondos;
import logica.logicaFotoMiNave;
import logicaEnemigos.eleccionfotoEnemigo;
import logicaEnemigos.logicaEnemigosConjunta;
import logicaLaser.logicaFotoLaser;
import logicaLaser.logicaLaser;
import ventanas.ventanaJuego;
import ventanas.ventanaJuego.hiloLaser;


public class hiloEnemigoCuatro {
	int limiteDerecho=ventanaJuego.paneljuego.WIDTH;
	int limiteIzquierdo=ventanaJuego.anchoPanelJuego-50;
	long tiempoAccion;
	public  logicaEnemigosConjunta unEnemigo;
	ArrayList<logicaEnemigosConjunta> misEnemigos = new ArrayList<logicaEnemigosConjunta>();
	int numeroEnemigosMatados;
	Puntuacion puntuacionActual = new Puntuacion();
	
	//los corazones
	corazonNivel3y4 corazon;

	int vida=4;
	public hiloEnemigoCuatro(int tipoEnemigo){
		//lanzmos hilo creacion enemigos
		Runnable r = new hiloCreacionEnemigos(tipoEnemigo); 
		new Thread(r).start();
		
		//lanzamos hilo movimiento
		hiloMovimiento movimientoEnemigo = new hiloMovimiento(); 
		tiempoAccion = System.currentTimeMillis();
		movimientoEnemigo.start();
		
		//lanzams hilo de gestion choques
		hiloChoques choqueConLaser = new hiloChoques(); 
		choqueConLaser.start();

		//creamos los corazones
		corazon= new corazonNivel3y4(vida);
	}


	/*
	 * hilo que crea a los enemigos y los mete en la arraty list
	 * tambien los va sacando por pantalla
	 */
	public class hiloCreacionEnemigos implements Runnable {
		int tipoEnemigo;

		public hiloCreacionEnemigos(int tipoEnemigo){
			this.tipoEnemigo=tipoEnemigo;
		}

		public void run() {
			
				//si aun no se han perdido todas las vidas, entra
				while(vida>0){
					unEnemigo= new logicaEnemigosConjunta(tipoEnemigo);
					//posicon aleatoria en el eje de las x (sin que toque los bordes para que se vea bien la imagen
					unEnemigo.setPosX((int)(Math.random()*((limiteIzquierdo)-limiteDerecho+1)+limiteDerecho));
					//la posicion de las y es el alto del panel
					unEnemigo.setPosY(ventanaJuego.paneljuego.HEIGHT);
					//Le ponemos un giro de inicio
					unEnemigo.setGiro(90);
					//lo metemos en el array de enmigos
					misEnemigos.add(unEnemigo);

					//lo sacmos en el panel de juego
					ventanaJuego.paneljuego.add(unEnemigo.getFotoEnemigo());
					ventanaJuego.paneljuego.repaint();

					try {
						//cada cuanto tiempo los va creando
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}



			
		}
	}
	
	/*
	 * hilo que gestiona el movimiento de los enemigos
	 */
	public class hiloMovimiento extends Thread{
		int i;
		public void run(){
			while(vida>0){
				
				//Aqui lo que se hace es que cada 0.3 segundos, se calcula un nuevo giro para el enemigo
				//Exsten 2 posibilidades o seguira por donde va desde el principio o cambia directamente
				if ((System.currentTimeMillis()-tiempoAccion >=1000) && (System.currentTimeMillis()-tiempoAccion <=1500)){
					for (int i = 0;i < misEnemigos.size();i++){
						misEnemigos.get(i).randomDestino();
						
					}
					tiempoAccion = System.currentTimeMillis();
				}
				
				//les damos movimiento
				for(i=0;i<misEnemigos.size();i++){
				//	misEnemigos.get(i).gira(10);
					misEnemigos.get(i).setSuVelocidad(-100);
					//Aqui le pasamos los parametros que necesita para mover el enemigo
					misEnemigos.get(i).mueve(0.040, misEnemigos.get(i).getGiro());
					ventanaJuego.paneljuego.repaint();
				}
				
				//miramos si sobrepasan las frontera (primero laterales y luego la de abajo)
				for(i=0;i<misEnemigos.size();i++){
					if(misEnemigos.get(i).getPosX() < limiteDerecho){
						misEnemigos.get(i).setGiro(270);
						
					} else if (misEnemigos.get(i).getPosX() > limiteIzquierdo){
						misEnemigos.get(i).setGiro(90);
						
					}
					//frontera inferior
					if(misEnemigos.get(i).getPosY()>ventanaJuego.altoPanelJuego-50){
						ventanaJuego.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
						misEnemigos.remove(i);
						vida-=1;
						//Ya que la puntuacion depende de las vidas tambien, recalculamos la puntuacion 
						//cada vez que se pierda una vida
						puntuacionActual.calcularPuntuacion(numeroEnemigosMatados, vida, 4);
						
						corazon.setVidas(vida);
						corazon.eliminarVidas();
						
						if(vida==0){
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										int puntuacionFinal = puntuacionActual.puntuacionFinal(numeroEnemigosMatados, vida, 4);
										ventanas.gameOver.window = new ventanas.gameOver(puntuacionFinal);
										ventanas.gameOver.window.frame.setVisible(true);
									
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							ventanaJuego.funcionar=false;
						}
					}
				}
				try {
					hiloMovimiento.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
	/*
	 * hilo que gestiona el movimiento de los enemigos
	 */
	public class hiloChoques extends Thread{
		int i;
		int z;
		public void run(){
			while(vida>0){
				for(z=0;z<ventanaJuego.misLasers.size();z++){
					for(i=0;i<misEnemigos.size();i++){

						
						Area areaEnemigo = new Area(misEnemigos.get(i).getFoto().miArea);
						Area areaLaser = new Area(ventanaJuego.misLasers.get(z).getFotoLaser().miArea );
						if(areaEnemigo.intersects(areaLaser.getBounds2D())){
							ventanaJuego.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
							misEnemigos.remove(i);
							//Calculamos la puntuacion cada vez que muera un enemigo
							numeroEnemigosMatados++;
							puntuacionActual.calcularPuntuacion(numeroEnemigosMatados, vida, 4);
						}
						
						
					}
				}
				try {
					hiloChoques.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}