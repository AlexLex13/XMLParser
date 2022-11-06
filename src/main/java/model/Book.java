package model;

import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private  int number_of_pages;
    private String publishing_house;
    private  int circulation;
    private  int year_of_publication;

    public Book(String author, String title, int number_of_pages, String publishing_house, int circulation, int year_of_publication) {
        this.author = author;
        this.title = title;
        this.number_of_pages = number_of_pages;
        this.publishing_house = publishing_house;
        this.circulation = circulation;
        this.year_of_publication = year_of_publication;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getPublishing_house() {
        return publishing_house;
    }

    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getNumber_of_pages() == book.getNumber_of_pages() &&
                getCirculation() == book.getCirculation() &&
                getYear_of_publication() == book.getYear_of_publication() &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getPublishing_house(), book.getPublishing_house());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle(), getNumber_of_pages(), getPublishing_house(), getCirculation(), getYear_of_publication());
    }

    @Override
    public String toString() {
        return "\nBook{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", number_of_pages=" + number_of_pages +
                ", publishing_house='" + publishing_house + '\'' +
                ", circulation=" + circulation +
                ", year_of_publication=" + year_of_publication +
                '}';
    }
}
