package controller;

import java.util.List;
import dao.ShipDao;
import entity.Load;
import entity.Sailor;
import entity.Ship;

public class ShipServiceImpl implements ShipService {
	ShipDao shipDao;

	public ShipServiceImpl(ShipDao shipDao) {
		this.shipDao = shipDao;
	}

	@Override
	public void addShip(Ship ship) {
		shipDao.addShip(ship);

	}

	@Override
	public void removeShip(String shipName) {
		shipDao.removeShip(shipName);

	}

	@Override
	public void addSailorsToShip(List<Sailor> sailorList, String shipName) {
		shipDao.addSailorsToShip(shipName, sailorList);

	}

	@Override
	public void removeSailorsFromShip(List<Sailor> sailorList, String shipName) {
		shipDao.removeSailorsFromShip(shipName, sailorList);

	}

	@Override
	public void increaseLoadQuantity(String shipName, String loadName, Double quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException();
		}
		shipDao.increaseLoadQuantity(shipName, loadName, quantity);

	}

	@Override
	public void decreaseQuantity(String shipName, String loadName, Double quanity) {
		shipDao.decreaseLoadQuantity(shipName, loadName, quanity);

	}

	@Override
	public void addLoad(String shipName, Load load) {
		shipDao.addLoad(shipName, load);
	}

	@Override
	public void removeLoad(String shipName, String loadName) {
		shipDao.removeLoad(shipName, loadName);

	}

	@Override
	public Ship getShipByShipName(String shipName) {
		return shipDao.getShipByShipName(shipName);
	}

	@Override
	public void updateShip(String shipName) {
		shipDao.updateShip(shipName);

	}

}
