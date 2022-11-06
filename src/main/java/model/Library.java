package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBook() {
        return books;
    }

    public void setBook(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" + books + '}';
    }

    public int sumOfCirculation() {
        int circulation = 0;
        for (var book: this.books ) {
            circulation += book.getCirculation();
        }
        return circulation;
    }

    public String getMaxNumberOfPages(){
        int number_of_pages=0;
        Book result = null;
        for (var book: this.books) {
            if (book.getNumber_of_pages() > number_of_pages) {
                number_of_pages = book.getNumber_of_pages();
                result = book;
            }
        }
        return result.getTitle();
    }

    public String getEarliestYearOfPublication(){
        int year_of_publication= Calendar.getInstance().get(Calendar.YEAR);
        Book result = null;
        for (var book: this.books) {
            if (book.getYear_of_publication() < year_of_publication) {
                year_of_publication = book.getYear_of_publication();
                result = book;
            }
        }
        return result.getTitle();
    }

    public int countOfBooks(){
        return this.books.size();
    }
}
