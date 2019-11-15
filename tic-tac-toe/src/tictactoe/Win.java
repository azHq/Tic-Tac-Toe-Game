package tictactoe;


public class Win {
	public int[][] arr;
	public int[][]path;
	
	public Win(int[][] arr,int[][]path) {
		this.arr=arr;
		this.path=path;
	}
	
	public boolean findForWin () {
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==2) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						if(arr[temp][2]==2&&arr[path[temp][j]][2]==0) {
						
							arr[path[temp][j]][2]=2;
							return true;
						}
						if(arr[temp][2]==0&&arr[path[temp][j]][2]==2) {
							
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
