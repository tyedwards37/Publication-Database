/// @file Book.java
/// @brief - Defines Book objects.
/// @author Tyler Edwards - tk.edwards2003@gmail.com

public class Book extends Publication
{
  protected String m_author;
  protected String m_binding;
  protected int m_pages;

  // default instance of Book 
  // @param N/A
  public Book()
  {
    super();
    m_author = null;
    m_binding = null;
    m_pages = 0;
  }

  // standard instance of Book 
  // @param String, int, String, int, String, String, int
  public Book(String t, int y, String m, int i, String a, String b, int p)
  {
    super(t, y, m, i);
    m_author = a;
    m_binding = b;
    m_pages = p;
  }
  
  // copy another instance of Book 
  // @param Book
  public Book(Book b)
  {
    super(b.getTitle(), b.getYear(), b.getPublisher(), b.getISBN());
    m_author = b.m_author;
    m_binding = b.m_binding;
    m_pages = b.m_pages;
  }

  public String getAuthor() {return m_author;} 
  public String getBinding() {return m_binding;}
  public int getPages() {return m_pages;}

  public void setAuthor(String a) {m_author = a;}
  public void setBinding(String b) {m_binding = b;}
  public void setPages(int p) {m_pages = p;}

  // Formats and creates a string that represents a given book's values
  // @input N/A
  // @output String
  public String toString()
  {
    String s = "\nThis Book:\n";
    s += super.toString();
    s += "Author: " + m_author + "\n";
    s += "Binding: " + m_binding + "\n";
    s += "Pages: " + m_pages + "\n";
    return s;
  }
}
