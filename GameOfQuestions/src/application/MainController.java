package application;

import java.io.IOException;
import java.sql.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
	static String user;
	static int counter = 0;
	static String rightAnswer;
	static Question newQuestion;
	static int sumRigntAns = 0;
	static int sumWrongAns = 0;
	@FXML
	private Button firstButton;
	@FXML
	private Label question;
	@FXML
	private Button but1;
	@FXML
	private Button but2;
	@FXML
	private Button but3;
	@FXML
	private Button but4;
	@FXML
	private Button but5;
	@FXML
	private Label ansLabel;
	@FXML
	private Label counterLabel;
	@FXML
	private TextField userName;

	public void setQuest(ActionEvent event) {
		counter++;
		// System.out.println(counter);
		counterLabel.setText("Question number: " + counter + " right: " + sumRigntAns + " wrong: " + sumWrongAns);
		Functions func = new Functions();
		newQuestion = func.getQuestion();
		// System.out.println(newQuestion);
		question.setText(newQuestion.getQuestionItSelf());
		but1.setText("A: " + newQuestion.getAns_1());
		but2.setText("B: " + newQuestion.getAns_2());
		but3.setText("C: " + newQuestion.getAns_3());
		but4.setText("D: " + newQuestion.getAns_4());
		rightAnswer = newQuestion.getRight_ans();
		but5.setDisable(true);
		but1.setDisable(false);
		but2.setDisable(false);
		but3.setDisable(false);
		but4.setDisable(false);
		ansLabel.setText("");

	}

	public void checkAnswer(ActionEvent event) {
		if (ansLabel.getText() != null) {
			if (ansLabel.getText().equals(rightAnswer)) {
				ansLabel.setText("Your answer is correct!");
				sumRigntAns++;
			} else {
				ansLabel.setText("You answer is wrong");
				sumWrongAns++;
			}
		} else {
			ansLabel.setText("");
		}
		counterLabel.setText("Question number: " + counter + " right: " + sumRigntAns + " wrong: " + sumWrongAns);
		question.setText("");
		but1.setText("A: ");
		but2.setText("B: ");
		but3.setText("C: ");
		but4.setText("D: ");
		but5.setDisable(true);
	}

	public void putScoreInDB(ActionEvent event) {
		Functions func = new Functions();
		func.setHighScore(user, sumRigntAns);
	}

	public void changeScreen(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;

		stage = new Stage();
		root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(firstButton.getScene().getWindow());
		stage.show();
		user = userName.getText();
		System.out.println(user);

	}

	public void setAnswer1(ActionEvent event) {
		ansLabel.setText(newQuestion.getAns_1());
		disable();
	}

	public void setAnswer2(ActionEvent event) {
		ansLabel.setText(newQuestion.getAns_2());
		disable();
	}

	public void setAnswer3(ActionEvent event) {
		ansLabel.setText(newQuestion.getAns_3());
		disable();
	}

	public void setAnswer4(ActionEvent event) {
		ansLabel.setText(newQuestion.getAns_4());
		disable();
	}

	public void disable() {
		but1.setDisable(true);
		but2.setDisable(true);
		but3.setDisable(true);
		but4.setDisable(true);
		but5.setDisable(false);
	}

}
