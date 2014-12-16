package hilosEnemigos;

public class eleccionHilo {
	hiloEnemigoUno enemigoUno;
	hiloEnemigoDos enemigoDos;
	hiloEnemigoTres enemigoTres;
	hiloEnemigoCuatro enemigoCuatro;
	public eleccionHilo(int tipoEnemigo){
		if(tipoEnemigo==1){
			enemigoUno= new hiloEnemigoUno(tipoEnemigo);
		}
		if(tipoEnemigo==2){
			enemigoDos= new hiloEnemigoDos(tipoEnemigo);
		}
		if(tipoEnemigo==3){
			enemigoTres= new hiloEnemigoTres(tipoEnemigo);
		}
		if(tipoEnemigo==4){
			enemigoCuatro= new hiloEnemigoCuatro(tipoEnemigo);
		}
	}
		

}
