package Elements;

import java.awt.Color;

import javax.swing.text.DefaultEditorKit.CopyAction;

import Primitives.Point3D;
import Primitives.Vector;

public class PointLight extends Light{

	private Point3D _position;
	private double _kc;
	private double _kl;
	private double _kq;
	
	/**
	 * default constructor
	 */
	public PointLight() {
		super();
		this._position = new Point3D();
		this._kc = 0.1;
		this._kl = 0.1;
		this._kq = 0.1;
	}
	/**
	 *  constructor
	 */
	public PointLight(Point3D position, double kc, double kl, double kq) {
		super();
		this._position = new Point3D(position);
		this._kc = kc;
		this._kl = kl;
		this._kq = kq;
	}
	/**
	 *  constructor
	 */
	public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
		super(color);
		this._position = new Point3D(position);
		this._kc = kc;
		this._kl = kl;
		this._kq = kq;
	}
	/**
	 *  copy constructor
	 */
	public PointLight(PointLight pl) {
		super(pl.getColor());
		this._position = new Point3D(pl._position);
		this._kc = pl._kc;
		this._kl = pl._kl;
		this._kq = pl._kq;
	}
	/**
	 * get_position
	 * @return
	 */
	public Point3D get_position() {
		return new Point3D(_position);
	}
	/**
	 * set_position
	 * @param position
	 */
	public void set_position(Point3D position) {
		this._position = new Point3D(position);
	}
	/**
	 * get_kc
	 * @return
	 */
	public double get_kc() {
		return _kc;
	}
	/**
	 * set_kc
	 * @param kc
	 */
	public void set_kc(double kc) {
		this._kc = kc;
	}
	/**
	 * get_kl
	 * @return
	 */
	public double get_kl() {
		return _kl;
	}
	/**
	 * set_kl
	 * @param kl
	 */
	public void set_kl(double kl) {
		this._kl = kl;
	}
	/**
	 * get_kq
	 * @return
	 */
	public double get_kq() {
		return _kq;
	}
	/**
	 * set_kq
	 * @param kq
	 */
	public void set_kq(double kq) {
		this._kq = kq;
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
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))
			return false;
		if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))
			return false;
		if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}
	/**
	 * tostring
	 */
@Override
public String toString() {
	return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
}
/**
 * getintensity
 */
	@Override
	public Color getIntensity(Point3D p) {
		double d = this._position.distance(p);
		Color mone = this.getColor();
		double mechne = 1/(_kc + (_kl * d) + (_kq * Math.pow(d, 2))); 
		if(mechne>1) mechne=1;
		int red = (int)(mone.getRed()*mechne);
		int green =(int) (mone.getGreen()*mechne);
		int blue =(int) (mone.getBlue()*mechne);
		if(red>255) red=255;
		if(green >255) green=255;
		if(blue>255)blue=255;
		if(red<0) red=0;
		if(green<0) green=0;
		if(blue<0)blue=0;
		return new Color(red,green,blue);
	}
	/**
     * A vector that emerges from the light source to a point
	 */
	@Override
	public Vector getL(Point3D point) {
		
		Vector l = new Vector(point);
		Vector v= new Vector(this._position);
		l.subtract(v);
		l.normalize();
		return l;	
		}
	}
