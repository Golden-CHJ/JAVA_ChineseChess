package chess;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.TableStringConverter;

import chess.ChessBorad;

/***4.15 00:30���***/
public class piecesClick extends MouseAdapter{

	public void mouseClicked(MouseEvent arg0) {
		int x,y;
		//35ΪX�ᣬ45ΪY�ᣬ60Ϊ�����30,40Ϊx��y���� �����õ�
		
		x=(arg0.getX()-35)/60;
		y=(arg0.getY()-45)/60;
		//System.out.println("clicked!");
		//�����֮��x yΪ����
		if (x < 0 || x > 8 || y < 0 || y > 9){
			//����������⣬���ε����Ч
			System.out.println("clicked outside!");
			return;
		}
	/*1*/	else {
			//System.out.println("clicked!");
		     
			if(ChessBorad.chessborder.p1==null) {
				//û�㵽����
				System.out.println("ûѡ��");
				//ChessBorad.chessborder.p1=new Point(x,y);
				//System.out.println("û�㵽���ӣ���ǰ���꣺"+ChessBorad.chessborder.p1.x+" "+ChessBorad.chessborder.p1.y+" ");
				ChessBorad.chessborder.p1=new Point(x,y);
			}
	/*2*/   else {
		      //�㵽���� 
				if (ChessBorad.chessborder.pieces[ChessBorad.chessborder.p1.y][ChessBorad.chessborder.p1.x] == null){
					//ѡ������Ϊ��
					
					ChessBorad.chessborder.p1=new Point(x,y);
					System.out.println("��ǰ����Ϊ�գ���ǰ���꣺"+ChessBorad.chessborder.p1.x+" "+ChessBorad.chessborder.p1.y+" ");
			       }
		/*3*/	else {
			             //ChessBorad.chessborder.p2=new Point(x,y);
						//ѡ�����Ӳ�Ϊ��
							System.out.println("ѡ�����Ӳ�Ϊ��");
			             if(ChessBorad.chessborder.pieces[ChessBorad.chessborder.p1.y][ChessBorad.chessborder.p1.x].name.charAt(0)!=ChessBorad.player){
			            	 //���Ǳ�������
			            	 System.out.println("�����Լ�����");
			            	ChessBorad. chessborder.p1=new Point(x, y);
			             }
			             else{
			            	 //ѡ���Լ�����
			            	 System.out.println("ѡ�к��Լ�����");
			            	 if(ChessBorad.chessborder.pieces[y][x]==null) {
			            		 //�ڶ���ѡ��ҹ��
			            		 System.out.println("�ڶ���ѡ��ҹ��");
			            		 ChessBorad.chessborder.p2=new Point(x, y);
			            		 if(ChessBorad.chessborder.movePiece(ChessBorad.chessborder.p1, ChessBorad.chessborder.p2)==true) {
			            			 //���ڿ����ƶ���
			            			 System.out.println("���ڿ��Զ���");
			            			 String temp=ChessBorad.chessborder.pieces[ChessBorad.chessborder.p2.y][ChessBorad.chessborder.p2.x].name;
			            			 if(temp.charAt(1)=='˧') {
			            				 ChessBorad.info.AddLog("�ڷ�ʤ��");
			            				 int res=JOptionPane.showConfirmDialog(null, "�ڷ�ʤ������", "�Ƿ���������Ϊ�˳���", JOptionPane.YES_NO_OPTION);
        				                 if(res==JOptionPane.YES_OPTION){ 
        				                    System.out.println("ѡ���Ǻ�ִ�еĴ���");
        				                    new ChessBorad();//������ǡ���ִ����������
        				                 }else{
        				                   System.exit(0);
        				                  } 
			            			 }
			            			 if(temp.charAt(1)=='��') {
			            				 ChessBorad.info.AddLog("�췽ʤ��");
			            				 int res=JOptionPane.showConfirmDialog(null, "�췽ʤ������", "�Ƿ���������Ϊ�˳���", JOptionPane.YES_NO_OPTION);
        				                 if(res==JOptionPane.YES_OPTION){ 
        				                    System.out.println("ѡ���Ǻ�ִ�еĴ���");
        				                    new ChessBorad();//������ǡ���ִ����������
        				                 }else{
        				                   System.exit(0);
        				                  } 
			            			 }
			            			 ChessBorad.chessborder.p1=null;
			            			 ChessBorad.chessborder.p2=null;
			            			 if(ChessBorad.player=='��') {
			            				 ChessBorad.info.AddLog("�췽ִ��");
			            				 ChessBorad.player='��';
			            			 }
			            			 else if(ChessBorad.player=='��'){
			            				 ChessBorad.info.AddLog("�ڷ�ִ��");
			            				 ChessBorad.player='��';
			            			 }
			            		 
			            	 }
			            	 
			            	 else {
			            		 System.out.println("���Ӳ����ƶ�");
			            		 ChessBorad.chessborder.p1=new Point(x, y);
			            		 ChessBorad.chessborder.p2=null;
			            	 }
			             }
			             else {
			            	 //�ڶ���ѡ�зǿ�
			            	 System.out.println("�ڶ���ѡ��Ϊ��");
			            	 if(ChessBorad.chessborder.pieces[y][x].name.charAt(0)==ChessBorad.player) {
			            		 System.out.println("�ڶ���ѡ�б�������");
			            		 ChessBorad.chessborder.p1=new Point(x, y);
			            	 }
			            	 else {
			            		 //ѡ�ез�����
			            		 System.out.println("�ڶ���ѡ�е��ǵз�����");
			            		 ChessBorad.chessborder.p2=new Point(x, y);
			            		 String temp=ChessBorad.chessborder.pieces[ChessBorad.chessborder.p2.y][ChessBorad.chessborder.p2.x].name;
			            		 if(ChessBorad.chessborder.movePiece(ChessBorad.chessborder.p1, ChessBorad.chessborder.p2)==true) {
			            			 System.out.println("�ƶ���->"+temp);
			            			 if(temp.charAt(1)=='˧') {
			            				 ChessBorad.info.AddLog("�ڷ�ʤ��");
			            				 int res=JOptionPane.showConfirmDialog(null, "�ڷ�ʤ������", "�Ƿ���������Ϊ�˳���", JOptionPane.YES_NO_OPTION);
			            				                 if(res==JOptionPane.YES_OPTION){ 
			            				                    System.out.println("ѡ���Ǻ�ִ�еĴ���");
			            				                    new ChessBorad();//������ǡ���ִ����������
			            				                 }else{
			            				                   System.exit(0);
			            				                  } 
			            				        
			            			 }
			            			 if(temp.charAt(1)=='��') {
			            				 ChessBorad.info.AddLog("�췽ʤ��");
			            				 int res=JOptionPane.showConfirmDialog(null, "�췽ʤ������", "�Ƿ���������Ϊ�˳���", JOptionPane.YES_NO_OPTION);
        				                 if(res==JOptionPane.YES_OPTION){ 
        				                    System.out.println("ѡ���Ǻ�ִ�еĴ���");
        				                    new ChessBorad();//������ǡ���ִ����������
        				                 }else{
        				                   System.exit(0);
        				                  } 
			            			 }
			            
			            			 ChessBorad.chessborder.p1=null;
			            			 ChessBorad.chessborder.p2=null;
			            			 if(ChessBorad.player=='��') {
			            				 ChessBorad.info.AddLog("�췽ִ��");
			            				 ChessBorad.player='��';
			            			 }
			            			 else if(ChessBorad.player=='��'){
			            				 ChessBorad.info.AddLog("�ڷ�ִ��");
			            				 ChessBorad.player='��';
			            			 }
			            			 
			            	
			             }
			             else {
							//���ܳ�
			            	 System.out.println("�����ƶ�");
			            	 ChessBorad.chessborder.p1=new Point(x, y);
			            	 ChessBorad.chessborder.p2=null;
						}
					}
				}
			}
	}
}
}
		//ʵʱ��������
		((ChessBorad.Component)arg0.getSource()).repaint();
		((ChessBorad.Component)arg0.getSource()).paintImmediately(0, 0, ((ChessBorad.Component)arg0.getSource()).getWidth(), ((ChessBorad.Component)arg0.getSource()).getHeight());
		
	}
}
