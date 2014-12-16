package logica;

public class logicaFondoJuego {

	String rutaFondo;
	
	int JoptionPanel;
	
//constructor que recibe el int para elejir el fondo
public logicaFondoJuego(int fondoventanaJuego){

	if(fondoventanaJuego==1){
		rutaFondo="/fondos/nebulosa.jpg";
		JoptionPanel=1;
	}
	else if(fondoventanaJuego==2){
		rutaFondo="/fondos/luna.jpg";
		JoptionPanel=2;
	}
	else if(fondoventanaJuego==3){
		rutaFondo="/fondos/cuadrante.jpg";
		JoptionPanel=3;
	}
	else if(fondoventanaJuego==4){
		rutaFondo="/fondos/negro.jpg";
		JoptionPanel=4;
	}
}
	
	public String getRutaFondo() {
		return rutaFondo;
	}

	public void setRutaFondo(String rutaFondo) {
		this.rutaFondo = rutaFondo;
	}
	
	public int getJoptionPanel() {
		return JoptionPanel;
	}

	public void setJoptionPanel(int joptionPanel) {
		JoptionPanel = joptionPanel;
	}
	



}
