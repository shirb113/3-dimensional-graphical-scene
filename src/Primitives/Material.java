package Primitives;

public class Material {
	
	private double _kd; // Diffusion attenuation coefficient – פיזור האור 	
	private double _ks; // Specular attenuation coefficient – החזרת האור
	private double _nShininess;  // Refraction index – מידת מבהיקות של החומר
	private double _kr; //Reflection
	private double _kt; //Refraction
	/**
	 * default constructor
	 */
	public Material() {
		this._kd = 1;
		this._ks = 1;
		this._kr = 0;
		this._kt = 0;
		this._nShininess = 19;
	}
	/**
	 * constructor
	 * @param _kd
	 * @param _ks
	 * @param _nShininess
	 */
	public Material(double kd, double ks, double nShininess,double kr,double kt) {
		super();
		this._kd = kd;
		this._ks = ks;
		this._kr = kr;
		this._kt = kt;
		this._nShininess = nShininess;
	}
	
	/**
	 * constructor
	 * @param material
	 */
	public Material(Material material) {
		super();
		this._kd = material._kd;
		this._ks = material._ks;
		this._kr = material._kr;
		this._kt = material._kt;
		this._nShininess = material._nShininess;
	}
/**
 * get_kd
 * @return
 */
	public double get_kd() {
		return _kd;
	}

	/**
	 * set_kd
	 * @param _kd
	 */
	public void set_kd(double kd) {
		this._kd = kd;
	}
/**
 * get_ks
 * @return
 */
	public double get_ks() {
		return _ks;
	}
/**
 * set_ks
 * @param _ks
 */
	public void set_ks(double ks) {
		this._ks = ks;
	}

	/**
	 * get_nShininess
	 * @return
	 */
	public double get_nShininess() {
		return _nShininess;
	}
/**
 * set_nShininess
 * @param _nShininess
 */
	public void set_nShininess(double nShininess) {
		this._nShininess = nShininess;
	}
	/**
	 * get_kr
	 * @return
	 */
	public double get_kr() {
		return _kr;
	}
	/**
	 * set_kr
	 * @return
	 */
	public void set_kr(double kr) {
		this._kr = kr;
	}
	/**
	 * get_kt
	 * @return
	 */
	public double get_kt() {
		return _kt;
	}
	/**
	 * gset_kt
	 * @return
	 */
	public void set_kt(double kt) {
		this._kt = kt;
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
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
			return false;
		if (Double.doubleToLongBits(_kr) != Double.doubleToLongBits(other._kr))
			return false;
		if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
			return false;
		if (Double.doubleToLongBits(_kt) != Double.doubleToLongBits(other._kt))
			return false;
		if (Double.doubleToLongBits(_nShininess) != Double.doubleToLongBits(other._nShininess))
			return false;
		return true;
	}
/**
 * tostring
 */
@Override
public String toString() {
	return "Material [_kd=" + _kd + ", _ks=" + _ks + ", _nShininess=" + _nShininess + ", _kr=" + _kr + ", _kt=" + _kt
			+ "]";
}

}
