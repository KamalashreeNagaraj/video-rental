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
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			double rentalAmount = rental.getRentalAmount();

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if (rental.isApplicableForBonusFrequentRenterPoints())
				frequentRenterPoints++;

			// show figures for this rental
			result += rental.getRentalStatement(rentalAmount);
			totalAmount += rentalAmount;

		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}
}
