/// @file Journal.java
/// @brief - Defines Journal objects.
/// @author Tyler Edwards - tk.edwards2003@gmail.com

public class Journal extends Publication
{
  protected String m_editor;
  protected int m_issueNum;

  // default instance of Journal
  // @param N/A
  public Journal()
  {
    super();
    m_editor = null;
    m_issueNum = 0;
  }

  // standard instance of Journal
  // @param String, int, String, int, String, int
  public Journal(String t, int y, String m, int i, String e, int n)
  {
    super(t, y, m, i);
    m_editor = e;
    m_issueNum = n;
  }

  // copy another instance of Journal 
  // @param Journal
  public Journal(Journal j)
  {
    super(j.getTitle(), j.getYear(), j.getPublisher(), j.getISBN());
    m_editor = j.m_editor;
    m_issueNum = j.m_issueNum;
  }

  public String getEditor() {return m_editor;}
  public int getIssueNum() {return m_issueNum;}

  public void setEditor(String e) {m_editor = e;}
  public void setIssueNum(int n) {m_issueNum = n;}

  // Formats and creates a string that represents a given journal's values
  // @input N/A
  // @output String
  public String toString()
  {
    String s = "\nThis Journal:\n";
    s += super.toString();
    s += "Editor: " + m_editor + "\n";
    s += "Issue Number: " + m_issueNum + "\n";
    return s;
  }
}
