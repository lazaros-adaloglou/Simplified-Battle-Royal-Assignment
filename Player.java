//Lazaros Adaloglou

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
	
	// Function getRandomMove.
	
	int [ ] getRandomMove ( ) {
		
	    int [ ] newSquare = new int [ 2 ] ;
	    
	    // Initializing the variables that will allow/forbidden the random move of the player.
		
		int forbidden1 = 0 ; 
		int forbidden2 = 0 ; 
		int forbidden3 = 0 ; 
		int forbidden4 = 0 ;
		int forbidden5 = 0 ;
		int forbidden6 = 0 ;
		int forbidden7 = 0 ;
		int forbidden8 = 0 ;
		
		// If the player can't go north , northeast or east, the corresponding variables are set.
		
		if ( getX ( ) + 1 > getBoard ( ).getM ( ) / 2 & getY ( ) - 1 < - getBoard ( ).getN ( ) / 2 ) {
			
			forbidden1 = 1 ;
			forbidden2 = 2 ;
			forbidden3 = 3 ;
			forbidden4 = 4 ;
			forbidden8 = 8 ;
			
		}
		
		// Same for the remaining directions.
		
        if ( getX ( ) + 1 > getBoard ( ).getM ( ) / 2 & getY ( ) + 1 > getBoard ( ).getN ( ) / 2 ) {
			
        	forbidden2 = 2 ;
			forbidden3 = 3 ;
			forbidden4 = 4 ;
			forbidden5 = 5 ;
			forbidden6 = 6 ;
			
		}
        
        if ( getX ( ) - 1 < - getBoard ( ).getM ( ) / 2 & getY ( ) + 1 > getBoard ( ).getN ( ) / 2 ) {
			
        	forbidden4 = 4 ;
			forbidden5 = 5 ;
			forbidden6 = 6 ;
			forbidden7 = 7 ;
			forbidden8 = 8 ;
			
		}
        
        if ( getX ( ) - 1 < - getBoard ( ).getM ( ) / 2 & getY ( ) - 1 < - getBoard ( ).getN ( ) / 2 ) {
			
        	forbidden1 = 1 ;
			forbidden2 = 2 ;
			forbidden6 = 6 ;
			forbidden7 = 7 ;
			forbidden8 = 8 ;
			
		}
        
        if ( getY ( ) - 1 < - getBoard ( ).getN ( ) / 2 ) {
			
        	forbidden1 = 1 ;
			forbidden2 = 2 ;
			forbidden8 = 8 ;
			
		}
        
        if ( getY ( ) + 1 > getBoard ( ).getN ( ) / 2 ) {
			
        	forbidden4 = 4 ;
			forbidden5 = 5 ;
			forbidden6 = 6 ;
			
		}
        
        if ( getX ( ) + 1 > getBoard ( ).getM ( ) / 2 ) {
			
        	forbidden2 = 2 ;
			forbidden3 = 3 ;
			forbidden4 = 4 ;
			
		}
        
        if ( getX ( ) - 1 < - getBoard ( ).getM ( ) / 2 ) {
			
        	forbidden6 = 6 ;
			forbidden7 = 7 ;
			forbidden8 = 8 ;
			
		}
        
        // Now if rand is nothing like the variables that got "activated" , it will let the player move.
		
		int rand = ( ( int ) ( Math.random ( ) * 7 ) ) + 1 ;
		
		while ( rand == forbidden1 | rand == forbidden2 | rand == forbidden3 | rand == forbidden4 | rand == forbidden5 | rand == forbidden6 | rand == forbidden7 | rand == forbidden8 ) {
			
			rand = ( ( int ) ( Math.random ( ) * 7 ) ) + 1 ;
			
		}
		
		// Now that rand passed the test,it's time to assign and return the new directions.(The ifs inside the switch statement are used to skip the zero cords situation. 
		
		switch ( rand ) {
		
		case 1 :
			
			if ( getY ( ) - 1 == 0 ) {
			
			newSquare [ 0 ] = getX ( ) ;
			
			newSquare [ 1 ] = getY ( ) - 2 ;
			
			}
			
			else {
				
				newSquare [ 0 ] = getX ( ) ;
				
				newSquare [ 1 ] = getY ( ) - 1 ;
				
			}
			
			break ;
			
        case 2 :
        	
        	if ( getY ( ) - 1 == 0 & getX ( ) + 1 == 0 ) {
        	
			newSquare [ 0 ] = getX ( ) + 2 ;
			
			newSquare [ 1 ] = getY ( ) - 2 ;
			
        	}
        	
        	else if ( getY ( ) - 1 != 0 & getX ( ) + 1 == 0 ) {
            	
			newSquare [ 0 ] = getX ( ) + 2 ;
			
			newSquare [ 1 ] = getY ( ) - 1 ;
			
        	}
        	
        	else if ( getY ( ) - 1 == 0 & getX ( ) + 1 != 0 ) {
            	
			newSquare [ 0 ] = getX ( ) + 1 ;
			
			newSquare [ 1 ] = getY ( ) - 2 ;
			
        	}
        	
        	else {
            	
    		newSquare [ 0 ] = getX ( ) + 1 ;
    			
    		newSquare [ 1 ] = getY ( ) - 1 ;
    			
            }
			
			break ;
			
        case 3 :
        	
        	if ( getX ( ) + 1 == 0 ) {
        	
			newSquare [ 0 ] = getX ( ) + 2 ;
			
			newSquare [ 1 ] = getY ( ) ; 

        	} else {
        		
    			newSquare [ 0 ] = getX ( ) + 1 ;
    			
    			newSquare [ 1 ] = getY ( ) ;
        	}
        	
	        break ;
	
        case 4 :
        	
        	if ( getY ( ) + 1 == 0 & getX ( ) + 1 == 0 ) {
            	
    			newSquare [ 0 ] = getX ( ) + 2 ;
    			
    			newSquare [ 1 ] = getY ( ) + 2 ;
    			
            	}
            	
            	else if ( getY ( ) + 1 != 0 & getX ( ) + 1 == 0 ) {
                	
    			newSquare [ 0 ] = getX ( ) + 2 ;
    			
    			newSquare [ 1 ] = getY ( ) + 1 ;
    			
            	}
            	
            	else if ( getY ( ) + 1 == 0 & getX ( ) + 1 != 0 ) {
                	
    			newSquare [ 0 ] = getX ( ) + 1 ;
    			
    			newSquare [ 1 ] = getY ( ) + 2 ;
    			
            	}
            	
            	else {
                	
        		newSquare [ 0 ] = getX ( ) + 1 ;
        			
        		newSquare [ 1 ] = getY ( ) + 1 ;
        			
                }
    			
	
	        break ;
	
        case 5 :
        	
        	if ( getY ( ) + 1 == 0 ) {
        	
            newSquare [ 0 ] = getX ( ) ;
			
			newSquare [ 1 ] = getY ( ) + 2 ;
			
        	} else {
        		
                newSquare [ 0 ] = getX ( ) ;
    			
    			newSquare [ 1 ] = getY ( ) + 1 ;
    			
        	}

	         break ;
	
        case 6 :
        	
                if ( getY ( ) + 1 == 0 & getX ( ) - 1 == 0 ) {
            	
    			newSquare [ 0 ] = getX ( ) - 2 ;
    			
    			newSquare [ 1 ] = getY ( ) + 2 ;
    			
            	}
            	
            	else if ( getY ( ) + 1 != 0 & getX ( ) - 1 == 0 ) {
                	
    			newSquare [ 0 ] = getX ( ) - 2 ;
    			
    			newSquare [ 1 ] = getY ( ) + 1 ;
    			
            	}
            	
            	else if ( getY ( ) + 1 == 0 & getX ( ) - 1 != 0 ) {
                	
    			newSquare [ 0 ] = getX ( ) - 1 ;
    			
    			newSquare [ 1 ] = getY ( ) + 2 ;
    			
            	}
            	
            	else {
                	
        		newSquare [ 0 ] = getX ( ) - 1 ;
        			
        		newSquare [ 1 ] = getY ( ) + 1 ;
        			
                }
    			

	         break ;
	
        case 7 :
        	
        	if ( getX ( ) - 1 == 0 ) {
        	
            newSquare [ 0 ] = getX ( ) - 2 ;
			
 			newSquare [ 1 ] = getY ( ) ;
        	} else {
        		
                newSquare [ 0 ] = getX ( ) - 1 ;
    			
     			newSquare [ 1 ] = getY ( ) ;
        		
        	}
	         break ;
	
        case 8 :
        	
            if ( getY ( ) - 1 == 0 & getX ( ) - 1 == 0 ) {
            	
			newSquare [ 0 ] = getX ( ) - 2 ;
			
			newSquare [ 1 ] = getY ( ) - 2 ;
			
        	}
        	
        	else if ( getY ( ) - 1 != 0 & getX ( ) - 1 == 0 ) {
            	
			newSquare [ 0 ] = getX ( ) - 2 ;
			
			newSquare [ 1 ] = getY ( ) - 1 ;
			
        	}
        	
        	else if ( getY ( ) - 1 == 0 & getX ( ) - 1 != 0 ) {
            	
			newSquare [ 0 ] = getX ( ) - 1 ;
			
			newSquare [ 1 ] = getY ( ) - 2 ;
			
        	}
        	
        	else {
            	
    		newSquare [ 0 ] = getX ( ) - 1 ;
    			
    		newSquare [ 1 ] = getY ( ) - 1 ;
    			
            }

	        break ;
		
	    }
		
		return newSquare ;
		
	}
	
	// Function move.
	
	int [ ] move ( ) {
		
		//First the move direction is printed
		
		int oldx = getX ( ) ;
		
		int oldy = getY ( ) ;
		
		int [ ] Move = getRandomMove ( ) ;
		
		// Then the new cords are set as player coordinates.
		
		setX ( Move [ 0 ] ) ;
		
		setY ( Move [ 1 ] ) ;
		
		int weapons = 0 ;
		
		int traps = 0 ;
		
		int food = 0 ;
		
		int [ ] intmove = new int [ 5 ] ;
		
		if ( oldx == getX ( ) & oldy > getY ( ) ) {
		
		System.out.println ( getName ( ) + " moved North " + "\n" + "\n" ) ;
		
		}
		
		if ( oldx < getX ( ) & oldy > getY ( ) ) {
			
		System.out.println ( getName ( ) + " moved Northeast " + "\n" + "\n" ) ;
		
		}
		
		if ( oldx > getX ( ) & oldy > getY ( ) ) {
			
		System.out.println ( getName ( ) + " moved Northwest " + "\n" + "\n" ) ;
		
		}
		
		if ( oldx < getX ( ) & oldy == getY ( ) ) {
			
		System.out.println ( getName ( ) + " moved East " + "\n" + "\n" ) ;
		
		}
		
		if ( oldx < getX ( ) & oldy < getY ( ) ) {
			
		System.out.println ( getName ( ) + " moved Southeast " + "\n" + "\n" ) ;
		
		}
		
		if ( oldx == getX ( ) & oldy < getY ( ) ) {
			
		System.out.println ( getName ( ) + " moved South " + "\n" + "\n" ) ;
		
		}
		
		if ( oldx > getX ( ) & oldy < getY ( ) ) {
			
		System.out.println ( getName ( ) + " moved Southwest " + "\n" + "\n" ) ;
		
		}
		
		if ( oldx > getX ( ) & oldy == getY ( ) ) {
			
		System.out.println ( getName ( ) + " moved West " + "\n" + "\n" ) ;
		
		}
		
		// Here the activity the player is printed.
		
		for ( int i = 0 ; i < getBoard ( ).getWeapons ( ).length ; i++ ) {
			
			if ( getX ( ) == getBoard ( ).getWeapons ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getWeapons ( ) [ i ].getY ( ) & getId ( ) == getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) ) {
				
				switch ( getBoard ( ).getWeapons ( ) [ i ].getType ( ) ) {
				
				case "bow" :
					
					setBow ( getBoard ( ).getWeapons ( ) [ i ] ) ;
					
					System.out.println ( getName ( ) + " acquired the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " bow." + "\n" + "\n" ) ;
					
					// The cords are set to 0 to remove the weapon from the game upon acquisition.
					
					getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
					
					getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;
					
					weapons++ ;
					
					break ;
					
                case "pistol" :
                	
                	setPistol ( getBoard ( ).getWeapons ( ) [ i ] ) ;
					
					System.out.println ( getName ( ) + " acquired the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " pistol." + "\n" + "\n" ) ;
					
					getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
					
					getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;
					
					weapons++ ;
					
					break ;
					
                case "sword" :
                	
                	setSword ( getBoard ( ).getWeapons ( ) [ i ] ) ;
					
					System.out.println ( getName ( ) + " acquired the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " sword." + "\n" + "\n" ) ;
					
					getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
					
					getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;
					
					weapons++ ;
					
					break ;
					
				}		
				
		    }
			
			if ( getX ( ) == getBoard ( ).getWeapons ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getWeapons ( ) [ i ].getY ( ) & getId ( ) != getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) ) {
				
				switch ( getBoard ( ).getWeapons ( ) [ i ].getType ( ) ) {
				
				case "bow" :
					
					System.out.println ( getName ( ) + " touched the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " bow,but it's not his to claim. " + "\n" + "\n" ) ;
					
					break ;
					
                case "pistol" :
                	
					System.out.println ( getName ( ) + " touched the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " pistol,but it's not his to claim. " + "\n" + "\n" ) ;
					
					break ;
					
                case "sword" :
                	
					System.out.println ( getName ( ) + " touched the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " sword,but it's not his to claim. " + "\n" + "\n" ) ;
					
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
					
					   System.out.println ( getName ( ) + " defeated the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " beast." + "\n" + "\n" ) ;
					
					   traps++ ;
					   
					}
					
					else {
					
					setScore ( getScore ( ) + getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) ;
					
					System.out.println ( getName ( ) + " could not defeat the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " beast." + "\n" + "\n" ) ;
					
					System.out.println ( getName ( ) + " lost " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " points." + "\n" + "\n" ) ;
					
					traps++ ;
					
					}
					
					break ;
					
                case "rope" :
                	
                	if ( getSword ( ) != null ) {
                		
                	   setScore ( getScore ( ) ) ;
    					
 					   System.out.println ( getName ( ) + " outplayed the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " trap." + "\n" + "\n" ) ;
 					
 					   traps++ ;
 					   
                	}
                	
                	else {
                	
                	setScore ( getScore ( ) + getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) ;
					
					System.out.println ( getName ( ) + " got outplayed by the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " trap." + "\n" + "\n" ) ;
					
					System.out.println ( getName ( ) + " lost " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " points." + "\n" + "\n" ) ;
					
					traps++ ;
					
					}	
                	
                	break ;
				
				}
		    }
			
		}
		
		for ( int i = 0 ; i < getBoard ( ).getFood ( ).length ; i++ ) {
			
			if ( getX ( ) == getBoard ( ).getFood ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getFood ( ) [ i ].getY ( ) ) {
				
					setScore ( getScore ( ) + getBoard ( ).getFood ( ) [ i ].getPoints ( ) ) ;
					
					System.out.println ( getName ( ) + " acquired the " + "F" + getBoard ( ).getFood ( ) [ i ].getId ( ) + " supply." + "\n" + "\n" ) ;
					
					System.out.println ( getName ( ) + " earned " + getBoard ( ).getFood ( ) [ i ].getPoints ( ) + " points." + "\n" + "\n" ) ;
					
                    getBoard ( ).getFood ( ) [ i ].setX ( 0 ) ;
					
					getBoard ( ).getFood ( ) [ i ].setY ( 0 ) ;
					
					food++ ;
					
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