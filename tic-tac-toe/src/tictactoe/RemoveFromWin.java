package tictactoe;

public class RemoveFromWin {
	public int[][] arr;
	public int[][]path;
	
	public RemoveFromWin(int[][] arr,int[][]path) {
		this.arr=arr;
		this.path=path;
	}
	
	public boolean check () {
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==1) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						if(arr[temp][2]==0&&j%2==0&&i%2==1) {
							
							System.out.println("11111111");
							arr[temp][2]=2;
							return true;
						}
						
					}
					
				}
				
			}
			
		}
		
		
		
		/*for(int i=0;i<9;i++) {
			
			if(arr[i][2]==1) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						
						 if(arr[temp][2]==0&&temp%2==1&&j%2==1){
							 
							 System.out.println("2222222");
							
							arr[temp][2]=2;
							return true;
						}
					}
					
				}
				
			}
			
		}*/
		
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==1) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1) {
						
						if(arr[temp][2]==0&&j%2==1){
							
							
							System.out.println("333333"+j+" "+i+"  "+temp);
							arr[temp][2]=2;
							return true;
						}
					}
					
				}
				
			}
			
		}	
		
		/*for(int i=0;i<9;i++) {
			
			if(arr[i][2]==1) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1	) {
						
						 if(arr[temp][2]==0&&temp%2==1&&j%2==0){
							
							 
							 System.out.println("444444");
							arr[temp][2]=2;
							return true;
						}
					}
					
				}
				
			}
			
		}*/
		
		
		
		
	return false;
			
		
	}

}


