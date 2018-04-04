/* This is an interface which has 4 method declarations 
 *  Launch() - Return true on a successful launch
 *	Land() - Return false on a successful launch
 *	canCarry(Item item) - Returns true if an item can be carried by a rocket without exceeding the weight limit.
 * 	Carry(Item item) - Loads an item into the rocket.
 */
public interface SpaceShip {
	
	public Boolean Launch();
	public Boolean Land();
	public Boolean CanCarry(Item item);
	public void Carry(Item item);
	
}
