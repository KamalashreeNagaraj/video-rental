package com.twu.refactor;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getRentalAmount() {
        return movie.getRentalCharge(this.daysRented);
    }

    public boolean isApplicableForBonusFrequentRenterPoints() {
        return movie.getPriceCode() == Movie.NEW_RELEASE
                && getDaysRented() > 1;
    }

    public String getStatement() {
        return "\t" + movie.getTitle() + "\t" + getRentalAmount() + "\n";
    }

    public int frequentRentalPoints() {
        return isApplicableForBonusFrequentRenterPoints() ? 2 : 1;
    }
}