// Lazaros Adaloglou.

// Import ArrayList class.

import java.util.ArrayList ;

// Board Class.

public class Board {
	
    // Class Variables.
	
    int M , N , W , T , F ; 	
    int [ ] [ ] weaponAreaLimits = new int [ 4 ] [ 2 ] ;
	int [ ] [ ] trapAreaLimits = new int [ 4 ] [ 2 ] ;
	int [ ] [ ] foodAreaLimits = new int [ 4 ] [ 2 ] ;
	Weapon [ ] weapons = new Weapon [ W ] ;
	Trap [ ] traps = new Trap [ T ] ;
	Food [ ] food = new Food [ F ] ;
	
	// Getters and Setters.
	
	public int getM ( ) {
		
	    return M ;
		
	}

	public void setM ( int M ) {
		
		this.M = M ;
		
	}
	
    public int getN ( ) {
		
		return N ;
		
	}

	public void setN ( int N ) {
		
		this.N = N ;
		
	}

	public int getW ( ) {
		
		return W ;
		
	}

	public void setW ( int W ) {
		
		this.W = W ;
		
	}
	
    public int getT ( ) {
		
		return T ;
		
	}

	public void setT ( int T ) {
		
		this.T = T ;
		
	}
	
	public int getF ( ) {
		
		return F ;
		
	}

	public void setF ( int F ) {
		
		this.F = F ;
		
	}

	public int [ ] [ ] getWeaponAreaLimits ( ) {
		
		return weaponAreaLimits ;
		
	}
 
	public void setWeaponAreaLimits ( int [ ] [ ] weaponAreaLimits ) {
		
		this.weaponAreaLimits = weaponAreaLimits ;
		
	}
	
	public int [ ] [ ] getTrapAreaLimits ( ) {
		
		return trapAreaLimits ;
			
	}

	public void setTrapAreaLimits ( int [ ] [ ] trapAreaLimits ) {
			
		this.trapAreaLimits = trapAreaLimits ;
			
	}

	public int [ ] [ ] getFoodAreaLimits ( ) {
		
		return foodAreaLimits ;
		
	}

	public void setFoodAreaLimits ( int [ ] [ ] foodAreaLimits ) {
		
		this.foodAreaLimits = foodAreaLimits ;
		
	}

	public Weapon [ ] getWeapons ( ) {
		
		return weapons ;
		
	}

	public void setWeapons ( Weapon [ ] weapons ) {
		
		this.weapons = weapons ;
		
	}
	
    public Trap [ ] getTraps ( ) {
		
		return traps ;
		
	}

	public void setTraps ( Trap [ ] traps ) {
		
		this.traps = traps ;
		
	}

	public Food [ ] getFood ( ) {
		
		return food ;
		
	}

	public void setFood ( Food [ ] food ) {
		
		this.food = food ;
		
	}
	
	// Constructors.
	
	public Board ( ) {
		
	    setM ( 0 ) ;		
		setN ( 0 ) ;
		setW ( 0 ) ;
		setT ( 0 ) ;
		setF ( 0 ) ;
		setWeaponAreaLimits ( null ) ;
		setTrapAreaLimits ( null ) ;
		setFoodAreaLimits ( null ) ;
		
	}
	
	public Board ( int M , int N , int W , int T , int F , int [ ] [ ] weaponAreaLimits , int [ ] [ ] trapAreaLimits , int [ ] [ ] foodAreaLimits ) {
		
		setM ( M ) ;
		setN ( N ) ;
		setW ( W ) ;
		setT ( T ) ;
		setF ( F ) ;
		setWeaponAreaLimits ( weaponAreaLimits ) ;
		setTrapAreaLimits ( trapAreaLimits ) ;
		setFoodAreaLimits ( foodAreaLimits ) ;
		
	}
	
	// Function perimeterBoxes.
	
