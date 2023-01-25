package iteratorsAndComparators.lab.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        setAuthors(authors);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return this.year;
    }
    public void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }
    public List<String> getAuthors() {
        return this.authors;
    }
}
