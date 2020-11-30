package SimpleUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;
import Primitives.Point2D;


public class Point2DTest {

	@Test
	public void test() {
		Coordinate temp1 = new Coordinate(4.0);
		Coordinate temp2= new Coordinate(3.0);
		
		Point2D temp3 = new Point2D();
		Point2D temp4 = new Point2D(temp1, temp1);	
		double x1=temp3.get_x().get_coordinate();
		double y1=temp3.get_y().get_coordinate();
		assertEquals(0.0,x1,0);
		assertEquals(0.0,y1,0);
		
		double x2 = temp4.get_x().get_coordinate();
		double y2 = temp4.get_y().get_coordinate();
		assertEquals(4.0,x2,0);
		assertEquals(4.0,y2,0);
		
		temp3.set_x(temp2);
		temp3.set_y(temp2);
		 x1=temp3.get_x().get_coordinate();
		 y1=temp3.get_y().get_coordinate();
		assertEquals(3.0,x1,0);
		assertEquals(3.0,y1,0);
		
		String str = temp3.toString();
		assertEquals("Point2D [_x=Coordinate [_coordinate=3.0], _y=Coordinate [_coordinate=3.0]]",str);
		
		boolean b =temp3.equals(temp4);
		assertEquals(false,b);
		
		Point2D temp5 = new Point2D();
		Point2D temp6 = new Point2D();	
		boolean t=temp5.equals(temp6);
		assertEquals(true,t);
		
		
	}

}

