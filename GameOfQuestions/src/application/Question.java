package application;

public class Question {
	private String questionItSelf;
	private String ans_1;
	private String ans_2;
	private String ans_3;
	private String ans_4;
	private String right_ans;

	public Question(String que, String ans_1, String ans_2, String ans_3, String ans_4, String right_ans) {
		this.questionItSelf = que;
		this.ans_1 = ans_1;
		this.ans_2 = ans_2;
		this.ans_3 = ans_3;
		this.ans_4 = ans_4;
		this.right_ans = right_ans;
	}

	public String getQuestionItSelf() {
		return questionItSelf;
	}

	public void setQuestionItSelf(String questionItSelf) {
		this.questionItSelf = questionItSelf;
	}

	public String getAns_1() {
		return ans_1;
	}

	public void setAns_1(String ans_1) {
		this.ans_1 = ans_1;
	}

	public String getAns_2() {
		return ans_2;
	}

	public void setAns_2(String ans_2) {
		this.ans_2 = ans_2;
	}

	public String getAns_3() {
		return ans_3;
	}

	public void setAns_3(String ans_3) {
		this.ans_3 = ans_3;
	}

	public String getAns_4() {
		return ans_4;
	}

	public void setAns_4(String ans_4) {
		this.ans_4 = ans_4;
	}

	public String getRight_ans() {
		return right_ans;
	}

	public void setRight_ans(String right_ans) {
		this.right_ans = right_ans;
	}
	@Override
 public String toString(){
	 return questionItSelf + " " + right_ans;
 }
}
