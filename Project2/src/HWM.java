/**
 * This has all of the classes needed for a human to have a weapon with a magazine and a count	
 * @author km1473
 */
	class Human
	{
		Weapon w;
		
		public Human(Weapon w) {this.w = w;}
		
		public Weapon getWeapon() {
			return w;
		}
		
		//testing purposes only, remove
		public Either<Weapon> getWeaponEither(){
			return Either.of(w);
		}
	}
	
	class Weapon
	{
		Magazine m;
		
		public Weapon(Magazine m) {this.m = m;}
		
		public Magazine getMag() {
			return m;
		}
		
		//testing, remove
		public Either<Magazine> getMagEither(){
			return Either.of(m);
		}
	}
	
	class Magazine
	{
		private int count;
		
		public Magazine(int c) {count = c;}
		
		public int getCount() {return count;}
	}
