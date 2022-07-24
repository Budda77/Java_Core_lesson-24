package ua.lviv.lgs.homeworkCinema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Schedule {
	
	List<Seance> seance = new ArrayList<>();
	Seance s = new Seance();
	Time startTimeHour;
	Time endTime = new Time(0,0);
	
	public Schedule() {} 
	
	public Schedule(List<Seance> seance) {
	super();
	this.seance = seance;
}

//	method to fill certain seances for a day
	
	public Schedule addSomeSeance(int count) {
		startTimeHour = new Time(0,0);
		int sessions = 1;
		while(sessions <= count) {
			startTimeHour = getTime(endTime);
			if(endTime.getHour() <=22) {
				s= new Seance(addMovie(getRandom(0,12)), startTimeHour);
				seance.add(s);
				endTime = s.getEndTime();			
			}	
			sessions++;	
		}
		return  new Schedule(seance);
	}
	
//	method to fill seances for whole day
	
	public Schedule addSeancesForDay() {
		startTimeHour = new Time(0,0);
		
		while(endTime.getHour() <= 22) {
			startTimeHour = getTime(endTime);
			s= new Seance(addMovie(getRandom(0,12)), startTimeHour);
			seance.add(s);
			endTime = s.getEndTime();
		}			 
		return new Schedule(seance);
	}
	
	public void removeSeance(int hour) {

		//	use custom Iterator to iterate Values through TreeMap
		Iterator iterators =  new Collection(seance);

		while(iterators.hasNext()) {
			Seance next = (Seance) iterators.next();
			if(next.getStartTime().getHour() == hour) {
				iterators.remove();
			}
		}		
	}
	
	@Override
	public String toString() {
		return "Schedule:\n [" + seance + "]\n";
	}
		
	// Auxiliary methods
	
	public int getRandom(int min, int max) {		
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
	
	public Movie addMovie(int id) {

		List<Movie> moviesLibrary = new ArrayList<>();
		moviesLibrary.add(new Movie("Lolita", new Time(1,30)));
		moviesLibrary.add(new Movie("Dune", new Time(2,30)));
		moviesLibrary.add(new Movie("The Father", new Time(1,50)));
		moviesLibrary.add(new Movie("Free Guy", new Time(1,40)));
		moviesLibrary.add(new Movie("Cruella", new Time(1,10)));
		moviesLibrary.add(new Movie("Minary", new Time(1,30)));
		moviesLibrary.add(new Movie("Our Friend", new Time(1,50)));
		moviesLibrary.add(new Movie("Avatar", new Time(2,10)));
		moviesLibrary.add(new Movie("Spider-Man", new Time(1,50)));
		moviesLibrary.add(new Movie("Parasite", new Time(1,30)));
		moviesLibrary.add(new Movie("Joker", new Time(2,5)));
		moviesLibrary.add(new Movie("First Man", new Time(1,20)));
		moviesLibrary.add(new Movie("Terminator", new Time(2,20)));
	
             Movie mov = moviesLibrary.get(id);
		return  mov;
	}
	
	// the method that calculate the start of Seance
	
	public Time getTime(Time durationTime) {
	
		if(startTimeHour.getHour() == 0 && startTimeHour.getMin() == 0) {
			startTimeHour = new Time(9,00);
		}else { 
			startTimeHour = durationTime;			
		}
		return startTimeHour;
	}
	
}
