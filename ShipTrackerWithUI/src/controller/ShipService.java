package controller;

import java.util.List;

import entity.Load;
import entity.Sailor;
import entity.Ship;

public interface ShipService {
	
	void addShip(Ship ship);
	void removeShip(String shipName);
	void addSailorsToShip(List<Sailor> sailorList, String shipName);
	void removeSailorsFromShip(List<Sailor> sailorList, String shipName);
	void increaseLoadQuantity(String shipName, String loadName, Double quanity);
	void decreaseQuantity(String shipName, String loadName, Double quanity);
	void addLoad(String shipName, Load load);
	void removeLoad(String shipName, String loadName);
	Ship getShipByShipName(String shipName);
	void updateShip(String shipName);
	
}
