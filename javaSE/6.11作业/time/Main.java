class Main {
	public static void main(String[] args) {
		Time time = new Time();


		time.setTime(23, 59, 59);
		time.nextSecond();

		System.out.println(time.timeToString());
	}
}