import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;

public class Database
{
  public static void main (String[] args)
  {
    HashMap<Integer, Publication> publications = new HashMap<>();
    Scanner scnr = new Scanner(System.in);
    Scanner scnrLine = new Scanner(System.in);
    int input = 0;
    while(input != 5)
    {
      System.out.println("\nWhat would you like to do?\n");
      System.out.println("1 - Create a Publication");
      System.out.println("2 - Print Publication Information to File");
      System.out.println("3 - List All Publications");
      System.out.println("4 - Delete a publication.");
      System.out.println("5 - Quit\n");
      input = scnr.nextInt();

      switch (input)
      {
        case 1: // Creating a publication
        {
        boolean correct = false;
          while(!correct)
          {
            System.out.print("\nWhat type of publication is it? (Book, Journal, or EJournal)  ");
            String publication = scnr.next();

            if(publication.toLowerCase().equals("book"))
            {
              System.out.print("\nISBN: ");
              int ISBN = scnr.nextInt();
              System.out.print("\nTitle: ");
              String title = scnrLine.nextLine();
              System.out.print("\nPublisher: ");
              String publisher = scnrLine.nextLine();
              System.out.print("\nYear of Publication: ");
              int year = scnr.nextInt();
              System.out.print("\nAuthor: ");
              String author = scnrLine.nextLine();
              System.out.print("\nType of Binding (Hardcover or Paperback): ");
              String binding = scnr.next();
              while(!(binding.toLowerCase().equals("hardcover") || binding.toLowerCase().equals("paperback")))
              {
                System.out.print("\nPlease insert a valid binding type:  ");
                binding = scnr.next();
              }
              System.out.print("\nPages: ");
              int pages = scnr.nextInt();

              Book b = new Book(title, year, publisher, ISBN, author, binding, pages);
              publications.put(ISBN, b);
              correct = true;
            }

            else if(publication.toLowerCase().equals("journal"))
            {
              System.out.print("\nISBN: ");
              int ISBN = scnr.nextInt();
              System.out.print("\nTitle: ");
              String title = scnrLine.nextLine();
              System.out.print("\nPublisher: ");
              String publisher = scnrLine.nextLine();
              System.out.print("\nYear of Publication: ");
              int year = scnr.nextInt();
              System.out.print("\nEditor: ");
              String editor = scnrLine.nextLine();
              System.out.print("\nIssue Number: ");
              int issueNum = scnr.nextInt();

              Journal j = new Journal(title, year, publisher, ISBN, editor, issueNum);
              publications.put(ISBN, j);
              correct = true;
            }

            else if(publication.toLowerCase().equals("ejournal"))
            {
              System.out.print("\nISBN: ");
              int ISBN = scnr.nextInt();
              System.out.print("\nTitle: ");
              String title = scnrLine.nextLine();
              System.out.print("\nPublisher: ");
              String publisher = scnrLine.nextLine();
              System.out.print("\nYear of Publication: ");
              int year = scnr.nextInt();
              System.out.print("\nEditor: ");
              String editor = scnrLine.nextLine();
              System.out.print("\nIssue Number: ");
              int issueNum = scnr.nextInt();
              System.out.print("\nURL: ");
              String url = scnr.next();
              System.out.print("\nPublication Fee: ");
              int fee = scnr.nextInt();

              EJournal ej = new EJournal(title, year, publisher, ISBN, editor, issueNum, url, fee);
              publications.put(ISBN, ej);
              correct = true;
            }

            else
            {
              System.out.println("That is an invalid publication type.");
              continue;
            }
          }

          break;
        }

        case 2: // Printing a Publication to file
        {
          try
          {
            System.out.print("\nISBN of the Publication: ");
            int ISBN = scnr.nextInt();
            if(publications.containsKey(ISBN))
            {
              System.out.print("\nName of the File: ");
              String file = scnr.next();

              Publication p = publications.get(ISBN);
              p.print(file);
            }

            else
            {
              System.out.println("\n This ISBN does not exist in the database.");
            }
          }

          catch(IOException excpt)
          {
            System.out.println("Caught IOException: " + excpt.getMessage());
          }

          break;
        }

        case 3: // Listing all publications
        {
          ArrayList<Publication> publicationArray = new ArrayList<Publication>();
          ArrayList<Publication> publicationOrdered = new ArrayList<Publication>();
          ArrayList<Integer> indexes = new ArrayList<Integer>();

          for(int ISBN : publications.keySet())
          {
            publicationArray.add(publications.get(ISBN));
          }

          for(int i = 0; i < publicationArray.size(); i++)
          {
            int index = 0;
            for(int ISBN : publications.keySet())
            {
              Publication p = publications.get(ISBN);
              if(publicationArray.get(i).compareTo(p) == 1) {index++;}
            }

            indexes.add(index);
          }

          for(int i = 0; i < indexes.size(); i++)
          {
            publicationOrdered.add(indexes.get(i), publicationArray.get(i));
          }

          for(int i = 0; i < publicationOrdered.size(); i++)
          {
            Publication p = publicationOrdered.get(i);
            System.out.println("\nTitle: " + p.getTitle() + " | Year of Publication: " + p.getYear());
          }
          break;
        }

        case 4: // Deleting a publication
        {
          System.out.print("\nISBN of the Publication: ");
          int ISBN = scnr.nextInt();
          if(publications.containsKey(ISBN))
          {
            //Publication p = publications.get(ISBN);

            publications.remove(ISBN);
            System.out.println("\nDone.");
          }

          else
          {
            System.out.println("\n This ISBN does not exist in the database.");
          }
          break;
        }

        case 5:
        {
          System.out.println("\nGoodbye.");
          break;
        }

        default:
        {
          System.out.println("\nInvalid number. Please enter a number 1-5.");
          input = scnr.nextInt();
          break;
        }
      }
    }

    scnr.close();
    scnrLine.close();
  }
}
