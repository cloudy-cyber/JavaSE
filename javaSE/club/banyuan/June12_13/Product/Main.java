package club.banyuan.June12_13.Product;

public  class Main {
    public static void main(String[] args) {
        Product product1 = new Product("手机", 2001.00);
        product1.setNum(10);
        System.out.println(product1.getInfo());
        System.out.println(product1.getNum());
        System.out.println(product1.buy(1));
    }
}
