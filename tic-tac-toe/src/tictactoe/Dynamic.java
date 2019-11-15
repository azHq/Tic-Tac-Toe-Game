package tictactoe;

public class Dynamic {
	
	int counter=0;
	boolean team1=false;
	boolean team2=false;
	public Dynamic() {
		
	}
	
	public int searchBestPloyed(int[][] arr,int[][] path,int move) {
		
		int c=0;
		int[][] altArr=new int[9][3];
		for(int i=0;i<9;i++) {
			for(int j=0;j<3;j++) {
				
				altArr[i][j]=arr[i][j];
				
			}
			
			//System.out.println(arr[i][2]+" i"+);
			
			
				
				System.out.print(arr[i][2]+" ");
				
				c++;
				if(c==3){
					c=0;
					System.out.println();
				}
				
				
			
			
		}
		
		System.out.println();
		
		
		
		if(checkWhoWin(altArr,path)) {
			
			if(team2) {
				/*int c=0;
				for(int i=0;i<9;i++) {
					
					System.out.print(arr[i][2]);
					
					c++;
					if(c==3){
						c=0;
						System.out.println();
					}
					
					
				}*/
				
				
				return 1;
			}
			else if(team1) {
				
				/*int c=0;
				for(int i=0;i<9;i++) {
					
					System.out.print(arr[i][2]);
					
					c++;
					if(c==3){
						c=0;
						System.out.println();
					}
					
					
				}*/
				
				return -1; 
			}
			
		}
		
		int counter2=0;
		for(int i=0;i<9;i++) {
			
			if(altArr[i][2]!=0)  counter2++;
				
			
		}
		if(counter2==9) {
			counter2=0;
			
			return 0;
		}
		
		
		if(move==1) {
			
			int ret=-100;
			for(int i=0;i<9;i++) {
				
				if(altArr[i][2]==0) {
					
					altArr[i][2]=1;			
					ret=Math.max(ret,searchBestPloyed(altArr,path,2));
					
					altArr[i][2]=0;
								
				}
						
			}
			
			return ret;
		}
		
		
		
		
		
		
		if(move==2) {
			
			int ret=-100;
			for(int i=0;i<9;i++) {
				
				if(altArr[i][2]==0) {
					
					altArr[i][2]=2;			
					ret=Math.max(ret,searchBestPloyed(altArr,path,1));
					
					altArr[i][2]=0;	
							
								
				}
						
			}
			
			return ret;
		}
		
	
		
		
		
		
		
		
		
		
		return 0;
	
	}
	
	
	
	public boolean checkWhoWin (int[][] arr,int[][] path) {
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==2) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						if(arr[temp][2]==2&&arr[path[temp][j]][2]==2) {
							
							System.out.println("D  team2  win");
							
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
							
							System.out.println("D  team1  win");
							
							team1=true;
							return true;
						}
						
					}
				}
				
				
					
			}
			
			
		}
		
		
		
		
	return false;
			
		
	}
	
	
	
	public boolean tryToWin (int[][] arr,int[][] path) {
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==1) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						if(arr[temp][2]==1&&arr[path[temp][j]][2]==0) {
							
							System.out.println("try tp win 1");
							arr[path[temp][j]][2]=1;
							return true;
						}
						if(arr[temp][2]==0&&arr[path[temp][j]][2]==1) {
							
							System.out.println("try to win2");
							arr[temp][2]=1;
							return true;
						}
					}
				}
				
			}
		}
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==1) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&j>=4) {
						if(arr[temp][2]==0&&arr[path[temp][j-4]][2]==0) {
						
							arr[temp][2]=1;
							return true;
						}
						
					}
					else if(temp!=-1&&j<4) {
						
						if(arr[temp][2]==0&&arr[path[temp][j+4]][2]==0) {
							
							arr[temp][2]=1;
							return true;
						}
						
						
					}
					
				}
				
			}
			
		}
		
		
		
		
	return false;
			
		
	}
	
	

}
