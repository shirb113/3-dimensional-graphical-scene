package Primitives;

public class Vector {

	private Point3D _head;

	/**
	 * default constructor
	 */
	public Vector() {
		this._head = new Point3D();
	}
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector(double x, double y, double z){
		this._head = new Point3D(x,y,z); 
	}
/**
 * constructor
 * @param _head
 */
	public Vector(Point3D head) {
		super();
		this._head = new Point3D(head);
	}
	/**
	 * constructor
	 * @param p1
	 * @param p2
	 */
	public Vector(Point3D p1, Point3D p2){
		Coordinate x = new Coordinate(p2.get_x().get_coordinate()-p1.get_x().get_coordinate());
		Coordinate y = new Coordinate(p2.get_y().get_coordinate()-p1.get_y().get_coordinate());
		Coordinate z = new Coordinate(p2.get_z().get_coordinate()-p1.get_z().get_coordinate());
		this._head = new Point3D(x, y, z);
		}

	/**
	 * copy constructor
	 * @param vec
	 */
	public Vector(Vector vec) {
		this._head = vec.get_head();
	}
/**
 * get - _head
 * @return
 */
	public Point3D get_head() {
		return new Point3D(_head);
	}
/**
 * set - _head
 * @param _head
 */
	public void set_head(Point3D head) {
		this._head = new Point3D(head);
	}
/**
 * equals
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (_head == null) {
			if (other._head != null)
				return false;
		} else if (!_head.equals(other._head))
			return false;
		return true;
	}
/**
 * toString - print
 */
	@Override
	public String toString() {
		return "Vector [_head=" + _head + "]";
	}
	/**
	 * Function that performs a connection operation between 2 Vectors
	 * @param vector
	 */
	public void add (Vector vector) {
		this._head.add(vector);
	}
	/**
	 * Function that performs a subtraction operation between 2 Vectors
	 * @param vector
	 */
	public void subtract (Vector vector){
		this._head.subtract(vector);
	}
/**
 * Function that calculates vector length
 * @return
 */
	public double length() {
		double x = Math.pow(this._head.get_x().get_coordinate(),2);
		double y = Math.pow(this._head.get_y().get_coordinate(),2);
		double z = Math.pow(this._head.get_z().get_coordinate(),2);
		double len = Math.sqrt(x+y+z);
		return len;
	}
	/**
	 * A function that normalizes a vector
	 */
	public void normalize() {
		double len = length();
		this._head.set_x(new Coordinate(this._head.get_x().get_coordinate()/len));
		this._head.set_y(new Coordinate(this._head.get_y().get_coordinate()/len));
		this._head.set_z(new Coordinate(this._head.get_z().get_coordinate()/len));
		
	}
	/**
	 * Function multiplies Vector in scalar
	 * @param scalingFactor
	 */
	public void scale(double scalingFactor){
		this._head.set_x(new Coordinate((this._head.get_x().get_coordinate())*scalingFactor));
		this._head.set_y(new Coordinate((this._head.get_y().get_coordinate())*scalingFactor));
		this._head.set_z(new Coordinate((this._head.get_z().get_coordinate())*scalingFactor));
		
	}
	/**
	 * Dot product
	 * @param vector
	 * @return
	 */
	public double dotProduct(Vector vector){
		double dp=0;
		dp+=this._head.get_x().get_coordinate()*vector._head.get_x().get_coordinate();
		dp+=this._head.get_y().get_coordinate()*vector._head.get_y().get_coordinate();
		dp+=this._head.get_z().get_coordinate()*vector._head.get_z().get_coordinate();
		return dp;
	}
	/**
	 * Cross product
	 * @param vector
	 * @return
	 */
	public Vector crossProduct (Vector vector){
		Vector ans = new Vector();		
		ans._head.set_x(new Coordinate(this._head.get_y().get_coordinate()*vector._head.get_z().get_coordinate()-this._head.get_z().get_coordinate()*vector._head.get_y().get_coordinate()));
		ans._head.set_y(new Coordinate(this._head.get_z().get_coordinate()*vector._head.get_x().get_coordinate()-this._head.get_x().get_coordinate()*vector._head.get_z().get_coordinate()));
		ans._head.set_z(new Coordinate(this._head.get_x().get_coordinate()*vector._head.get_y().get_coordinate()-this._head.get_y().get_coordinate()*vector._head.get_x().get_coordinate()));
		return ans;
	
		
	}
	
}

