package chess;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class infoborder extends JPanel {
		StringBuffer log = new StringBuffer();
		String[] logS = new String[30];
		JButton jButton;
		//Add�����Ĳ���λ��
		int Address = 0;
		
	 public infoborder() {
			// TODO �Զ����ɵĹ��캯�����
			//��ʼ����ʾ��10��
		 super();
		 this.setOpaque(false);
			for (int i = 0;i <15; i ++){
				logS[i] = new String("");
			}
			//���ò���λ��Ϊ��0��
			Address = 0;
			jButton =new JButton("����");
		}
		public void paintComponent(Graphics g){
			BufferedImage BImage = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = BImage.createGraphics();
			g2d.drawImage(Toolkit.getDefaultToolkit().getImage("info.png"), 700, 50,this);
			g2d.setColor(Color.black);
			g2d.setFont(new Font("����",Font.CENTER_BASELINE,35));
			//�������壬����Ϊ��Ҫ��ʾ��10������
			for (int i = 0;i < 15;i ++){
				g2d.drawString(logS[i], 750, 73 + i * 40);
			}
			//ˢ��
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
			//ˢ�½���
			this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
			return new String(log);
		}
		
		public void Clear(){//���log
			this.log = new StringBuffer();//�����ʾ��10��
			for (int i = 0;i < 15; i ++){
				logS[i] = new String("");
			}
			Address = 0;
		}
		public void huiqi() {
		}
}
