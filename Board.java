//Lazaros Adaloglou

// Import ArrayList class.

import java.util.ArrayList ;

// Board Class.

public class Board {
	
    // Class Variables.
	
    int M , N , W , T , F ; 
	
    int [ ] [ ] weaponAreaLimits = new int [ 4 ] [ 2 ] ;
	
	int [ ] [ ] trapAreaLimits = new int [ 4 ] [ 2 ] ;
	
	int [ ] [ ] foodAreaLimits = new int [ 4 ] [ 2 ] ;
	
	Weapon [ ] weapons = new Weapon [ getW ( ) ] ;
	
	Trap [ ] traps = new Trap [ getT ( ) ] ;
	
	Food [ ] food = new Food [ getF ( ) ] ;
	
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
	
	// Function createRandomWeapon.
	
	void createRandomWeapon ( ) {
		
		// Create a weapon array.
		
		Weapon [ ] weaponlist = new Weapon [ getW ( ) ] ;
		
		// Create a temporary string variable.
		
		String strtemp = "strtemp" ; 
		
		// Create two dynamic lists for the coordinates of available squares to randomly place a weapon.
		
		ArrayList < Integer > AvailableSquaresX = new ArrayList < Integer > ( ) ;
		
		ArrayList < Integer > AvailableSquaresY = new ArrayList < Integer > ( ) ;
		
	    // boundary = The length of the weapon limits perimeter's side.For example if weaponarealimits = { -k , -k } e.t.c. then boundary = 2*k.
		
		int boundary = 2 * Math.abs ( getWeaponAreaLimits ( ) [ 0 ] [ 0 ] ) ;
		
		// While loop to fill the above lists with the coordinates inside the weapon area limits.
		
		while ( boundary >= 2 ) {
		
		   // Fills from ( - boundary / 2 , - boundary / 2 ) to ( boundary / 2 - 1 , - boundary / 2 ). 
			
		   for ( int i = 0 ; i < boundary ; i++ ) {
					
		      if ( i - boundary / 2  == 0 ) {
							
				  i++ ;
							
			  }
				      
			  if ( i < boundary ) {
				    	  
				   AvailableSquaresX.add ( i - boundary / 2 ) ;
							
				   AvailableSquaresY.add ( - boundary / 2 ) ;
				    	  
			  }
						
			} 
					
		   // From ( boundary / 2 , - boundary / 2 ) to ( boundary / 2 , boundary / 2 - 1 ).
			
		   for ( int i = 0 ; i < boundary ; i++ ) {
						
		      if ( i - boundary / 2  == 0 ) {
							
		         i++ ;
							
		      }
		      
		      if ( i < boundary ) {
						
		         AvailableSquaresX.add ( boundary / 2 ) ;
				
		         AvailableSquaresY.add ( i - boundary / 2 ) ;
		         
		      }
		   } 
				
		   // From ( boundary / 2 , boundary / 2 ) to ( - boundary / 2 + 1 , boundary / 2 ).
			
		   for ( int i = 0 ; i < boundary ; i++ ) {
						
		      if ( boundary / 2 - i  == 0 ) {
							
	             i++ ;
							
		      }
		      
		      if ( i < boundary ) {
						
		         AvailableSquaresX.add ( boundary / 2 - i ) ;
				
		         AvailableSquaresY.add ( boundary / 2 ) ;
		         
		      }	
		   } 
				
		   // From ( - boundary / 2 , boundary / 2 ) to ( - boundary / 2 , - boundary / 2 + 1 ).
			
		   for ( int i = 0 ; i < boundary ; i++ ) {
						
		      if ( boundary / 2 - i  == 0 ) {
							
		         i++ ;
							
		      }
		      
		      if ( i < boundary ) {
						
		         AvailableSquaresX.add ( - boundary / 2 ) ;
				
		         AvailableSquaresY.add ( boundary / 2 - i ) ;
		         
		      }	
		   }
		   
		   boundary = boundary - 2 ;
		   
        }
				
		// For loop to randomize weapon coordinates.
		
		for ( int i = 0 ; i < getW ( ) ; i = i + 2 ) {
			
		   // Switch statement to determine the type of weapon to put as argument in the objects inside the weapon array.
			
		   switch ( i % 6 ) {
		 	
		       case 0 :
		 		
		 	      strtemp = "pistol" ;
		  	
		  	      break ;
		  	
		  	   case 2 :
		  	
		  	      strtemp = "bow" ;
		  	
		  	      break ;
		  	
		  	   case 4 :
		  	
		  	      strtemp = "sword" ;
		  		
		  	      break ;
		  
		   }
		   
		   // rand1 = random number from 0 to the last index of the dynamic arrays.
			
		   int rand1 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
		   
		   // Create an object and place random cords based on rand1.
			
		   Weapon temp1 = new Weapon ( i + 1 , AvailableSquaresX.get ( rand1 ) , AvailableSquaresY.get ( rand1 ) , 1 , strtemp ) ;
		   
		   // Put that object in the weapons list.
			
	       weaponlist [ i ] = temp1 ;
	       
	       // Delete the cords used to avoid using them again.
			
		   AvailableSquaresX.remove ( rand1 ) ;
			
		   AvailableSquaresY.remove ( rand1 ) ;
			
		   // if ( i + 2 <= getW ( ) ) {.   <--- this is an implementation for odd number of weapons. *
				
		   int rand2 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
		   
		   // Repeat the same process for the same type weapon for the second player .
				
		   Weapon temp2 = new Weapon ( i + 2 , AvailableSquaresX.get ( rand2 ) , AvailableSquaresY.get ( rand2 ) , 2 , strtemp ) ;
			
		   weaponlist [ i + 1 ] = temp2 ;
			
		   AvailableSquaresX.remove ( rand2 ) ;
			
		   AvailableSquaresY.remove ( rand2 ) ;
			
		   // }.  <---- *this too.
		
		}
		
		// After the for loop concludes,the weaponlist array is transferred to the weapons variable,so we have the amount of weapons we asked, with random cords.
		
		setWeapons ( weaponlist ) ;
		
	}

