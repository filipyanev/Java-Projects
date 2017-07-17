package entity;

import java.util.List;

public class BulkCarrier extends Ship{

	public BulkCarrier(String name, List<Load> loads, List<Sailor> sailors, Course course) {
		super(name, loads, sailors, course);
		
	}

	@Override
	public String getShipType() {
		return "Bulk Carrier";
	}

}
