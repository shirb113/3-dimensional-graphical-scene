package SimpleUnitTests;

import java.awt.Color;

import org.junit.Test;


import Primitives.Material;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class RecursiveTester {


	@Test
	public void recursiveTest1()
	{
			Scene scene = new Scene();
			scene.set_screenDistance(200);
			
			Sphere sphere = new Sphere(new Color(0,0, 100), new Point3D(0.0, 0.0, -1000), 500);	
			Material material = new Material();		
			material.set_nShininess(20); 
			material.set_kt(0.5);
			sphere.set_material(new Material(material));
			scene.addGeometry(sphere);
			
			Sphere sphere2 = new Sphere(new Color (100, 20, 20), new Point3D(0.0, 0.0, -1000),250);
			material.set_kt(0);	
			sphere2.set_material(new Material(material));
			scene.addGeometry(sphere2);

			scene.addLight(new SpotLight(new Vector(2, 2, -3),new Color(255, 100, 100), new Point3D(-200, -200, -150),0.1, 0.00001, 0.000005));
					
			ImageWriter imageWriter = new ImageWriter("Recursive Test1", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();
			//render.printGrid(50);
			imageWriter.writeToimage();
			
		}
	
		
		@Test
		public void recursiveTest2() throws Exception{
			
			Scene scene = new Scene();
			scene.set_screenDistance(200);
			
			Sphere sphere = new Sphere( Color.RED,new Point3D(0.0, 0.0, -1000), 500);
			Material material = new Material();
			material.set_nShininess(20);
			material.set_kt(0.5);
			sphere.set_material(new Material(material));	
			scene.addGeometry(sphere);
			
			Sphere sphere2 = new Sphere(Color.BLUE, new Point3D(0.0, 0.0, -1000),250);
			material.set_kt(0);
			sphere2.set_material(new Material(material));
			scene.addGeometry(sphere2);
			
			scene.addLight(new SpotLight(new Vector(2, 2, -3),new Color(255, 100, 100), new Point3D(-200, -200, -150), 
						    0.1, 0.00001, 0.000005));
				
			ImageWriter imageWriter = new ImageWriter("Recursive Test2", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();
			//render.printGrid(50);
			imageWriter.writeToimage();
		}
		
		@Test
		public void recursiveTest3() throws Exception{
			
			Scene scene = new Scene();
			scene.set_screenDistance(200);
			Sphere sphere = new Sphere(new Color(0, 0, 100), new Point3D(-550, -500, -1000),300);
			Material material = new Material();
			material.set_nShininess(20); 
			material.set_kt(0.5);
			sphere.set_material(new Material(material));
			scene.addGeometry(sphere);
			
			Sphere sphere2 = new Sphere(new Color(100, 20, 20), new Point3D(-550, -500, -1000),150);
			Material material2 = new Material();
			material2.set_nShininess(20);
			material2.set_kt(0);		
			sphere2.set_material(new Material(material2));
			scene.addGeometry(sphere2);
			
			Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
					 new Point3D( -1500,  1500, -1500),
					 new Point3D(  200,  200, -375));

			Triangle triangle2 = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
					  new Point3D( -1500,  1500, -1500),
					  new Point3D( -1500, -1500, -1500));

			
		
			Material material3 = new Material();		
			material3.set_kr(1);		
			triangle.set_material(new Material(material3));
			
			Material material4 = new Material();		
			material4.set_kr(0.5);		
			triangle2.set_material(new Material(material4));
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);


			scene.addLight(new SpotLight(new Vector(-2, -2, -3),new Color(255, 100, 100),  new Point3D(200, 200, -150), 
					   0.1, 0.00001, 0.000005));
		
			ImageWriter imageWriter = new ImageWriter("Recursive Test3", 500, 500, 500, 500);
			
			Render render = new Render( scene, imageWriter);
			render.renderImage();
			//render.printGrid(50);
			imageWriter.writeToimage();		
		}
			 
	}
	
	
	

	
	



