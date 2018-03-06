package cinemaBaibuh;

import java.io.Serializable;
import java.util.Date;

public class Seassion implements Serializable{

	private Hall h;
	private Film f;
	private Date d;
	public Seassion(Hall h, Film f, Date d) {
		super();
		this.h = h;
		this.f = f;
		this.d = d;
	}
	public Hall getH() {
		return h;
	}
	public void setH(Hall h) {
		this.h = h;
	}
	public Film getF() {
		return f;
	}
	public void setF(Film f) {
		this.f = f;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((f == null) ? 0 : f.hashCode());
		result = prime * result + ((h == null) ? 0 : h.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seassion other = (Seassion) obj;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		if (h == null) {
			if (other.h != null)
				return false;
		} else if (!h.equals(other.h))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Seassion [Hall = " + h + ", Film = " + f + ", Date = " + d + "]";
	}
	
	
	
	
	
}
