package logicaAlertaJlabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class logicaFotoAlerta  extends JLabel {
	//El tamaño de la nave
		public static int tamañoX = 400;
		public static int tamañoY = 80;
		
		double miVelocidad;
		
		//constructor de la clase
		public logicaFotoAlerta() {
			//le damos el tamaño al JLabel de la nave
			setSize(tamañoX, tamañoY);
			
			//CReamos una BufferedImage de nombre "imgagenPrimitiva" , que lee el archivo donde esta la imagen
			BufferedImage imgagenPrimitiva = null;//CReamos una BufferedImage de nombre "img" , con la cual se lee el archivo donde esta la imagen
			//Hacemos el try cathc por si no en cuentra el fichero
					try {
						imgagenPrimitiva = ImageIO.read(new File("bin\\logicaAlertaJlabel\\alerta.jpg"));
					} catch (IOException e) {
						System.err.print("No se ha podido cargar bien la imagen");
					    e.printStackTrace();
					}
			
			/*Utilizo el metodo getScaledInstance el cual pertenenece a la clase BufferedImage y nos da una Image
			 *redimensionada 
			 */
			setIcon(new ImageIcon(imgagenPrimitiva.getScaledInstance(tamañoX, tamañoY, Image.SCALE_SMOOTH)));
		}
		

		public void calcVelocidadConAceleracion(long tiempo, double aceleracion) {
			int posX=getX();
			miVelocidad=aceleracion*tiempo;
			System.out.println("posicion:  "+ getX()+"velocida:   "+miVelocidad);
			setLocation(posX+=miVelocidad, getY());
		}
		
		
		protected void paintComponent(Graphics g) {
			Image imagenRedimensionada= ((ImageIcon)getIcon()).getImage();
			 //El Graphics realmente es Graphics2D
			Graphics2D g2 = (Graphics2D) g;
			// Prepara rotación (siguientes operaciones se rotarán)
	        //g2.rotate( miGiro, 50, 50 );
			// Prepara rotación (siguientes operaciones se rotarán)
			 g2.drawImage( imagenRedimensionada, 0, 0, tamañoX, tamañoY, null );
		}


}
