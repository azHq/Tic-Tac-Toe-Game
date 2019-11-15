package tictactoe;


import javax.swing.JFrame;

public class MainClass {
	
	public static void main(String[] args) {
		
		Tictac tt=new Tictac();
		JFrame frame=new JFrame("Sudip");
		frame.setBounds(0,0,1500,1000);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tt);
		frame.setVisible(true);
		
	}

}
