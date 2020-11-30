package SimpleUnitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import org.junit.Test;

import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class ShadowTester {

	@Test
	public void test() {
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		
		Sphere sphere = new Sphere (new Color(0,0,100),new Point3D(0,0,-1000), 500);
		
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100),new Point3D(-125, -225, -260), new Point3D(-225, -125, -260),new Point3D(-225, -225, -270));
		
		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);
				
		scene.addLight(new SpotLight(new Vector(2, 2, -3), new Color(255, 100, 100), new Point3D(-200, -200, -150), 0.1, 0.00001, 0.000005));
	

		ImageWriter imageWriter = new ImageWriter("Shadow Test", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
	}

}
