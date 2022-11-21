import java.util.Arrays;
import java.util.Scanner;
public class denominations {

	public static void main(String[] args) {

		Sorting sort = new Sorting();
		NotesCount notesCount = new NotesCount();

		System.out.println("Enter the size of currency denominations :");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] notes = new int[size];
		System.out.println("Enter the currency denominations value :");
		for (int i = 0; i < size; i++) {
			notes[i] = in.nextInt();
		}
		System.out.println("Enter the amount you want to pay :");
		int amount = in.nextInt();
		sort.sort(notes,0,notes.length-1);
		notesCount.countNotes(notes, amount);
	}
}

class Sorting {
	void merge(int arr[], int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];
		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}


	public void sort(int[] notes, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(notes, left, mid);
			sort(notes, mid + 1, right);
			merge(notes, left, mid, right);
		}
	}
}

class NotesCount {
	public void countNotes(int notes[], int amount) {
		int[] noteCounter = new int[notes.length];
		try {
			for (int i = 0; i < notes.length; i++) {
				if (amount >= notes[i]) {
					noteCounter[i] = amount / notes[i];
					amount = amount - noteCounter[i] * notes[i];
				}
			}
			if (amount > 0) {
				System.out.println("Exact amount cannot be given with the highest denomination :");
			} else {
				System.out.println("Your payment approach in order to give min no of notes will be :");
				for (int i = 0; i < notes.length; i++) {
					if (noteCounter[i] != 0) {
						System.out.println(notes[i] + ":" + noteCounter[i]);
					}
				}
			}
		} catch (ArithmeticException e) {
			System.out.println(e+ " notes of denomination 0 is invalid");
		}
	}
}
class BubbleSort {
	 public void bubbleSort(int arr[]) {
		    int n = arr.length;
		    for (int i = 0; i < n-1; i++) {
		      for (int j =0; j < n-i-1; j++) {
		        if (arr[j] < arr[j+1]) {
		          int temp = arr[j];
		          arr[j] = arr[j+1];
		          arr[j+1] = temp;
		      }
		   }
		}
	}
}
