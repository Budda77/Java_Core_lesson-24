package ua.lviv.lgs.homeworkCinema;

import java.util.Iterator;
import java.util.List;

public interface Iterators {
	public boolean hasNext();
	public Object next();
}

class Collection<Schedule> implements Iterator<Schedule>{
	private static List<Seance> seance;
	private int count =0;

	Collection(List<Seance> seance){

		Collection.seance = seance;
	}

	@Override
	public boolean hasNext() {
		return count < seance.size();
	}

	@Override
	public Schedule next() {

		return (Schedule) seance.get(this.count++);
	}

	public void remove() {
		seance.remove(--count);
	}

}