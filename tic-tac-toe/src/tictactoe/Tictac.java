package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Tictac extends JPanel implements ActionListener,MouseListener{
	Timer timer;
	int delay=8;
	
	int[][] arr= new int[9][3];
	int[][] path=new int[9][8];
	
	boolean flag=false,mouse=true,AI=false;
	
	Win win;
	Defence defence;
	TryToWin tryToWin;
	RemoveFromWin removeFromWin;
	WhoWin whoWin;
	Dynamic dp;
	minimax min;
	int counter3=0;
	
	boolean game=true;
	
	public Tictac() {
		
		addMouseListener(this);
		
		timer=new Timer(delay,this);
		
		timer.start();
		
		int count=0;
		for(int j=100;j<=300;j+=100) {
			
		
			for(int i=400;i<=600;i+=100) {
				
			
				arr[count][0]=i+30;
				arr[count][1]=j+60;
				arr[count][2]=0;
				
				System.out.println(count++);
			}
		}
		
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<8;j++) {
				
				path[i][j]=-1;
			}
			
		}
		
		
		
		path[0][4]=1;
		path[0][5]=4;
		path[0][6]=3;
		
		path[1][0]=0;
		path[1][4]=2;
		path[1][5]=5;
		path[1][6]=4;
		path[1][7]=3;
		
		path[2][0]=1;
		path[2][6]=5;
		path[2][7]=4;
		
		path[3][2]=0;
		path[3][3]=1;
		path[3][4]=4;
		path[3][5]=7;
		path[3][6]=6;
		
		path[4][0]=3;
		path[4][1]=0;
		path[4][2]=1;
		path[4][3]=2;
		path[4][4]=5;
		path[4][5]=8;
		path[4][6]=7;
		path[4][7]=6;
		
		path[5][0]=4;
		path[5][1]=1;
		path[5][2]=2;
		path[5][6]=8;
		path[5][7]=7;
		
		path[6][2]=3;
		path[6][3]=4;
		path[6][4]=7;
		
		path[7][0]=6;
		path[7][1]=3;
		path[7][2]=4;
		path[7][3]=5;
		path[7][4]=8;
		
		path[8][0]=7;
		path[8][1]=4;
		path[8][2]=5;
		
		
		
		
		win=new Win(arr,path);
		defence=new Defence(arr,path);
		tryToWin=new TryToWin(arr,path);
		removeFromWin=new RemoveFromWin(arr,path);
		whoWin=new WhoWin(arr,path);
		
		 dp=new Dynamic();
		 min=new minimax(path);
		
		
		
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0,1500,1000);
		
		g.setColor(Color.red);
		
		for(int i=100;i<=400;i+=100) {
			
			g.drawLine(400,i,700,i);
		}
		
		for(int i=400;i<=700;i+=100) {
			
			g.drawLine(i,100,i,400);
		}
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==2) g.setColor(Color.blue);
			else g.setColor(Color.yellow);
			g.setFont(new Font("serif",Font.BOLD,55));
			if(arr[i][2]==1) g.drawString("O",arr[i][0],arr[i][1]);
			if(arr[i][2]==2) g.drawString("X",arr[i][0],arr[i][1]);
			
			
		}
		
		
		game=whoWin.checkWhoWin();
		
		if(whoWin.team1==true) {
			
			
			
			g.setFont(new Font("serif",Font.BOLD,28));
			g.setColor(Color.red);
			g.drawString("Congratulations! You have Won the match",800, 200);
			
			
				
				
			
			
		}
		else if(whoWin.team2==true) {
			
			
			
			g.setFont(new Font("serif",Font.BOLD,28));
			g.setColor(Color.red);
			g.drawString("AI have Won the match",800, 200);
			
			
		}
		
		int counter2=0;
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]!=0)  counter2++;
				
			
		}
		
		if(counter2==9) {
			
			
			
			g.setFont(new Font("serif",Font.BOLD,28));
			g.setColor(Color.red);
			g.drawString(" Match draw",800, 200);
			
			
				
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(SwingUtilities.isLeftMouseButton(e)&&mouse==true) {
			
			int x=e.getX();
			int y=e.getY();
			
			for(int i=0;i<9;i++) {
				
				if((x>arr[i][0]-30&&x<arr[i][0]+70)&&(y>arr[i][1]-60&&y<arr[i][1]+40)&&arr[i][2]==0) {
					
					
					arr[i][2]=1;
					
					mouse=false;
					AI=true;
					
				}
			}
			
			
			
			
		}
		
		
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(AI==true) {
			
			int temp2=-100,index=0;
			
					
			
			index=min.findBestMove(arr);
			
			
			
			AI=false;
			mouse=true;
			arr[index][2]=2;
		
			
			
			
								
								
								
								
								
								
								
								
								
								
								
								
			
			
			
			
			
			
		}
		
		
		
		if(game==false) repaint();
	}

}
