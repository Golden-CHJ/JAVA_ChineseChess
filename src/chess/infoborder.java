package chess;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class infoborder extends JPanel {
		StringBuffer log = new StringBuffer();
		String[] logS = new String[30];
		JButton jButton;
		//Add方法的插入位置
		int Address = 0;
		
	 public infoborder() {
			// TODO 自动生成的构造函数存根
			//初始化显示的10行
		 super();
		 this.setOpaque(false);
			for (int i = 0;i <15; i ++){
				logS[i] = new String("");
			}
			//设置插入位置为第0行
			Address = 0;
			jButton =new JButton("悔棋");
		}
		public void paintComponent(Graphics g){
			BufferedImage BImage = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = BImage.createGraphics();
			g2d.drawImage(Toolkit.getDefaultToolkit().getImage("info.png"), 700, 50,this);
			g2d.setColor(Color.black);
			g2d.setFont(new Font("楷体",Font.CENTER_BASELINE,35));
			//绘制字体，内容为需要显示的10行文字
			for (int i = 0;i < 15;i ++){
				g2d.drawString(logS[i], 750, 73 + i * 40);
			}
			//刷新
			jButton.setBounds(700, 15, 60, 30);
			add(jButton);
			g.drawImage(BImage, 0, 0, null);
		}
		
		public String AddLog(String s){
			log.append(s + "\n");
			if (Address < 15){
				logS[Address] = s;
				Address ++;
			}	
			else{
				for (int i = 0;i < 14;i ++){
					logS[i] = logS[i + 1];
				}
				logS[14] = s;
			}
			//刷新界面
			this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
			return new String(log);
		}
		
		public void Clear(){//清空log
			this.log = new StringBuffer();//清空显示的10行
			for (int i = 0;i < 15; i ++){
				logS[i] = new String("");
			}
			Address = 0;
		}
		public void huiqi() {
		}
}
