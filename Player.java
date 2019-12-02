// Lazaros Adaloglou.

// Player Class.

public class Player {

	// Class Variables.
	
	int id ;
	int x ;
	int y ;
	int score ;
	String name ;
	Board board ;
	Weapon bow ;
	Weapon pistol ;
	Weapon sword ;
	
	// Getters and Setters.
	
	public int getId ( ) {
			
		return id ;
			
	}
		
	public void setId ( int id ) {
			
		this.id = id ;
			
	}
		
	public int getX ( ) {
			
		return x ;
			
	}
		
	public void setX ( int x ) {
			
		this.x = x ;
			
	}
		
	public int getY ( ) {
			
		return y ;
			
	}
		
	public void setY ( int y ) {
			
		this.y = y ;
			
	}
	
	public int getScore ( ) {
				
		return score ;
				
	}
			
	public void setScore ( int score ) {
				
		this.score = score ;
				
	}
	
	public String getName ( ) {
		
		return name ;
		
	}

	public void setName ( String name ) {
		
		this.name = name ;
		
	}

	public Board getBoard ( ) {
		
		return board ;
		
	}

	public void setBoard ( Board board ) {
		
		this.board = board ;
		
	}

	public Weapon getBow ( ) {
		
		return bow ;
		
	}

	public void setBow ( Weapon bow ) {
		
		this.bow = bow ;
		
	}

   	public Weapon getPistol ( ) {
		
		return pistol ;
		
	}

	public void setPistol ( Weapon pistol ) {
		
		this.pistol = pistol ;
		
	}
	
	public Weapon getSword ( ) {
			
		return sword ;
			
	}

	public void setSword ( Weapon sword ) {
			
		this.sword = sword ;
			
	}
	
	// Constructors.
	
   	public Player ( ) {
		
        setId ( 0 ) ;
		setX ( 0 ) ;
		setY ( 0 ) ;
		setScore ( 0 ) ;
		setName ( "null" ) ;
		setBoard ( null ) ;
		setBow ( null ) ;
		setPistol ( null ) ;
		setSword ( null ) ;
		
   	}
	
	public Player ( int id , int x , int y , int score , String name , Board board , Weapon bow , Weapon pistol , Weapon sword ) {
			
        setId ( id ) ;
		setX ( x ) ;
		setY ( y ) ;
		setScore ( score ) ;
		setName ( name ) ;
		setBoard ( board ) ;
		setBow ( bow ) ;
		setPistol ( pistol ) ;
		setSword ( sword ) ;
		
	}
	
	// Function playerPerimeter.
	
	int [ ] [ ] playerPerimeter ( int x , int y ) {
	
        int [ ] [ ] perimeterMoves = new int [ 8 ] [ 2 ] ;
        int k = 0 ;
        int zerocondx = 0 ;
        int zerocondy = 0 ;
    
        for ( int i = 0 ; i < 3 ; i = i + 2 ) {
    	
    	    for ( int j = 0 ; j < 3 ; j++ ) {
    	    	
    	    	if ( j == 0 & x + j - 1 == 0 ) {
    	    		
    	    		zerocondx = - 1 ;
    	    		
    	    	}
    	    	
    	    	if ( j == 2 & x + j - 1 == 0 ) {
    	    		
    	    		zerocondx = 1 ;
    	    		
    	    	}
    	    	
    	    	if ( i == 0 & y + i - 1 == 0 ) {
    	    		
    	    		zerocondy = - 1 ;
    	    		
    	    	}
    	    	
    	    	if ( i == 2 & y + i - 1 == 0 ) {
    	    		
    	    		zerocondy = 1 ;
    	    		
    	    	}
    			
    	   	    perimeterMoves [ k ] [ 0 ] = ( x + j - 1 + zerocondx ) ;
    	   	    perimeterMoves [ k ] [ 1 ] = ( y + i - 1 + zerocondy ) ;
    	        zerocondx = 0 ;
    	        zerocondy = 0 ;
    	   	    k++ ;
    			
    	    }
    	    
	    	if ( i == 0 & x + i - 1 == 0 ) {
	    		
	    		zerocondx = - 1 ;
	    		
	    	}
	    	
	    	if ( i == 2 & x + i - 1 == 0 ) {
	    		
	    		zerocondx = 1 ;
	    		
	    	}
    	
    	    perimeterMoves [ k ] [ 0 ] = ( x + i - 1 + zerocondx ) ;
    	    perimeterMoves [ k ] [ 1 ] = ( y ) ;
            zerocondx = 0 ;
    	    k++ ;
    		
        }
    
        return perimeterMoves ;
        
	}
	
