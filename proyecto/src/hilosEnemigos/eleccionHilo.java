package hilosEnemigos;

public class eleccionHilo {
	hiloEnemigoUno enemigoUno;
	hiloEnemigoDos enemigoDos;
	hiloEnemigoTres enemigoTres;
	hiloEnemigoCuatro enemigoCuatro;
	public eleccionHilo(int tipoEnemigo, String nombrePiloto){
		//Es para saber que logica de enemigo se debe de ejecutar, tambien le pasamos el nombre piloto para 
		// despues hacer el ranking des los Scores
		if(tipoEnemigo==1){
			enemigoUno= new hiloEnemigoUno(tipoEnemigo, nombrePiloto);
		}
		if(tipoEnemigo==2){
			enemigoDos= new hiloEnemigoDos(tipoEnemigo, nombrePiloto);
		}
		if(tipoEnemigo==3){
			enemigoTres= new hiloEnemigoTres(tipoEnemigo, nombrePiloto);
		}
		if(tipoEnemigo==4){
			enemigoCuatro= new hiloEnemigoCuatro(tipoEnemigo, nombrePiloto);
		}
	}
		

}
