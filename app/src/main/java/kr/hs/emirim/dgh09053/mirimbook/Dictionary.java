package kr.hs.emirim.dgh09053.mirimbook;

public class Dictionary {
    private String Title;
    private String Author;
    private String BookNum;

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getBookNum() {
        return BookNum;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setBookNum(String bookNum) {
        BookNum = bookNum;
    }

    public Dictionary(String title, String author, String bookNum) {
        Title = title;
        Author = author;
        BookNum = bookNum;
    }
}
