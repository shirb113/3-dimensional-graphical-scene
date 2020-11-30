package Scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.Light;
import Geometries.Geometry;


public class Scene {

  private String _sceneName;
  private Color _background;
  private AmbientLight _ambientLight;
  private ArrayList<Geometry> _geometries;
  private Camera _camera;
  private double _screenDistance;
  private List<Light> _lights;
  
  
  
  /**
   * default constructor
   */
  public Scene() {
    this._sceneName = "";
    this._background = Color.BLACK;
    this._ambientLight = new AmbientLight();
    this._geometries = new ArrayList<Geometry>();
    this._camera = new Camera();
    this._screenDistance = 150;
    this._lights = new ArrayList<Light>();
  }
  /**
   * constructor
   */
  public Scene(String sceneName, Color background, AmbientLight ambientLight, ArrayList<Geometry> geometries, Camera camera, double screenDistance) {
	    this._sceneName = sceneName;
	    this._background = background;
	    this._ambientLight = new AmbientLight(ambientLight);
	    this._geometries = geometries;
	    this._camera = new Camera(camera);
	    this._screenDistance = screenDistance;
	  }
  /**
   * constructor
   */
  public Scene(String sceneName, Color background, AmbientLight ambientLight, ArrayList<Geometry> geometries, Camera camera, double screenDistance,List<Light> lights) {
	    this._sceneName = sceneName;
	    this._background = background;
	    this._ambientLight = new AmbientLight(ambientLight);
	    this._geometries = geometries;
	    this._camera = new Camera(camera);
	    this._screenDistance = screenDistance;
	    this._lights = lights;
	  }
  /**
   * copy constructor
   */
  public Scene(Scene sce) {
	    this._sceneName = sce._sceneName;
	    this._background = sce._background;
	    this._ambientLight = sce._ambientLight;
	    this._geometries = sce._geometries;
	    this._camera = sce._camera;
	    this._screenDistance =sce._screenDistance;
	    this._lights = sce._lights;
	  }
  
  /**
   * get_sceneName
   * @return
   */
  public String get_sceneName() {
    return _sceneName;
  }
  /**
   * set_sceneName
   * @param sceneName
   */
  public void set_sceneName(String sceneName) {
    this._sceneName = sceneName;
  }
  /**
   * get_background
   * @return
   */
  public Color get_background() {
    return new Color(this._background.getRGB());
  }
  /**
   * set_background
   * @param background
   */
  public void set_background(Color background) {
    this._background = background;
  }
  /**
   * get_ambientLight
   * @return
   */
  public AmbientLight get_ambientLight() {
    return new AmbientLight(this._ambientLight);
  }
  /**
   * set_ambientLight
   * @param _ambientLight
   */
  public void set_ambientLight(AmbientLight ambientLight) {
    this._ambientLight = ambientLight;
  }
  /**
   * get_geometries
   * @return
   */
  public ArrayList<Geometry> get_geometries() {
    return new ArrayList<Geometry>(this._geometries);
  }
  /**
   * set_geometries
   * @param _geometries
   */
  public void set_geometries(ArrayList<Geometry> geometries) {
    this._geometries = new ArrayList<>(geometries);
  }
  /**
   * get_camera
   * @return
   */
  public Camera get_camera() {
    return new Camera(_camera);
  }
  /**
   * set_camera
   * @param _camera
   */
  public void set_camera(Camera camera) {
    this._camera = new Camera(camera);
  }
  /**
   * get_screenDistance
   * @return
   */
  public double get_screenDistance() {
    return _screenDistance;
  }
  /**
   * set_screenDistance
   * @param _screenDistance
   */
  public void set_screenDistance(double _screenDistance) {
    this._screenDistance = _screenDistance;
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
	Scene other = (Scene) obj;
	if (_ambientLight == null) {
		if (other._ambientLight != null)
			return false;
	} else if (!_ambientLight.equals(other._ambientLight))
		return false;
	if (_background == null) {
		if (other._background != null)
			return false;
	} else if (!_background.equals(other._background))
		return false;
	if (_camera == null) {
		if (other._camera != null)
			return false;
	} else if (!_camera.equals(other._camera))
		return false;
	if (_geometries == null) {
		if (other._geometries != null)
			return false;
	} else if (!_geometries.equals(other._geometries))
		return false;
	if (_sceneName == null) {
		if (other._sceneName != null)
			return false;
	} else if (!_sceneName.equals(other._sceneName))
		return false;
	if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
		return false;
	return true;
}

/**
 * toStrint - print
 */
@Override
public String toString() {
	return "Scene [_sceneName=" + _sceneName + ", _background=" + _background + ", _ambientLight=" + _ambientLight
			+ ", _geometries=" + _geometries + ", _camera=" + _camera + ", _screenDistance=" + _screenDistance + "]";
}
/**
   * Add Geometry Function
   * @param geometry
   */
  public void addGeometry(Geometry geometry)
  {
	  this._geometries.add(geometry);
  }
  /**
   * getGeometriesIterator
   * @return
   */
  public Iterator<Geometry>getGeometriesIterator()
	{
		return _geometries.iterator();
	}
  /**
   * getLightIterator
   * @return
   */
  public Iterator<Light> getLightIterator()
  {
      return _lights.listIterator();
  }
  /**
   * addLight
   * @param light
   */
  public void addLight(Light light){
	  this._lights.add(light);

  }
  
}