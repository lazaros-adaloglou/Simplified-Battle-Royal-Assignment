// Lazaros Adaloglou.

// Import ArrayList Class.

import java.util.ArrayList ;

// Import HashMap Class.

import java.util.HashMap ;

// Import Map Class.

import java.util.Map ;

// Import Math Class.

import java.lang.Math ;

// HeuristicPlayer Class.

public class HeuristicPlayer extends Player {
	
   	// Class Variables.
    
	ArrayList < Integer [ ] > path = new ArrayList < Integer [ ] > ( ) ; 
	static int r ;

	// Getters and Setters.
	
	public ArrayList < Integer [ ] > getPath ( ) {
		
	   	return path ;
		
	}

	public void setPath ( ArrayList < Integer [ ] > path ) {
		
		this.path = path ;
		
	}

	public static int getR ( ) {
		
		return r ;
		
	}

	public static void setR ( int r ) {
		
		HeuristicPlayer.r = r ;
		
	}
	
	// Constructors.
	
	public HeuristicPlayer ( ) {
		
        setId ( 0 ) ;
		setX ( 0 ) ;
		setY ( 0 ) ;
		setScore ( 0 ) ;
		setName ( "null" ) ;
		setBoard ( null ) ;
		setBow ( null ) ;
		setPistol ( null ) ;
		setSword ( null ) ;
		setPath ( null ) ;
		setR ( 0 ) ;
		
	}
	
	public HeuristicPlayer ( Player player1 ) {
		
        setId ( player1.getId ( ) ) ;
		setX ( player1.getX ( ) ) ;
		setY ( player1.getY ( ) ) ;
		setScore ( player1.getScore ( ) ) ;
		setName ( player1.getName ( ) ) ;
		setBoard ( player1.getBoard ( ) ) ;
		setBow ( player1.getBow ( ) ) ;
		setPistol ( player1.getPistol ( ) ) ;
		setSword ( player1.getSword ( ) ) ;
		
	}
	
	public HeuristicPlayer ( int id , int x , int y , int score , String name , Board board , Weapon bow , Weapon pistol , Weapon sword , ArrayList < Integer [ ] > path , int r ) {
		
        setId ( id ) ;
		setX ( x ) ;
		setY ( y ) ;
		setScore ( score ) ;
		setName ( name ) ;
		setBoard ( board ) ;
		setBow ( bow ) ;
		setPistol ( pistol ) ;
		setSword ( sword ) ;
		setPath ( path ) ;
		setR ( r ) ;
	
	}
	
	// isXsignDiff Function.
	
	boolean isXsignDiff ( Player p ) {
		
	   	if ( Math.signum ( p.getX ( ) ) == Math.signum ( getX ( ) ) ) {
			
		   	return false ;
			
		}
		
		else {
			
			return true ;
					
		}
		
	}
	
	// isYsignDiff Function.
	
	boolean isYsignDiff ( Player p ) {
		
		if ( Math.signum ( p.getY ( ) ) == Math.signum ( getY ( ) ) ) {
			
			return false ;
			
		}
		
		else {
			
			return true ;
					
		}
		
	}
	
	// playersDistance Function.
	
   	float playersDistance ( Player p ) {
		
	   	float xdist ;
		float ydist ;
		float distance ;
		
		if ( isXsignDiff ( p ) ) {
			
		   	xdist = Math.abs ( Math.abs ( p.getX ( ) - getX ( ) ) - 1 ) ;
			
		}
		
		else {
			
			xdist = Math.abs ( p.getX ( ) - getX ( ) ) ;
			
		}
		
		if ( isYsignDiff ( p ) ) {
			
			ydist = Math.abs ( Math.abs ( p.getY ( ) - getY ( ) ) - 1 ) ;
			
		}
		
		else {
			
			ydist = Math.abs ( p.getY ( ) - getY ( ) ) ;
			
		}
		
		// distance = ( float ) Math.sqrt ( Math.pow ( xdist , 2 ) + Math.pow ( ydist , 2 ) ) ;
		
		if ( xdist > ydist ) {
		
		    distance = xdist ;
		
		}
		
		else {
			
			distance = ydist ;
			
		}
		
		if ( distance <= getR ( ) ) {
		
		    return distance ;
		
		}
		
		else {
			
			return -1 ;
			
		}
		
	}
	
	// hasPistol Function.
	
	boolean hasPistol ( ) {
		
		if ( getPistol ( ) == null ) {
			
			return false ;
			
		}
		
		else {
			
			return true ;
			
		}
		
	}
	
	// Function diceCodes.
	
