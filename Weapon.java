// Lazaros Adaloglou.

// Weapon Class.

public class Weapon {

    // Class Variables.
	
	int id ;
	int x ;
	int y ;
	int playerId ;
	String type ;
	
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

	public int getPlayerId ( ) { 
		
		return playerId ;
		
	}
	
	public void setPlayerId ( int playerId ) { 
		
		this.playerId = playerId ;
		
	}
	
	public String getType ( ) { 
		
		return type ;
		
	}
	
	public void setType ( String type ) { 
		
		this.type = type ;
		
	}
	
	// Constructors.
	
    public Weapon ( ) {
    	
		setId ( 0 ) ;
		setX ( 0 ) ;
		setY ( 0 ) ; ;
		setPlayerId ( 0 ) ; ;
		setType ( "null" ) ;
		
	}
	
	public Weapon ( int id , int x , int y , int playerId , String type ) {
		
		setId ( id ) ;
		setX ( x ) ;
		setY ( y ) ; ;
		setPlayerId ( playerId ) ; ;
		setType ( type ) ;
		
	}
	
}
