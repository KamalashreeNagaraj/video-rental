package com.twu.refactor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {

    private static final String FILE_SOURCE_DIRECTORY_PATH = "test/data";

    private Customer dinsdale = new Customer("Dinsdale Pirhana");

    private Movie python = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
    private Movie ran = new Movie("Ran", Movie.REGULAR);
    private Movie la = new Movie("LA Confidential", Movie.NEW_RELEASE);
    private Movie trek = new Movie("Star Trek 13.2", Movie.NEW_RELEASE);
    private Movie wallace = new Movie("Wallace and Gromit", Movie.CHILDREN);

    public void setUp() {
        dinsdale.addRental(new Rental(python, 3));
        dinsdale.addRental(new Rental(ran, 1));
        dinsdale.addRental(new Rental(la, 2));
        dinsdale.addRental(new Rental(trek, 1));
        dinsdale.addRental(new Rental(wallace, 6));
    }

    public void testEmpty() throws Exception {
        dinsdale = new Customer("Dinsdale Pirhana");
        equalsFile("outputEmpty", dinsdale.statement());
    }

    public void testCustomer() throws Exception {
        equalsFile("output1", dinsdale.statement());
    }

    public void testChange() throws Exception {
        la.setPriceCode(Movie.REGULAR);
        equalsFile("outputChange", dinsdale.statement());
    }

    /*
    public void testHtml() throws Exception {
        equalsFile("1st Output", "outputHtml", dinsdale.htmlStatement());
    }
    */

    private void equalsFile(String fileName, String actualValue) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(FILE_SOURCE_DIRECTORY_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        String thisFileLine;
        while ((thisFileLine = file.readLine()) != null) {
            assertEquals("in file: " + fileName, thisFileLine, actualStream.readLine());
        }
    }

}
