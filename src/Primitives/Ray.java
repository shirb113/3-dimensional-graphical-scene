package Primitives;

public class Ray {

	private Point3D _POO;
	private Vector _direction;
	
	/**
	 * default constructor
	 */
	public Ray() {
		this._POO = new Point3D();
		this._direction = new Vector();
	}
	/**
	 * constructor
	 * @param POO
	 * @param direction
	 */
	public Ray(Point3D POO, Vector direction) {
		this._POO = new Point3D(POO);
		this._direction = new Vector(direction);
		this._direction.normalize();
	}
	/**
	 * copy constructor
	 * @param ray
	 */
	public Ray(Ray ray) {
		this._POO = new Point3D(ray._POO);
		this._direction = new Vector(ray._direction);
	}
	/**
	 * get _POO
	 * @return
	 */
	public Point3D get_POO() {
		return new Point3D(_POO);
	}
	/**
	 * set _POO
	 * @param _POO
	 */
	public void set_POO(Point3D POO) {
		this._POO = new Point3D(POO);
	}
	/**
	 * get _direction
	 * @return
	 */
	public Vector get_direction() {
		return new Vector(_direction);
	}
	/**
	 * set _direction
	 * @param _direction
	 */
	public void set_direction(Vector direction) {
		this._direction = new Vector(direction);
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
		Ray other = (Ray) obj;
		if (_POO == null) {
			if (other._POO != null)
				return false;
		} else if (!_POO.equals(other._POO))
			return false;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	/**
	 * toString - Ray
	 */
@Override
public String toString() {
	return "Ray [_POO=" + _POO + ", _direction=" + _direction + "]";
}
	
	
	
	
}
