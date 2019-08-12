package com.twu.refactor;

import java.util.ArrayList;

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
		String result = getStatementHeader();
		result += getStatementBody();
		result += getStatementFooter();
		return result;
	}

	public String getStatementHeader() {
		return "Rental Record for " + getName() + "\n";
	}

	public String getStatementFooter() {
		String result = "Amount owed is " + calculateTotalRentalAmount() + "\n";
		result += "You earned " + calculateFrequentRenterPoints() + " frequent renter points";
		return result;
	}

	private double calculateTotalRentalAmount() {
		double amount = 0;
		for (Rental rental: rentalList) {
			amount += rental.getRentalAmount();
		}
		return amount;
	}

	private int calculateFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental: rentalList) {
			frequentRenterPoints += rental.frequentRentalPoints();
		}
		return frequentRenterPoints;
	}

	private String getStatementBody() {
		StringBuilder statement = new StringBuilder();
		for (Rental rental: rentalList) {
			statement.append(rental.getStatement());
		}
		return statement.toString();
	}
}
