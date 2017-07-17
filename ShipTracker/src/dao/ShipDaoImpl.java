package dao;

import java.util.List;

import controller.Database;
import entity.Course;
import entity.Load;
import entity.Port;
import entity.Sailor;
import entity.Ship;

public class ShipDaoImpl implements ShipDao {

	@Override
	public void addShip(Ship ship) {
		List<Ship> ships = Database.ships;
		ships.add(ship);

	}

	@Override
	public void removeShip(String shipName) {
		List<Ship> ships = Database.ships;
		for (int i = 0; i < ships.size(); i++) {
			if (ships.get(i).getName().equals(shipName)) {
				ships.remove(i);
				break;
			}
		}

	}

	@Override
	public Ship getShipByShipName(String shipName) {
		List<Ship> ships = Database.ships;
		Ship ship = null;
		for (int i = 0; i < ships.size(); i++) {
			if (ships.get(i).getName().equals(shipName)) {
				ship = ships.get(i);
				break;
			}
		}
		return ship;

	}

	@Override
	public void addSailorsToShip(String shipName, List<Sailor> sailors) {
		Ship ship = null;
		ship = getShipByShipName(shipName);
		ship.getSailors().addAll(sailors);
	}

	@Override
	public void removeSailorsFromShip(String shipName, List<Sailor> sailors) {
		Ship ship = null;
		ship = getShipByShipName(shipName);
		ship.getSailors().removeAll(sailors);
	}

	@Override
	public void increaseLoadQuantity(String shipName, String loadName, Double quantity) {
		Ship ship = null;
		List<Load> loads = null;
		Load load = new Load(loadName, null);

		if (getShipByShipName(shipName) != null) {
			ship = getShipByShipName(shipName);
			loads = ship.getLoads();
		} else {
			System.out.println("There is no ship with that name.");
		}

		for (int i = 0; i < loads.size(); i++) {
			Load loadNow = loads.get(i);
			Double newQuantity = 0d;
			if (loadNow.getName().equals(load.getName())) {
				newQuantity = loads.get(i).getQuantity() + quantity;
				loads.get(i).setQuantity(newQuantity);
				break;
			}

		}
	}

	@Override
	public void decreaseLoadQuantity(String shipName, String loadName, Double quantity) {
		Ship ship = null;
		List<Load> loads = null;
		Load load = new Load(loadName, null);

		if (getShipByShipName(shipName) != null) {
			ship = getShipByShipName(shipName);
			loads = ship.getLoads();
		} else {
			System.out.println("There is no ship with that name.");
		}

		for (int i = 0; i < loads.size(); i++) {
			Load loadNow = loads.get(i);
			Double newQuantity = 0d;
			if (loadNow.getName().equals(load.getName())) {
				newQuantity = loads.get(i).getQuantity() - quantity;
				loads.get(i).setQuantity(newQuantity);
				break;
			}

		}

	}

	@Override
	public void removeLoad(String shipName, String loadName) {
		Ship ship = null;
		List<Load> loads = null;
		Load load = new Load(loadName, null);

		if (getShipByShipName(shipName) != null) {
			ship = getShipByShipName(shipName);
			loads = ship.getLoads();
		} else {
			System.out.println("There is no ship with that name.");
		}
		for (int i = 0; i < loads.size(); i++) {
			Load loadNow = loads.get(i);
			if (loadNow.getName().equals(load.getName())) {
				loads.remove(i);
				break;
			}

		}

	}

	@Override
	public void updateShip(String shipName) {
		Ship ship = null;
		if (getShipByShipName(shipName) != null) {
			ship = getShipByShipName(shipName);
		}
		Course course = ship.getCourse();
		Port lastPort = course.getCourse().poll();
		ship.setLastPort(lastPort);
		
		
		
		
	}

	@Override
	public void addLoad(String shipName, Load load) {
		Ship ship = null;
		
		if (getShipByShipName(shipName) != null) {
			ship = getShipByShipName(shipName);
		}
		ship.getLoads().add(load);
		
	}

}
