import java.io.Serializable;

public class Book implements Serializable {
    private String title;

    public String getTitle() {
        return title;
    }

    private int isbn;
    private String author;

    public Book (){
        isbn = 0;
        title = null;
        author = null;
    }
    public Book (String title, String author, int isbn){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    @Override
    public String toString (){
        return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\n";
    }
}
