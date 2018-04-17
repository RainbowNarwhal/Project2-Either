import java.util.Optional;

public class Runner 
{
	public static void main(String[] args)
	{
		/*Human h = new Human(null);
				
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
		
		System.out.println();
		
		System.out.println(eitherHuman.flatMap(Human::getWeaponEither).flatMap(Weapon::getMagEither));
		*/
		
		//This is where the test code we were given starts
		System.out.println("\nOfficial Test code:\n_____________________________");
		Human noWeapon = new Human(null);
		Human noMag = new Human(new Weapon(null));
		Human hasAll = new Human(new Weapon(new Magazine(2)));
		
		Either<Human> noWeaponE = Either.of(noWeapon);
		Either<Human> noMagE = Either.of(noMag);
		Either<Human> hasAllE = Either.of(hasAll);
		
		System.out.println("\n.map test for 3 Humans:");
		System.out.println(noWeaponE.map(Human::getWeapon).map(Weapon::getMag).map(Magazine::getCount));
		System.out.println(noMagE.map(Human::getWeapon).map(Weapon::getMag).map(Magazine::getCount));
		System.out.println(hasAllE.map(Human::getWeapon).map(Weapon::getMag).map(Magazine::getCount));

		System.out.println("\n.flatMap test for 3 Humans:");
		System.out.println(noWeaponE.flatMap(Human::getWeaponEither).flatMap(Weapon::getMagEither).flatMap(Magazine::getCountEither));
		System.out.println(noMagE.flatMap(Human::getWeaponEither).flatMap(Weapon::getMagEither).flatMap(Magazine::getCountEither));
		System.out.println(hasAllE.flatMap(Human::getWeaponEither).flatMap(Weapon::getMagEither).flatMap(Magazine::getCountEither));

		
	}
}
