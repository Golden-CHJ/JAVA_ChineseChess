package chess;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;


/*Frame*/


public class ChessBorad extends JFrame {
	private JPanel p1,p2;
	static infoborder info;
	 static chessborder chessborder;
	ChessBoradCanvas boradCanvas;
	piecesClick piecesClick ;
	static char player='��';//�������
	JMenuBar jMenuBar;
	JMenu jMenu;
	JMenuItem jMenuItem1;
	JMenuItem jMenuItem2;
	JMenuItem jMenuItem3;
	JButton jb1;
	/**
	StringBuffer log = new StringBuffer();
	String[] logS = new String[30];
	//Add�����Ĳ���λ��
	int Address = 0;
	**/
	
	public ChessBorad() {
		// TODO �Զ����ɵĹ��캯�����
         super("�й�����");//����JFrame�Ŀ��title
         piecesClick=new piecesClick();
		chessborder =new chessborder();
        Component c=new Component();
        /*
        for (int i = 0;i < 30; i ++){
			logS[i] = new String("");
		}
        logS[0] = new String("�췽ִ��");
		//���ò���λ��Ϊ��0��
		Address = 0;
      */
        jb1=new JButton("����");
        jMenuBar=new JMenuBar();
        jMenu =new JMenu("�й�����");
        jMenuItem1 =new JMenuItem("��������");
        jMenuItem2 =new JMenuItem("��������");
        jMenuItem3 =new JMenuItem("��ʾ����");
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);
        jMenuBar.add(jMenu);
      
		info=new infoborder();
		
		p1=new JPanel();
		
        c.addMouseListener(piecesClick);
 		this.getContentPane().add(c);
 		p1.add(info);
 		//this.add(jb1);
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ܷ������ر�
		this.setSize(1366,768);//����
		this.setVisible(true);//����Ƿ�ɼ�
		add(info);
		  this.setJMenuBar(jMenuBar);
		info.AddLog("�췽ִ��");
		repaint();
		//add(info);//��ǰ��������������
		/*p1=new JPanel();
		boradCanvas =new ChessBoradCanvas();
		add(boradCanvas);*/
		/**4.12�����ƶ�***/
		//test
		/*Point p1=new Point(0, 0);
		Point p2=new Point(0, 2);
		chessborder.movePiece(p1, p2);*/
		
		
		
	
	}
	class Component extends JPanel{//������
	    public Component() {
			// TODO �Զ����ɵĹ��캯�����
		}
	    public void paintComponent(Graphics g) {//�Ԅ��{�� ����Ҫ�����Q
			 
			super.paintComponents(g);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("chessboardafter.png"), 0, 0,
					Toolkit.getDefaultToolkit().getImage("chessboardafter.png").getWidth(null), 
					Toolkit.getDefaultToolkit().getImage("chessboardafter.png").getHeight(null), this);
			
			for (int i = 0;i < 10;i ++){
				for (int j = 0;j < 9;j ++){
					//�������Ӿͻ���
					if (chessborder.pieces[i][j] != null){
						g.drawImage(chessborder.pieces[i][j] .Icon, 
						45 + j  * 60, 35 + i * 60,
						chessborder.pieces[i][j] .Icon.getWidth(null) , chessborder.pieces[i][j] .Icon.getHeight(null), this);
					}
				}
			}//���ӻ���
			/*g.drawImage(Toolkit.getDefaultToolkit().getImage("info.png"), 650,50,
					Toolkit.getDefaultToolkit().getImage("info.png").getWidth(null), 
				Toolkit.getDefaultToolkit().getImage("info.png").getHeight(null), this);*/
			/*BufferedImage BImage = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = BImage.createGraphics();
			g2d.drawImage(Toolkit.getDefaultToolkit().getImage("info.png"), 0, 0,this);
			g2d.setColor(Color.red);
			g2d.setFont(new Font("�����п�",Font.CENTER_BASELINE,30));
			//�������壬����Ϊ��Ҫ��ʾ��10������
			for (int i = 0;i < 10;i ++){
				g2d.drawString(logS[i], 100, 60 + i * 40);
			}
			//ˢ��
			g.drawImage(BImage, 700,50, null);*/
			
	    }//component
	   /* public String AddLog(String s){
			log.append(s + "\n");
			if (Address < 10){
				logS[Address] = s;
				Address ++;
			}	
			else{
				for (int i = 0;i < 9;i ++){
					logS[i] = logS[i + 1];
				}
				logS[9] = s;
			}
			//ˢ�½���
			this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
			return new String(log);
	 	}//addlog*/
	    
	    
	}
	
}
