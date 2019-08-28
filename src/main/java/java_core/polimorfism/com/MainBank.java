package java_core.polimorfism.com;

public class MainBank
{

	public static void main(String[] args)
	{
		
		Bank def = new Bank_DEF();
		Bank abc = new Bank_ABC();
		Bank xyz = new Bank_XYZ();
		
		
		System.out.println(def.getInterestRate());
		System.out.println(abc.getInterestRate());
		System.out.println(xyz.getInterestRate());

	}

}
