package ua.lviv.lgs.homeworkCinema;

public class Seance implements Comparable<Seance>{
	
	private Movie movie;
	Time startTime;
	Time endTime;
	
	public Seance() {}

	public Seance(Movie movie, Time startTime) {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = endTime(startTime, movie.getDuration());
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
//	the method for calculating the endTime value 
	
	public Time endTime(Time start, Time duration) {
		int minResult = start.getMin()+duration.getMin();
		int hourResult = start.getHour()+ duration.getHour();
		if(minResult > 60) {
			hourResult = hourResult + 1;
			minResult = (start.getMin()+duration.getMin()) -60;
			return new Time(hourResult, minResult);
		}else if(minResult == 60) { 
			hourResult = hourResult + 2;
			minResult = 0;
			return new Time(hourResult, minResult);
		} else 
			return new Time(hourResult, minResult);
	}

	@Override
	public String toString() {
		 return "Seance [" + movie + ", start Seance=" + startTime + ", end Seance=" + endTime + "]\n";
	}
	
	@Override
	public int compareTo(Seance obj) {
		return this.movie.compareTo(obj.movie);
	}
	
}
