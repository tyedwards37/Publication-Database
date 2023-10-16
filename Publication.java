/// @file Publication.java
/// @brief - Defines Publication objects that get inherited for other objects.
/// @author Tyler Edwards - tk.edwards2003@gmail.com

import java.io.FileWriter;
import java.io.IOException;

public abstract class Publication implements Printable, Comparable<Publication>
{
  protected String m_title;
  protected int m_year;
  protected String m_publisher;
  protected int m_ISBN;

  // default instance of Publication
  // @param N/A
  public Publication()
  {
    m_title = null;
    m_year = 0;
    m_publisher = null;
    m_ISBN = 0;
  }

  // standard instance of Publication
  // @param String, int, String, int
  public Publication(String t, int y, String m, int i)
  {
    m_title = t;
    m_year = y;
    m_publisher = m;
    m_ISBN = i;
  }

  // copy another instance of Publication
  // @param Publication
  public Publication(Publication p)
  {
    m_title = p.m_title;
    m_year = p.m_year;
    m_publisher = p.m_publisher;
    m_ISBN = p.m_ISBN;
  }

  public String getTitle() {return m_title;}
  public int getYear() {return m_year;}
  public String getPublisher() {return m_publisher;}
  public int getISBN() {return m_ISBN;}

  public void setTitle(String t) {m_title = t;}
  public void setYear(int y) {m_year = y;}
  public void setPublisher(String p) {m_publisher = p;}
  public void setISBN(int i) {m_ISBN = i;}

  // Prints to a file
  // @input String
  // @output N/A
  public void print(String fileName) throws IOException
  {
    FileWriter fileWriter = null;
    try
    {
      System.out.println("Creating file " + fileName + ".");
      fileWriter = new FileWriter(fileName);

       fileWriter.write(this.toString());
    }

    catch(IOException excpt)
    {
      System.out.println("Caught IOException: " + excpt.getMessage());
    }

    finally
    {
      fileWriter.close();
      System.out.println("Closing the file.");
    }
  }

  // Compares two publicatino to see if they're the same 
  // @input Publication
  // @output int
  public int compareTo(Publication p)
  {
    int i = 0;
    if(getYear() > p.getYear()) {i = 1;}
    else if(getYear() < p.getYear()) {i = -1;}
    return i;
  }

  // Formats and creates a string that represents a given publication's values
  // @input N/A
  // @output String
  public String toString()
  {
    String s = "";
    s += "Title: " + m_title + "\n";
    s += "Year: " + m_year + "\n";
    s += "Publisher: " + m_publisher + "\n";
    s += "ISBN: " + m_ISBN + "\n";
    return s;
  }
}
