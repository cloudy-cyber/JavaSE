package club.banyuan.June19.books;

import club.banyuan.June19.books.Book;

public class PaperBook extends Book {
    private double weightG;

    public PaperBook(String title, double price, double cost, int page,double weightG) {
        super(title, price, cost, page);
        this.weightG=weightG;
    }

//    @Override
//    public double Profit() {
//        return super.Profit();
//    }
}
