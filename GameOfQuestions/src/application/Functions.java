package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Functions {
	static int index;
	static int[] indexArray = { 1, 2, 3 };

	public Question getQuestion() {
		Question currQuestion = null;
		try {
			Connection connection = makeConnection();
			java.sql.Statement st = connection.createStatement();
			String query = "SELECT * FROM question";
			ResultSet rs = st.executeQuery(query);

			index = checkQuestions();

			while (rs.next()) {
				int questionId = rs.getInt("question_id");
				String queItSelf = rs.getString("question");
				String answer1 = rs.getString("answer_1");
				String answer2 = rs.getString("answer_2");
				String answer3 = rs.getString("answer_3");
				String answer4 = rs.getString("answer_4");
				String rightAns = rs.getString("right_ans");
				Question question = new Question(queItSelf, answer1, answer2, answer3, answer4, rightAns);

				if (questionId == index) {
					currQuestion = question;

				} else {
					continue;
				}
			}
			st.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return currQuestion;
	}

	public int checkQuestions() {
		int number = 0;
		for (int i = 0; i < indexArray.length; i++) {
			number = indexArray[i];
			if (number != 0) {
				indexArray[i] = 0;
				break;
			}
		}
		return number;
	}

	public Connection makeConnection() {

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/questions_gamedb";
			String username = "root";
			String password = "1234";
			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void setHighScore(String str, int score) {
		// Functions func = new Functions();
		try {

			Connection connection = makeConnection();
			java.sql.Statement st = connection.createStatement();

			String query = "INSERT INTO highscore (user, points) VALUES(?,?)";

			java.sql.PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, str);
			preparedStmt.setInt(2, score);
			preparedStmt.execute();
			st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
