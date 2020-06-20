package club.banyuan.June19.books;

import club.banyuan.June19.books.Book;

public class EBbook extends Book {
    private int sizeMB;

    public int getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(int sizeMB) {
        this.sizeMB = sizeMB;
    }

    public EBbook(String title, double price,  int pages,int sizeMB) {
        super(title, price, 0, pages);
        this.sizeMB=sizeMB;
    }
}
