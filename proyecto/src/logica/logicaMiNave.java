package logica;

public class logicaMiNave {
	
		//Esta clase se utilizara para dar las funciones al juego

//creamos valorres numericos para cada una de las variables de mi coche
private double miVelocidad;
private double miDireccionActual;
private double posX;
private double posY;


//constructor
public logicaMiNave(){
	miVelocidad = 0.0;
	miDireccionActual = 0.0;
	posX = 623;
	posY = 100;

}

//Añadimos los set y get
public double getMiVelocidad() {
	return miVelocidad;
}
public void setMiVelocidad(double miVelocidad) {
	this.miVelocidad = miVelocidad;
}
public double getMiDireccionActual() {
	return miDireccionActual;
}
public void setMiDireccionActual(double dir) {
	if (dir < 0) dir = 360 + dir;
	if (dir > 360) dir = dir - 360;
	miDireccionActual = dir;
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
public void setPosY(double posY) {
	this.posY = posY;
}


public void setPosicion(double posX,double posY){
	setPosY(posX);
	setPosX(posY);
}

//generamos un toString para ver que elementos hay guardados en las variables
@Override
public String toString() {
	return " en posicion " + miDireccionActual+" y direccion "+ posX + " en las x, " + posY +" en las Y; con una velocidad de "+ miVelocidad;
}

//generamos el metodo para la aceleracion del coche
public void acelera(double aceleracion){
	miVelocidad += aceleracion;
}

//tiempo por segundo de el movimeiento
public void mueve( double tiempoDeMovimiento) {
	setPosX( posX + miVelocidad * Math.cos(miDireccionActual/180.0*Math.PI) * tiempoDeMovimiento );
	
}



}




