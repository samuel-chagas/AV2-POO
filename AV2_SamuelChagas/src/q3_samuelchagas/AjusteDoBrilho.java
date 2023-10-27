package q3_samuelchagas;
import java.awt.Color;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class AjusteDoBrilho {

	public static int Valor;
	public static void main(String[] args) {
		String arquivo = "C:/Users//SAMUEL//Documents//java//AV2_SamuelChagas//src//q3_samuelchagas//image.png";
		File file = new File (arquivo);
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Aumentar ou Diminuir o Brilho:");
		Valor = scan.nextInt();
		
		scan.close();
		
		try {
			BufferedImage imagem = ImageIO.read(file);
			int Largura = imagem.getWidth();
			int Altura = imagem.getHeight();
			
			
			for (int i = 0; i < Largura; i++) {
				for (int j = 0; j < Altura; j++) {
					Color c = new Color (imagem.getRGB(i, j));
					
					
					
				int Vermelho = (c.getRed() + Valor) <= 255 ? c.getRed() + Valor >= 0 ? (c.getRed() + Valor) : 0 : 255;
				int Verde = (c.getGreen() + Valor) <= 255 ? c.getGreen() + Valor >= 0 ? (c.getGreen() + Valor) : 0 : 255;
				int Azul = (c.getBlue() + Valor) <= 255 ? c.getBlue() + Valor >= 0 ? (c.getBlue() + Valor) : 0 : 255;
					
					imagem.setRGB (i,j, new Color (Vermelho, Verde, Azul).getRGB());
			 }
			}
			ImageIO.write(imagem, "png", file);
		}   catch (IOException e) {
			e.printStackTrace();
  }
 }
}
