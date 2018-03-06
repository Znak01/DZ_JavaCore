package cinemaBaibuh;

import java.io.Serializable;

public class Film implements Serializable{

	
	private String name;
	private String ganre;
	public Film(String name, String ganre) {
		super();
		this.name = name;
		this.ganre = ganre;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGanre() {
		return ganre;
	}

	public void setGanre(String ganre) {
		this.ganre = ganre;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ganre == null) ? 0 : ganre.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Film other = (Film) obj;
		if (ganre == null) {
			if (other.ganre != null)
				return false;
		} else if (!ganre.equals(other.ganre))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [name=" + name + ", ganre=" + ganre + "]";
	}
	
	
	
	
}
