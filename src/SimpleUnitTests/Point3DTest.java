package SimpleUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;

public class Point3DTest {

	@Test
	public void test() {
		Point3D point1 = new Point3D();
		Point3D point2 = new Point3D();
		
		boolean b = point1.equals(point2);
		assertEquals(true,b);
		
		point2.set_x(new Coordinate(3.1));
		point2.set_y(new Coordinate(3.2));
		point2.set_z(new Coordinate(3.3));
	    b = point1.equals(point2);
		assertEquals(false,b);
		
		point1.add(point2);
		String str = point1.toString();
		assertEquals("Point3D [_x=Coordinate [_coordinate=3.1], _y=Coordinate [_coordinate=3.2]_z=Coordinate [_coordinate=3.3]]",str);
		
		point1.add(new Vector());
		str = point1.toString();
		assertEquals("Point3D [_x=Coordinate [_coordinate=3.1], _y=Coordinate [_coordinate=3.2]_z=Coordinate [_coordinate=3.3]]",str);
		
		point1.subtract(new Vector());
		str = point1.toString();
		assertEquals("Point3D [_x=Coordinate [_coordinate=3.1], _y=Coordinate [_coordinate=3.2]_z=Coordinate [_coordinate=3.3]]",str);
		
		point2.subtract(point1);
		str = point2.toString();
		assertEquals("Point3D [_x=Coordinate [_coordinate=0.0], _y=Coordinate [_coordinate=0.0]_z=Coordinate [_coordinate=0.0]]",str);
		
		Point3D point3 = new Point3D(1,2,3);
		Point3D point4 = new Point3D(2,4,7);
		
		double dis = point3.distance(point4);
		assertEquals(4.58257569495584,dis,0);
		
		//Point3D point5 = new Point3D(3,4,5);
		//Point3D point6 = new Point3D(3,4,5);
		//Coordinate c1;
		//c1 = point5.get_x();
		//c1.set_coordinate(10);
		//System.out.println(point5);
	}

}
