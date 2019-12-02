// Lazaros Adaloglou.

// Food Class.

public class Food {

    // Class Variables
	
	int id ;
	int x ;
	int y ;
	int points ;
	
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
	
	// Constructors.
	
	public Food ( ) {
		
		setId ( 0 ) ;
		setX ( 0 ) ;
		setY ( 0 ) ;
		setPoints ( 0 ) ;
				
	}
	
	public Food ( int id , int x , int y , int points ) {
			
		setId ( id ) ;
		setX ( x ) ;
		setY ( y ) ;
		setPoints ( points ) ;
			
	}
	
}
