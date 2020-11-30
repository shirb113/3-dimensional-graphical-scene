package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class DirectionalLight extends Light {
	
	private Vector _direction;

	/**
	 * default constructor
	 */
	public DirectionalLight() {
		super();
		this._direction = new Vector(0,0,1);
		}
		/**
		 * constructor
		 * @param direction
		 */
	public DirectionalLight(Vector direction) {
		super();
		this._direction = new Vector(direction);
	}
	/**
	 * constructor
	 * @param color
	 * @param direction
	 */
	public DirectionalLight(Color color, Vector direction) {
		super(color);
		this._direction = new Vector(direction);
	}
	/**
	 * getDirectional
	 * @return
	 */
	public Vector get_direction() {
		return new Vector(_direction);
	}
	/**
	 * setDirectional
	 * @param direction
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	/**
	 * tostring
	 */
@Override
public String toString() {
	return "DirectionalLight [_direction=" + _direction + "]";
}
/**
 * getintensity
 */
	@Override
	public Color getIntensity(Point3D point) {
		return this.getColor();
	}
	/**
     * A vector that emerges from the light source to a point
	 */
	@Override
	public Vector getL(Point3D point) {
		return this.get_direction();
	}

}
