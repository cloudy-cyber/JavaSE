package club.banyuan.June19.books;

public class Book {
    private String title;
    private double price;//售价
    private double cost;//成本
    private int pages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    //获取利润
    public double Profit(){
        return price-cost;
    }

    public Book(String title,double price,double cost,int page){
        this.title=title;
        this.price=price;
        this.cost=cost;
        this.pages=page;
    }
}
