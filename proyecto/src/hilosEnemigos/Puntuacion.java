package hilosEnemigos;

import ventanas.ventanaJuego;

public class Puntuacion {
	//puntuacion del jugador
	int puntuacion = 0;
	
	public void calcularPuntuacion(int enemigosMatados, int vidas, int nivel){
		//Siempre llamaremos a este metodo para ir calculando poco a poco las puntuaciones
		if ((nivel == 1) || (nivel == 2)){
			puntuacion = (int) (enemigosMatados*10+vidas*0.5*100);
			ventanaJuego.puntuacionVisible.setText(""+puntuacion);
		} else {
			puntuacion = enemigosMatados*10+vidas*100;
			ventanaJuego.puntuacionVisible.setText(""+puntuacion);
		}
		ventanaJuego.fondoControles.repaint();
	}
	
	public int puntuacionFinal(int enemigosMatados, int vidas, int nivel){
		if ((nivel == 1) || (nivel == 2)){
			return (int) (enemigosMatados*10+vidas*0.5*100);
		} else {
			return enemigosMatados*10+vidas*100;
		}
	}
}
