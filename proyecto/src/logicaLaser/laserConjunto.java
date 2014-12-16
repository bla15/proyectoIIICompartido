package logicaLaser;

import javax.swing.JLabel;



//esta clase pondar en comun los metodos de la foto y de la logica del laser
public class laserConjunto extends logicaLaser {
	//creamos la foto del laser
	logicaFotoLaser fotoLaser;
	
	//llamamos al constrctor
	public laserConjunto (){
		//Instanciamos la foto del laser
		fotoLaser= new logicaFotoLaser();

	}
	
	//devuelve la foto del laser para poder incluirlo al panel
	public logicaFotoLaser getFotoLaser() {
		return fotoLaser;
	}
	
	//metodo para cambiar la x del laser
	public void setPosX(double posX) {
		//para el metodo padre
		super.setPosX(posX);
		//para que afecte a la foto del laser
		fotoLaser.setLocation((int)posX, fotoLaser.getY());
		
	}
	//metodo para cambiar la y del laser
	public void setPosY(double posY) {
		super.setPosY(posY);	
		fotoLaser.setLocation(fotoLaser.getX(),(int)posY);
	}
	
	public void mueve(double tiempoDeMovimiento) {
		// TODO Auto-generated method stub
		super.mueve(tiempoDeMovimiento);
	}
	
	public laserConjunto esteLaser( ) {
		return this;
	}
}
