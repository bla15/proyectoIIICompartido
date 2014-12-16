package logicaEnemigos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.temporal.TemporalAmount;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class eleccionfotoEnemigo extends JLabel {

	public static int TAMAÑO = 50;

	double suVelocidad;

	String rutafoto;
	public Area miArea = new Area();

	public eleccionfotoEnemigo(int tipoEnemigo){
		//le damos el tamaño al JLabel de la nave enemiga
		setSize(TAMAÑO, TAMAÑO);

		//CReamos una BufferedImage de nombre "imgagenPrimitiva" , que lee el archivo donde esta la imagen
		BufferedImage imgagenPrimitiva = null;//CReamos una BufferedImage de nombre "img" , con la cual se lee el archivo donde esta la imagen
		//Hacemos el try cathc por si no en cuentra el fichero
		try {

			imgagenPrimitiva = ImageIO.read(new File(rutaFoto(tipoEnemigo)));
		} catch (IOException e) {
			System.err.print("No se ha podido cargar bien la imagen");
			e.printStackTrace();
		}

		/*Utilizo el metodo getScaledInstance el cual pertenenece a la clase BufferedImage y nos da una Image
		 *redimensionada 
		 */
		setIcon(new ImageIcon(imgagenPrimitiva.getScaledInstance(TAMAÑO, TAMAÑO, Image.SCALE_SMOOTH)));
		
	}
	
	public String rutaFoto(int tipoEnemigo){
		if(tipoEnemigo==1){
			rutafoto="bin\\logicaEnemigos\\enemigoUno.png";
			
		}
		if(tipoEnemigo==2){
			rutafoto="bin\\logicaEnemigos\\EnemigoDos.png";
		}
		if(tipoEnemigo==3){
			rutafoto="bin\\logicaEnemigos\\EnemigoTres.png";
			
		}
		if(tipoEnemigo==4){
			rutafoto="bin\\logicaEnemigos\\EnemigoCuatro.png";	
		}
		return rutafoto;
	}
	public void setPosiciones(int posicionX, int posicionY){
		int posX= getX() + posicionX;
		setLocation(posX, posicionY);
		
	}
	public void calcVelocidadConAceleracion(long tiempo, double aceleracion) {
		int posX=getX();
		suVelocidad=aceleracion*tiempo;
		System.out.println("posicion:  "+ getX()+"velocida:   "+suVelocidad);
		setLocation(posX+=suVelocidad, getY());
	}
	
	
	
	
	@Override
	public void setLocation(int x, int y) {
		// TODO Auto-generated method stub
		super.setLocation(x, y);
		Rectangle r = new Rectangle(x,y,TAMAÑO,TAMAÑO);
		miArea = new Area(r);
	}

	@Override
	public void setLocation(Point p) {
		// TODO Auto-generated method stub
		setLocation(p.x,p.y);
	}

	protected void paintComponent(Graphics g) {
		Image imagenRedimensionada= ((ImageIcon)getIcon()).getImage();
		 //El Graphics realmente es Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		// Prepara rotación (siguientes operaciones se rotarán)
        //g2.rotate( miGiro, 50, 50 );
		// Prepara rotación (siguientes operaciones se rotarán)
		 g2.drawImage( imagenRedimensionada, 0, 0, TAMAÑO, TAMAÑO, null );
	}



}
