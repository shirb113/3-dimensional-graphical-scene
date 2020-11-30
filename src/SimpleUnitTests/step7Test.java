package SimpleUnitTests;

import java.awt.Color;

import org.junit.Test;

import Elements.DirectionalLight;
import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class step7Test {

	@Test
	public void test() {

		Scene scene = new Scene();
		
		scene.addGeometry(new Sphere(Color.blue, new Point3D(0.0, 0.0, -150), 50));
		
		Triangle triangle = new Triangle(Color.red,new Point3D( 100, 0, -149), new Point3D(  0, 100, -149), new Point3D( 100, 100, -149));
		
		Triangle triangle2 = new Triangle(Color.green,new Point3D( 100, 0, -149),new Point3D(  0, -100, -149),new Point3D( 100,-100, -149));
		
		Triangle triangle3 = new Triangle(Color.orange,new Point3D(-100, 0, -149),new Point3D(  0, 100, -149),new Point3D(-100, 100, -149));
		
		Triangle triangle4 = new Triangle(Color.pink,new Point3D(-100, 0, -149),new Point3D(  0,  -100, -149),new Point3D(-100, -100, -149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Render test3", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		imageWriter.writeToimage();

	}
	
}
