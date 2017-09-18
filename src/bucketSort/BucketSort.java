package bucketSort;

import java.util.ArrayList;

public class BucketSort {
	
	public static void bucketSort(double[] A) {
		//ArrayList<LinkedList<double>> b = new ArrayList<LinkedList<double>>();
		int n = A.length;
		
		ArrayList<Double>[] b = (ArrayList<Double>[])new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			b[i] = new ArrayList<Double>();
		}
		
		for(int i = 0; i < n; i++) {
			int bi = (int)(n * A[i]);
			(b[bi]).add(A[i]);
		}
		
		for(int i = 0; i < n; i++) {
			insertionSort(b[i]);
		}
		int k = 0;
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < b[i].size(); j++) {
				A[k] = b[i].get(j);
				k++;
			}
		}
	}
	
	
	public static void insertionSort(ArrayList<Double> A) {
		
		for(int j = 1; j < A.size(); j++) {
			double key = A.get(j);
			int i = j - 1;
			while(i >=0 && A.get(i) > key) {
				A.set(i + 1, A.get(i));
				i--;
			}
			A.set(i + 1, key);
		}
	}
	
	public static void main(String[] args) {
		
		double[] A = {0.78, 0.61, 0.91, 0.11, 0.18, 0.57};
		System.out.println("Unsorted Array: ");
		for(double ele: A) {
			System.out.print("\t" + ele);
		}
		bucketSort(A);
		System.out.println("\nSorted Array: ");
		for(double ele: A) {
			System.out.print("\t" + ele);
		}
	}
}
