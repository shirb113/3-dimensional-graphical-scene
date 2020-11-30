package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public abstract class Light {
	
	private Color _color;
	
	/**
	 * default constructor
	 */
	public Light() {
		this._color= Color.WHITE;
	}

	/**
	 * constructor
	 * @param color
	 */
	public Light(Color c) {
		this._color = new Color(c.getRed(),c.getGreen(),c.getBlue());
	}
/**
 * get _color
 * @return
 */
	public Color getColor() {
		return _color;
	}
/**
 * set _color
 * @param color
 */
	public void setColor(Color c) {
		this._color = new Color(c.getRed(),c.getGreen(),c.getBlue());
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
	Light other = (Light) obj;
	if (_color == null) {
		if (other._color != null)
			return false;
	} else if (!_color.equals(other._color))
		return false;
	return true;
}
/**
 * tostring
 */
@Override
public String toString() {
	return "Light [_color=" + _color + "]";
}

/**
 * getintensity
 * @return
 */
public abstract Color getIntensity(Point3D p);
/**
 * A vector that emerges from the light source to a point
 * @param point
 * @return
 */
public abstract Vector getL(Point3D point);

}
