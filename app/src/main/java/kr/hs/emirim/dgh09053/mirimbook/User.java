    package kr.hs.emirim.dgh09053.mirimbook;

    public class User {
        public int LibraryNum;
        public String Title;
        public String Series;
        public String Auther;
        public String BookNum;
        public String Publisher;

        public int getLibraryNum() {
            return LibraryNum;
        }

        public String getSeries() {
            return Series;
        }

        public String getAuther() {
            return Auther;
        }

        public String getBookNum() {
            return BookNum;
        }

        public String getPublisher() {
            return Publisher;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public void setPublisher(String publisher) {
            Publisher = publisher;
        }

        public void setLibraryNum(int libraryNum) {
            LibraryNum = libraryNum;
        }

        public void setBookNum(String bookNum) {
            BookNum = bookNum;
        }

        public void setAuther(String auther) {
            Auther = auther;
        }

        public void setSeries(String series) {
            Series = series;
        }
    }
