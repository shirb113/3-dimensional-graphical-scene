package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Camera {
	
	private Point3D _p;
    private Vector _vup;
    private Vector _vright;
    private Vector _vtoward;
    

	/**
	 * default constructor
	 */
	public Camera() {
		this._p = new Point3D(0,0,0);
		this._vup = new Vector(0,1,0);
		this._vtoward = new Vector(0,0,-1);
		this._vright = new Vector(_vtoward.crossProduct(_vup));
	}
	/**
	 * constructor
	 * @param vup
	 * @param vright
	 */
	public Camera(Vector vup, Vector vtoward) {
		super();
		this._p = new Point3D(0,0,0);
		this._vup = new Vector(vup);
		this._vup.normalize();
		this._vtoward =new Vector(vtoward);
		this._vtoward.normalize();
		this._vright = new Vector(vup.crossProduct(vtoward));
		this._vright.normalize();
	}
	/**
	 * constructor
	 * @param p
	 * @param vup
	 * @param vright
	 * @param vtoward
	 */
	public Camera(Point3D p, Vector vup, Vector vright, Vector vtoward) {
		super();
		this._p = new Point3D(p);
		this._vup = new Vector(vup);
		this._vup.normalize();
		this._vright =new Vector(vright);
		this._vright.normalize();
		this._vtoward = new Vector(vtoward);
		this._vtoward.normalize();
	}
	/**
	 * copy constructor
	 * @param c
	 */
	public Camera(Camera c) {
		this._p =c._p;
		this._vup = c._vup;
		this._vup.normalize();
		this._vright = c._vright;
		this._vright.normalize();
		this._vtoward = c._vtoward;
		this._vtoward.normalize();
	}
/**
 * get p
 * @return
 */
	public Point3D get_p() {
		return new Point3D(this._p);
	}
/**
 * set p
 * @param _p
 */
	public void set_p(Point3D p) {
		this._p = new Point3D(p);
	}
	/**
	 * get _vup
	 * @return
	 */
	public Vector get_vup() {
		return new Vector(_vup);
	}
	/**
	 * set _vup
	 * @param vup
	 */
	public void set_vup(Vector vup) {
		this._vup = new Vector(vup);
	}
	/**
	 * get right
	 * @return
	 */
	public Vector get_vright() {
		return new Vector(_vright);
	}
	/**
	 * set right
	 * @param vright
	 */
	public void set_vright(Vector vright) {
		this._vright = new Vector(vright);
	}
	/**
	 * get toward
	 * @return
	 */
	public Vector get_vtoward() {
		return new Vector(_vtoward);
	}
	/**
	 * set toward
	 * @param vtoward
	 */
	public void set_vtoward(Vector vtoward) {
		this._vtoward = new Vector(vtoward);
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
		Camera other = (Camera) obj;
		if (_p == null) {
			if (other._p != null)
				return false;
		} else if (!_p.equals(other._p))
			return false;
		if (_vright == null) {
			if (other._vright != null)
				return false;
		} else if (!_vright.equals(other._vright))
			return false;
		if (_vtoward == null) {
			if (other._vtoward != null)
				return false;
		} else if (!_vtoward.equals(other._vtoward))
			return false;
		if (_vup == null) {
			if (other._vup != null)
				return false;
		} else if (!_vup.equals(other._vup))
			return false;
		return true;
	}
	/**
	 * toString- print
	 */
	@Override
	public String toString() {
		return "Camera [_p=" + _p + ", _vup=" + _vup + ", _vright=" + _vright + ", _vtoward=" + _vtoward + "]";
	}
	/**
	 * function that creates a ray through a pixel
	 * @param Nx - The width of each single pixel
	 * @param Ny - The height of each single pixel
	 * @param x - Point
	 * @param y - Point
	 * @param screenDist - Distance from the main screen
	 * @param screenWidth - Screen width 
	 * @param screenHeight - Screen height
	 * @return Ray
	 */
	public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,double screenDist, double screenWidth,double screenHeight,int k){
		
        //helps to calculate the locatoin in the pixle
        int locX=1;
        int locY=1;
        //up-left of the pixel
        if(k==0)
        {
            locX=0;
            locY=0;                  
         }
        //up right pixle
         if(k==1)
        {
        	locX=2;
            locY=0;                  
        }
       //middle of the pixel
         if(k==2)
        {
        	locX=1;
            locY=1;                  
        }
        //down-left of the pixel
         if(k==3)
        {
        	locX=0;
            locY=2;                   
        }
        //down-right of the pixel
        else if(k==4)
        {
        	locX=2;
            locY=2;                  
        }
		//create a copy of _vtoward
		Vector temppc = new Vector(this._vtoward);
		//Multiply the vector in screenDist
		temppc.scale(screenDist);
		Point3D Pc=new Point3D(this._p);
		Pc.add(temppc);
		
		//calculate the width of each single pixel
		double Rx = screenWidth/Nx;
		//calculate the height of each single pixel
		double Ry = screenHeight/Ny;
		
		double right = ((x-(double)Nx/2)*Rx)+((Rx/2)*locX);
		double up = ((y-(double)Ny/2)*Ry)+((Ry/2)*locY);

		//calculate
		//P=Pc+[[(X-(Nx/2)*Rx+(Rx/2)]*Vright-[(Y-(Ny/2)*Ry+(Ry/2)]*Vup]
		Vector tempVright=new Vector(this._vright);
        Vector tempVup=new Vector(this._vup);
        tempVright.scale(right);
        tempVup.scale(up);

        tempVright.subtract(tempVup);
        Pc.add(tempVright);
      
        //return new ray
        Point3D centerPoint= new Point3D(right,up*(-1),screenDist*(-1));
        Vector v=new Vector(this._p,centerPoint);
    	v.normalize();
        return new Ray(this._p,v);
	}
}