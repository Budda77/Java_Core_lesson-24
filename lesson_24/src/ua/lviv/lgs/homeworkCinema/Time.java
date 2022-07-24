package ua.lviv.lgs.homeworkCinema;

public class Time implements Comparable <Time> {
	private int hour;
	private int min;

	
	public Time() {
	}
	
	public Time( int hour,int min) {
		super();

		this.hour = hour;
		this.min = min;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " [" + hour + ":" + min + "]";
		//return "Time [hour=" + hour + ", min=" + min + "]";
	}

	@Override
	public int compareTo(Time o) {
		
		return this.getHour()-o.getHour();
	}
	
	

}