	int [ ] [ ] diceCodes ( int x , int y ) {
		
		int [ ] [ ] remap = new int [ 8 ] [ 2 ] ;
		
		remap [ 0 ] = playerPerimeter ( x , y ) [ 1 ] ;
		remap [ 1 ] = playerPerimeter ( x , y ) [ 2 ] ;
		remap [ 2 ] = playerPerimeter ( x , y ) [ 7 ] ;
		remap [ 3 ] = playerPerimeter ( x , y ) [ 6 ] ;
		remap [ 4 ] = playerPerimeter ( x , y ) [ 5 ] ;
		remap [ 5 ] = playerPerimeter ( x , y ) [ 4 ] ;
		remap [ 6 ] = playerPerimeter ( x , y ) [ 3 ] ;
		remap [ 7 ] = playerPerimeter ( x , y ) [ 0 ] ;
		
		return remap ;
				
	}
	
	// Function cantCounterTrap.
	
	boolean cantCounterTrap ( Trap trap ) {
	    
	    if ( getSword ( ) != null & trap.getType ( ) == "rope" ) {
	    	
	    	return false ;
	    	
	    }
	    
	    if ( getBow ( ) != null & trap.getType ( ) == "animal" ) {
	    	
	    	return false ;
	    	
	    }
	    
	    else {
	    	
	    	return true ;
	    	
	    }
		
	}
	
	// evaluate Function.
	
	double evaluate ( int dice , Player p ) {
		
	    double evaluation ;
	    double forceKill = 0 ;
	    double gainWeapons = 0 ;
	    double gainPoints = 0 ;
	    double avoidTraps = 0 ;
	    double allowed = 1 ;
	    double centerFactor = 0 ;
	    int [ ] [ ] diceMoves ; 
	    int [ ] newSquare = new int [ 2 ] ;
	    
	    diceMoves = diceCodes ( getX ( ) , getY ( ) ) ;
	    
	    for ( int j = 1 ; j <= getR ( ) ; j++ ) {
	    	
	    	newSquare = diceMoves [ dice - 1 ] ;
	    	
	        for ( int i = 0 ; i < getBoard ( ).getWeapons ( ).length ; i++ ) {
	    
	            if ( newSquare [ 0 ] == getBoard ( ).getWeapons ( ) [ i ].getX ( ) & newSquare [ 1 ] == getBoard ( ).getWeapons ( ) [ i ].getY ( ) & getId ( ) == getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) ) {
	        	
	        	    gainWeapons = ( gainWeapons + 10 ) / j ;
	        	
	            }
	        
	        }
	    
	        for ( int i = 0 ; i < getBoard ( ).getTraps ( ).length ; i++ ) {
	        	
	        	Trap trapi = getBoard ( ).getTraps ( ) [ i ] ;
		    
	            if ( newSquare [ 0 ] == trapi.getX ( ) & newSquare [ 1 ] == trapi.getY ( ) & cantCounterTrap ( trapi ) ) {
	        	
	        	    avoidTraps = ( avoidTraps + getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) / j ;
	        	
	            }
	        
	        }
	    
	        for ( int i = 0 ; i < getBoard ( ).getFood ( ).length ; i++ ) {
		    
	            if ( newSquare [ 0 ] == getBoard ( ).getFood ( ) [ i ].getX ( ) & newSquare [ 1 ] == getBoard ( ).getFood ( ) [ i ].getY ( ) ) {
	        	
	        	    gainPoints = ( gainPoints + getBoard ( ).getFood ( ) [ i ].getPoints ( ) ) / j ;
	        	
	            }
	        
	        }
	    
	        if ( hasPistol ( ) ) {
	    	
	    	    forceKill = 1 / playersDistance ( p ) ;
	    	
	        }
	    
	        if ( Math.abs ( newSquare [ 0 ] ) > Math.abs ( getBoard ( ).getM ( ) / 2 ) || Math.abs ( newSquare [ 1 ] ) > Math.abs ( getBoard ( ).getN ( ) / 2 ) ) {
	    	
	    	    allowed = 0 ;
	    	
	        }
	        
	        if ( Math.abs ( newSquare [ 0 ] ) < Math.abs ( getX ( ) ) & Math.abs ( newSquare [ 1 ] ) < Math.abs ( getY ( ) ) ) {
	        	
	        	centerFactor = 1 ;
	        	
	        }
	        
	        diceMoves = diceCodes ( newSquare [ 0 ] , newSquare [ 1 ] ) ;
	        
	    }
	    
	    evaluation = ( 7 + gainWeapons * 0.2 + avoidTraps * 0.6 + gainPoints * 0.3 + forceKill + centerFactor) * allowed ;
	    
