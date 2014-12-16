package hilosEnemigos;

import ventanas.ventanaJuego;
import fondos.logicaFondos;

public class corazonNivel1y2 {
	// vidas que me quedan
	int vidas;
	//los corazones
	logicaFondos corazon1;
	logicaFondos corazon2;
	logicaFondos corazon3;
	logicaFondos corazon4;
	
	public corazonNivel1y2(int vida){
		//igualamos vidas
		vidas=vida;
		//creamos los corazones
		corazon1 = new logicaFondos("/fondos/corazonVivo.png");
		corazon1.setBounds(27, 60, 39, 45);
		ventanaJuego.fondoControles.add(corazon1);
		
		corazon2 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon2.setBounds(75, 60, 39, 45);
		ventanaJuego.fondoControles.add(corazon2);
		
		corazon3 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon3.setBounds(124, 60, 39, 45);
		ventanaJuego.fondoControles.add(corazon3);
		
		corazon4 = new logicaFondos("/fondos/CorazonVivo.png");
		corazon4.setBounds(165, 60, 39, 45);
		ventanaJuego.fondoControles.add(corazon4);
		ventanaJuego.fondoControles.repaint();
	}
	
	public void pares(){
		if(vidas==6){
			ventanaJuego.fondoControles.remove(corazon4);
			corazon4 = new logicaFondos("/fondos/corazonMuerto.png");
			corazon4.setBounds(165, 60, 39, 45);
			ventanaJuego.fondoControles.add(corazon4);
			ventanaJuego.fondoControles.repaint();
		}
		if(vidas==4){
			ventanaJuego.fondoControles.remove(corazon3);
			corazon3 = new logicaFondos("/fondos/corazonMuerto.png");
			corazon3.setBounds(124, 60, 39, 45);
			ventanaJuego.fondoControles.add(corazon3);
			ventanaJuego.fondoControles.repaint();
		}
		if(vidas==2){
			ventanaJuego.fondoControles.remove(corazon2);
			corazon2 = new logicaFondos("/fondos/corazonMuerto.png");
			corazon2.setBounds(75, 60, 39, 45);
			ventanaJuego.fondoControles.add(corazon2);
			ventanaJuego.fondoControles.repaint();
		}
		if(vidas==0){
			ventanaJuego.fondoControles.remove(corazon1);
			corazon1 = new logicaFondos("/fondos/corazonMuerto.png");
			corazon1.setBounds(27, 60, 39, 45);
			ventanaJuego.fondoControles.add(corazon1);
			ventanaJuego.fondoControles.repaint();
		}
	}
	
	public void impares(){
		if(vidas==7){
			ventanaJuego.fondoControles.remove(corazon4);
			corazon4 = new logicaFondos("/fondos/medioCorazon.png");
			corazon4.setBounds(165, 60, 39, 45);
			ventanaJuego.fondoControles.add(corazon4);
			ventanaJuego.fondoControles.repaint();
		}
		if(vidas==5){
			ventanaJuego.fondoControles.remove(corazon3);
			corazon3 = new logicaFondos("/fondos/medioCorazon.png");
			corazon3.setBounds(124, 60, 39, 45);
			ventanaJuego.fondoControles.add(corazon3);
			ventanaJuego.fondoControles.repaint();
		}
		if(vidas==3){
			ventanaJuego.fondoControles.remove(corazon2);
			corazon2 = new logicaFondos("/fondos/medioCorazon.png");
			corazon2.setBounds(75, 60, 39, 45);
			ventanaJuego.fondoControles.add(corazon2);
			ventanaJuego.fondoControles.repaint();
		}
		if(vidas==1){
			ventanaJuego.fondoControles.remove(corazon1);
			corazon1 = new logicaFondos("/fondos/medioCorazon.png");
			corazon1.setBounds(27, 60, 39, 45);
			ventanaJuego.fondoControles.add(corazon1);
			ventanaJuego.fondoControles.repaint();
		}
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

}