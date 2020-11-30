package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Sphere extends RadialGeometry {

	private Point3D _center;

	/**
	 * default constructor
	 */
	public Sphere() {
		super();
		this._center = new Point3D();	
	}
	/**
	 * constructor
	 * @param center
	 */
	public Sphere(Point3D center) {
		super();
		this._center = new Point3D(center);
	}
/**
 * constructor
 * @param center
 * @param radius
 */
	public Sphere(Point3D center, double radius) {
		super(radius);
		this._center = new Point3D(center);
	}
	/**
	 * constructor
	 * @param c
	 * @param center
	 * @param radius
	 */
	public Sphere(Color c, Point3D center, double radius) {
		super(c,radius);
		this._center = new Point3D(center);
	}
	
	public Sphere(Material m, Point3D center, double radius) {
		super(m,radius);
		this._center = new Point3D(center);
	}
	public Sphere(Material m, Color c, Point3D center, double radius) {
		super(m,radius,c);
		this._center = new Point3D(center);
	}
	/**
	 * copy constructor
	 * @param sphere
	 */
	public Sphere(Sphere sphere) {
		super(sphere);
		this._center=sphere._center;
	}
	/**
	 * get_center
	 * @return
	 */
	public Point3D get_center() {
		return new Point3D(_center);
	}
	/**
	 * set_center
	 * @param center
	 */
	public void set_center(Point3D center) {
		this._center =  new Point3D(center);
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
		Sphere other = (Sphere) obj;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		return true;
	}
/**
 * 	toString - print
 */
   @Override
   public String toString() {
	   return "Sphere [_center=" + _center + "]";
   }
   /**
    * get normal
    * @param point
    * @return
    */
   @Override
	public Vector getNormal(Point3D point) {
		Vector vector = new Vector(_center, point);
		vector.normalize();
		return vector;
   }
   /**
    * function that find intersections points between the ray and the sphere
    */
   @Override
	public List<Point3D> findIntersections(Ray ray){
		
		//create v
		ray.get_direction().normalize();
        Vector v=new Vector(ray.get_direction());
        //create L
        Point3D temp = new Point3D(this._center);
        temp.subtract(ray.get_POO());
        Vector L=new Vector(temp);
        //tm,d,th,t1,t2
        double tm = L.dotProduct(v);
		double d = Math.sqrt(Math.pow(L.length(), 2)-Math.pow(tm, 2));
		double th = Math.sqrt(Math.pow(this.get_radius(), 2)-(Math.pow(d, 2)));
		double t1 = tm-th;
		double t2 = tm+th;
		//Dynamic allocation
		ArrayList<Point3D> array=new ArrayList<Point3D>();
		//there are no intersections, returns null 
		if (d>this.get_radius())
		{
			return new ArrayList<Point3D>();
		}
		
		if(t1<0 || t2<0)
			return new ArrayList<Point3D>(); 
		
		//find p1 and add to array
		if(t1>=0)
		{
			Vector pv1 = new Vector(v);
			pv1.scale(t1);
			Point3D p1 = new Point3D(ray.get_POO());
			p1.add(pv1);
			array.add(p1);
		}
		//find p2 and add to array
		if(t2>=0)
		{
			Vector pv2 = new Vector(v);
			pv2.scale(t2);
			Point3D p2 = new Point3D(ray.get_POO());
			p2.add(pv2);
			array.add(p2);

		}
		return array;
		}
}
