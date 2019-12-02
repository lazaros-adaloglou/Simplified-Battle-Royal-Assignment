// Lazaros Adaloglou.

// Trap Class.

public class Trap {
	
    // Class Variables.
	
	int id ;
	int x ;
	int y ;
	int points ;
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
	
	public int getPoints ( ) {
				
		return points ;
				
	}
			
	public void setPoints ( int points ) {
				
		this.points = points ;
				
	}
	
	public String getType ( ) {
		
		return type ;
			
	}
		
	public void setType ( String type ) {
			
		this.type = type ;
			
	}
	
	// Constructors.
	
	public Trap ( ) {
		
		setId ( 0 ) ;
		setX ( 0 ) ;
		setY ( 0 ) ;
		setPoints ( 0 ) ;
		setType ( "null" ) ;
			
	}
		
	public Trap ( int id , int x , int y , int points , String type ) {
				
		setId ( id ) ;
		setX ( x ) ;
		setY ( y ) ;
		setPoints ( points ) ;
		setType ( type ) ;
				
	}
		
}
