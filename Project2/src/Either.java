
public class Either 
{
	public static void main(String[] args)
	{
		System.out.println(new Human(null));
		System.out.println(new Human(new Weapon (null)));
		System.out.println(new Human(new Weapon(new Magazine(2))));
	}
}
