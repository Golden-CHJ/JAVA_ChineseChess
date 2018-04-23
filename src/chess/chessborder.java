package chess;
import java.awt.*;
import javax.swing.*;
/****4.14 ���*******/


/*chj qizi and rule*/
public class chessborder {
	public ChessBorad.Component c;

	public chessPieces[][] pieces;
	public Point p1,p2;
	public chessborder() {
		pieces=new chessPieces[10][9];
		for (int i = 0;i < 10;i ++){
			for (int j = 0;j < 9;j ++){
				pieces[i][j] = null;
			}
		}
		//p1 p2Ϊ·��
		
		Point p1=null;
		Point p2=null;
		//���úڳ�
				pieces[0][0] = new chessPieces(1);
				//���ú���
				pieces[0][1] = new chessPieces(2);
				//���ú���
				pieces[0][2] = new chessPieces(5);
				//���ú�ʿ
				pieces[0][3] = new chessPieces(4);
				//���úڽ�
				pieces[0][4] = new chessPieces(0);
				//���ú�ʿ
				pieces[0][5] = new chessPieces(4);
				//���ú���
				pieces[0][6] = new chessPieces(5);
				//���ú���
				pieces[0][7] = new chessPieces(2);
				//���úڳ�
				pieces[0][8] = new chessPieces(1);
				//���ú���
				for (int i = 0;i < 9;i += 2){
					pieces[3][i] = new chessPieces(6);
				}
				//���ú���
				pieces[2][1] = new chessPieces(3);
				pieces[2][7] = new chessPieces(3);
				
				//���ú쳵
				pieces[9][0] = new chessPieces(8);
				//���ú���
				pieces[9][1] = new chessPieces(9);
				//���ú���
				pieces[9][2] = new chessPieces(13);
				//���ú�ʿ
				pieces[9][3] = new chessPieces(11);
				//���ú�˧
				pieces[9][4] = new chessPieces(12);
				//���ú�ʿ
				pieces[9][5] = new chessPieces(11);
				//���ú���
				pieces[9][6] = new chessPieces(13);
				//���ú���
				pieces[9][7] = new chessPieces(9);
				//���ú쳵
				pieces[9][8] = new chessPieces(8);
				//���ú��
				for (int i = 0;i < 9;i += 2){
					pieces[6][i] = new chessPieces(7);
				}
				//���ú���
				pieces[7][1] = new chessPieces(10);
				pieces[7][7] = new chessPieces(10);
	}
	
	
	public boolean movePiece(Point beg,Point end) {
		if (pieces[beg.y][beg.x] == null){
			//Դλ��û�����ӣ��ƶ�ʧ��
			return false;
		}
		else{
			/**
			 * 0���ڽ�
			 * 1���ڳ�
			 * 2������
			 * 3������
			 * 4����ʿ
			 * 5������
			 * 6������
			 * 7�����
			 * 8���쳵
			 * 9������
			 * 10������
			 * 11����ʿ
			 * 12����˧
			 * 13������
			 */
			switch (pieces[beg.y][beg.x].id) {
			case 0://��
				if(end.x>=3&&end.x<=5&&end.y>=0&&end.y<=2&&distance(beg,end)==1) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("��["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; 
					
					return true;
					}
					else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						ChessBorad.info.AddLog("��["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						//System.out.println("�ԣ�");
						return true;
					}
				}
				else {
					return false;
				}
/*4.12 rule*/
			case 1://��
				if(end.x==beg.x||end.y==beg.y) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("�ڳ�["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; {
						
					}
					return true;
					}
					else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
						ChessBorad.info.AddLog("�ڳ�["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else {
					return false;
				}
			case 2://ma
				if (distance(beg,end) > 2.2 && distance(beg,end) < 2.3){
					//�ж��Ƿ�ѹ���
					if (Math.abs(beg.x -end.x) == 1){
						if (pieces[(beg.y+end.y)/2][beg.x] == null){
							ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
							pieces[end.y][end.x] =pieces[beg.y][beg.x];
							pieces[beg.y][beg.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						if (pieces[beg.y][(beg.x+end.x)/2]==null){ 
							ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
							pieces[end.y][end.x] =pieces[beg.y][beg.x];
							pieces[beg.y][beg.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			case 9://ma
				if (distance(beg,end) > 2.2 && distance(beg,end) < 2.3){
					//�ж��Ƿ�ѹ���
					if (Math.abs(beg.x -end.x) == 1){
						if (pieces[(beg.y+end.y)/2][beg.x] == null){
							ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
							pieces[end.y][end.x] =pieces[beg.y][beg.x];
							pieces[beg.y][beg.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						if (pieces[beg.y][(beg.x+end.x)/2]==null){ 
							ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
							pieces[end.y][end.x] =pieces[beg.y][beg.x];
							pieces[beg.y][beg.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			case 5://xiang
				if (distance(beg,end) > 2.7 && distance(beg,end) < 2.9){
					//�ж��Ƿ�ѹ���
					if (Math.abs(beg.x -end.x) == 2){
						if (pieces[(beg.y+end.y)/2][(beg.x+end.x)/2] == null){
							ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
							pieces[end.y][end.x] =pieces[beg.y][beg.x];
							pieces[beg.y][beg.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						if (pieces[(beg.y+end.y)/2][(beg.x+end.x)/2] == null){
							ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
							pieces[end.y][end.x] =pieces[beg.y][beg.x];
							pieces[beg.y][beg.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			case 13://xiang
				if (distance(beg,end) > 2.7 && distance(beg,end) < 2.9){
					//�ж��Ƿ�ѹ���
					if (Math.abs(beg.x -end.x) == 2){
						if (pieces[(beg.y+end.y)/2][(beg.x+end.x)/2] == null){
							ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
							pieces[end.y][end.x] =pieces[beg.y][beg.x];
							pieces[beg.y][beg.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						if (pieces[(beg.y+end.y)/2][(beg.x+end.x)/2] == null){
							ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
							pieces[end.y][end.x] =pieces[beg.y][beg.x];
							pieces[beg.y][beg.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			case 4://ʿ
				if(end.x>=3&&end.x<=5&&end.y>=0&&end.y<=2&&distance(beg,end)>1.3&&distance(beg,end)<1.5) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("��ʿ["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; 
					return true;
					}
					else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
						ChessBorad.info.AddLog("��ʿ["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else {
					return false;
				}
			case 11://ʿ
				if(end.x>=3&&end.x<=5&&end.y>=7&&end.y<=9&&distance(beg,end)>1.3&&distance(beg,end)<1.5) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("��ʿ["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; 
					return true;
					}
					else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
						ChessBorad.info.AddLog("��ʿ["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else {
					return false;
				}
			case 6://zu
				if(beg.y<5&&distance(beg, end)==1&&end.y-beg.y==1&&end.x==beg.x) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; 
					return true;
					}
				    else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
				    	ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else if(beg.y>=5&&distance(beg, end)==1&&end.y>=beg.y) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; 
					return true;
					}
				    else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
				    	ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else {
					return false;
				}
			case 7://bing
				if(beg.y>=6&&distance(beg, end)==1&&beg.y-end.y==1&&end.x==beg.x) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("���["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; 
					return true;
					}
				    else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
				    	ChessBorad.info.AddLog("���["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else if(beg.y<6&&distance(beg, end)==1&&end.y<=beg.y) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("���["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; 
					return true;
					}
				    else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
				    	ChessBorad.info.AddLog("���["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else {
					return false;
				}
			case 8://��
				if(end.x==beg.x||end.y==beg.y) {
					if(pieces[end.y][end.x]==null) {
						ChessBorad.info.AddLog("�쳵["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; {
						
					}
					return true;
					}
					else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
						ChessBorad.info.AddLog("�쳵["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = null; 
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else {
					return false;
				}
			
			case 3://pao
				if(end.x==beg.x||end.y==beg.y) {
					if(pieces[end.y][end.x]==null) {
						int a=0;
						for(int i= ((end.y>beg.y)?beg.y:end.y)+1;i<((end.y>beg.y)?end.y:beg.y);i++) {
							if(pieces[i][end.x]!=null) {
								a++;
							}
						}
						for(int i= ((end.x>beg.x)?beg.x:end.x)+1;i<((end.x>beg.x)?end.x:beg.x);i++) {
							if(pieces[end.y][i]!=null) {
								a++;
							}
						}
						if(a==0) {
							if(pieces[end.y][end.x] == null) {
								ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
								pieces[end.y][end.x] = null; 
								pieces[end.y][end.x] = pieces[beg.y][beg.x];
								pieces[beg.y][beg.x] = null; 
								return true;
							}
							else {
								return false;
							}
							
						}
					}
					else if (pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//�з�����
						//System.out.println("test1");
						if(end.x==beg.x) {
							int a=0;
							//System.out.println("test2");
							for(int i= ((end.y>beg.y)?beg.y:end.y)+1;i<((end.y>beg.y)?end.y:beg.y);i++) {
								if(pieces[i][end.x]!=null) {
									a++;
								}
							}
							if(a==1) {
								if(pieces[end.y][end.x] == null) {
									return false;
								}
								else {
									ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
									pieces[end.y][end.x] = null; 
								pieces[end.y][end.x] = pieces[beg.y][beg.x];
								pieces[beg.y][beg.x] = null; 
								return true;
								}
								
							}
							else {
								System.out.println("���ƶ�ʧ�ܣ��м���ţ����ӣ�"+a);
								return false;
							}
						}
						else if(end.y==beg.y) {
							int a=0;
							//System.out.println("test2");
							for(int i= ((end.x>beg.x)?beg.x:end.x)+1;i<((end.x>beg.x)?end.x:beg.x);i++) {
								if(pieces[end.y][i]!=null) {
									a++;
								}
							}
							if(a==1) {
								if(pieces[end.y][end.x] == null) {
									return false;
								}
								else {
									ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
								pieces[end.y][end.x] = null; 
								pieces[end.y][end.x] = pieces[beg.y][beg.x];
								pieces[beg.y][beg.x] = null; 
								return true;
								}
								
							}
							else {
								System.out.println("���ƶ�ʧ�ܣ��м���ţ����ӣ�"+a);
								return false;
							}
						}
					}
				}
				else {
					
					return false;
				}
			case 10://pao
				if(end.x==beg.x||end.y==beg.y) {
					if(pieces[end.y][end.x]==null) {
						int a=0;
						for(int i= ((end.y>beg.y)?beg.y:end.y)+1;i<((end.y>beg.y)?end.y:beg.y);i++) {
							if(pieces[i][end.x]!=null) {
								a++;
							}
						}
						for(int i= ((end.x>beg.x)?beg.x:end.x)+1;i<((end.x>beg.x)?end.x:beg.x);i++) {
							if(pieces[end.y][i]!=null) {
								a++;
							}
						}
						if(a==0) {
							if(pieces[end.y][end.x] == null) {
								ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
								pieces[end.y][end.x] = null; 
								pieces[end.y][end.x] = pieces[beg.y][beg.x];
								pieces[beg.y][beg.x] = null; 
								return true;
							}
							else {
								return false;
							}
							
						}
					}
					else if (pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//�з�����
						//System.out.println("test1");
						if(end.x==beg.x) {
							int a=0;
							//System.out.println("test2");
							for(int i= ((end.y>beg.y)?beg.y:end.y)+1;i<((end.y>beg.y)?end.y:beg.y);i++) {
								if(pieces[i][end.x]!=null) {
									a++;
								}
							}
							if(a==1) {
								if(pieces[end.y][end.x] == null) {
									return false;
								}
								else {
									ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
									pieces[end.y][end.x] = null; 
								pieces[end.y][end.x] = pieces[beg.y][beg.x];
								pieces[beg.y][beg.x] = null; 
								return true;
								}
								
							}
							else {
								System.out.println("���ƶ�ʧ�ܣ��м���ţ����ӣ�"+a);
								return false;
							}
						}
						else if(end.y==beg.y) {
							int a=0;
							//System.out.println("test2");
							for(int i= ((end.x>beg.x)?beg.x:end.x)+1;i<((end.x>beg.x)?end.x:beg.x);i++) {
								if(pieces[end.y][i]!=null) {
									a++;
								}
							}
							if(a==1) {
								if(pieces[end.y][end.x] == null) {
									return false;
								}
								else {
									ChessBorad.info.AddLog("����["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
								pieces[end.y][end.x] = null; 
								pieces[end.y][end.x] = pieces[beg.y][beg.x];
								pieces[beg.y][beg.x] = null; 
								return true;
								}
								
							}
							else {
								System.out.println("���ƶ�ʧ�ܣ��м���ţ����ӣ�"+a);
								return false;
							}
						}
					}
				}
				else {
					
					return false;
				}
			
			case 12://˧
				if(end.x>=3&&end.x<=5&&end.y>=7&&end.y<=9&&distance(beg,end)==1) {
					if(pieces[end.y][end.x]==null) {
					ChessBorad.info.AddLog("��˧["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
					pieces[end.y][end.x] = pieces[beg.y][beg.x];
					pieces[beg.y][beg.x] = null; 
					return true;
					}
					else if(pieces[end.y][end.x].name.charAt(0)!=pieces[beg.y][beg.x].name.charAt(0)) {
						//��ͬ��ɫ
						ChessBorad.info.AddLog("��˧["+beg.y+"]["+beg.x+"]��["+end.y+"]["+end.x+"]");
						pieces[end.y][end.x] = pieces[beg.y][beg.x];
						pieces[beg.y][beg.x] = null; 
						System.out.println("�ԣ�");
						return true;
					}
				}
				else {
					return false;
				}
			default:
				break;
			}
			/*pieces[end.y][end.x] = pieces[beg.y][beg.x];
			pieces[beg.y][beg.x] = null; 
			return true;*/
			return false;
		}
	}
	
	public float distance(Point a,Point b) {
		//�������ӵ��ƶ�����
		return (float)Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
	
}