    int [ ] [ ] perimeterBoxes ( int sideLength ) {
    	
    	int perimeter = sideLength * 4 - 4 ;
	    int [ ] [ ] temp = new int [ perimeter ] [ 2 ] ;                           
	    int k = 0 ;
		
		// While loop to fill the above array with the perimeter boxes.
		
        // Fills from ( - sideLength / 2 , - sideLength / 2 ) to ( sideLength / 2 - 1 , - sideLength / 2 ). 
			
	    for ( int i = 0 ; i < sideLength ; i++ ) {
					
		    if ( i - sideLength / 2  == 0 ) {
							
		        i++ ;
							
		    }   
				      
			if ( i < sideLength ) {
				    	  
			    temp [ k ] [ 0 ] = i - sideLength / 2 ;
			    temp [ k ] [ 1 ] = - sideLength / 2 ;
				k++ ;
				    	  
		    }
						
	    } 
					
		// From ( sideLength / 2 , - sideLength / 2 ) to ( sideLength / 2 , sideLength / 2 - 1 ).
			
		for ( int i = 0 ; i < sideLength ; i++ ) {
						
		    if ( i - sideLength / 2  == 0 ) {
							
		        i++ ;
							
		    }
		      
		    if ( i < sideLength ) {
						
		    	temp [ k ] [ 0 ] = sideLength / 2 ;
		    	temp [ k ] [ 1 ] = i - sideLength / 2 ;
		    	k++ ;
		         
		    }
		    
		} 
				
		// From ( sideLength / 2 , sideLength / 2 ) to ( - sideLength / 2 + 1 , sideLength / 2 ).
			
		for ( int i = 0 ; i < sideLength ; i++ ) {
						
		    if ( sideLength / 2 - i  == 0 ) {
							
	            i++ ;
							
		    }
		      
		    if ( i < sideLength ) {
						
		        temp [ k ] [ 0 ] = sideLength / 2 - i ;
		    	temp [ k ] [ 1 ] = sideLength / 2 ;
		        k++ ;
		        
		    }
		    
		} 
				
		// From ( - sideLength / 2 , sideLength / 2 ) to ( - sideLength / 2 , - sideLength / 2 + 1 ).
			
		for ( int i = 0 ; i < sideLength ; i++ ) {
						
		    if ( sideLength / 2 - i  == 0 ) {
							
		        i++ ;
							
		    }
		      
		    if ( i < sideLength ) {
						
		    	temp [ k ] [ 0 ] = - sideLength / 2 ;
		    	temp [ k ] [ 1 ] = sideLength / 2 - i ;
		        k++ ;
		        
		    }
		    
	    }
		
		return temp ;
	    
	}
	
	// Function createRandomWeapon.
	
	void createRandomWeapon ( ) {
		
	    // Create a weapon array.
		
		Weapon [ ] weaponlist = new Weapon [ getW ( ) ] ;
		
		// Create a temporary string variable.
		
		String [ ] strtemp = { "pistol" , "bow" , "sword" } ; 
		
		// Create two dynamic lists for the coordinates of available squares to randomly place a weapon.
		
		ArrayList < Integer > AvailableSquaresX = new ArrayList < Integer > ( ) ;
		ArrayList < Integer > AvailableSquaresY = new ArrayList < Integer > ( ) ;
		
	    // sideLength = The length of the weapon area perimeter's side.For example if weaponarealimits = { k , k } , { - k , - k } , ... , then sideLength = 2*|k|.
		
		int sideLength = 2 * Math.abs ( getWeaponAreaLimits ( ) [ 0 ] [ 0 ] ) ;
		int perimeter ;
		int temp [ ] [ ] ;
		
		// While loop to find all the boxes.
		    
		while ( sideLength >= 2 ) {
			
			perimeter = sideLength * 4 - 4 ;
			temp = perimeterBoxes ( sideLength ) ;
			
		    for ( int i = 0 ; i < perimeter ; i++ ) {
				
			    AvailableSquaresX.add ( temp [ i ] [ 0 ] ) ;
			    AvailableSquaresY.add ( temp [ i ] [ 1 ] ) ;
				
			}
		    
		    sideLength = sideLength - 2 ;
		    
        }
				
		// For loop to randomize weapon coordinates.
		
		for ( int i = 0 ; i < getW ( ) ; i = i + 1 ) {
		   
		    // rand1 = random number from 0 to the last index of the dynamic arrays.
			
		    int rand1 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
		   
		    // Create an object and place random cords based on rand1.
			
		    Weapon temp1 = new Weapon ( i + 1 , AvailableSquaresX.get ( rand1 ) , AvailableSquaresY.get ( rand1 ) , ( i % 2 ) + 1 , strtemp [ i % 3 ] ) ;
		   
		    // Put that object in the weapons list.
			
	        weaponlist [ i ] = temp1 ;
	        
	        // Delete the cords used to avoid using them again.
			
		    AvailableSquaresX.remove ( rand1 ) ;
		    AvailableSquaresY.remove ( rand1 ) ;
		    
		    // After the for loop concludes,the weaponlist array is transferred to the weapons variable,so we have the amount of weapons we asked, with random cords.
		    
		}
		
	    setWeapons ( weaponlist ) ;
		
    }    
    
	// Function createRandomTrap.
	
