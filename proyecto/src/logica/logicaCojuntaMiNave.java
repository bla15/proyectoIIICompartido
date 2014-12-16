package logica;

import javax.swing.JLabel;







public class logicaCojuntaMiNave extends logicaMiNave {
	logicaFotoMiNave miNave;
	
	public logicaCojuntaMiNave (){
		//Instanciamos el JLabel de nombre miNave para que exista
		miNave = new logicaFotoMiNave();

	}
	public void setFotoNave(logicaFotoMiNave miNave) {
		this.miNave = miNave;
	}
	//devuelve la foto de la nave
	public logicaFotoMiNave getFotoNave() {
		return miNave;
	}
	
	
	public void setPosX(double posX) {
		//Al poner super.setPos indicamos que es el metodo del padre al cual hay que pasarle una variable de tipo Double
		super.setPosX(posX);
		//Esa variable alterara la posicion del eje de las x sobre el cual esta el JLabel
		miNave.setLocation((int)posX, miNave.getY());
		
	}
	public void setPosY(double posY) {
		super.setPosY(posY);	
		miNave.setLocation(miNave.getX(),(int)posY);
	}
	
	public void mueve(double tiempoDeMovimiento) {
		// TODO Auto-generated method stub
		super.mueve(tiempoDeMovimiento);
	}
}
