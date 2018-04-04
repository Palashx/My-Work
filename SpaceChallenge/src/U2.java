/* Extends rocket class for the methods canCarry(Item) and Carry(Item)*/

public class U2 extends Rocket{
	
	public U2(){
		Rocket.weightofrocket = 18000;
		Rocket.maximumweightofrocket = 29000;
	}
	
	/* Calculates the launch probability and return a boolean accordingly*/
	public Boolean Launch() {
		double random = Math.random();
		double problaunch = (((double)4/(double)100))*((double)weightofrocket / (double)maximumweightofrocket);
		
		if(random > problaunch) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/* Calculates the launch probability and return a boolean accordingly*/
	public Boolean Land() {
		double random = Math.random();
		double probland = ((double)8/(double)100)*((double)weightofrocket / (double)maximumweightofrocket);
			if(random > probland) {
				return true;
			}
			else {
				return false;
		}
	}

}
