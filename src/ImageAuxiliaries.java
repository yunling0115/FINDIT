import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
public class ImageAuxiliaries {
	public static Image readImage(String fileName){
		try {
			URL url = ImageAuxiliaries.class.getResource(fileName);
			if(url==null){System.out.println("url is null"); return null; }
			ImageProducer producer = (ImageProducer)(url.getContent());
			if(producer==null){System.out.println("producer is null"); return null;}
			Toolkit tk = Toolkit.getDefaultToolkit();
			Image image = tk.createImage(producer);
			return image;
		}
		catch (IOException e){System.out.println("NOOO");};
		return null;
	}
	
}
