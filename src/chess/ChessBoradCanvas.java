package chess;
import java.awt.*;
import javax.swing.*;




public class ChessBoradCanvas extends JPanel{

	Image borad;
	
	public void paintComponet(Graphics g){
		super.paintComponent(g);
		System.out.println(1);
		//ÆåÅÌ
		g.drawImage(Toolkit.getDefaultToolkit().getImage("chessboardafter.png"), 0, 0,
				Toolkit.getDefaultToolkit().getImage("chessboardafter.png").getWidth(null), 
				Toolkit.getDefaultToolkit().getImage("chessboardafter.png").getHeight(null), this);
		//Æå×Ó
		
		
	}
}
