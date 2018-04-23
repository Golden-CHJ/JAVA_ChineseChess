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
	static char player='红';//设置玩家
	JMenuBar jMenuBar;
	JMenu jMenu;
	JMenuItem jMenuItem1;
	JMenuItem jMenuItem2;
	JMenuItem jMenuItem3;
	JButton jb1;
	/**
	StringBuffer log = new StringBuffer();
	String[] logS = new String[30];
	//Add方法的插入位置
	int Address = 0;
	**/
	
	public ChessBorad() {
		// TODO 自动生成的构造函数存根
         super("中国象棋");//设置JFrame的框架title
         piecesClick=new piecesClick();
		chessborder =new chessborder();
        Component c=new Component();
        /*
        for (int i = 0;i < 30; i ++){
			logS[i] = new String("");
		}
        logS[0] = new String("红方执子");
		//设置插入位置为第0行
		Address = 0;
      */
        jb1=new JButton("悔棋");
        jMenuBar=new JMenuBar();
        jMenu =new JMenu("中国象棋");
        jMenuItem1 =new JMenuItem("保存棋谱");
        jMenuItem2 =new JMenuItem("制作棋谱");
        jMenuItem3 =new JMenuItem("演示棋谱");
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
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//能否正常关闭
		this.setSize(1366,768);//宽、高
		this.setVisible(true);//框架是否可见
		add(info);
		  this.setJMenuBar(jMenuBar);
		info.AddLog("红方执子");
		repaint();
		//add(info);//放前面启动不了棋盘
		/*p1=new JPanel();
		boradCanvas =new ChessBoradCanvas();
		add(boradCanvas);*/
		/**4.12棋子移动***/
		//test
		/*Point p1=new Point(0, 0);
		Point p2=new Point(0, 2);
		chessborder.movePiece(p1, p2);*/
		
		
		
	
	}
	class Component extends JPanel{//添加面板
	    public Component() {
			// TODO 自动生成的构造函数存根
		}
	    public void paintComponent(Graphics g) {//自動調用 不需要改名稱
			 
			super.paintComponents(g);
			g.drawImage(Toolkit.getDefaultToolkit().getImage("chessboardafter.png"), 0, 0,
					Toolkit.getDefaultToolkit().getImage("chessboardafter.png").getWidth(null), 
					Toolkit.getDefaultToolkit().getImage("chessboardafter.png").getHeight(null), this);
			
			for (int i = 0;i < 10;i ++){
				for (int j = 0;j < 9;j ++){
					//发现棋子就绘制
					if (chessborder.pieces[i][j] != null){
						g.drawImage(chessborder.pieces[i][j] .Icon, 
						45 + j  * 60, 35 + i * 60,
						chessborder.pieces[i][j] .Icon.getWidth(null) , chessborder.pieces[i][j] .Icon.getHeight(null), this);
					}
				}
			}//棋子绘制
			/*g.drawImage(Toolkit.getDefaultToolkit().getImage("info.png"), 650,50,
					Toolkit.getDefaultToolkit().getImage("info.png").getWidth(null), 
				Toolkit.getDefaultToolkit().getImage("info.png").getHeight(null), this);*/
			/*BufferedImage BImage = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = BImage.createGraphics();
			g2d.drawImage(Toolkit.getDefaultToolkit().getImage("info.png"), 0, 0,this);
			g2d.setColor(Color.red);
			g2d.setFont(new Font("华文行楷",Font.CENTER_BASELINE,30));
			//绘制字体，内容为需要显示的10行文字
			for (int i = 0;i < 10;i ++){
				g2d.drawString(logS[i], 100, 60 + i * 40);
			}
			//刷新
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
			//刷新界面
			this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
			return new String(log);
	 	}//addlog*/
	    
	    
	}
	
}
