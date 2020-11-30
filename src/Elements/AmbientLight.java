package Elements;

import java.awt.Color;

import Primitives.Point3D;

public class AmbientLight {
	
	private Color _color;
	private double _ka;
	
	/**
	 * default constructor
	 */
	public AmbientLight() {
		super();
		this._color = Color.white;
		this._ka = 0.1;
	}
	/**
	 * constructor
	 * @param _color
	 * @param _ka
	 */
	public AmbientLight(Color color, double ka) {
		super();
		this._color = color;
		this._ka = ka;
	}
	/**
	 * constructor
	 * @param red
	 * @param blue
	 * @param green
	 */
	public AmbientLight(int red, int blue, int green) {
		super();
		this._color = new Color(red,green,blue);
		this._ka = 1.0;
	}
	/**
	 * copy constructor
	 * @param obj
	 */
	public AmbientLight(AmbientLight obj) {
		super();
		this._color = obj._color;
		this._ka = obj._ka;
	}
	/**
	 * get_color
	 * @return
	 */
	public Color get_color() {
		return new Color(this._color.getRGB());
	}
	/**
	 * set_color
	 * @param color
	 */
	public void set_color(Color color) {
		this._color = color;
	}
	/**
	 * get_ka
	 * @return
	 */
	public double get_ka() {
		return _ka;
	}
	/**
	 * set_ka
	 * @param ka
	 */
	public void set_ka(double ka) {
		this._ka = ka;
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
		AmbientLight other = (AmbientLight) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
			return false;
		return true;
	}
	/**
	 * toString-print
	 */
	@Override
	public String toString() {
		return "AmbientLight [_color=" + _color + ", _ka=" + _ka + "]";
	}
	/**
	 * getIntensity - return color
	 * @param p
	 * @return
	 */
	public Color getIntensity(Point3D p){
		int red = (int)(this.get_color().getRed()*_ka);
		int green = (int)(this.get_color().getGreen()*_ka);
		int blue = (int)(this.get_color().getBlue()*_ka);
		if(red>255) red=255;
		if(green >255) green=255;
		if(blue>255)blue=255;
        return new Color(red,green,blue);
	}
}
