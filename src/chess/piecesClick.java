package chess;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.TableStringConverter;

import chess.ChessBorad;

/***4.15 00:30完成***/
public class piecesClick extends MouseAdapter{

	public void mouseClicked(MouseEvent arg0) {
		int x,y;
		//35为X轴，45为Y轴，60为间隔，30,40为x，y减弱 方便点得到
		
		x=(arg0.getX()-35)/60;
		y=(arg0.getY()-45)/60;
		//System.out.println("clicked!");
		//算出来之后x y为格数
		if (x < 0 || x > 8 || y < 0 || y > 9){
			//点击在棋盘外，本次点击无效
			System.out.println("clicked outside!");
			return;
		}
	/*1*/	else {
			//System.out.println("clicked!");
		     
			if(ChessBorad.chessborder.p1==null) {
				//没点到棋子
				System.out.println("没选到");
				//ChessBorad.chessborder.p1=new Point(x,y);
				//System.out.println("没点到棋子，当前坐标："+ChessBorad.chessborder.p1.x+" "+ChessBorad.chessborder.p1.y+" ");
				ChessBorad.chessborder.p1=new Point(x,y);
			}
	/*2*/   else {
		      //点到棋子 
				if (ChessBorad.chessborder.pieces[ChessBorad.chessborder.p1.y][ChessBorad.chessborder.p1.x] == null){
					//选中棋子为空
					
					ChessBorad.chessborder.p1=new Point(x,y);
					System.out.println("当前棋子为空，当前坐标："+ChessBorad.chessborder.p1.x+" "+ChessBorad.chessborder.p1.y+" ");
			       }
		/*3*/	else {
			             //ChessBorad.chessborder.p2=new Point(x,y);
						//选中棋子不为空
							System.out.println("选中棋子不为空");
			             if(ChessBorad.chessborder.pieces[ChessBorad.chessborder.p1.y][ChessBorad.chessborder.p1.x].name.charAt(0)!=ChessBorad.player){
			            	 //不是本方棋子
			            	 System.out.println("不是自己棋子");
			            	ChessBorad. chessborder.p1=new Point(x, y);
			             }
			             else{
			            	 //选中自己棋子
			            	 System.out.println("选中后自己棋子");
			            	 if(ChessBorad.chessborder.pieces[y][x]==null) {
			            		 //第二次选中夜空
			            		 System.out.println("第二次选中夜空");
			            		 ChessBorad.chessborder.p2=new Point(x, y);
			            		 if(ChessBorad.chessborder.movePiece(ChessBorad.chessborder.p1, ChessBorad.chessborder.p2)==true) {
			            			 //终于可以移动了
			            			 System.out.println("终于可以动了");
			            			 String temp=ChessBorad.chessborder.pieces[ChessBorad.chessborder.p2.y][ChessBorad.chessborder.p2.x].name;
			            			 if(temp.charAt(1)=='帅') {
			            				 ChessBorad.info.AddLog("黑方胜利");
			            				 int res=JOptionPane.showConfirmDialog(null, "黑方胜利！！", "是否重来（否为退出）", JOptionPane.YES_NO_OPTION);
        				                 if(res==JOptionPane.YES_OPTION){ 
        				                    System.out.println("选择是后执行的代码");
        				                    new ChessBorad();//点击“是”后执行这个代码块
        				                 }else{
        				                   System.exit(0);
        				                  } 
			            			 }
			            			 if(temp.charAt(1)=='将') {
			            				 ChessBorad.info.AddLog("红方胜利");
			            				 int res=JOptionPane.showConfirmDialog(null, "红方胜利！！", "是否重来（否为退出）", JOptionPane.YES_NO_OPTION);
        				                 if(res==JOptionPane.YES_OPTION){ 
        				                    System.out.println("选择是后执行的代码");
        				                    new ChessBorad();//点击“是”后执行这个代码块
        				                 }else{
        				                   System.exit(0);
        				                  } 
			            			 }
			            			 ChessBorad.chessborder.p1=null;
			            			 ChessBorad.chessborder.p2=null;
			            			 if(ChessBorad.player=='黑') {
			            				 ChessBorad.info.AddLog("红方执子");
			            				 ChessBorad.player='红';
			            			 }
			            			 else if(ChessBorad.player=='红'){
			            				 ChessBorad.info.AddLog("黑方执子");
			            				 ChessBorad.player='黑';
			            			 }
			            		 
			            	 }
			            	 
			            	 else {
			            		 System.out.println("棋子不能移动");
			            		 ChessBorad.chessborder.p1=new Point(x, y);
			            		 ChessBorad.chessborder.p2=null;
			            	 }
			             }
			             else {
			            	 //第二次选中非空
			            	 System.out.println("第二次选中为空");
			            	 if(ChessBorad.chessborder.pieces[y][x].name.charAt(0)==ChessBorad.player) {
			            		 System.out.println("第二次选中奔放旗子");
			            		 ChessBorad.chessborder.p1=new Point(x, y);
			            	 }
			            	 else {
			            		 //选中敌方棋子
			            		 System.out.println("第二次选中的是敌方棋子");
			            		 ChessBorad.chessborder.p2=new Point(x, y);
			            		 String temp=ChessBorad.chessborder.pieces[ChessBorad.chessborder.p2.y][ChessBorad.chessborder.p2.x].name;
			            		 if(ChessBorad.chessborder.movePiece(ChessBorad.chessborder.p1, ChessBorad.chessborder.p2)==true) {
			            			 System.out.println("移动！->"+temp);
			            			 if(temp.charAt(1)=='帅') {
			            				 ChessBorad.info.AddLog("黑方胜利");
			            				 int res=JOptionPane.showConfirmDialog(null, "黑方胜利！！", "是否重来（否为退出）", JOptionPane.YES_NO_OPTION);
			            				                 if(res==JOptionPane.YES_OPTION){ 
			            				                    System.out.println("选择是后执行的代码");
			            				                    new ChessBorad();//点击“是”后执行这个代码块
			            				                 }else{
			            				                   System.exit(0);
			            				                  } 
			            				        
			            			 }
			            			 if(temp.charAt(1)=='将') {
			            				 ChessBorad.info.AddLog("红方胜利");
			            				 int res=JOptionPane.showConfirmDialog(null, "红方胜利！！", "是否重来（否为退出）", JOptionPane.YES_NO_OPTION);
        				                 if(res==JOptionPane.YES_OPTION){ 
        				                    System.out.println("选择是后执行的代码");
        				                    new ChessBorad();//点击“是”后执行这个代码块
        				                 }else{
        				                   System.exit(0);
        				                  } 
			            			 }
			            
			            			 ChessBorad.chessborder.p1=null;
			            			 ChessBorad.chessborder.p2=null;
			            			 if(ChessBorad.player=='黑') {
			            				 ChessBorad.info.AddLog("红方执子");
			            				 ChessBorad.player='红';
			            			 }
			            			 else if(ChessBorad.player=='红'){
			            				 ChessBorad.info.AddLog("黑方执子");
			            				 ChessBorad.player='黑';
			            			 }
			            			 
			            	
			             }
			             else {
							//不能吃
			            	 System.out.println("不能移动");
			            	 ChessBorad.chessborder.p1=new Point(x, y);
			            	 ChessBorad.chessborder.p2=null;
						}
					}
				}
			}
	}
}
}
		//实时更新棋盘
		((ChessBorad.Component)arg0.getSource()).repaint();
		((ChessBorad.Component)arg0.getSource()).paintImmediately(0, 0, ((ChessBorad.Component)arg0.getSource()).getWidth(), ((ChessBorad.Component)arg0.getSource()).getHeight());
		
	}
}
