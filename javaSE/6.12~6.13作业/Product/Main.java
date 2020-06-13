class Main {
	public static void main(String[] args) {
		Product product1 = new Product("手机", 2001.00);
		System.out.println(product1.getinfo());
		System.out.println(product1.getNum());
		System.out.println(product1.buy(1));
	}
}