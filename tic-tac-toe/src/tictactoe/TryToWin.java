package tictactoe;


public class TryToWin {
	public int[][] arr;
	public int[][]path;
	
	public TryToWin(int[][] arr,int[][]path) {
		this.arr=arr;
		this.path=path;
	}
	
	public boolean check () {
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==2) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&j>=4) {
						if(arr[temp][2]==0&&arr[path[temp][j-4]][2]==0) {
						
							arr[temp][2]=2;
							return true;
						}
						
					}
					else if(temp!=-1&&j<4) {
						
						if(arr[temp][2]==0&&arr[path[temp][j+4]][2]==0) {
							
							arr[temp][2]=2;
							return true;
						}
						
						
					}
					
				}
				
			}
			
		}
		
		
		
		
	return false;
			
		
	}

}

