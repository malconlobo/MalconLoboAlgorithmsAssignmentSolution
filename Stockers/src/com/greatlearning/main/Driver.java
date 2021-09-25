package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.services.StockServices;

public class Driver {

	public static void main(String[] args) {
		int noOfCompanies;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the no of companies");
		noOfCompanies = sc.nextInt();
		double[] sharePrice = new double[noOfCompanies];
		boolean[] riseOrFall = new boolean[noOfCompanies];

		for (int i = 0; i < noOfCompanies; i++) {
			System.out.println("Please enter the share price of company " + (i + 1));
			sharePrice[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			riseOrFall[i] = sc.nextBoolean();
		}
		
		int choice = 0;
		StockServices service = new StockServices();

		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("-----------------------------------------------");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				choice = 0;
				System.out.println("Thanks for using our application!");
				break;

			case 1:
				service.sortSharePrice(sharePrice,true);
				break;

			case 2:
				service.sortSharePrice(sharePrice,false);
				break;

			case 3:
				System.out.println("Total no of companies whose stock price rose today : " + service.count(riseOrFall, "rise"));
				break;
				
			case 4:
				System.out.println("Total no of companies whose stock price declined today : " + service.count(riseOrFall, "fall"));
				break;
				
			case 5:
				System.out.println("Enter the key value");
				double key = sc.nextDouble();
				service.search(sharePrice,key);
				break;
			}
		} while (choice != 0);

		sc.close();
	}

}