	// Function createRandomTrap.
	
	void createRandomTrap ( ) {
		
	   // This function does the same thing as createRandomWeapon,except it doesn't use the while loop because the traps are in a perimeter and not an area.
		
       // Create a trap array.
		
	   Trap [ ] traplist = new Trap [ getT ( ) ] ;
				
	   // Create two dynamic lists.
		
	   ArrayList < Integer > AvailableSquaresX = new ArrayList < Integer > ( ) ;
		
	   ArrayList < Integer > AvailableSquaresY = new ArrayList < Integer > ( ) ;
				
	   // The length of the trap limits perimeter's side.
		
	   int boundary = 2 * Math.abs ( getTrapAreaLimits ( ) [ 0 ] [ 0 ] ) ;
		
	   // From ( - boundary / 2 , - boundary / 2 ) to ( boundary / 2 - 1 , - boundary / 2 ).
		
	   for ( int i = 0 ; i < boundary ; i++ ) {
			
	      if ( i - boundary / 2  == 0 ) {
				
		     i++ ;
				
	      }
			
		  AvailableSquaresX.add ( i - boundary / 2 ) ;
			
		  AvailableSquaresY.add ( - boundary / 2 ) ;
			
	   } 
		
	   // From ( boundary / 2 , - boundary / 2 ) to ( boundary / 2 , boundary / 2 - 1 ).
		
	   for ( int i = 0 ; i < boundary ; i++ ) {
					
	      if ( i - boundary / 2  == 0 ) {
						
	         i++ ;
						
	      }
					
	      AvailableSquaresX.add ( boundary / 2 ) ;
			
	      AvailableSquaresY.add ( i - boundary / 2 ) ;
			
	   } 
			
	   // From ( boundary / 2 , boundary / 2 ) to ( - boundary / 2 + 1 , boundary / 2 ).
		
	   for ( int i = 0 ; i < boundary ; i++ ) {
					
	      if ( boundary / 2 - i  == 0 ) {
						
             i++ ;
						
	      }
					
	      AvailableSquaresX.add ( boundary / 2 - i ) ;
			
	      AvailableSquaresY.add ( boundary / 2 ) ;
					
	   } 
			
	   // From ( - boundary / 2 , boundary / 2 ) to ( - boundary / 2 , - boundary / 2 + 1 ).
		
	   for ( int i = 0 ; i < boundary ; i++ ) {
					
	      if ( boundary / 2 - i  == 0 ) {
						
	         i++ ;
						
	      }
					
	      AvailableSquaresX.add ( - boundary / 2 ) ;
			
	      AvailableSquaresY.add ( boundary / 2 - i ) ;
					
	   }
		
	   // For loop to randomize Trap coordinates.
		
	   for ( int i = 0 ; i < getT ( ) ; i = i + 2 ) {
			
	   int rand1 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
		
	   Trap temp1 = new Trap ( i + 1 , AvailableSquaresX.get ( rand1 ) , AvailableSquaresY.get ( rand1 ) , - ( int ) ( ( Math.random ( ) * 9 ) + 1 ) , "animal" ) ;
		
	   traplist [ i ] = temp1 ;
		
	   AvailableSquaresX.remove ( rand1 ) ;
		   
	   AvailableSquaresY.remove ( rand1 ) ;
		
	   // if ( i + 2 <= getT ( ) ) {.   <===== Implementation for odd number of traps.**
			
	   int rand2 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
			
	   Trap temp2 = new Trap ( i + 2 , AvailableSquaresX.get ( rand2 ) , AvailableSquaresY.get ( rand2 ) , - ( int ) ( ( Math.random ( ) * 9 ) + 1 ) , "rope" ) ;
		
	   traplist [ i + 1 ] = temp2 ;
		
	   AvailableSquaresX.remove ( rand2 ) ;
		      
	   AvailableSquaresY.remove ( rand2 ) ;
	   
	   // }. <===== **This too.
	      
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
				
	   // The length of the Food limits perimeter's side.
	   
	   int boundary = 2 * Math.abs ( getFoodAreaLimits ( ) [ 0 ] [ 0 ] ) ;
		
	   // From ( - boundary / 2 , - boundary / 2 ) to ( boundary / 2 - 1 , - boundary / 2 ).
	   
	   for ( int i = 0 ; i < boundary ; i++ ) {
			
          if ( i - boundary / 2  == 0 ) {
				
		     i++ ;
				
		  }
			
		  AvailableSquaresX.add ( i - boundary / 2 ) ;
			
		  AvailableSquaresY.add ( - boundary / 2 ) ;
			
	   } 
		
	   // From ( boundary / 2 , - boundary / 2 ) to ( boundary / 2 , boundary / 2 - 1 ).		
	   
	   for ( int i = 0 ; i < boundary ; i++ ) {
					
	      if ( i - boundary / 2  == 0 ) {
						
		     i++ ;
						
		  }
					
		  AvailableSquaresX.add ( boundary / 2 ) ;
			
		  AvailableSquaresY.add ( i - boundary / 2 ) ;
			
	   } 
			
	   // From ( boundary / 2 , boundary / 2 ) to ( - boundary / 2 + 1 , boundary / 2 ).
	   
	   for ( int i = 0 ; i < boundary ; i++ ) {
					
	      if ( boundary / 2 - i  == 0 ) {
						
		     i++ ;
						
		  }
					
		  AvailableSquaresX.add ( boundary / 2 - i ) ;
			
		  AvailableSquaresY.add ( boundary / 2 ) ;
					
	   } 
			
	   // From ( - boundary / 2 , boundary / 2 ) to ( - boundary / 2 , - boundary / 2 + 1 ).
	   
	   for ( int i = 0 ; i < boundary ; i++ ) {
					
	      if ( boundary / 2 - i  == 0 ) {
						
		     i++ ;
						
		  }
					
		  AvailableSquaresX.add ( - boundary / 2 ) ;
			
		  AvailableSquaresY.add ( boundary / 2 - i ) ;
					
	   }
		
	   // For loop to randomize Food coordinates.
	   
	   for ( int i = 0 ; i < getF ( ) ; i = i + 2 ) {
			
	      int rand1 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
		
		  Food temp1 = new Food ( i + 1 , AvailableSquaresX.get ( rand1 ) , AvailableSquaresY.get ( rand1 ) , ( int ) ( ( Math.random ( ) * 9 ) + 1 ) ) ;
		
		  foodlist [ i ] = temp1 ;
		
	      AvailableSquaresX.remove ( rand1 ) ;
		   
	      AvailableSquaresY.remove ( rand1 ) ;
		
	      // if ( i + 2 <= getF ( ) ) {.
			
		  int rand2 = ( int ) ( Math.random ( ) * ( AvailableSquaresX.size ( ) - 1 ) ) ;
			
	      Food temp2 = new Food ( i + 2 , AvailableSquaresX.get ( rand2 ) , AvailableSquaresY.get ( rand2 ) , ( int ) ( ( Math.random ( ) * 9 ) + 1 ) ) ;
		
          foodlist [ i + 1 ] = temp2 ;
		
		  AvailableSquaresX.remove ( rand2 ) ;
		      
		  AvailableSquaresY.remove ( rand2 ) ;
		
	      //}.
		   
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
		
	  // "Perimetrically" filling these dynamic arrays with the same process.
	
	   ArrayList < Integer > AreaLimitsX = new ArrayList < Integer > ( ) ;
		
	   ArrayList < Integer > AreaLimitsY = new ArrayList < Integer > ( ) ;
		
	   // From ( - M / 2 , - M / 2 ) to ( M / 2 - 1 , - M / 2 ).
		
	   for ( int i = 0 ; i < getM ( ) ; i++ ) {
			
	      if ( i - getM ( ) / 2  == 0 ) {
				
		     i++ ;
				
		  }
			
		  AreaLimitsX.add ( i - getM ( ) / 2 ) ;
			
		  AreaLimitsY.add ( - getM ( ) / 2 ) ;
			
	   } 
		
	   // From ( M / 2 , - M / 2 ) to ( M / 2 , M / 2 - 1 ).	
	   
	   for ( int i = 0 ; i < getN ( ) ; i++ ) {
					
	      if ( i - getN ( ) / 2  == 0 ) {
						
		     i++ ;
						
		  }
					
		  AreaLimitsX.add ( getN ( ) / 2 ) ;
			
		  AreaLimitsY.add ( i - getN ( ) / 2 ) ;
			
	   } 
			
	   // From ( M / 2 , M / 2 ) to ( - M / 2 + 1 , M / 2 ).
		
	   for ( int i = 0 ; i < getM ( ) ; i++ ) {
					
	      if ( getM ( ) / 2 - i  == 0 ) {
						
	         i++ ;
						
		  }
					
		  AreaLimitsX.add ( getM ( ) / 2 - i ) ;
			
		  AreaLimitsY.add ( getM ( ) / 2 ) ;
					
       } 
			
	   // From ( - N / 2 , N / 2 ) to ( - N / 2 , - N / 2 + 1 ).
		
	   for ( int i = 0 ; i < getN ( ) ; i++ ) {
					
	      if ( getN ( ) / 2 - i  == 0 ) {
						
	         i++ ;
						
		  }
					
		  AreaLimitsX.add ( - getN ( ) / 2 ) ;
			
	      AreaLimitsY.add ( getN ( ) / 2 - i ) ;
					
	   }
	   
	   // Implementing a counter that increments when players are found in the outside "ring" of the "map". (With two players: Maximum value = 2 ) 
		
	   int counter = 0 ;
		
	   for ( int i = 0 ; i < AreaLimitsX.size ( ) ; i++ ) {
			
	      if ( p1.getX ( ) == AreaLimitsX.get ( i ) & p1.getY ( ) == AreaLimitsY.get ( i ) ) {
				
		     counter++ ;
				
		  }
			
	      if ( p2.getX ( ) == AreaLimitsX.get ( i ) & p2.getY ( ) == AreaLimitsY.get ( i ) ) {
	   		
	         counter++ ;
	   		
	      }
	   	
	   }
		
	   // If none of the players is found in the perimeter,then the counter will be zero ( 0 ),and the outside square is removed. 
	   
	   if ( counter == 0 ) {
			
	      setM ( getM ( ) - 2 ) ;
			
		  setN ( getN ( ) - 2 ) ;
			
	   }

	}
	
	// Function getStringRepresentation.
		
	String [ ] [ ] getStringRepresentation ( ) {
		
		
	   // This is the variable to be filled with the string elements and returned by the function.
		
	   String [ ] [ ] map = new String [ getM ( ) ] [ getN ( ) ]  ;
		
	   // These variables are used to "skip" the zero coordinates of the game board.
	   
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
				 
				 // If they correspond to the cords currently checked by the for loop,the i , j element of the map variable is assigned the corresponding string value. (Here it's W+playerId+id).
					
			    if ( getWeapons ( ) [ k ].getX ( )  == j - getM ( ) / 2 + unit1 & getWeapons ( ) [ k ].getY ( )  == i - getM ( ) / 2 + unit2 ) {
						
				   map [ i ] [ j ] = "W" + getWeapons ( ) [ k ].getPlayerId ( ) + getWeapons ( ) [ k ].getId ( ) ;
						
				}
					
			 }
			 
			 // Same for the traps list.
					
			 for ( int k = 0 ; k < getTraps ( ).length ; k++ ) {
					
		        if ( getTraps ( ) [ k ].getX ( )  == j - getM ( ) / 2 + unit1 & getTraps ( ) [ k ].getY ( )  == i - getM ( ) / 2 + unit2 ) {
						
				   map [ i ] [ j ] = "T" + getTraps ( ) [ k ].getId ( ) + "_" ;
				   	
			    }
				    
			 }   
			 
			 // Same for the food list.
					
			 for ( int k = 0 ; k < getFood ( ).length ; k++ ) {
			    	
			    if ( getFood ( ) [ k ].getX ( )  == j - getM ( ) / 2 + unit1 & getFood ( ) [ k ].getY ( )  == i - getM ( ) / 2 + unit2 ) {
						
				   if ( getFood ( ) [ k ].getId ( ) >= 10 ) {
							
				      map [ i ] [ j ] = "F" + getFood ( ) [ k ].getId ( ) ;
							
				   }
						
				   else {
						
				      map [ i ] [ j ] = "F" + getFood ( ) [ k ].getId ( ) + "_" ;
						
				   }
						
				}
					 
			 }
			 
			  // If no objects are on the panel, then set it to "___".
			    
			 if ( map [ i ] [ j ] == null ) {
			    	
			    map [ i ] [ j ] = "___" ;
					
		     } 
				
	      }
			
	   }
		
	   return map ;
		
	}
	
}