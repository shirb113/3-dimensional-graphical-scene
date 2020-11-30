package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Triangle extends Geometry implements FlatGeometry {
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;
     
     /**
      * default constructor
      */
     public Triangle()
     {
    	 super();
    	 _p1=new Point3D();
    	 _p2=new Point3D();
    	 _p3=new Point3D();
     }
     /**
      * constructor
      * @param p1
      * @param p2
      * @param p3
      */
     public Triangle(Point3D p1, Point3D p2, Point3D p3)
     {
    	 super();
    	 _p1=new Point3D(p1);
    	 _p2=new Point3D(p2);
    	 _p3=new Point3D(p3);
     }
     /**
      * constructor
      * @param c
      * @param p1
      * @param p2
      * @param p3
      */
     public Triangle(Color c,Point3D p1, Point3D p2, Point3D p3)
     {
    	 super(c);
    	 _p1=new Point3D(p1);
    	 _p2=new Point3D(p2);
    	 _p3=new Point3D(p3);
     }
     /**
      * constructor
      * @param m
      * @param p1
      * @param p2
      * @param p3
      */
     public Triangle(Material m,Point3D p1, Point3D p2, Point3D p3)
     {
    	 super(m);
    	 _p1=new Point3D(p1);
    	 _p2=new Point3D(p2);
    	 _p3=new Point3D(p3);
     }
     /**
      * constructor
      * @param m
      * @param c
      * @param p1
      * @param p2
      * @param p3
      */
     public Triangle(Material m, Color c, Point3D p1, Point3D p2, Point3D p3)
     {
    	 super(c,m);
    	 _p1=new Point3D(p1);
    	 _p2=new Point3D(p2);
    	 _p3=new Point3D(p3);
     }
     /**
      * copy constructor
      * @param tr
      */
     public Triangle(Triangle tr)
     {
    	 super(tr.getColor(),tr.get_material());
    	 
    	 this._p1=tr._p1;
    	 this._p2=tr._p2;
    	 this._p3=tr._p3;
     }
     
     /**
      * get_p1
      * @return
      */
	public Point3D get_p1() {
		return new Point3D(_p1);
	}
	/**
	 * set_p1
	 * @param p1
	 */
	public void set_p1(Point3D p1) {
		_p1 = new Point3D(p1);
	}
	/**
     * get_p2
     * @return
     */
	public Point3D get_p2() {
		return new Point3D(_p2);
	}
	/**
	 * set_p2
	 * @param p2
	 */
	public void set_p2(Point3D p2) {
		_p2 = new Point3D(p2);
	}
	/**
     * get_p3
     * @return
     */
	public Point3D get_p3() {
		return new Point3D(_p3);
	}
	/**
	 * set_p3
	 * @param p3
	 */
	public void set_p3(Point3D p3) {
		_p3 = new Point3D(p3);
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
		Triangle other = (Triangle) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_p2 == null) {
			if (other._p2 != null)
				return false;
		} else if (!_p2.equals(other._p2))
			return false;
		if (_p3 == null) {
			if (other._p3 != null)
				return false;
		} else if (!_p3.equals(other._p3))
			return false;
		return true;
	}
	/**
	 * toString - print
	 */
	@Override
	public String toString() {
		return "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + "]";
	}
     /**
      * get normal
      * @param point
      * @return
      */
	@Override
	public Vector getNormal(Point3D p) {
		Vector v1 = new Vector(_p1, _p2);
		Vector v2 = new Vector(_p1, _p3);
		Vector v = v2.crossProduct(v1);
		v.normalize();
		v.scale(-1);		
		return v;
		
	}
	   /**
	    * function that find intersections points between the ray and the Triangle
	    */
	@Override
	public  List<Point3D> findIntersections(Ray ray)
	{
		
		//create v1 v2
		Point3D p1 = new Point3D(this._p1);
		p1.subtract(this._p2);
		Vector v1=new Vector(p1);
		Point3D p2 = new Point3D(this._p1);
		p2.subtract(this._p3);
		Vector v2=new Vector(p2);

		//create plane
		Plane plane = new Plane(this._p1,v1.crossProduct(v2));
		//Dynamic allocation
		List<Point3D> array=new ArrayList<Point3D>();
		array = plane.findIntersections(ray);
		//System.out.println(array);
		//if array is empty
		if(array.isEmpty()==true)
			return array;
		
		//create V1 V2 V3
		Point3D T1=new Point3D(this._p1);
		Point3D T2=new Point3D(this._p2);
		Point3D T3=new Point3D(this._p3);
		T1.subtract(ray.get_direction());
		Vector V1 = new Vector(T1);
		T2.subtract(ray.get_direction());
		Vector V2 = new Vector(T2);
		T3.subtract(ray.get_direction());
		Vector V3 = new Vector(T3);


		//create N1 N2 N3
		Vector N1 = new Vector(V1.crossProduct(V2));
		N1.normalize();
		Vector N2 = new Vector(V2.crossProduct(V3));
		N2.normalize();
		Vector N3 = new Vector(V3.crossProduct(V1));
		N3.normalize();

		//create p-p0
		Point3D p=new Point3D(array.get(0));
		p.subtract(ray.get_direction());
		
		
		//positives
		if(N1.dotProduct(new Vector(p))> 0 && N2.dotProduct(new Vector(p))>0 && N3.dotProduct(new Vector(p))>0)
			return array;
				
		//negatives
		if(N1.dotProduct(new Vector(p))< 0 && N2.dotProduct(new Vector(p))<0 && N3.dotProduct(new Vector(p))<0)
			return array;
		
		return new ArrayList<Point3D>();
	}
}
