/// @file EJournal.java
/// @brief - Defines Ejournal objects.
/// @author Tyler Edwards - tk.edwards2003@gmail.com

public class EJournal extends Journal
{
  protected String m_URL;
  protected double m_fee;

  // default instance of EJournal
  // @param N/A
  public EJournal()
  {
    super();
    m_URL = null;
    m_fee = 0.0;
  }

  // standard instance of EJournal
  // @param String, int, String, int, String, int, String, double
  public EJournal(String t, int y, String m, int i, String e, int n, String u, double f)
  {
    super(t, y, m, i, e, n);
    m_URL = u;
    m_fee = f;
  }

  // copy another instance of EJournal
  // @param EJournal
  public EJournal(EJournal e)
  {
    super(e.getTitle(), e.getYear(), e.getPublisher(), e.getISBN(), e.getEditor(), e.getIssueNum());
    m_URL = e.m_URL;
    m_fee = e.m_fee;
  }

  public String getURL() {return m_URL;}
  public double getFee() {return m_fee;}

  public void setURL(String u) {m_URL = u;}
  public void setFee(double f) {m_fee = f;}

  // Formats and creates a string that represents a given ejournal's values
  // @input N/A
  // @output String
  public String toString()
  {
    String s = "\nThis EJournal:\n";
    s += "URL: " + m_URL + "\n";
    s += "Publication Fee: " + m_fee + "\n";
    s += super.toString();
    return s;
  }
}
