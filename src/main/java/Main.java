import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Library lb = new Library();
        int choice = 0;

        do{
            try{
                System.out.println("Enter (1) to add a book, \n"+
                                   "(2) to look up a book\n"+
                                   "(3) to look up a genre: or -1 to exit: ");
                choice = input.nextInt();
        
                switch(choice)
                {
                    case 1:
                        addBookToLibrary(input, lb);
                        break;
                    case 2:
                        lookUpBookFromLibrary(input, lb);
                        break;
                    case 3:
                    lookUpGenreFromLibrary(input, lb);
                    break;
                    case -1:
                        System.out.print("Exiting Program");
                        break;
                    default:
                        System.out.println("Invalid number please try again");
                        break;
                }
            }catch (Exception e){
                System.out.print("Invalid entry please try again");
                System.exit(0);
                input.close();
            }
        }while(choice != -1);

         
        input.close();
    }

    private static void lookUpGenreFromLibrary(Scanner input, Library lb) {
        String genre;
        System.out.print("Please enter the genre of the book: ");
        genre = input.next();

        if(lb.uniqueGenre.contains(genre))
        {
            System.out.println("Yes we have " + genre + " books in the back!");
        }
        else
        {
            System.out.println("Sorry we do not have "+ genre +" at the moment.");
        }
    }

    public static void addBookToLibrary(Scanner input, Library lb)
    {
        String titleOfBook;
        String genreOfBook;
        int numberOfPages;
        
        try
        {
            input.nextLine();
            System.out.println("Please enter the title of the book:");
                titleOfBook = input.nextLine();
                System.out.println("Please enter the genre of the book:");
                genreOfBook = input.nextLine();
                System.out.println("Please enter the number of pages in the book:");
                numberOfPages = input.nextInt();

                Book bk = new Book(titleOfBook, genreOfBook, numberOfPages);
                lb.add(titleOfBook, bk);

            System.out.println("Book Added to library");    
        }
        catch(Exception e)
        {
            System.out.println("Sorry that was an invalid input, please try again");
        }
    }
    public static void lookUpBookFromLibrary(Scanner input, Library lb)
    {
        String titleOfBook;
        input.nextLine();
        System.out.print("Please enter the title of the book: ");
        titleOfBook = input.nextLine();

        if(lb.libraryBooks.containsKey(titleOfBook))
        {
            System.out.println("Yes we have " + titleOfBook + " in the back! Book info below: ");
            System.out.println(lb.getBook(titleOfBook).toString());
        }
        else
        {
            System.out.println("Sorry we do not have "+ titleOfBook +" at the moment.");
        }
    }
}