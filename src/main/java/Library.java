import java.util.HashMap;
import java.util.HashSet;

public class Library{

    public HashMap<String,Book> libraryBooks;
    public HashSet <String> uniqueGenre;

    public Library(){
        this.libraryBooks = new HashMap<String,Book>();
        this.uniqueGenre = new HashSet<String>();
    }
    
    public void add(String title, Book book)
    {
        this.libraryBooks.put(title, book);
        this.uniqueGenre.add(book.genre);
    }
    public Book getBook(String title)
    {
        return libraryBooks.get(title);
    }
}