	void createRandomTrap ( ) {
		
	    // This function does the same thing as createRandomWeapon,except it doesn't use the while loop because the traps are in a perimeter and not in an area.
		
        // Create a trap array.
		
	    Trap [ ] traplist = new Trap [ getT ( ) ] ;
				
	    // Create two dynamic lists.
		
	    ArrayList < Integer > AvailableSquaresX = new ArrayList < Integer > ( ) ;
	    ArrayList < Integer > AvailableSquaresY = new ArrayList < Integer > ( ) ;
				
	    // sideLength = The length of the trap area perimeter's side.For example if traparealimits = { k , k } , { - k , - k } , ... , then sideLength = 2*|k|.
		
		int sideLength = 2 * Math.abs ( getTrapAreaLimits ( ) [ 0 ] [ 0 ] ) ;
		int perimeter = sideLength * 4 - 4 ;
		int temp [ ] [ ] ;
		
		// Find all the boxes.
			
		temp = perimeterBoxes ( sideLength ) ;
			
		for ( int i = 0 ; i < perimeter ; i++ ) {
				
			AvailableSquaresX.add ( temp [ i ] [ 0 ] ) ;
			AvailableSquaresY.add ( temp [ i ] [ 1 ] ) ;
				
		}
	    
	    // For loop to randomize Trap coordinates.
		
	    for ( int i = 0 ; i < getT ( ) ; i = i + 1 ) {
	    	
			String [ ] strtemp = { "animal" , "rope" } ;
	        int rand1 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
		    int points = - ( int ) ( ( Math.random ( ) * 9 ) + 1 ) ;
		    
	        Trap temp1 = new Trap ( i + 1 , AvailableSquaresX.get ( rand1 ) , AvailableSquaresY.get ( rand1 ) , points , strtemp [ i % 2 ] ) ;
	        traplist [ i ] = temp1 ;
		
	        AvailableSquaresX.remove ( rand1 ) ;
	        AvailableSquaresY.remove ( rand1 ) ;
	      
	    }
		
	    setTraps ( traplist ) ;
		
    }
	
    // Function createRandomFood.
	
	void createRandomFood ( ) {
		
	    // Same for this function, as the above.
		
        // Create a food array.
		
	    Food [ ] foodlist = new Food [ getF ( ) ] ;
	
	    // Create two dynamic lists.
	   
	    ArrayList < Integer > AvailableSquaresX = new ArrayList < Integer > ( ) ;
	    ArrayList < Integer > AvailableSquaresY = new ArrayList < Integer > ( ) ;
				
	    // sideLength = The length of the trap area perimeter's side.For example if foodarealimits = { k , k } , { - k , - k } , ... , then sideLength = 2*|k|.
		
		int sideLength = 2 * Math.abs ( getFoodAreaLimits ( ) [ 0 ] [ 0 ] ) ;
		int perimeter = sideLength * 4 - 4 ;
		int temp [ ] [ ] ;
		
		// Find all the boxes.
			
		temp = perimeterBoxes ( sideLength ) ;
			
		for ( int i = 0 ; i < perimeter ; i++ ) {
				
			AvailableSquaresX.add ( temp [ i ] [ 0 ] ) ;
			AvailableSquaresY.add ( temp [ i ] [ 1 ] ) ;
				
		}
		
	    // For loop to randomize Food coordinates.
	   
	    for ( int i = 0 ; i < getF ( ) ; i = i + 1 ) {
			
	        int rand1 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
	        int points = ( int ) ( ( Math.random ( ) * 9 ) + 1 ) ;
		
		    Food temp1 = new Food ( i + 1 , AvailableSquaresX.get ( rand1 ) , AvailableSquaresY.get ( rand1 ) , points ) ;		
		    foodlist [ i ] = temp1 ;
		
	        AvailableSquaresX.remove ( rand1 ) ;
	        AvailableSquaresY.remove ( rand1 ) ;
            	   	   
	    }
		
	    setFood ( foodlist ) ;
    
    }
	
	// Function createBoard. 
	
	void createBoard ( ) {
		
	    // Uses the create() functions to "shuffle" the object coordinates.
		
        createRandomWeapon ( ) ;
		
	    createRandomTrap ( ) ;
		
	    createRandomFood ( ) ;
		
   	}
	
   	// Function resizeBoard.
	
