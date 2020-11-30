package Primitives;

public class Coordinate {

	private double _coordinate;

	/**
	 * default constructor
	 */
	public Coordinate() {
		this._coordinate = 0.0;
	}
	/**
	 * constructor
	 * @param coordinate
	 */
	public Coordinate(double coordinate) {
		this._coordinate = coordinate;
	}
	/**
	 * copy constructor
	 * @param obj = Type of Coordinate
	 */
	public Coordinate(Coordinate obj) {
		this._coordinate=obj._coordinate;
	}
	/**
	 * get _coordinate
	 * @return _coordinate
	 */
	public double get_coordinate() {
		return _coordinate;
	}
	/**
	 * set _coordinate
	 * @param coordinate
	 */
	public void set_coordinate(double coordinate) {
		this._coordinate = coordinate;
	}
	/**
	 * equals the values
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(_coordinate) != Double.doubleToLongBits(other._coordinate))
			return false;
		return true;
	}
	/**
	 * toString - print point2D
	 */
	@Override
	public String toString() {
		return "Coordinate [_coordinate=" + _coordinate + "]";
	}
	/**
	 * Function performs connection operation between 2 coordinates
	 * @param other
	 */
	public void add(Coordinate other) {
		_coordinate +=other._coordinate;
	}
	/**
	 * Function performs subtraction between 2 coordinates
	 * @param other
	 */
	public void subtract (Coordinate other){
		_coordinate-=other._coordinate;
	} 

	
	
}
