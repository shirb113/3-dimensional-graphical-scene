package SimpleUnitTests;

import java.awt.Color;

import org.junit.Test;

import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class step11Test {

	@Test
	public void number1() throws Exception{
		
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
			
		ImageWriter imageWriter = new ImageWriter("Step11 - 1", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
	}
	@Test
	public void number2(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(100);
		Sphere sphere = new Sphere (new Color(140,100,0),new Point3D(0,0,-1000), 800);
		Material m= new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200,-100),1, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Step11 - 2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
		
	}

}
