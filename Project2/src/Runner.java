import java.util.Optional;

public class Runner 
{
	public static void main(String[] args)
	{
		Human h = new Human(null);
		
		
		
		Human human = new Human(new Weapon(null));
		Human humanNoWep = new Human(null);
		Either<Human> eitherHuman = Either.of(human);
		System.out.println(eitherHuman);
		Either<Human> eitherNull = Either.of(null);
		System.out.println(eitherNull);
		Either<Human> eitherNoWep = Either.of(humanNoWep);
		
		Optional<Human> optionalHuman = Optional.of(human);
		System.out.println(optionalHuman);
//		Optional<Human> optionalNull = Optional.of(null);
//		System.out.println(optionalNull);
		
		System.out.println();
		
		System.out.println(human.getWeapon());
		System.out.println(eitherHuman.map(Human::getWeapon).map(Weapon::getMag).map(Magazine::getCount));
		System.out.println(humanNoWep.getWeapon());
		System.out.println(eitherNoWep.map(Human::getWeapon));
		
	}
}
