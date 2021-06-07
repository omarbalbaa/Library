import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User extends Account implements Serializable {
    int borrowedBooksNo = 0;
    private List<Book> borrowedBooks = new ArrayList<Book>();
    public User(String name, int id) {
        super(name, id);
    }

    public void requestBorrow(Book book){
        if (borrowedBooksNo == 0){
            borrowedBooks.add(book);
            borrowedBooksNo ++;
            System.out.println("Your request received successfully!");
        }
        else {
            System.out.println("You have a borrowed book or a pending request!");
        }
    }

}
