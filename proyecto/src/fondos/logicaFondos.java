package fondos;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class logicaFondos extends JPanel {
	
		public Image imagenFondo;
		public URL fondo;
		
	public logicaFondos(String ruta){
		//Se le pasa la ruta del archivo, y lo pone como fondo
		fondo= this.getClass().getResource(ruta);
		imagenFondo= new ImageIcon(fondo).getImage();
		//"/t/as.jpg"
	}

	public void paintComponent(Graphics g){
		g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
	}

}



