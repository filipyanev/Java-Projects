package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MainController {
	@FXML
	private ImageView ship;

	public void move(ActionEvent event) {
		// ship.setX(0);
		// ship.setY(0);

		Coordinates coord = new Coordinates();
		coord.setX(53);
		coord.setY(214);
		

		ship.setX(coord.getX());
		ship.setY(coord.getY());
//		ship.setVisible(true);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					System.out.println(coord.getX() +" " + coord.getY());
					if (ship.getX() < 406 && ship.getY() < 220) {
						ship.setX(ship.getX() + 2);
						ship.setY(ship.getY() + 2);
					} if (ship.getX() > 406 && ship.getY() > 220) {
						ship.setX(ship.getX() - 2);
						ship.setY(ship.getY() - 2);
					} if (ship.getX() == 406 && ship.getY() > 220) {
						ship.setY(ship.getY() - 2);
					} if (ship.getX() == 406 && ship.getY() < 220) {
						ship.setY(ship.getY() + 2);
					}  if (ship.getX() < 406 && ship.getY() == 220) {
						ship.setX(ship.getX() + 2);
					}if (ship.getX() > 406 && ship.getY() == 220) {
						ship.setX(ship.getX() - 2);
					}
					coord.setX(ship.getX());
					  coord.setY(ship.getY());
					  if (ship.getX() == 405 && ship.getY() == 220) {
						  timer.cancel();
					  }
				});
			}
		}, 1 * 1 * 100, 1 * 1 * 100);

	}
}
