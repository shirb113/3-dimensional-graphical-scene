package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class SpotLight extends PointLight {
	
	private Vector _direction;


	/**
	 * diffult constractor
	 */
	public SpotLight() {
		super();
		this._direction = new Vector(0,0,1);
	}
	/**
	 * constructor
	 * @param _direction
	 */
	public SpotLight(Vector direction) {
		super();
		this._direction = new Vector(direction);
	}

/**
 * constructor
 * @param _direction
 */
public SpotLight(Vector direction,Color c, Point3D position, double kc, double kl, double kq ) {
	super(c,position,kc,kl,kq);
	this._direction =  new Vector(direction);
}
/**
 * copy constructor
 * @param sl
 */
public SpotLight(SpotLight sl) 
{
	super(sl.getColor(),sl.get_position(),sl.get_kc(),sl.get_kl(),sl.get_kq());
	this._direction = sl.get_direction();
}
/**
 * get_direction
 * @return
 */
public Vector get_direction() {
	return new Vector(_direction);
}
/**
 * set_direction
 * @param _direction
 */
public void set_direction(Vector direction) {
	this._direction =new Vector(direction);
}
/**
 * equals
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	SpotLight other = (SpotLight) obj;
	if (_direction == null) {
		if (other._direction != null)
			return false;
	} else if (!_direction.equals(other._direction))
		return false;
	return true;
}
/**
 * toString
 */
@Override
public String toString() {
	return "SpotLight [_direction=" + _direction + "]";
}
/**
 * getintensity
 */
	@Override
	public Color getIntensity(Point3D p) {
		
		Vector dv = this.get_direction();
		dv.normalize();
		Vector l = new Vector(this.getL(p));
		l.normalize();
		double temp = dv.dotProduct(l);
		
		double d = this.get_position().distance(p);
		Color mone = this.getColor();
		double mechne = this.get_kc() +this.get_kl()*d +this.get_kq()*d*d;
		if(mechne < 1) mechne=1;
		if(temp < 0) temp=(-1)*temp;
		double red = (mone.getRed()/mechne)*temp;
		double green =(mone.getGreen()/mechne)*temp;
		double blue =(mone.getBlue()/mechne)*temp;
		if(red>255) red=255;
		if(green>255) green=255;
		if(blue>255)blue=255;
		if(red<0) red=0;
		if(green <0) green=0;
		if(blue<0)blue=0;
		return new Color((int)(red),(int)(blue),(int)(green));
	}
	

}
