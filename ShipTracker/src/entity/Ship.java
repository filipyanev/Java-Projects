package entity;

import java.util.List;
import entity.Port;

public abstract class Ship {
	private String name;
	private List<Load> loads = null;
	private List<Sailor> sailors = null;
	private Port lastPort =  new Port("Unknown", 0 ,0);
	private Course course = null;
	private int currentX;
	private int currentY;

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public Ship(String name, List<Load> loads, List<Sailor> sailors, Course course) {
		
		this.name = name;
		this.loads = loads;
		this.sailors = sailors;
		this.course = course;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Load> getLoads() {
		return loads;
	}

	public void setLoads(List<Load> loads) {
		this.loads = loads;
	}

	public List<Sailor> getSailors() {
		return sailors;
	}

	public void setSailors(List<Sailor> sailors) {
		this.sailors = sailors;
	}

	public Port getLastPort() {
		return lastPort;
	}

	public void setLastPort(Port lastPort) {
		this.lastPort = lastPort;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + currentX;
		result = prime * result + currentY;
		result = prime * result + ((lastPort == null) ? 0 : lastPort.hashCode());
		result = prime * result + ((loads == null) ? 0 : loads.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sailors == null) ? 0 : sailors.hashCode());
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
		Ship other = (Ship) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (currentX != other.currentX)
			return false;
		if (currentY != other.currentY)
			return false;
		if (lastPort == null) {
			if (other.lastPort != null)
				return false;
		} else if (!lastPort.equals(other.lastPort))
			return false;
		if (loads == null) {
			if (other.loads != null)
				return false;
		} else if (!loads.equals(other.loads))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sailors == null) {
			if (other.sailors != null)
				return false;
		} else if (!sailors.equals(other.sailors))
			return false;
		return true;
	}

	public abstract String getShipType();

	public String toString() {
		return "Ship Type: " + getShipType() + ", Ship Name: " + name + ", all sailors: " + sailors + " next Port: ";
	}

}
