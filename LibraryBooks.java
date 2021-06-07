import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LibraryBooks implements Serializable {
    public List<Book> listOfBooks;

    public LibraryBooks(){
        listOfBooks = new ArrayList<Book>();
    }

    public void addBook(Book book){
        listOfBooks.add(book);
    }

    @Override
    public String toString (){
        String allBooks = "\n";
        for (int i=0; i<listOfBooks.size() ; i++){
            Book b = listOfBooks.get(i);
            allBooks = allBooks + b.toString();
        }
        return allBooks;
    }
}