	// Function getRandomMove.
	
	int [ ] getRandomMove ( ) {
		
	    int [ ] [ ] potentialMoves = new int [ 8 ] [ 2 ] ;
	    int rand = ( int ) ( Math.random ( ) * 7 ) ;
	    
	    potentialMoves = playerPerimeter ( getX ( ) , getY ( ) ) ;
	    
	    while ( Math.abs ( potentialMoves [ rand ] [ 0 ] ) > Math.abs ( getBoard ( ).getM ( ) / 2 ) | Math.abs ( potentialMoves [ rand ] [ 1 ] ) > Math.abs ( getBoard ( ).getN ( ) / 2 ) ) {
        
	        rand = ( int ) ( Math.random ( ) * 7 ) ;
	    
	    }
	    
	    return potentialMoves [ rand ] ;
	    
	}
	    	
   	// Function move.
	
	int [ ] move ( ) {
		
		int oldx = getX ( ) ;
		int oldy = getY ( ) ;
		int [ ] Move = getRandomMove ( ) ;
		setX ( Move [ 0 ] ) ;
		setY ( Move [ 1 ] ) ;
		int weapons = 0 ;
		int traps = 0 ;
		int food = 0 ;
		int [ ] intmove = new int [ 5 ] ;
		
		if ( oldx == getX ( ) & oldy > getY ( ) ) {
		
		    System.out.println ( getName ( ) + " moves North." + "\n" + "\n" ) ;
		
		}
		
		if ( oldx < getX ( ) & oldy > getY ( ) ) {
			
		    System.out.println ( getName ( ) + " moves Northeast." + "\n" + "\n" ) ;
		
		}
		
		if ( oldx > getX ( ) & oldy > getY ( ) ) {
			
		    System.out.println ( getName ( ) + " moves Northwest." + "\n" + "\n" ) ;
		
		}
		
		if ( oldx < getX ( ) & oldy == getY ( ) ) {
			
		    System.out.println ( getName ( ) + " moves East." + "\n" + "\n" ) ;
		
		}
		
		if ( oldx < getX ( ) & oldy < getY ( ) ) {
			
		    System.out.println ( getName ( ) + " moves Southeast." + "\n" + "\n" ) ;
		
		}
		
		if ( oldx == getX ( ) & oldy < getY ( ) ) {
			
		    System.out.println ( getName ( ) + " moves South." + "\n" + "\n" ) ;
		
		}
		
		if ( oldx > getX ( ) & oldy < getY ( ) ) {
			
		    System.out.println ( getName ( ) + " moves Southwest." + "\n" + "\n" ) ;
		
		}
		
		if ( oldx > getX ( ) & oldy == getY ( ) ) {
			
		    System.out.println ( getName ( ) + " moves West." + "\n" + "\n" ) ;
		
		}
		
		// Here the activity of the player is printed.
		
		for ( int i = 0 ; i < getBoard ( ).getWeapons ( ).length ; i++ ) {
			
		   	if ( getX ( ) == getBoard ( ).getWeapons ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getWeapons ( ) [ i ].getY ( ) & getId ( ) == getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) ) {
				
			   	switch ( getBoard ( ).getWeapons ( ) [ i ].getType ( ) ) {
				
				case "bow" :
					
				   	setBow ( getBoard ( ).getWeapons ( ) [ i ] ) ;
					System.out.println ( getName ( ) + " acquires the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " bow." + "\n" + "\n" ) ;
					getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
					getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;
					weapons++ ;
					
				break ;
					
                case "pistol" :
                	
                	setPistol ( getBoard ( ).getWeapons ( ) [ i ] ) ;
					System.out.println ( getName ( ) + " acquires the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " pistol." + "\n" + "\n" ) ;
					getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
					getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;					
					weapons++ ;
					
				break ;
					
                case "sword" :
                	
                	setSword ( getBoard ( ).getWeapons ( ) [ i ] ) ;	
					System.out.println ( getName ( ) + " acquires the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " sword." + "\n" + "\n" ) ;
					getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
					getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;
					weapons++ ;
					
				break ;
					
				}		
				
		    }   

			if ( getX ( ) == getBoard ( ).getWeapons ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getWeapons ( ) [ i ].getY ( ) & getId ( ) != getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) ) {
				
			   	switch ( getBoard ( ).getWeapons ( ) [ i ].getType ( ) ) {
				
				case "bow" :
					
					System.out.println ( getName ( ) + " touches the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " bow, but it's not theirs to claim. " + "\n" + "\n" ) ;
					
				break ;
					
                case "pistol" :
                	
					System.out.println ( getName ( ) + " touches the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " pistol, but it's not theirs to claim. " + "\n" + "\n" ) ;
					
				break ;
					
                case "sword" :
                	
					System.out.println ( getName ( ) + " touches the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " sword, but it's not theirs to claim. " + "\n" + "\n" ) ;
					
				break ;
					
				}		
				
		    }   
			
		}   
		
		for ( int i = 0 ; i < getBoard ( ).getTraps ( ).length ; i++ ) {
			
			if ( getX ( ) == getBoard ( ).getTraps ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getTraps ( ) [ i ].getY ( ) ) {
				
			   	switch ( getBoard ( ).getTraps ( ) [ i ].getType ( ) ) {
				
				case "animal" :
					
				   	if ( getBow ( ) != null ) {
					
					    setScore ( getScore ( ) ) ;
					    System.out.println ( getName ( ) + " defeats the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " beast." + "\n" + "\n" ) ;
					    traps++ ;
					   
					}  
					
					else {
					
					    setScore ( getScore ( ) + getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) ;
					    System.out.println ( getName ( ) + " cannot defeat the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " beast." + "\n" + "\n" ) ;
					
					    if ( ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) == 1 ) {
						
					   	    System.out.println ( getName ( ) + " loses " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " point." + "\n" + "\n" ) ;
						    traps++ ;
						
					    }   
					
					    else {
						
					   	    System.out.println ( getName ( ) + " loses " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " points." + "\n" + "\n" ) ;
						    traps++ ;
						
					    }
					
					}
					
				break ;
					
                case "rope" :
                	
                   	if ( getSword ( ) != null ) {
                		
                	    setScore ( getScore ( ) ) ;
 					    System.out.println ( getName ( ) + " outplays the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " trap." + "\n" + "\n" ) ;
 					    traps++ ;
 					   
                	}   
                	
                	else {
                	
                	    setScore ( getScore ( ) + getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) ;
					    System.out.println ( getName ( ) + " gets outplayed by the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " trap." + "\n" + "\n" ) ;
					
					    if ( ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) == 1 ) {
					
					        System.out.println ( getName ( ) + " loses " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " point." + "\n" + "\n" ) ;
					        traps++ ;
					
					    }	
					
					    else {
						
					   	    System.out.println ( getName ( ) + " loses " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " points." + "\n" + "\n" ) ;
						    traps++ ;
						
					    }   
					
                	}
                	
                break ;
				
		        }
			
		    }
			
		}   
		
		for ( int i = 0 ; i < getBoard ( ).getFood ( ).length ; i++ ) {
			
		   	if ( getX ( ) == getBoard ( ).getFood ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getFood ( ) [ i ].getY ( ) ) {
				
			   	setScore ( getScore ( ) + getBoard ( ).getFood ( ) [ i ].getPoints ( ) ) ;	
				System.out.println ( getName ( ) + " acquires the " + "F" + getBoard ( ).getFood ( ) [ i ].getId ( ) + " supply." + "\n" + "\n" ) ;
					
				if ( getBoard ( ).getFood ( ) [ i ].getPoints ( ) == 1 ) {
					
				    System.out.println ( getName ( ) + " earns " + getBoard ( ).getFood ( ) [ i ].getPoints ( ) + " point." + "\n" + "\n" ) ;
                    getBoard ( ).getFood ( ) [ i ].setX ( 0 ) ;
					getBoard ( ).getFood ( ) [ i ].setY ( 0 ) ;
					food++ ;
					
				}   
					
				else {
						
				    System.out.println ( getName ( ) + " earns " + getBoard ( ).getFood ( ) [ i ].getPoints ( ) + " points." + "\n" + "\n" ) ;	
	                getBoard ( ).getFood ( ) [ i ].setX ( 0 ) ;	
					getBoard ( ).getFood ( ) [ i ].setY ( 0 ) ;	
					food++ ;
						
				}   
					
			}   
			
		}   
	    
		intmove [ 0 ] = getX ( ) ;
		intmove [ 1 ] = getY ( ) ;
		intmove [ 2 ] = weapons ;
		intmove [ 3 ] = traps ;
		intmove [ 4 ] = food ;
		
		return intmove ;
		
	}   
	
}
