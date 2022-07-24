package ua.lviv.lgs;

@FunctionalInterface
public interface ApplicationDefaultMethod extends CustomInterfaceOne, CustomInterfaceTwo{

	@Override
	default void regularDefaultMethod() {
		CustomInterfaceOne.super.regularDefaultMethod();
	}

}

@FunctionalInterface
interface CustomInterfaceOne {
	String customMethod();
	
	default void regularDefaultMethod() {
		System.out.println("Hi");
	}
}

@FunctionalInterface
interface CustomInterfaceTwo {
	String customMethod();
	
	default void regularDefaultMethod() {
		System.out.println("Bye");
	}
}


