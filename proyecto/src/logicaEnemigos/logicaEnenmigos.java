package logicaEnemigos;

import java.util.Random;

public class logicaEnenmigos {

	//creamos valorres numericos para cada una de las variables que tendra el laser
	private double suVelocidad;
	private double suDireccionActual;
	private double posX;
	private double posY;
	private int giro = 0;

	public logicaEnenmigos(){
		//le damos una velocidad inicial al laser
		suVelocidad = 50;
		suDireccionActual = 0.0;
		posX = 500 ;
		posY = 500;
		}
	
	
	public double getSuVelocidad() {
		return suVelocidad;
		}
		public void setSuVelocidad(double suVelocidad) {
		this.suVelocidad = suVelocidad;
		}
		public double getSuDireccionActual() {
		return suDireccionActual;
		}
		public void setSuDireccionActual(double dir) {
		if (dir < 0) dir = 360 + dir;
		if (dir > 360) dir = dir - 360;
		suDireccionActual = dir;
		}
		public double getPosX() {
		return posX;
		}
		public void setPosX(double posX) {
		this.posX = posX;
		}
		public double getPosY() {
		return posY;
		}
		public int getGiro(){
			return giro;
		}
		public void setPosY(double posY) {
		this.posY = posY;
		}

		public void setPosicion(double posX,double posY){
		setPosY(posX);
		setPosX(posY);
		}
		
		public void setGiro(int giro2){
			//hacer lo esto con giro set y get
			this.giro=giro2;
		}

		//generamos el metodo para la aceleracion de los enemigos
		public void acelera(double aceleracion){
			suVelocidad += aceleracion;
		}
		//generamos el metodo para que el enemigo gire
		public void gira( double giro ) {
		setSuDireccionActual( suDireccionActual + giro );
		}

		//tiempo por segundo de el movimeiento
		public void mueve( double tiempoDeMovimiento, double giro) {
		if (giro > 0){
			setPosX( posX + (suVelocidad*4) * Math.sin(suDireccionActual+giro/180.0*Math.PI) * tiempoDeMovimiento );
		} else {
			setPosX( posX + suVelocidad * Math.sin(suDireccionActual+giro/180.0*Math.PI) * tiempoDeMovimiento );
		}
		setPosY( posY + suVelocidad * -Math.cos(suDireccionActual/180.0*Math.PI) * tiempoDeMovimiento );
		
		// el negativo es porque en pantalla la Y crece hacia abajo y no hacia arriba
		}
		
		//Metodo que permite cambiar de forma aleatoria el destino del enemigo 
		//en cualquier momento
		public void randomDestino(){
			Random aleatorio = new Random();
			int numero = aleatorio.nextInt(2);
			if (numero == 0)
				setGiro(90);
			else 
				setGiro(270);
		}
}
