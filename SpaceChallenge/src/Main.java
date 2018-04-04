/* This class makes a simulation object 
 * loads all the items from phase 1 and 
 * phase 2  and calculates total budget 
 * for the U1 and U2 rockets.
 */

import java.util.ArrayList;

public class Main {
	
	public static void main ( String [] args) {
		
		ArrayList<Rocket> arraylistu1 = new ArrayList<Rocket>();
		ArrayList<Rocket> arraylistu2 = new ArrayList<Rocket>();
		ArrayList<Item> arraylistitem = new ArrayList<Item>();
		
		Simulation simulation = new Simulation();
		try {
			arraylistitem = simulation.loadItem();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		arraylistu1 = simulation.loadU1(arraylistitem);
		
		try {
			arraylistitem = simulation.loadItem();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		arraylistu2 = simulation.loadU2(arraylistitem);
	
		System.out.println("No. of U1 created are "+arraylistu1.size());
		int totalnumofrockets;
		totalnumofrockets = simulation.runSimulation(arraylistu1) * 100;
		System.out.println("We require $"+ totalnumofrockets + " for proceeding with U1 rockets.");
		
		System.out.println("No. of U2 created are "+arraylistu2.size());
		totalnumofrockets = simulation.runSimulation(arraylistu2) * 120;
		System.out.println("We require $"+ totalnumofrockets + " for proceeding with U2 rockets.");
		}

}
