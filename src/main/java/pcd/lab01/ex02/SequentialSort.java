package pcd.lab01.ex02;

import java.util.*;

import static java.io.ObjectInputFilter.merge;

public class SequentialSort {

	static final int VECTOR_SIZE = 400_000_000;
	
	public static void main(String[] args) {
	
		log("Generating array...");
		var v = genArray(VECTOR_SIZE);
		
		log("Array generated.");
		log("Sorting (" + VECTOR_SIZE + " elements)...");


		Thread thread1 = new MyThread(v,0, VECTOR_SIZE/2);
		Thread thread2 = new MyThread(v,VECTOR_SIZE/2, VECTOR_SIZE);

		long t0 = System.nanoTime();
		Arrays.sort(v, 0, v.length);
		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<v.length;i++){
			System.out.println("Questo è l'"+i+"-esimo numero: "+v[i]);
		}

		long t1 = System.nanoTime();
		log("Done from main. Time elapsed: " + ((t1 - t0) / 1000000) + " ms");
		
		// dumpArray(v);
	}


	private static int[] genArray(int n) {
		Random gen = new Random(System.currentTimeMillis());
		var v = new int[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = gen.nextInt(25000);
		}
		return v;
	}

	private static void dumpArray(int[] v) {
		for (var l:  v) {
			System.out.print(l + " ");
		}
		System.out.println();
	}

	private static void log(String msg) {
		System.out.println(msg);
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int i = 0, j = 0, k = 0;
		int[] mergedArray = new int[arr1.length + arr2.length];

		// Confronta gli elementi dei due array e inseriscili nell'array risultante
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) { // Anche valori uguali vengono mantenuti
				mergedArray[k++] = arr1[i++];
			} else {
				mergedArray[k++] = arr2[j++];
			}
		}

		// Copia gli elementi rimanenti di arr1, se ce ne sono
		while (i < arr1.length) {
			mergedArray[k++] = arr1[i++];
		}

		// Copia gli elementi rimanenti di arr2, se ce ne sono
		while (j < arr2.length) {
			mergedArray[k++] = arr2[j++];
		}

		return mergedArray;
	}

}
