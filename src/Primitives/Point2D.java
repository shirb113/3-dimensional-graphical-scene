package Primitives;


public class Point2D {
	
	private Coordinate _x;
	private Coordinate _y;
	
	/**
	 * default constructor
	 */
	public Point2D(){
		this._x= new Coordinate();
		this._y= new Coordinate();
	}
	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public Point2D(Coordinate x, Coordinate y) {
		this._x= new Coordinate(x);
		this._y= new Coordinate(y);
	}
     /**
 * copy constructor
 * @param p
 */
	public Point2D(Point2D point) {
		this._x= new Coordinate(point._x);
		this._y= new Coordinate(point._y);
	}
	/**
	 * get _x 
	 * @return
	 */
	public Coordinate get_x() {
		return new Coordinate(this._x);
	}
/**
 * set _x
 * @param x
 */
	public void set_x(Coordinate x) {
		_x = new Coordinate(x);
	}
/**
 * get  _y
 * @return
 */
	public Coordinate get_y() {
		return new Coordinate(this._y);
	}
/**
 * set _y
 * @param y
 */
	public void set_y(Coordinate y) {
		_y = new Coordinate(y);
	}
/**
 * equals point to point Coordinate
 */
	@Override
	public boolean equals(Object obj) {
	   if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if(this._x.get_coordinate()!=other._x.get_coordinate())
			return false;
		if(this._y.get_coordinate()!=other._y.get_coordinate())
			return false;
		return true;
	}
/**
 * toString - print point
 */
	@Override
	public String toString() {
		return "Point2D [_x=" + _x + ", _y=" + _y + "]";
	}

	
	

}
