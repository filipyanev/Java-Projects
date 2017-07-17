package entity;

import java.util.List;

public class Tanker extends Ship{

	public Tanker(String name, List<Load> loads, List<Sailor> sailors, Course course) {
		super(name, loads, sailors, course);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getShipType() {
		return "Tanker";
	} 
	

}
