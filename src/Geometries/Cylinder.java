package Geometries;

import java.awt.Color;
import java.util.ArrayList;

import com.sun.javafx.geom.Matrix3f;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Cylinder extends RadialGeometry {
	
	private Point3D _axisPoint;
	private Vector _axisDirection;
	
	
	/**
	 * default constructor
	 */
	public Cylinder() {
		super();
		this._axisPoint = new Point3D();
		this._axisDirection = new Vector();
	}
	/**
	 * constructor
	 * @param axisPoint
	 * @param axisDirection
	 */
	public Cylinder(Point3D axisPoint, Vector axisDirection) {
		super();
		this._axisPoint = new Point3D(axisPoint);
		this._axisDirection = new Vector(axisDirection);
	}
	/**
	 * constructor
	 * @param axisPoint
	 * @param axisDirection
	 * @param material
	 */
	public Cylinder(Point3D axisPoint, Vector axisDirection, Material material) {
		super(material);
		this._axisPoint = new Point3D(axisPoint);
		this._axisDirection = new Vector(axisDirection);
	}
	/**
	 * constructor
	 * @param c
	 * @param r
	 * @param axisPoint
	 * @param axisDirection
	 */
	public Cylinder(Color c, double r,Point3D axisPoint, Vector axisDirection) {
		super(c,r);
		this._axisPoint = new Point3D(axisPoint);
		this._axisDirection = new Vector(axisDirection);
	}
	/**
	 * constuctor
	 * @param c
	 * @param m
	 * @param r
	 * @param axisPoint
	 * @param axisDirection
	 */
	public Cylinder(Color c, Material m, double r,Point3D axisPoint, Vector axisDirection) {
		super(m,r,c);
		this._axisPoint = new Point3D(axisPoint);
		this._axisDirection = new Vector(axisDirection);
	}
	/**
	 * copy constructor
	 * @param cylinder
	 */
	public Cylinder(Cylinder cylinder) {
		super();
		this._axisPoint = cylinder._axisPoint;
		this._axisDirection = cylinder._axisDirection;
	}
	/**
	 * get_axisPoint
	 * @return
	 */
	public Point3D get_axisPoint() {
		return new Point3D(_axisPoint);
	}
	/**
	 * set_axisPoint
	 * @param axisPoint
	 */
	public void set_axisPoint(Point3D axisPoint) {
		this._axisPoint = new Point3D(axisPoint);
	}
	/**
	 * get_axisDirection
	 * @return
	 */
	public Vector get_axisDirection() {
		return new Vector(_axisDirection);
	}
	/**
	 * set_axisDirection
	 * @param axisDirection
	 */
	public void set_axisDirection(Vector axisDirection) {
		this._axisDirection = new Vector(axisDirection);
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
		Cylinder other = (Cylinder) obj;
		if (_axisDirection == null) {
			if (other._axisDirection != null)
				return false;
		} else if (!_axisDirection.equals(other._axisDirection))
			return false;
		if (_axisPoint == null) {
			if (other._axisPoint != null)
				return false;
		} else if (!_axisPoint.equals(other._axisPoint))
			return false;
		return true;
	}
	/**
	 * toString - print
	 */
@Override
public String toString() {
	return "Cylinder [_axisPoint=" + _axisPoint + ", _axisDirection=" + _axisDirection + "]";
}
/**
 * get normal
 * @param point
 * @return
 */
@Override
public Vector getNormal(Point3D point){
	return null;
}
/**
 * findIntersections
 */
@Override
public ArrayList<Point3D> findIntersections(Ray ray) {
	return null;
}
	
	
	

}
