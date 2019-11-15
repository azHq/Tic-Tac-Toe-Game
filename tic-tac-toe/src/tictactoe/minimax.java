package tictactoe;

public class minimax {
	
	public boolean team1,team2;
	int[][] path=new int[9][8];
	public minimax(int [][] path) {
		this.path=path;
	}
	
	public int minimax(int[][] arr, int depth, boolean isMax)
	{
	    
			int[][] board=new int[9][3];
		  for(int i=0;i<9;i++) {
				for(int j=0;j<3;j++) {
					
					board[i][j]=arr[i][j];
				}
			
			}
		  
		
		  int counter2=0;
			for(int i=0;i<9;i++) {
				
				if(board[i][2]!=0)  counter2++;
					
				
			}
			if(counter2==9) {
				counter2=0;
				
				return 0;
			}
		
		
		if(checkWhoWin(board,path)==1) {
			
		
				
				
				
				return 1;
		}
		else if(checkWhoWin(board,path)==-1) {
				
				
				
				return -1; 
		}
			
		
		
		
		
		
		
		
		
		
		
		
	    // If this maximizer's move
	    if (isMax)
	    {
	        int best = -1000;
	 
	        // Traverse all cells
	        for (int i = 0; i<9; i++)
	        {
	           
	               
	                if (board[i][2]==0)
	                {
	                   
	                    board[i][2] = 2;
	 
	                   
	                    best = Math.max( best,
	                        minimax(board, depth+1, !isMax) );
	                    
	                    
	                    System.out.println("best for team 1: "+best);
	 
	                    System.out.println("depth: "+depth);
	                    
	                    board[i][2] =0;
	                }
	            }
	        
	        return best;
	    }
	 
	 
	    else
	    {
	    	  int best =1000;
	    		 
		      
		        for (int i = 0; i<9; i++)
		        {
		           
		                // Check if cell is empty
		                if (board[i][2]==0)
		                {
		                    // Make the move
		                    board[i][2] = 1;
		 
		                   
		                    best = Math.min( best,
		                        minimax(board, depth+1, !isMax) );
		                    System.out.println("best for team 2:  "+best);
		 
		                  
		                    board[i][2] =0;
		                }
		                
		        }
		            
		        
		        return best;
		      
	    }
	    
	}
	 
	
	int findBestMove(int[][] arr)
	{
	    int bestVal = -1000;
	   int index=0;
	   
	   
	   int[][] board=new int[9][3];
	   for(int i=0;i<9;i++) {
			for(int j=0;j<3;j++) {
				
				board[i][j]=arr[i][j];
			}
		
		}
	 
	    
	    for (int i = 0; i<9; i++)
	    {
	      
	            
	            if (board[i][2]==0)
	            {
	                // Make the move
	                board[i][2] = 2;
	 
	                
	                int moveVal = minimax(board, 0, false);
	                
	                System.out.println("return valuevvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv:"+moveVal);
	 
	                // Undo the move
	                board[i][2] =0;
	 
	              
	                if (moveVal > bestVal)
	                {	
	                	
	                	 System.out.println("check best for move" );
	                	index=i;
	                    bestVal = moveVal;
	                }
	            }
	        }
	    
	 
	   System.out.println("The Optimal Move is : "+index);
	 
	    return index;
	}
	
	
	
	
	public int checkWhoWin (int[][] arr,int[][] path) {
		
		
		for(int i=0;i<9;i++) {
			
			if(arr[i][2]==2) {
				for(int j=0;j<8;j++) {
					
					int temp=path[i][j];
					if(temp!=-1&&path[temp][j]!=-1) {
						if(arr[temp][2]==2&&arr[path[temp][j]][2]==2) {
							
							System.out.println("D  team2  win");
							
						
							return 1;
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
							
							
							return -1;
						}
						
					}
				}
				
				
					
			}
			
			
		}
		
		
		
		
	return 0;
			
		
	}

}
