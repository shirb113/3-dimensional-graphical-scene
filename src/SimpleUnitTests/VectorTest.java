package SimpleUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;

public class VectorTest {

	@Test
	public void test() {
		Vector vec1= new Vector();
		Vector vec2= new Vector();
		
		boolean b= vec1.equals(vec2);
		assertEquals(true,b);
		
		vec2.set_head(new Point3D(new Coordinate(3.1),new Coordinate(3.1),new Coordinate(3.1)));
		b= vec1.equals(vec2);
		assertEquals(false,b);
		
		vec1.add(vec2);
		b= vec1.equals(vec2);
		assertEquals(true,b);	
		
		vec1.subtract(vec1);
		b= vec1.equals(new Vector());
		assertEquals(true,b);
		
		vec1 = new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
		double len = vec1.length();
		assertEquals(3.7416573867739413,len,0);
		
		vec1.set_head(new Point3D(new Coordinate(5),new Coordinate(0),new Coordinate(0)));
		vec1.normalize();
		len = vec1.length();
		assertEquals(1,len,0);
		
		vec1.scale(3);
		len = vec1.length();
		assertEquals(3,len,0);
		
		Point3D p = vec1.get_head();
		p.set_y(new Coordinate(1));
		vec1.set_head(p);
		double d = vec1.dotProduct(vec2);
		assertEquals(12.4,d,0);
		
		vec1.set_head(new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0)));
		vec2.set_head(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0)));
		Vector vec3 = new Vector(vec1.crossProduct(vec2));
		String str =vec3.toString();
		//System.out.println(str);
		assertEquals("Vector [_head=Point3D [_x=Coordinate [_coordinate=0.0], _y=Coordinate [_coordinate=0.0]_z=Coordinate [_coordinate=1.0]]]",str);
		



	}

}
