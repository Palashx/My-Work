/* Extends rocket class for the methods canCarry(Item) and Carry(Item)*/

public class U1 extends Rocket{
	
	public U1() {
		Rocket.weightofrocket = 10000;
		Rocket.maximumweightofrocket = 18000;
	}
	
	
	/* Calculates the launch probability and return a boolean accordingly*/
	
	public Boolean Launch() {
		double random = Math.random();
		double problaunch = (((double)5/(double)100))*((double)weightofrocket / (double)maximumweightofrocket);
		if(random > problaunch) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* Calculates the land probability and return a boolean accordingly*/
	public Boolean Land() {
		double random = Math.random();
		double probland = ((double)1/(double)100)*((double)weightofrocket / (double)maximumweightofrocket);
		if(random > probland) {
			return true;
		}
		else {
			return false;
		}
	}
}
