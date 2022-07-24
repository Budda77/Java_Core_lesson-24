package ua.lviv.lgs.homeworkCinema;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Cinema {

	TreeMap<Days,Schedule> shedules = new TreeMap<>();
	
	public void addSeance(String day, int count) {

		Days d = Days.valueOf(day);
		shedules.put(d, new Schedule().addSomeSeance(count));

	}

	public void addSeancesForDay( int i) {
		try {
			Days d = Days.values()[i];
			shedules.put(d, new Schedule().addSeancesForDay());

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Enter a number from 0 to 7");
		}
	}
		
	public void removeSession(String day, int count) {
		Days d = Days.valueOf(day);

		Iterator<Entry<Days,Schedule>> iterator = shedules.entrySet().iterator();
		while(iterator.hasNext()) {

			Entry<Days,Schedule> next = iterator.next();
			if(next.getKey().equals(d)) {

				Schedule values = next.getValue();
				values.removeSeance(count);
			}		
		}	
	}
		
	
//	use stream to remove Key in TreeMap

	public void removeScheduleForDay(String day) {
		Days d = Days.valueOf(day);	
		shedules.keySet().removeIf(e->(e ==d));
		
		// old method:
		
//		Iterator<Entry<Days,Schedule>> iterator = shedules.entrySet().iterator();
//		while(iterator.hasNext()) {
//			Entry<Days,Schedule> next = iterator.next();
//			if(next.getKey().equals(d)) {
//				iterator.remove();
//				System.out.println(shedules);	
//			}
//		}	
	}
		
	public void showSchedyle() {	
		for(Map.Entry<Days,Schedule> entry: shedules.entrySet()) {
			Days key = entry.getKey();
			Schedule values = entry.getValue();
			System.out.println("Day: " + key);
			System.out.println("Seances: " + values);

		}
	}
	
	public void showSchedyle2() {
		for (Entry<Days,Schedule> entry : shedules.entrySet()) {
			System.out.println(entry.getKey() + " ----> " );
			System.out.println(entry.getValue());
		}
	}
	
	//Stream methods
	
	public void presentSeance() {
		
		shedules.entrySet().stream().forEach(
				entry -> System.out.println(entry.getKey() + "" + entry.getValue()));
	}
			
	public void present() {
//One
		shedules.keySet().stream()	
		.forEach(System.out::println);
//Two
		Stream.of(shedules.entrySet().toString())
		.forEach(System.out::println);
//Three
		Stream.of(shedules.values().toArray())
		.forEach(System.out::println);
//Four
		Stream.of(shedules.values().toString())
		.forEach(System.out::println);
//Five
		System.out.println(shedules.values().toString());
	}

}
