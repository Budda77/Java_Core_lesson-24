package ua.lviv.lgs;

import java.util.function.Function;

public class ApplicationFnInterfaceBP {

	public static void main(String[] args) {
		
		useCustomInterface();
		avoidCustomInterface();

	}
	
	public static void useCustomInterface() {
		CustomInterfaceImpl ci = new CustomInterfaceImpl();
		CustomInterface customInterface = p -> p+" Hello world";
		String result = ci.useCustomMethod("Use CustomMethod ---->", customInterface);
		System.out.println(result);
	}
	
	public static void avoidCustomInterface() {
		CustomInterfaceImpl ci = new CustomInterfaceImpl();
		Function<String, String> customInterface = p -> p+" Hello world";
		String result = ci.avoidCustomInterface("Avoid CustomInterface ---->", customInterface);
		System.out.println(result);
	}

}

// useless, to be removed

@FunctionalInterface
interface CustomInterface {
	String customMethod(String string);
}

class CustomInterfaceImpl{
	public String useCustomMethod(String string, CustomInterface customInterface) {
		return customInterface.customMethod(string);
	}
	
	public String avoidCustomInterface(String string, Function<String, String> fn) {
		return fn.apply(string);
		
	}
	
	
}