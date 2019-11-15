package tictactoe;


public class WhoWin {
	public int[][] arr;
	public int[][]path;
	
	public boolean team1=false;
	public boolean team2=false;
	
	
	public WhoWin(int[][] arr,int[][]path) {
		this.arr=arr;
		this.path=path;
	}
	
	public boolean checkWhoWin () {
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==2) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						if(arr[temp][2]==2&&arr[path[temp][j]][2]==2) {
						
							team2=true;
							return true;
						}
						
					}
				}
				
				
					
			}
			
			if(arr[i][2]==1) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						if(arr[temp][2]==1&&arr[path[temp][j]][2]==1) {
							
							team1=true;
							
							return true;
						}
						
					}
				}
				
				
					
			}
			
			
		}
		
		
		
		
	return false;
			
		
	}

}

