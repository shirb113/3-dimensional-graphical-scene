package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.Vector;
import sun.security.action.GetBooleanAction;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;

public abstract class Geometry {
	private Color _color;
	private Material _material;

	/**
	 * default constructor
	 */
	public Geometry() {
		this._color= Color.WHITE;
		this._material = new Material(0,0,0,0,0);
	}
/**
 * constructor
 * @param color
 */
	public Geometry(Color color, Material material) {
		this._color = color;
		this._material = new Material(material.get_kd(), material.get_ks(),material.get_kr(),material.get_kt(), material.get_nShininess());

	}
	public Geometry(Material material) {
		this._material = new Material(material.get_kd(), material.get_ks(),material.get_kr(),material.get_kt(), material.get_nShininess());

	}
	public Geometry(Color color) {
		this._color = color;
		this._material = new Material(1,1,0,0,19);
	}
	/**
	 * constructor
	 * @param color
	 * @param a
	 * @param b
	 * @param c
	 */
	public Geometry(Color color, double a, double b, double c,double d, double e) {
		this._color = color;
		this._material = new Material(a,b,c,d,e);

	}
/**
 * get _color
 * @return
 */
	public Color getColor() {
		return new Color(_color.getRGB());
	}
/**
 * set _color
 * @param color
 */
	public void setColor(Color color) {
		this._color = color;
	}
	/**
	 * get_material
	 * @return
	 */
	public Material get_material() {
	return new Material(this._material);
}
	/**
	 * set_material
	 * @param _material
	 */
public void set_material(Material _material) {
	this._material = _material;
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
		Geometry other = (Geometry) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		if (_material == null) {
			if (other._material != null)
				return false;
		} else if (!_material.equals(other._material))
			return false;
		return true;
	}
	
	/**
	 * toString
	 */
	@Override
public String toString() {
	return "Geometry [_color=" + _color + ", _material=" + _material + "]";
}
	/**
	 * abstract func - get normal
	 * @param point
	 * @return
	 */
	public abstract Vector getNormal(Point3D point);
	
	/**
	 * abstract func - findIntersections
	 * @param ray
	 * @return
	 */
	public abstract List<Point3D> findIntersections(Ray ray);
	
	/**
	 * getEmmission - getColor
	 * @return
	 */
	public Color getEmmission() {
		return getColor();
	} 
	
}
