package SimpleUnitTests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;

public class ImageWriterTest {
	
	/**
	 * A function for printing the grid - from the nootbook
	 * @param interval
	 * @param image
	 */
	public void printGrid(int interval, ImageWriter image)
    {
        for (int i=0;i<image.getHeight();i++)
            for (int j=0;j<image.getWidth();j++)
            {
                if(i%interval==0 || j%interval==0 )
                  image.writePixel(j,i,Color.WHITE); 
                else
                  image.writePixel(j,i,Color.BLACK);  
            }      
    } 

	@Test
	public void test() {
		
		 ImageWriter image = new ImageWriter ("Test1",500,500,50,50);
		 printGrid(50,image); 
		 
		 image.writeToimage();
		 assertTrue(true);
	}

}
