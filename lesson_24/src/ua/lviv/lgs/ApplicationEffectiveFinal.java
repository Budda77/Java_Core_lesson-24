package ua.lviv.lgs;

public class ApplicationEffectiveFinal {
	
	public void customMethod() {
		final String localVariable = "Local";
		
		CustomFnInterface ci = p->{
			// can not change because of effective final variable;
//			localVariable +=2;
			return localVariable;
		};
	}

}

@FunctionalInterface
interface CustomFnInterface{
	String test(String s);
}