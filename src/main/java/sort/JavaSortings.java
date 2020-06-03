package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaSortings {

	public static void main(String[] args) {
		Student[] a = new Student[5];
		a[0] = new Student(75, 2016);
		a[1] = new Student(52, 2019);
		a[2] = new Student(57, 2016);
		a[3] = new Student(220, 2014);
		a[4] = new Student(16, 2018);
		Arrays.sort(a);

		System.out.println(Arrays.toString(a));

		a = new Student[5];
		a[0] = new Student(75, 2016);
		a[1] = new Student(52, 2019);
		a[2] = new Student(57, 2016);
		a[3] = new Student(220, 2014);
		a[4] = new Student(16, 2018);
		Comparator<Student> comparator = new SortById();
		Arrays.sort(a, comparator);

		System.out.println(Arrays.toString(a));
	}

	public void mergesort(int[] arr, int left, int right){
		while(left < right){
			int mid = (right + left)/2;
			mergesort(arr, left, mid);
			mergesort(arr, mid + 1, right);
			mergeStage(arr, left, right, mid);
		}
	}

	private void mergeStage(int[] arr, int left, int right, int mid) {
		int leftSize = mid - left + 1;
		int rightSize = right - mid;
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
		for(int i = 0; i< leftSize; i++){
			leftArray[i] = arr[left + i];
		}
		for(int i = 0; i< rightSize; i++){
			rightArray[i] = arr[mid + 1 + i];
		}
		int i = 0, j = 0;
		int index = left;
		while(i < leftSize && j < rightSize){
			if(leftArray[i] > rightArray[j]){
				arr[index] = rightArray[j];
				j++;
			} else{
				arr[index] = leftArray[i];
				i++;
			}
			index++;
		}

		while(i < leftSize){
			arr[index] = leftArray[i];
			i++;
			index++;
		}

		while(j < rightSize){
			arr[index] = rightArray[j];
			j++;
			index++;
		}
	}
}
