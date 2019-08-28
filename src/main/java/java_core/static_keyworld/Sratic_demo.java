package java_core.static_keyworld;

public class Sratic_demo
{

	public static void main(String[] args)
	{
		// Static members belong to the class instead of a specific instance.
		
		Hello hello_0 = new Hello();
		Hello hello_1 = new Hello();
		Hello hello_2 = new Hello();
		
		hello_0.DoSomething("Hello Youtube");  // Not correct way of calling static method 
		hello_1.DoSomethingElse("Right way of calling");  // Correct way of calling non static method
		Hello.DoSomething("Right wey of calling"); // Correct way of calling method

	}

}
