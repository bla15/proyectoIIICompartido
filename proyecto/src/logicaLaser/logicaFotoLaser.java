package logicaLaser;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class logicaFotoLaser extends JLabel {
	//El tamaño de la nave
	public static int TAMAÑO = 50;
	
	double miVelocidad;
	
	public Area miArea = new Area();
	
	//constructor de la clase
	public logicaFotoLaser() {
		//le damos el tamaño al JLabel de la nave
		setSize(TAMAÑO, TAMAÑO);
		
		//CReamos una BufferedImage de nombre "imgagenPrimitiva" , que lee el archivo donde esta la imagen
		BufferedImage imgagenPrimitiva = null;//CReamos una BufferedImage de nombre "img" , con la cual se lee el archivo donde esta la imagen
		//Hacemos el try cathc por si no en cuentra el fichero
				try {
					imgagenPrimitiva = ImageIO.read(new File("bin\\logicaLaser\\laser.png"));
				} catch (IOException e) {
					System.err.print("No se ha podido cargar bien la imagen");
				    e.printStackTrace();
				}
		
		/*Utilizo el metodo getScaledInstance el cual pertenenece a la clase BufferedImage y nos da una Image
		 *redimensionada 
		 */
		setIcon(new ImageIcon(imgagenPrimitiva.getScaledInstance(TAMAÑO, TAMAÑO, Image.SCALE_SMOOTH)));
	}
	
	public void setPosiciones(int posicionX, int posicionY){
		int posX= getX() + posicionX;
		setLocation(posX, posicionY);
		
	}
	public void calcVelocidadConAceleracion(long tiempo, double aceleracion) {
		int posX=getX();
		miVelocidad=aceleracion*tiempo;
		System.out.println("posicion:  "+ getX()+"velocida:   "+miVelocidad);
		setLocation(posX+=miVelocidad, getY());
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
