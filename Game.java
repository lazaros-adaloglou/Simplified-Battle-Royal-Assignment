//Lazaros Adaloglou

// Class Game.

public class Game {

	// Class Variables.
	
	int round ;

	// Getters and Setters.
	
	public int getRound ( ) {
		
		return round ;
		
	}

	public void setRound ( int round ) {
		
		this.round = round ;
		
	}
	
	// Constructors.
	
	public Game ( ) {
			
	}
		
	public Game ( int round ) {
				
	    setRound ( round ) ;
		    
	}
		
	
	// Function main. 
	
	public static void main ( String [ ] args ) {
		
		// Initializing the game.
		
		Game game = new Game ( 0 ) ;
		
		int M = 20 ;
		int N = 20 ;
		int W = 6 ;
		int T = 8 ;
		int F = 10 ;
		int [ ] [ ] weaponAreaLimits = { { - 2 , - 2 } , { 2 , - 2 } , { 2 , 2 } , { -2 , 2 } } ;
		int [ ] [ ] trapAreaLimits = { { - 4 , - 4 } , { 4 , - 4 } , { 4 , 4 } , { -4 , 4 } } ;
		int [ ] [ ] foodAreaLimits = { { - 3 , - 3 } , { 3 , - 3 } , { 3 , 3 } , { -3 , 3 } } ;
		
		// Creating an object to create a game with the variables initialized.
		
		Board map = new Board ( M , N , W , T , F , weaponAreaLimits , trapAreaLimits , foodAreaLimits ) ;
		
		// "Shuffle" object cords.
		
		map.createBoard ( ) ;
		
		// Creating the two players.
		
		Player Lazaros1 = new Player ( 1 , - M / 2 , - M / 2 , 0 , "Player1" , map , null , null , null ) ;
		
		Player Lazaros2 = new Player ( 2 , M / 2 , M / 2 , 0 , "Player2" , map , null , null , null ) ;
		
		// Setting the string representation for Round 0 ( preparation). 
		
		String [ ] [ ] roundzero = map.getStringRepresentation ( ) ;
		
		roundzero [ 0 ] [ 0 ] = "P" + 1 + "_" ;
		
		roundzero [ map.getM ( ) - 1 ] [ map.getN ( ) - 1 ] = "_" + "P" + 2 ;
		
		System.out.println ( "\n" + "\n" + "Round: " + game.getRound ( ) + "\n" + "\n" ) ;
		
		for ( int i = 0 ; i < map.getM ( ) ; i++ ) {
			
			for ( int j = 0 ; j < map.getM ( ) ; j++ ) {
				
			   System.out.print ( roundzero [ i ] [ j ] ) ;
			
		    }
			
			System.out.print ( "\n" ) ;
			
		}
				
		game.setRound ( game.getRound ( ) + 1 ) ;
		
		// This while keeps the game playing until the board becomes 4x4.
		
		while ( map.getM ( ) > 4 & map.getN ( ) > 4 ) {
			
		    // In every round: The Round is printed, then the check for resizing happens , then the players move and last the board is printed.
			
			System.out.println ( "\n" + "\n" + "Round: " + game.getRound ( ) + "\n" + "\n" ) ;
			
                if ( game.getRound ( ) % 3 == 0 ) {
				
				map.resizeBoard ( Lazaros1 , Lazaros2 ) ;
				
			}
            	
                 Lazaros1.move ( ) ;
    			
			     Lazaros2.move ( ) ;
			     
			     //But before the string representation is used,the players are also added in the string representation.
			
		  String [ ] [ ] playerpos = map.getStringRepresentation ( ) ;	
		  
		  int unit1 = 0 ;
		  int unit2 = 0 ;
		  
		  //With this for and ifs the corresponding player cords help find where the player will be printed.
			
			for ( int i = 0 ; i < map.getM ( ) ; i++ ) {
				
				for ( int j = 0 ; j < map.getN ( ) ; j++ ) {
					
					if ( j >=  map.getN ( ) / 2 ) {
						
						unit1 = 1 ;
						
					}
					
					else {
						
						unit1 = 0 ;
						
					}
					
	                if ( i >=  map.getM ( ) / 2 ) {
						
						unit2 = 1 ;
						
					}
					
					else {
						
						unit2 = 0 ;
						
					}
                    
						if ( Lazaros1.getX ( )  == j - map.getM ( ) / 2 + unit1 & Lazaros1.getY ( )  == i - map.getM ( ) / 2 + unit2 ) {						
						    				
							playerpos [ i ] [ j ] = "P" + Lazaros1.getId ( ) + "_" ;
							
						}
						
                        if ( Lazaros2.getX ( )  == j - map.getM ( ) / 2 + unit1 & Lazaros2.getY ( )  == i - map.getM ( ) / 2 + unit2 ) {
                        	
                        	playerpos [ i ] [ j ] = "_" + "P" + Lazaros2.getId ( )  ;
							
						}
                        
                        if ( Lazaros1.getX ( )  == j - map.getM ( ) / 2 + unit1 & Lazaros1.getY ( )  == i - map.getM ( ) / 2 + unit2 & Lazaros2.getX ( )  == j - map.getM ( ) / 2 + unit1 & Lazaros2.getY ( )  == i - map.getM ( ) / 2 + unit2 ) {						
		    				
							playerpos [ i ] [ j ] = "P12" ;
							
						}
						
					}
				
			}
			
			// Printing the Board.
			
			for ( int i = 0 ; i < map.getM ( ) ; i++ ) {
				
				for ( int j = 0 ; j < map.getM ( ) ; j++ ) {
					
				System.out.print ( playerpos [ i ] [ j ] ) ;
				
			    }
				
				System.out.print ( "\n" ) ;
				
			}
			
			System.out.print ( "\n" ) ;
					
			game.setRound ( game.getRound ( ) + 1 ) ;
			
			
			
		}
		
		// End of the game:The winner is announced.
		
		System.out.println ( "\n" + Lazaros1.getName ( ) + " finished with " + Lazaros1.getScore ( ) + " points" + "\n" ) ;
		
		System.out.println ( Lazaros2.getName ( ) + " finished with " + Lazaros2.getScore ( ) + " points" + "\n" ) ;
		
		if ( Lazaros1.getScore ( ) > Lazaros2.getScore ( ) ) {
			
			System.out.println ( Lazaros1.getName ( ) + " won the game! " ) ;
			
		}
		
		else {
			
			System.out.println ( Lazaros2.getName ( ) + " won the game! " ) ;
			
		}

}
		
}