package Primitives;

public class Point3D extends Point2D {
	private Coordinate _z;

	/**
	 * default constructor
	 */
	public Point3D() {
		super();
		this._z = new Coordinate();
		}
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(Coordinate x, Coordinate y,Coordinate z) {
		super(x, y);
		this._z = new Coordinate(z);
	}
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(double x, double y,double z) {
		this.set_x(new Coordinate(x));
		this.set_y(new Coordinate(y));
		this.set_z(new Coordinate(z));
	}
	/**
	 * copy constructor
	 * @param point
	 */
	public Point3D(Point3D point) {
		this.set_x(point.get_x());
		this.set_y(point.get_y());
		this._z = point._z;
	}
	/**
	 * get _z
	 * @return
	 */
	public Coordinate get_z() {
		return new Coordinate(this._z);
	}
	/**
	 * set_z
	 * @param z
	 */
	public void set_z(Coordinate z) {
		_z = new Coordinate(z);
	}
	/**
	 * equals point to point Coordinate
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (_z == null) {
			if (other._z != null)
				return false;
		} else if (!_z.equals(other._z))
			return false;
		return true;
	}
	/**
	 * toString - print 
	 */
	@Override
	public String toString() {
		return "Point3D [_x=" + this.get_x() + ", _y=" + this.get_y() + "_z=" + _z + "]";
	}
	/**
	 * Function that performs a connection operation between point3D and a vector 
	 * @param vector
	 */
	public void add (Vector vector) {
		this.set_x(new Coordinate((this.get_x().get_coordinate())+(vector.get_head().get_x().get_coordinate())));
		this.set_y(new Coordinate((this.get_y().get_coordinate())+(vector.get_head().get_y().get_coordinate())));
		set_z(new Coordinate(this._z.get_coordinate()+(vector.get_head().get_z().get_coordinate()))); 
	}
	
	/**
	 * function that performs a subtraction operation between point3D and a vector
	 * @param vector
	 */
	public void subtract (Vector vector ){
		this.set_x(new Coordinate((this.get_x().get_coordinate())-(vector.get_head().get_x().get_coordinate())));
		this.set_y(new Coordinate((this.get_y().get_coordinate())-(vector.get_head().get_y().get_coordinate())));
		this._z = new Coordinate(_z.get_coordinate()-(vector.get_head().get_z().get_coordinate())); 
	}
	/**
	 * Function that performs a connection operation between 2 points 3D
	 * @param point
	 */
	public void add (Point3D point) {
		this.set_x(new Coordinate((this.get_x().get_coordinate())+(point.get_x().get_coordinate())));
		this.set_y(new Coordinate((this.get_y().get_coordinate())+(point.get_y().get_coordinate())));
		this._z = new Coordinate(this._z.get_coordinate()+point._z.get_coordinate());
	}
	/**
	 * function that performs a subtraction operation between 2 points
	 * @param point
	 */
	public void subtract (Point3D point) {
		this.set_x(new Coordinate((this.get_x().get_coordinate())-(point.get_x().get_coordinate())));
		this.set_y(new Coordinate((this.get_y().get_coordinate())-(point.get_y().get_coordinate())));
		this._z = new Coordinate(this._z.get_coordinate()-point._z.get_coordinate());
	}
	/**
	 * Function that calculates a distance between 2 points
	 * @param point
	 * @return
	 */
	public double distance (Point3D point){
		double dis = 0;
		dis +=Math.pow(this.get_x().get_coordinate()-point.get_x().get_coordinate(),2);
		dis +=Math.pow(this.get_y().get_coordinate()-point.get_y().get_coordinate(),2);
		dis +=Math.pow(this.get_z().get_coordinate()-point.get_z().get_coordinate(),2);
		dis = Math.sqrt(dis);
		return dis;
	}	
}
