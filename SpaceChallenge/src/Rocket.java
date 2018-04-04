/* This class implements interface spaceship.
 * All methods in the spaceship are implemented here.
 * 
 */

public class Rocket implements SpaceShip{
	
	public static int weightofrocket;
	public static int maximumweightofrocket;
	
	/* Methods Launch() and Land() are overridden in both the classes U1 and U2 to get the actual results*/
	
	public Boolean Launch() {
		return true; 
	}
	public Boolean Land() {
		return true; 
	}
	
	/* Returns true if item weight and weight of the rocket are in the permissible limit*/
	
	final public Boolean CanCarry(Item item) {
		
		if ((item.weight + Rocket.weightofrocket) <= Rocket.maximumweightofrocket) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* This method first checks, weather the rocket can carry the object or not and then loads accordingly*/
	
	final public void Carry(Item item) {
		if (CanCarry(item)) {
			weightofrocket = (weightofrocket + item.weight);
		}
	}
	
}
