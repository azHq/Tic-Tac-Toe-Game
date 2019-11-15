package tictactoe;

public class Defence {
	
	public int[][] arr;
	public int[][]path;
	
	public Defence(int[][] arr,int[][]path) {
		
		this.arr=arr;
		this.path=path;
		
	}

	public boolean defenceWin () {
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==1) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						if(arr[temp][2]==1&&arr[path[temp][j]][2]==0) {
						
							arr[path[temp][j]][2]=2;
							return true;
						}
						if(arr[temp][2]==0&&arr[path[temp][j]][2]==1) {
							
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
