
public class Runner 
{
	public static void main(String[] args)
	{
		Human h = new Human(null);
		
		
		
		Human human = new Human(new Weapon(new Magazine(10)));
		Either<Human> eitherHuman = Either.of(human);
		System.out.println(eitherHuman);
		Either<Human> eitherNull = Either.of(null);
		System.out.println(eitherNull);
	}
}
