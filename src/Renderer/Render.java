package Renderer;

import java.awt.Color;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Elements.Light;
import Geometries.FlatGeometry;
import Geometries.Geometry;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Scene.Scene;

public class Render {

	private Scene _scene;
	private ImageWriter _imagewriter;
	private int RECURSION_LEVEL = 3;

	/**
	 * constructor
	 */
	public Render() {
		super();
		this._scene = new Scene();
		this._imagewriter = new ImageWriter("Default",500,500,500,500);
	}
	/**
	 * constructor
	 * @param _scene
	 * @param _imagewriter
	 */
	public Render(Scene scene, ImageWriter imagewriter) {
		super();
		this._scene = new Scene(scene);
		this._imagewriter = imagewriter;
	}
	/**
	 * get_scene
	 * @return
	 */
	public Scene get_scene() {
		return _scene;
	}
	/**
	 * set_scene
	 * @param _scene
	 */
	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}
	/**
	 * get_imagewriter
	 * @return
	 */
	public ImageWriter get_imagewriter() {
		return _imagewriter;
	}
	/**
	 * set_imagewriter
	 * @param _imagewriter
	 */
	public void set_imagewriter(ImageWriter _imagewriter) {
		this._imagewriter = _imagewriter;
	}

	/**
	 * equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (_imagewriter == null) {
			if (other._imagewriter != null)
				return false;
		} else if (!_imagewriter.equals(other._imagewriter))
			return false;
		if (_scene == null) {
			if (other._scene != null)
				return false;
		} else if (!_scene.equals(other._scene))
			return false;
		return true;
	}
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Render [_scene=" + _scene + ", _imagewriter=" + _imagewriter + "]";
	}
	/**
	 * printGrid
	 * @param interval
	 */
	public void printGrid(int interval){
		for (int i=0;i<_imagewriter.getHeight();i++)
			for (int j=0;j<_imagewriter.getWidth();j++)
			{
				if(i%interval==0 || j%interval==0 )
					_imagewriter.writePixel(j,i,Color.WHITE); 
			}   
	}
	/**
	 * renderImage - A function whose function is to produce the actual image
	 */
	public void renderImage()
	{
		//Matrix for runtime efficiency
		boolean [][] gridArray = new boolean[500][500];
		for (int i=0;i<_imagewriter.getHeight();i++){
			for (int j=0;j<_imagewriter.getWidth();j++)
			{
				Ray ray = _scene.get_camera().constructRayThroughPixel(_imagewriter.getNx(), _imagewriter.getNy(),i,j, _scene.get_screenDistance(), _imagewriter.getWidth(),_imagewriter.getHeight(),2);
				Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray); 
				//If the intersectionPoints is empty, we will mark the gridArray FALSE
				if (intersectionPoints.isEmpty())
					gridArray[i][j]=false;
				else
					gridArray[i][j]=true;
			}
		}
		int red=0;
		int green=0;
		int blue=0;
		for (int i=0; i<_imagewriter.getHeight(); i++){
			for (int j=0; j<_imagewriter.getWidth(); j++)
			{
				red = 0;
				green = 0;
				blue = 0;
				Color color = new Color(0,0,0);
				// If in gridArray[i][j] is true then send 5 rays through that pixel
				if (gridArray[i][j]==true){
					for(int k=0;k<5;k++)
					{
						Ray ray = this._scene.get_camera().constructRayThroughPixel(_imagewriter.getNx(), _imagewriter.getNy(),i,j, _scene.get_screenDistance(), _imagewriter.getWidth(),_imagewriter.getHeight(),k);
						Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray); 
						if (intersectionPoints.isEmpty()){
							color = this._scene.get_background();
							red+=color.getRed();
							green+=color.getGreen();
							blue+=color.getBlue();

						}
						else
						{
							Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
							for(Entry<Geometry,Point3D> entry:closestPoint.entrySet()){
								color = calcColor(entry.getKey(), entry.getValue(),ray);
								red+=color.getRed();
								green+=color.getGreen();
								blue+=color.getBlue();

							}	
						}
					}
				}
				red = (int)red/5;
				green = (int)green/5;
				blue = (int)blue/5;
				if(red>255) red=255;
				if(green >255) green=255;
				if(blue>255)blue=255;
				if(red<0) red=0;
				if(green<0) green=0;
				if(blue<0)blue=0;
				Color finalc =  new Color(red,green,blue);
				this._imagewriter.writePixel(i,j,finalc);	

			}
		}
	}
	/**
	 * getSceneRayIntersections 
	 * ray - Ray to find intersections with it
	 * Map of intersection Points and their geometries
	 * Find the intersection points of this ray with all the geometries in geometries list
	 * @param ray
	 * @return
	 */
	private Map<Geometry,List<Point3D>> getSceneRayIntersections(Ray ray)
	{
		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		Map<Geometry,List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
		while (geometries.hasNext()){
			Geometry geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
			if(!geometryIntersectionPoints.isEmpty())
				intersectionPoints.put(geometry, geometryIntersectionPoints);
		}
		return intersectionPoints;
	}


	/**
	 * getClosestPoint - Find the closest point to the Scene from the list (Map) of intersection points
     * and return Map of the closest point and its match geometry
	 * @param intersectionPoints
	 * @return
	 */
	private Map<Geometry,Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints)
	{

		double distance = Double.MAX_VALUE;  
		Point3D P0 = _scene.get_camera().get_p();
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();

		for (Entry<Geometry, List<Point3D>> entry:intersectionPoints.entrySet()){
			for (Point3D point: entry.getValue())  
				if(P0.distance(point )< distance){
					minDistancePoint.clear(); 
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}
		}
		return minDistancePoint;
	}
	/**
	 * calcDiffuseComp
	 * @param kd -  geometry material kd Value
     * @param normal - Geometry's normal
     * @param l - vector, from:light source, to:intersection point
     * @param intensity - light's color.
     * @return Color - point's diffusive light
	 */
	public Color calcDiffuseComp(double kd,Vector normal,Vector l, Color intensity){
		normal.normalize();
		l.normalize();
		double nl = normal.dotProduct(l);
		if(nl < 0) nl = -1 * nl;
		if(nl > 1) nl = 1;
		double kdnl = kd*nl;
		double red = kdnl*intensity.getRed();
		double green = kdnl*intensity.getGreen();
		double blue = kdnl*intensity.getBlue();
		if(red>255) red=255;
		if(green >255) green=255;
		if(blue>255)blue=255;
		if(red<0) red=0;
		if(green<0) green=0;
		if(blue<0)blue=0;
		return new Color((int)(red),(int)(green),(int)(blue));
	}
	/**
	 * calcSpecularComp
     * @param ks - double of the geometry material
     * @param v - Vector from intersection point To the Camera
     * @param normal - Vector normal of the geometry at the intersection point
     * @param l - Vector from the light source to the intersection point
     * @param shininess - double of the geometry shininess
     * @param intensity - Color of the light in the intersection point
	 * @return color of specular Light in the intersection point
	 */

	public Color calcSpecularComp (double ks, Vector v, Vector normal, Vector l, double shininess, Color intensity ){

		normal.normalize();
		l.normalize();
		v.normalize();
		Vector R = calcR(l,normal);
		R.normalize();
		double vr = v.dotProduct(R);
		if(vr < 0) vr = 0;
		double ksVR=ks*(Math.pow(vr,shininess));
		if(ksVR>1) ksVR=1;
		double red = ksVR*intensity.getRed();
		double green = ksVR*intensity.getGreen();
		double blue = ksVR*intensity.getBlue();
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255)blue=255;
		if(red<0) red=0;
		if(green<0) green=0;
		if(blue<0)blue=0;
		return new Color((int)(red),(int)(blue),(int)(green));
	}

	/**
	 * calcColor - Shell function
	 * @param geometry
	 * @param point
	 * @param ray
	 * @return
	 */
	private Color calcColor(Geometry geometry, Point3D point, Ray ray)
	{

		return calcColor(geometry,point,ray,0);
	}
	/**
	 * calcColor - Calculate color in point
	 * @param geometry - geometry of the point's
     * @param point - intersection point
     * @param inRay - Ray that intersected with the point
     * @param level - number of recursive calls
     *
	 * @return Color - pixel color
	 */
	private Color calcColor(Geometry geometry, Point3D point,Ray inRay,int level) {
		int r,g,b;
		if(level == RECURSION_LEVEL) 
			return new Color(0,0,0);
		Color ambientLight = _scene.get_ambientLight().getIntensity(point);
		Color emissionLight = geometry.getEmmission();
		Color diffuseLight = new Color(0,0,0);
		Color specularLight = new Color(0,0,0);
		Iterator<Light> lights = this._scene.getLightIterator();
		while (lights.hasNext()){
			Light light=lights.next();
			// Calculate the diffuseLight and specularLight
			if (!occluded(light, point, geometry))
			{
				diffuseLight = addColors(diffuseLight,calcDiffuseComp(geometry.get_material().get_kd(),geometry.getNormal(point),light.getL(point),light.getIntensity(point)));
				specularLight = addColors(specularLight,calcSpecularComp(geometry.get_material().get_ks(),new Vector(point,_scene.get_camera().get_p()),geometry.getNormal(point),light.getL(point),geometry.get_material().get_nShininess(),light.getIntensity(point)));
			}	
		}

		Color reflectedLight=new Color(0,0,0);
		Color refractedLight=new Color(0,0,0);
		Color reflectedColor=new Color(0,0,0);
		Color refractedColor=new Color(0,0,0);

		Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
		Map<Geometry,Point3D> reflectedEntry = findClosestIntersection(reflectedRay);
		if(reflectedEntry!=null) {
			for(Entry<Geometry,Point3D> entry:reflectedEntry.entrySet())
			{
				if(entry.getValue() instanceof FlatGeometry)
					reflectedColor=new Color(0,0,0);
				else
					if(entry.getValue()!=null)
						reflectedColor = calcColor(entry.getKey(), entry.getValue(), reflectedRay, level + 1);
			}
		}
		double kr = geometry.get_material().get_kr();
		r = (int) (kr * reflectedColor.getRed());
		g = (int) (kr * reflectedColor.getGreen());
		b = (int) (kr * reflectedColor.getBlue());
		if(r>255) r=255;
		if(g >255) g=255;
		if(b>255)b=255;
		if(r<0) r=0;
		if(g<0) g=0;
		if(b<0)b=0;
		reflectedLight = new Color(r,g,b);

		Ray refractedRay = constructRefractedRay(geometry.getNormal(point), point, inRay);
		Map<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay);
		if(refractedEntry!=null)
			for(Entry<Geometry,Point3D> entry:refractedEntry.entrySet())
			{
				if(entry.getValue() instanceof FlatGeometry)
					refractedColor=new Color(0,0,0);
				else
					if(entry.getValue()!=null)
						refractedColor = calcColor(entry.getKey(), entry.getValue(), refractedRay, level + 1);
			}
		double kt = geometry.get_material().get_kt();
		r = (int) (kt * refractedColor.getRed());
		g = (int) (kt * refractedColor.getGreen());
		b = (int) (kt * refractedColor.getBlue());
		if(r>255) r=255;
		if(g >255) g=255;
		if(b>255)b=255;
		if(r<0) r=0;
		if(g<0) g=0;
		if(b<0)b=0;

		refractedLight = new Color(r,g,b);
		return  addColors(addColors(addColors(ambientLight,emissionLight),addColors(diffuseLight,specularLight)),addColors(reflectedLight,refractedLight));
	}

	/**
	 * constructRefractedRay - Calculate the refracted ray from the intersection with the geometry
	 * @param geometry - geometry of the intersection point
	 * @param point - intersection point
	 * @param inRay - ray intersect with the point
	 * @return ray - refracted ray from the geometry
	 */
	private Ray constructRefractedRay(Vector normal, Point3D point, Ray inRay) 
	{
		Vector v=new Vector(inRay.get_direction());
		Point3D poin=new Point3D(point);
		poin.add(v);
		Ray r=new Ray(poin,inRay.get_direction());
		return r; 
	}



	/**
	 * constructReflectedRay - Get the reflected ray from the intersection with the geometry
     * @param normal - Vector represents the geometry normal
     * @param point - Point3D Represents intersection point
     * @param r - Ray represents ray to be reflected.
	 * @return Ray - represents the reflected ray from the geometry
	 */
	private Ray constructReflectedRay(Vector normal,Point3D point,Ray r)
	{

		Vector v=new Vector(r.get_direction());
		normal.scale(2*(r.get_direction().dotProduct(normal)));
		v.subtract(normal);
		Point3D newPoint=new Point3D(point);
		newPoint.add(v);
		return new Ray(newPoint,v);
	}

	/**
	 * findClosestIntersection
	 * @param ray
	 * @return
	 */
	private  Map<Geometry,Point3D> findClosestIntersection(Ray ray)
	{
		Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
		return getClosestPoint(intersectionPoints);
	}
	
	/**
	 * A function that checks whether the geometry is hidden or not
	 * @param light - LightSource to check the point with
     * @param point - the intersection Point
     * @param geometry - geometry of the intersection point
	 * @return False - if light gets to the given Point. True - if it's blocked by other geometry
	 */
	private boolean occluded(Light light, Point3D point, Geometry geometry) 
	{
		Vector lightDirection = light.getL(point);
		lightDirection.scale(-1);

		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);

		geometryPoint.add(epsVector.get_head());
		Ray lightRay = new Ray(geometryPoint , lightDirection);
		Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
		Map<Geometry, Point3D> close = this.getClosestPoint(intersectionPoints);

		if (geometry instanceof FlatGeometry) {
			close.remove(geometry);
		}
		for (Entry<Geometry, Point3D> entry: close.entrySet())
			if (entry.getKey().get_material().get_kt() == 0)
				return true;
		return false;
	}

	/**
	 * calcR - for calcSpecularComp function
	 * @param d - Vector
	 * @param n - Vector
	 * @return
	 */
	public Vector calcR(Vector d, Vector n){
		d.normalize();
		n.normalize();
		double dn = d.dotProduct(n)*(-2);
		n.scale(dn);
		d.add(n);
		d.normalize();
		return d;
	}	
	/**
	 * Ezer function for calculating 2 colors
	 * @param a - Color
	 * @param c - Color
	 * @return
	 */
	private Color addColors(Color a, Color c){
		int r=a.getRed()+c.getRed();
		int g=a.getGreen()+c.getGreen();
		int b=a.getBlue()+c.getBlue();
		if(r>255) r=255;
		if(r<0) r=0;
		if(g>255)g=255;
		if(g<0)g=0;
		if(b>255) b=255;
		if(b<0) b=0;
		return new Color(r, g, b);
	}
}


