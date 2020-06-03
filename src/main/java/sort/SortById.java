package sort;

import java.util.Comparator;

public class SortById implements Comparator<Student> {
	public int compare(Student a, Student b) {
		return a.studentId - b.studentId;
	}
}
