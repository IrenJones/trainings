package sort;

public class Student implements Comparable<Student> {
	int studentId;
	int year;

	public Student(int studentId, int year) {
		this.studentId = studentId;
		this.year = year;
	}

	@Override
	public String toString() {
		return studentId + "/" + year;
	}

	@Override
	public int compareTo(Student student) {
		int result = this.year - student.year;
		if (result != 0) {
			return result;
		} else {
			return this.studentId - student.studentId;
		}
	}
}