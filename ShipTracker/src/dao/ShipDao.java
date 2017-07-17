package dao;

import java.util.List;

import entity.Load;
import entity.Sailor;
import entity.Ship;

public interface ShipDao {
	void addShip(Ship ship);
	void removeShip(String shipName);
	void updateShip(String shipName);
	Ship getShipByShipName(String shipName);
	void addSailorsToShip(String shipName, List<Sailor> sailors);
	void removeSailorsFromShip(String shipName, List<Sailor> sailors);
	void increaseLoadQuantity(String shipName, String loadName, Double quanity);
	void decreaseLoadQuantity(String shipName, String loadName, Double quanity);
	void removeLoad(String shipName, String laodName);
	void addLoad(String shipName, Load load);
}









