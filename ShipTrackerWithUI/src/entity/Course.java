package entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course {
	private LinkedList<Port> course;

	public Course() {
		this.course = new LinkedList<Port>();

	}

	public List<Port> getCourse() {
		return course;
	}

	public void setCourse(Port port) {
		this.course.add(port);
	}

	public Port getNextPort() {
		return this.course.getFirst();
	}

	public String toString() {
		Queue<Port> printQueue = new LinkedList<Port>(course);
		StringBuilder courseTxt = new StringBuilder();

		for (int i = 0; i < printQueue.size(); i++) {
			String port = printQueue.poll().getName();
			courseTxt.append(port + "-");
		}

		return courseTxt.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		return true;
	}
}
