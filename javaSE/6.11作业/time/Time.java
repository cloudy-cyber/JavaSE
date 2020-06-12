class Time {
	int hour;
	int minute;
	int second;

	void setTime(int ahour, int aminute, int asecond) {
		hour = ahour;
		minute = aminute;
		second = asecond;
	}

	String timeToString() {
		String time = hour + ":" + minute + ":" + second;
		return time;
	}

	void nextSecond () {
		second++;
		if (second == 60) {
			second = 0;
			minute++;
			if (minute == 60) {
				minute = 0;
				hour++;
				if (hour == 24) {
					hour = 0;
					System.out.println("时间到了第二天。");
				}
			}
		}
	}
}