package hilosEnemigos;

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


public class hiloEnemigoTres {
	int limiteDerecho=ventanaJuego.paneljuego.WIDTH;
	int limiteIzquierdo=ventanaJuego.anchoPanelJuego-50;
	public  logicaEnemigosConjunta unEnemigo;
	ArrayList<logicaEnemigosConjunta> misEnemigos = new ArrayList<logicaEnemigosConjunta>();
	
	//los corazones
	corazonNivel3y4 corazon;


	int vida=4;
	public hiloEnemigoTres(int tipoEnemigo){
		//lanzmos hilo creacion enemigos
		Runnable r = new hiloCreacionEnemigos(tipoEnemigo); 
		new Thread(r).start();
		
		//lanzamos hilo movimiento
		hiloMovimiento movimientoEnemigo = new hiloMovimiento(); 
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
			
				/*
				 * variable que indica el numero maximo de enmigos que tenemos que crear en este nivel
				 * se va haiendo cada vez mas peque�a hasta llegar aceor
				 */
				int numeroMaximosEnemigos=10;

				//si aun no hemos alcanzado el maximo de enmigos entra
				while((numeroMaximosEnemigos>0)&&(vida>0)){

					//System.out.println(misEnemigos.size());


					unEnemigo= new logicaEnemigosConjunta(tipoEnemigo);
					//posicon aleatoria en el eje de las x (sin que toque los bordes para que se vea bien la imagen
					unEnemigo.setPosX((int)(Math.random()*((limiteIzquierdo)-limiteDerecho+1)+limiteDerecho));
					//la posicion de las y es el alto del panel
					unEnemigo.setPosY(ventanaJuego.paneljuego.HEIGHT);
					//lo metemos en el array de enmigos
					misEnemigos.add(unEnemigo);

					//lo sacmos en el panel de juego
					ventanaJuego.paneljuego.add(unEnemigo.getFotoEnemigo());
					ventanaJuego.paneljuego.repaint();
					//reducimos en un enemigo
					numeroMaximosEnemigos-=1;

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
				System.out.println(vida);
				//les damos movimiento
				for(i=0;i<misEnemigos.size();i++){
				//	misEnemigos.get(i).gira(10);
					misEnemigos.get(i).setSuVelocidad(-125);
					misEnemigos.get(i).mueve(0.040, 0);
					ventanaJuego.paneljuego.repaint();
				}
				
				//miramos si sobrepasan las frontera
				for(i=0;i<misEnemigos.size();i++){
					if(misEnemigos.get(i).getPosY()>ventanaJuego.altoPanelJuego-50){
						ventanaJuego.paneljuego.remove(misEnemigos.get(i).getFotoEnemigo());
						misEnemigos.remove(i);
						vida-=1;
						corazon.setVidas(vida);
						corazon.eliminarVidas();
						
						if(vida==0){
							JOptionPane.showMessageDialog(null, "Te has quedado sin vida", "Error", JOptionPane.ERROR_MESSAGE);
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