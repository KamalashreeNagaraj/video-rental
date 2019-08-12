package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";

		totalAmount = getTotalRentalAmount();
		frequentRenterPoints = getFrequentRenterPoints();
		result += getRentalStatement();

		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}

	private double getTotalRentalAmount() {
		double amount = 0;
		for (Rental rental: rentalList) {
			amount += rental.getRentalAmount();
		}
		return amount;
	}

	private int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental: rentalList) {
			frequentRenterPoints += rental.frequentRentalPoints();
		}
		return frequentRenterPoints;
	}

	private String getRentalStatement() {
		String statement = "";
		for (Rental rental: rentalList) {
			statement += rental.getStatement();
		}
		return statement;
	}
}
