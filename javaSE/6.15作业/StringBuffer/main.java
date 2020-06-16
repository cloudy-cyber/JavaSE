class main {
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer();
		a.string1 = "12345678";
		System.out.println(a.string1);
		a.char1 = '9';
		System.out.println(a.char1);


		StringBuffer b = new StringBuffer();
		b.string1 = a.ToString();
		System.out.println(b.string1);

		System.out.println(b.reverse());

		System.out.println(b.reverse(1, 4));

	}
}