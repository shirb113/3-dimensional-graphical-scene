package SimpleUnitTests;
import static org.junit.Assert.*;

import org.junit.Test;

import Primitives.Coordinate;

public class CoordinateTest {

	@Test
	public void test() {
		Coordinate temp = new Coordinate();
		Coordinate temp2= new Coordinate(3.0);
		
		double x = temp.get_coordinate();
		assertEquals(0.0,x,0);
		
		temp.set_coordinate(4);
		x=temp.get_coordinate();
		assertEquals(4.0,x,0);
		
		temp.add(temp2);
		x=temp.get_coordinate();
		assertEquals(7.0,x,0);
		
		temp.subtract(temp2);
		x=temp.get_coordinate();
		assertEquals(4,x,0);
		
		String str = temp.toString();
		assertEquals("Coordinate [_coordinate=4.0]",str);
		
		boolean b = temp.equals(temp2);
		assertEquals(false,b);
		temp.set_coordinate(0.0);
		temp2.set_coordinate(0.0);
		b = temp.equals(temp2);
		assertEquals(true,b);
		
		
	}

}
