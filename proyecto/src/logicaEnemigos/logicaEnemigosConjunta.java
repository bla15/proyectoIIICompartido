package logicaEnemigos;

public class logicaEnemigosConjunta extends logicaEnenmigos{
	eleccionfotoEnemigo fotoEnemigo;
	
	public eleccionfotoEnemigo getFoto() {
		return fotoEnemigo;
	}
	
	public logicaEnemigosConjunta(int tipoEnemigo){
		fotoEnemigo=new eleccionfotoEnemigo(tipoEnemigo);
	}
	
	//devuelve la foto del enemigo para poder incluirlo al panel
		public eleccionfotoEnemigo getFotoEnemigo() {
			return fotoEnemigo;
		}
		//metodo para cambiar la x del enemigo
		public void setPosX(double posX) {
			//para el metodo padre
			super.setPosX(posX);
			//para que afecte a la foto del enemigo
			fotoEnemigo.setLocation((int)posX, fotoEnemigo.getY());
			
		}
		//metodo para cambiar la y del enemigo
		public void setPosY(double posY) {
			super.setPosY(posY);	
			fotoEnemigo.setLocation(fotoEnemigo.getX(),(int)posY);
		}
		public void mueve(double tiempoDeMovimiento, double giro) {
			// TODO Auto-generated method stub
			super.mueve(tiempoDeMovimiento,giro);
		}
		public logicaEnemigosConjunta esteEnemigo() {
			return this;
		}
		public void setGiro(int giro){
			super.setGiro(giro);
		}
}