		return evaluation ;
		    
	}
	
	// Function kill.
	
	static boolean kill ( Player player1 , Player player2 , float d ) {
		
		HeuristicPlayer heurp = new HeuristicPlayer ( player1 ) ;
		
		if ( heurp.getPistol ( ) != null & heurp.playersDistance ( player2 ) < d & heurp.playersDistance ( player2 ) != - 1 ) {
			
		   	return true ;
			
		}
		
		else {
		
		    return false ;
		
		}
		
	}
	
	// Function move.
	
	int [ ] move ( Player p ) {
		
		int [ ] newMove = new int [ 2 ] ;
		int direction = 0 ;
		int pickedWeapon = 0 ;
		int metTrap = 0 ;
		int pickedFood = 0 ;
		int [ ] movement = new int [ 6 ] ; 
		Map < Integer , Double > move = new HashMap < > ( ) ; 
		
	    for ( int i = 1 ; i < 9 ; i++ ) {
	    	
	    	move.put ( i , evaluate ( i , p ) ) ;
	    	
	    }
	    
	    Map.Entry < Integer , Double > maxEntry = null ;
	    	
	    for ( Map.Entry < Integer , Double > entry : move.entrySet ( ) ) {
	    	
	        if ( maxEntry == null || entry.getValue ( ).compareTo ( maxEntry.getValue ( ) ) > 0 ) {
	        	
                maxEntry = entry ;
	            
            }  
	            
        }
	    
	    direction = maxEntry.getKey ( ) ;
	    newMove = diceCodes ( getX ( ) , getY ( ) ) [ direction - 1 ] ;
	    setX ( newMove [ 0 ] ) ;
	    setY ( newMove [ 1 ] ) ;
	    
	    for ( int i = 0 ; i < getBoard ( ).getWeapons ( ).length ; i++ ) {
	    
	        if ( getX ( ) == getBoard ( ).getWeapons ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getWeapons ( ) [ i ].getY ( ) ) {
	        	
	        	pickedWeapon = 1 ;
	        	
	        }
	        
	    }
	    
	    for ( int i = 0 ; i < getBoard ( ).getTraps ( ).length ; i++ ) {
		    
	        if ( getX ( ) == getBoard ( ).getTraps ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getTraps ( ) [ i ].getY ( ) ) {
	        	
	        	metTrap = 1 ;
	        	
	        }
	        
	    }
	    
	    for ( int i = 0 ; i < getBoard ( ).getFood ( ).length ; i++ ) {
		    
	        if ( getX ( ) == getBoard ( ).getFood ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getFood ( ) [ i ].getY ( ) ) {
	        	
	        	pickedFood = 1 ;
	        	
	        }
	        
	    }
	    
	    movement [ 0 ] = newMove [ 0 ] ;
	    movement [ 1 ] = newMove [ 1 ] ;
	    movement [ 2 ] = pickedWeapon ;
	    movement [ 3 ] = metTrap ;
	    movement [ 4 ] = pickedFood ;
	    movement [ 5 ] = direction ;	    

		Integer [ ] resultMove = new Integer [ movement.length ] ;
		
		for ( int i = 0 ; i < movement.length ; i++ ) {
			
			resultMove [ i ] = Integer.valueOf ( movement [ i ] ) ;
			
		} 
		 
		path.add ( resultMove ) ;
		
		return movement ;
		
	}
	
	void statistics ( ) {
		
		String [ ] direction = { "North" , "Northeast" , "East" , "Southeast" , "South" , "Southwest" , "West" , "Northwest" } ;
		Integer [ ] currentMove = getPath ( ) .get ( getPath ( ).size ( ) - 1 ) ;
		System.out.println ( getName ( ) + " moves " + direction [ currentMove [ 5 ] - 1 ] ) ;
		System.out.println ( "\n" ) ;
		
		if ( currentMove [ 2 ] == 1 ) {
			
			for ( int i = 0 ; i < getBoard ( ).getWeapons ( ).length ; i++ ) {
				
			   	if ( getX ( ) == getBoard ( ).getWeapons ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getWeapons ( ) [ i ].getY ( ) & getId ( ) == getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) ) {
					
				   	switch ( getBoard ( ).getWeapons ( ) [ i ].getType ( ) ) {
					
					case "bow" :
						
					   	setBow ( getBoard ( ).getWeapons ( ) [ i ] ) ;
						System.out.println ( getName ( ) + " acquires the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " bow." + "\n" + "\n" ) ;
						getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
						getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;
						
					break ;
						
	                case "pistol" :
	                	
	                	setPistol ( getBoard ( ).getWeapons ( ) [ i ] ) ;
						System.out.println ( getName ( ) + " acquires the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " pistol." + "\n" + "\n" ) ;
						getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
						getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;	
						
					break ;
						
	                case "sword" :
	                	
	                	setSword ( getBoard ( ).getWeapons ( ) [ i ] ) ;	
						System.out.println ( getName ( ) + " acquires the " + "W" + getBoard ( ).getWeapons ( ) [ i ].getPlayerId ( ) + getBoard ( ).getWeapons ( ) [ i ].getId ( ) + " sword." + "\n" + "\n" ) ;
						getBoard ( ).getWeapons ( ) [ i ].setX ( 0 ) ;
						getBoard ( ).getWeapons ( ) [ i ].setY ( 0 ) ;
						
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
			
		}
		
		if ( currentMove [ 3 ] == 1 ) {
			
			for ( int i = 0 ; i < getBoard ( ).getTraps ( ).length ; i++ ) {
				
				if ( getX ( ) == getBoard ( ).getTraps ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getTraps ( ) [ i ].getY ( ) ) {
					
				   	switch ( getBoard ( ).getTraps ( ) [ i ].getType ( ) ) {
					
					case "animal" :
						
					   	if ( getBow ( ) != null ) {
						
						    setScore ( getScore ( ) ) ;
						    System.out.println ( getName ( ) + " defeats the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " beast." + "\n" + "\n" ) ;
						   
						}  
						
						else {
						
						    setScore ( getScore ( ) + getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) ;
						    System.out.println ( getName ( ) + " cannot defeat the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " beast." + "\n" + "\n" ) ;
						
						    if ( ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) == 1 ) {
							
						   	    System.out.println ( getName ( ) + " loses " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " point." + "\n" + "\n" ) ;
							
						    }   
						
						    else {
							
						   	    System.out.println ( getName ( ) + " loses " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " points." + "\n" + "\n" ) ;
							
						    }
						
						}
						
					break ;
						
	                case "rope" :
	                	
	                   	if ( getSword ( ) != null ) {
	                		
	                	    setScore ( getScore ( ) ) ;
	 					    System.out.println ( getName ( ) + " outplays the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " trap." + "\n" + "\n" ) ;
	 					   
	                	}   
	                	
	                	else {
	                	
	                	    setScore ( getScore ( ) + getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) ;
						    System.out.println ( getName ( ) + " gets outplayed by the " + "T" + getBoard ( ).getTraps ( ) [ i ].getId ( ) + " trap." + "\n" + "\n" ) ;
						
						    if ( ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) == 1 ) {
						
						        System.out.println ( getName ( ) + " loses " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " point." + "\n" + "\n" ) ;
						
						    }	
						
						    else {
							
						   	    System.out.println ( getName ( ) + " loses " + ( - getBoard ( ).getTraps ( ) [ i ].getPoints ( ) ) + " points." + "\n" + "\n" ) ;
							
						    }   
						
	                	}   
	                	
	                break ;
					
			        }
				
			    }
				
			}
			
		}
		
		if ( currentMove [ 4 ] == 1 ) {
			
			for ( int i = 0 ; i < getBoard ( ).getFood ( ).length ; i++ ) {
				
			   	if ( getX ( ) == getBoard ( ).getFood ( ) [ i ].getX ( ) & getY ( ) == getBoard ( ).getFood ( ) [ i ].getY ( ) ) {
					
				   	setScore ( getScore ( ) + getBoard ( ).getFood ( ) [ i ].getPoints ( ) ) ;	
					System.out.println ( getName ( ) + " acquires the " + "F" + getBoard ( ).getFood ( ) [ i ].getId ( ) + " supply." + "\n" + "\n" ) ;
						
					if ( getBoard ( ).getFood ( ) [ i ].getPoints ( ) == 1 ) {
						
					    System.out.println ( getName ( ) + " earns " + getBoard ( ).getFood ( ) [ i ].getPoints ( ) + " point." + "\n" + "\n" ) ;
	                    getBoard ( ).getFood ( ) [ i ].setX ( 0 ) ;
						getBoard ( ).getFood ( ) [ i ].setY ( 0 ) ;
						
					}   
						
					else {
							
					    System.out.println ( getName ( ) + " earns " + getBoard ( ).getFood ( ) [ i ].getPoints ( ) + " points." + "\n" + "\n" ) ;	
		                getBoard ( ).getFood ( ) [ i ].setX ( 0 ) ;	
						getBoard ( ).getFood ( ) [ i ].setY ( 0 ) ;	
							
					}   
						
				}   
				
			}
		
		}
		
	}
	
}