   	void resizeBoard ( Player p1 , Player p2 ) {
		
	    // "Perimetrically" filling the outside border of the map with the use of perimeterBoxes.
	   
	    int [ ] [ ] temp ;
	    temp = perimeterBoxes ( getM ( ) ) ;
		
	    // Implementing a counter that increments when players are found in the outside "ring" of the "map". (With two players there: Maximum value = 2 ) 
		
	    int counter = 0 ;
		
	    for ( int i = 0 ; i < temp.length ; i++ ) {
			
	        if ( p1.getX ( ) == temp [ i ] [ 0 ] & p1.getY ( ) == temp [ i ] [ 1 ] ) {
				
		        counter++ ;
				
		    }
			
	        if ( p2.getX ( ) == temp [ i ] [ 0 ] & p2.getY ( ) == temp [ i ] [ 1 ] ) {
	   		
	            counter++ ;
	   		
	        }
	   	    
	    }   
		
	    // If none of the players is found in the perimeter,then the counter will be zero ( 0 ), and the outside "ring" is removed. 
	   
	    if ( counter == 0 ) {
			
	        setM ( getM ( ) - 2 ) ;
		    setN ( getN ( ) - 2 ) ;
		    System.out.println ( "The map has shrinked. May the odds be in your favor.." + "\n" + "\n" ) ;
			
	    }
        
   	}   
	
   	// Function getStringRepresentation.
		
	String [ ] [ ] getStringRepresentation ( ) {
		
	    // This is the variable to be filled with the string elements and returned by the function.
		
	    String [ ] [ ] map = new String [ getM ( ) ] [ getN ( ) ]  ;
		
	    // These variables are used to "skip" the zero coordinates (center) of the game board.
	   
	    int unit1 ;
	    int unit2 ;
	   
	    // Double for loop to check what object is on each square of the 2-D board and set the correct string element.
		
	    for ( int i = 0 ; i < getM ( ) ; i++ ) {
			
	        for ( int j = 0 ; j < getN ( ) ; j++ ) {
	    	  
	    	    //These "ifs" determine whether to use the unit variables to skip the zero coordinates at the center of the board.
				
		        if ( j >=  getM ( ) / 2 ) {
					
			        unit1 = 1 ;
					
		        }
				
			    else {
				 
			        unit1 = 0 ;
			    
			    }
				
                if ( i >=  getN ( ) / 2 ) {
					
			        unit2 = 1 ;
					
			    }
				
			    else {
				
		            unit2 = 0 ;
				 
			    }
             
                // For each weapon on the list check its cords.
				
			    for ( int k = 0 ; k < getWeapons ( ).length ; k++ ) {
				 
				    // If they correspond to the cords currently checked by the for loop, the i , j element of the map variable is assigned the corresponding string value. (Here it is W+playerId+id).
					
			        if ( getWeapons ( ) [ k ].getX ( )  == j - getM ( ) / 2 + unit1 & getWeapons ( ) [ k ].getY ( )  == i - getM ( ) / 2 + unit2 ) {
						
				        map [ i ] [ j ] = "|W" + getWeapons ( ) [ k ].getPlayerId ( ) + getWeapons ( ) [ k ].getId ( ) + "|" ;
						
				    }
					
			    }   
			 
			    // Same for the traps list.
					
			    for ( int k = 0 ; k < getTraps ( ).length ; k++ ) {
					
		            if ( getTraps ( ) [ k ].getX ( )  == j - getM ( ) / 2 + unit1 & getTraps ( ) [ k ].getY ( )  == i - getM ( ) / 2 + unit2 ) {
						
				        map [ i ] [ j ] = "|T" + getTraps ( ) [ k ].getId ( ) + "_|" ;
				   	
			        }
				    
			    }   
			 
			    // Same for the food list.
					
			    for ( int k = 0 ; k < getFood ( ).length ; k++ ) {
			    	
			        if ( getFood ( ) [ k ].getX ( )  == j - getM ( ) / 2 + unit1 & getFood ( ) [ k ].getY ( )  == i - getM ( ) / 2 + unit2 ) {
						
				        if ( getFood ( ) [ k ].getId ( ) >= 10 ) {
							
				            map [ i ] [ j ] = "|F" + getFood ( ) [ k ].getId ( ) + "|" ;
							
				        }
						
				        else {
						
				            map [ i ] [ j ] = "|F" + getFood ( ) [ k ].getId ( ) + "_|" ;
						
				        }
						
				    }      
					 
			    }   
			 
			    // If no objects are on the panel, then set it to "___".
			    
			    if ( map [ i ] [ j ] == null ) {
			    	
			        map [ i ] [ j ] = "|___|" ;
					
		        } 
				
	        }   
			
	    }      
		
	    return map ;
		
	}   
	
}  
