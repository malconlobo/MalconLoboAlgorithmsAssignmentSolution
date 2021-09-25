package com.greatlearning.services;

public class StockServices {

	public void sortSharePrice(double[] sharePrice, boolean isAscending) {
		int left = 0;
		int right = sharePrice.length - 1;
		mergeSort(left, right, sharePrice);
		if (isAscending == true) {
			System.out.println("The stock prices in ascending order are:");
			for (int i = sharePrice.length - 1; i >= 0; i--) {
				System.out.print(sharePrice[i] + " ");
			}
		} else {
			System.out.println("The stock prices in descending order are:");
			for (int i = 0; i < sharePrice.length; i++) {
				System.out.print(sharePrice[i] + " ");
			}
		}
		System.out.println();
	}

	public void mergeSort(int left, int right, double[] sharePrice) {
		if (left < right) {

			int mid = (left + right) / 2;
			mergeSort(left, mid, sharePrice);
			mergeSort(mid + 1, right, sharePrice);
			merge(left, mid, right, sharePrice);
		}
	}

	public void merge(int left, int mid, int right, double[] sharePrice) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		double[] leftArray = new double[n1];
		double[] rightArray = new double[n2];

		for (int i = 0; i < n1; i++) {
			leftArray[i] = sharePrice[left + i];
		}

		for (int i = 0; i < n2; i++) {
			rightArray[i] = sharePrice[mid + 1 + i];
		}

		int i = 0, j = 0, k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				sharePrice[k] = leftArray[i];
				i++;
			} else {
				sharePrice[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			sharePrice[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			sharePrice[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public int count(boolean[] riseOrFall, String string) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < riseOrFall.length; i++) {
			if ((string.equals("fall") && riseOrFall[i] == false) || (string.equals("rise") && riseOrFall[i] == true)) {
				count++;
			}
		}
		return count;
	}

	public void search(double[] sharePrice, double key) {
		// TODO Auto-generated method stub
		for (int i = 0; i < sharePrice.length; i++) {
			if(sharePrice[i] == key) {
				System.out.println("Stock of value " + key + " is present");
				return;
			}
		}
		System.out.println("Stock of value " + key + " is not present");
	}

}
