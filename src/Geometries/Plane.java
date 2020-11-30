package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Plane extends Geometry implements FlatGeometry {
	
	private Point3D _p1;
	private Vector _vec;
	
	/**
	 * default constructor
	 */
	public Plane() {
		super();
		this._p1 = new Point3D();
		this._vec = new Vector();
	}
/**
 * constructor
 * @param p1
 * @param vec
 */
	public Plane(Point3D p1, Vector vec) {
		super();
		this._p1 = new Point3D(p1);
		this._vec = new Vector(vec);
	}
	/**
	 * constructor
	 * @param c
	 * @param p1
	 * @param vec
	 */
	public Plane(Color c,Point3D p1, Vector vec) {
		super(c);
		this._p1 = new Point3D(p1);
		this._vec = new Vector(vec);
	}
	/**
	 * constucor
	 * @param m
	 * @param p1
	 * @param vec
	 */
	public Plane(Material m,Point3D p1, Vector vec) {
		super(m);
		this._p1 = new Point3D(p1);
		this._vec = new Vector(vec);
	}

	public Plane(Material m,Color c,Point3D p1, Vector vec) {
		super(c,m);
		this._p1 = new Point3D(p1);
		this._vec = new Vector(vec);
	}
	/**
	 * copy constructor
	 * @param p
	 */
	public Plane(Plane p) {
		super(p.getColor(),p.get_material());
		this._p1=p._p1;
		this._vec=p._vec;
	}
	/**
	 * get_p1
	 * @return
	 */
	public Point3D get_p1() {
		return  new Point3D(_p1);
	}
/**
 * set_p1
 * @param p1
 */
	public void set_p1(Point3D p1) {
		this._p1 =  new Point3D(p1);
	}
/**
 * get_vec
 * @return
 */
	public Vector get_Vec() {
		return new Vector(_vec);
	}
/**
 * set_vec
 * @param vec
 */
	public void set_Vec(Vector vec) {
		this._vec = new Vector(vec);
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
		Plane other = (Plane) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_vec == null) {
			if (other._vec != null)
				return false;
		} else if (!_vec.equals(other._vec))
			return false;
		return true;
	}
	/**
	 * toString - print
	 */
	@Override
	public String toString() {
		return "Plane [_p1=" + _p1 + ", vec=" + _vec + "]";
	}

	/**
     * get normal
     * @param point
     * @return
     */
	public Vector getNormal(Point3D point){		
		return this._vec;
	}

	/**
	* Function that find intersections points between the ray and the Plane
	* @param ray
	* @return array
    */
	@Override
	public List<Point3D> findIntersections(Ray ray){
		
		//create -N
		Vector NegetiveN = new Vector(this.get_Vec());
		NegetiveN.scale(-1);
		//create (P0-Q0) = PQ
		Point3D temp = new Point3D(ray.get_POO());
		temp.subtract(this._p1);
		Vector PQ = new Vector(temp);
		//create N*V
		Vector NV = new Vector(this._vec);
		//create t
		double nv = NV.dotProduct(ray.get_direction());
		double t = (NegetiveN.dotProduct(PQ))/nv;
		
		if(t<0)
			return new ArrayList<Point3D>();
	
		//create p
		Point3D p=new Point3D(ray.get_POO());
		Vector temp1 = new Vector(ray.get_direction());
		temp1.scale(t);
		p.add(temp1);
		
		//Dynamic allocation
		ArrayList<Point3D> array=new ArrayList<Point3D>();
		array.add(p);
		return array;

	}
}
