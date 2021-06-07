import java.io.*;
import java.util.Scanner;

public class Main {
    static String fileName = null;
    static LibraryBooks library = new LibraryBooks();
    static Scanner in = new Scanner(System.in);
    static Boolean running = true;
    static Librarian admin = new Librarian("Omar",18102532,"1111");
    static User demoUser =new User ("Balbaa",18102532);

    public static void main(String[] args) {
        while (running) {
            System.out.println("\nEnter 0 to load a library."
                    + "\nEnter 1 to add book to library"
                    + "\nEnter 2 to view all books in library"
                    + "\nEnter 3 to reserve a book to borrow"
                    + "\nEnter 4 for save and quit" );

            int answer = in.nextInt();

            switch (answer) {
                case 0 :
                    System.out.println("Enter the file name to load");
                    loadFile(in.next()); //MyStorage
                    break;
                case 1 :
                    addBook();
                    break;
                case 2 :
                    System.out.println(library.toString());
                    break;
                case 3:
                    reserveBook();
                    break;
                case 4 :
                    saveAndQuit();
                    break;
            }
        }
        System.exit(0);
    }

    private static void reserveBook() {
        Book b = null;
        System.out.println("\nEnter Title: ");
        String title = in.next();
        boolean bookExists = false;
        for (int i = 0; i < library.listOfBooks.size(); i++) {
            if (library.listOfBooks.get(i).getTitle().equals(title)){
                bookExists = true;
                b = library.listOfBooks.get(i);
            }
        }
        if (bookExists) {
            demoUser.requestBorrow(b);
        }
        else
            System.out.println("Unfortunately this Book does not exist!");
    }

    private static void addBook() {
        int isbn;
        String title, author, pass;

        System.out.println("\nEnter Title: ");
        title = in.next();

        System.out.println("\nEnter Author: ");
        author = in.next();

        System.out.println("\nEnter ISBN: ");
        isbn = in.nextInt();

        Book b = new Book(title, author, isbn);

        System.out.println("Enter your passcode");
        pass = in.next();
        if (admin.isLibrarian(pass))
            library.addBook(b);
        else
            System.out.println("Sorry! You are not allowed to do this.");
    }
    private static void loadFile(String name) {
    FileInputStream fis = null;
    ObjectInputStream in = null;
    File file = new File(name + ".ser");
		if (file.exists()) {
        try {
            fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);
            library = (LibraryBooks) in.readObject();
            fis.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    } else {
        System.out.println("\nThe file does not exist!");
    }
}
    private static void saveAndQuit() {
        System.out.println("Enter file name: ");
        fileName = in.next() + ".ser";
        running = false;
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(library);
            fos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
