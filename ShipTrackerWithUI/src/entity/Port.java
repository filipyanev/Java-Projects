package entity;

public class Port {
	private String name;
	private int portX;
	private int portY;

	public Port(String name, int portX, int portY) {
		this.name = name;
		this.portX = portX;
		this.portY = portY;
	}

	public int getPortX() {
		return portX;
	}

	public void setPortX(int portX) {
		this.portX = portX;
	}

	public int getPortY() {
		return portY;
	}

	public void setPortY(int portY) {
		this.portY = portY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + portX;
		result = prime * result + portY;
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
		Port other = (Port) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (portX != other.portX)
			return false;
		if (portY != other.portY)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name + " " + this.portX + " " + this.portY;
	}

}