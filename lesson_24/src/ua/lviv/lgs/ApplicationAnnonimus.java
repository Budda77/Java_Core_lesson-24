package ua.lviv.lgs;

public class ApplicationAnnonimus {

	public static void main(String[] args) {
	
		CustomSecondInterface si = new CustomSecondInterface() {

			@Override
			public void test() {
				System.out.println("Custon Anonimus Interface");
				
			}		
		};
		
		si.test();
		
		// Lambda
		CustomSecondInterface sil = ()-> System.out.println("Custom Lambda impl");
		sil.test();
	}
}


@FunctionalInterface
interface CustomSecondInterface{
	void test();
}