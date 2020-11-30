package SimpleUnitTests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Geometries.Plane;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class TriangleTest {

	@Test
	public void test() {
		/*Point3D p1=new Point3D(100,-100,-200);
		Point3D p2=new Point3D(50,50,50);
		Point3D p3=new Point3D(20,20,20);
		
		Triangle t1= new Triangle(p1,p2,p3);
		
		Vector v1= new Vector();
		v1 = t1.getNormal(new Point3D());
		String str = v1.toString();
		assertEquals("Vector [_head=Point3D [_x=Coordinate [_coordinate=-0.2672612419124244], _y=Coordinate [_coordinate=0.8017837257372732]_z=Coordinate [_coordinate=-0.5345224838248488]]]",str);
	
		Vector answer = new Vector(0,0, -1);
		Point3D directionPoint = new Point3D(0, 0, -1);
		Point3D planePoint = new Point3D(0, 100, -200);
		Point3D normalPoint = new Point3D(1, 1, -200);
		
		Vector direction = new Vector(directionPoint);
		
		Plane plane = new Plane(Color.white, planePoint, direction);
		
		Vector vector = plane.getNormal(normalPoint);
		assertEquals(answer, vector);*/
		
		// creating the expected values
		
				List<Point3D> answerList = new ArrayList<Point3D>();		
				Point3D answerPoint = new Point3D(0, 0, -200);		
				answerList.add(answerPoint);
				
				// building the triangle
				
				Point3D p1 = new Point3D(0, 100, -200);
				Point3D p2 = new Point3D(100, -100, -200);
				Point3D p3 = new Point3D(-100, -100, -200);
				
				Triangle t1 = new Triangle(Color.white, p1, p2, p3);
				Triangle t2 = new Triangle(t1);			
				
				// building the ray that will intersect the triangle
				
				Point3D centerPoint = new Point3D(0,0,0);		
				Vector vector = new Vector(0, 0, -5);
				Ray ray = new Ray(centerPoint, vector);

				// testing the findIntersection function
				
				List<Point3D> list = new ArrayList<Point3D>();
				list = t2.findIntersections(ray);
				assertEquals(answerList, list);	
				
	}



}
