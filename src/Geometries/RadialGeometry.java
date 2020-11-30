package Geometries;

import java.awt.Color;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;

public abstract class RadialGeometry extends Geometry {

	private double _radius;

	/**
	 * default constructor
	 */
	public RadialGeometry() {
		this._radius = 0.0;
	}
	/**
	 * constructor
	 * @param radius
	 */
	public RadialGeometry(double radius) {
		this._radius = radius;
	}
	/**
	 * constructor
	 * @param material
	 */
	public RadialGeometry(Material material) {
		super(material);
	}
	/**
	 * constructor
	 * @param material
	 * @param radius
	 */
	public RadialGeometry(Material material, double radius) {
		super(material);
		this._radius = radius;
	}
	/**
	 * constructor
	 * @param material
	 * @param radius
	 * @param color
	 */
	public RadialGeometry(Material material, double radius, Color color) {
		super(color,material);
		this._radius = radius;
	}
	/**
	 * constructor
	 * @param material
	 * @param color
	 */
	public RadialGeometry(Material material, Color color) {
		super(color,material);
	}
/**
 * constructor
 * @param c
 * @param radius
 */
	public RadialGeometry(Color c, double radius) {
		super(c);
		this._radius = radius;
	}
	/**
	 * copy constructor
	 * @param r
	 */
	public RadialGeometry(RadialGeometry r) {
		super(r.getColor());
		this._radius = r._radius;
	}
	/**
	 * get_radius
	 * @return
	 */
	public double get_radius() {
		return _radius;
	}
	/**
	 * set_radius
	 * @param radius
	 */
	public void set_radius(double radius) {
		this._radius = radius;
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
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}
	/**
	 * toString - print
	 */
	@Override
	public String toString() {
		return "RadialGeometry [_radius=" + _radius + "]";
	}
	/**
	 * abstract func - get normal
	 */
	public abstract Vector getNormal(Point3D point);
}
