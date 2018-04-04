import java.io.File;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class Simulation {
	
	/*Reading item from text file and puts them in an arraylist of items that should be loaded on the rockets*/
	
	public ArrayList<Item> loadItem() throws Exception {    
		
		ArrayList<Item> arraylist = new ArrayList<Item>();
		File file = new File("D:\\Udacity\\SpaceChallenge\\src\\Phase1.txt");
		Scanner filescanner = new Scanner(file);
		int i;
				
		while (filescanner.hasNextLine()) {				
			
			String line = filescanner.nextLine();
			line = line.replace('=',' ');             		// Replace = with a blank space 
			line = line.replaceAll(" ", "");				// Replace blank space ""
			String[] part = line.split("(?<=\\D)(?=\\d)");	//Split string to string array, with a digital and non digital output
			
			i = Integer.parseInt(part[1]);
			Item item = new Item();
			item.name = part[0];
			item.weight = i;
			arraylist.add(item);
		
		
		}
		filescanner.close();
		return arraylist;
		
	}
	
	//Creating u1 and fills them with items. 
	public ArrayList<Rocket> loadU1(ArrayList<Item> arraylist){		
		
		ArrayList<Rocket> arraylistu1 = new ArrayList<Rocket>();
		ArrayList<Item> arraylistitem = new ArrayList<Item>();
		arraylistitem = arraylist;
		
		while (!arraylistitem.isEmpty()) {
			String S = "";
			U1 u1 = new U1();
			int i = 0;
		
			while(Rocket.weightofrocket <= Rocket.maximumweightofrocket) {
			
				try {if (u1.CanCarry(arraylistitem.get(i))) {
					u1.Carry(arraylistitem.get(i));
					arraylistitem.remove(i);
				}
				} catch (Exception e) {
					S = "Got array out of bounds";
				}
			
				if (S.equals("Got array out of bounds")) {	
					break;	
				}
			
				i++;
				if (Rocket.weightofrocket == Rocket.maximumweightofrocket || arraylistitem.isEmpty()) {
					break;
				}
			}
			arraylistu1.add(u1);
		}
		return arraylistu1;
	}
	
	//Creating u and fills them with items. 
	public ArrayList<Rocket> loadU2(ArrayList<Item> arraylist){				
		
		ArrayList<Rocket> arraylistu2 = new ArrayList<Rocket>();
		ArrayList<Item> arraylistitem = new ArrayList<Item>();
		arraylistitem = arraylist;
		
		while (!arraylistitem.isEmpty()) {
			
			String S = "";
			U2 u2 = new U2();
			int i = 0;
			
		
			while(Rocket.weightofrocket <= Rocket.maximumweightofrocket) {
			
				try {if (u2.CanCarry(arraylistitem.get(i))) {
					u2.Carry(arraylistitem.get(i));
					arraylistitem.remove(i);
				}
				} catch (Exception e) {
					S = "Got array out of bounds";
				}
			
				if (S.equals("Got array out of bounds")) {	
				break;	
				}
			
				i++;
			
				if (Rocket.weightofrocket == Rocket.maximumweightofrocket || arraylistitem.isEmpty()) {
					break;
				}
			}
			arraylistu2.add(u2);
		}
			return arraylistu2;
	}
	
	/*
		This methods takes an ArrayList of rockets and calls Launch() and Land() methods for each rocket 
		and keeps a track of the total launches.If any Launch or Landing of a rocket fails 
		then that rocket id launched again. Returns number of rockets launched.
		
	*/
	
	public int runSimulation (ArrayList<Rocket> arraylist) {
		
		ArrayList<Rocket> arraylistux = new ArrayList<Rocket>();
		arraylistux = arraylist;
		int i = 0;
		int totalnumofrockets = 0;
		
		ListIterator<Rocket> itr = arraylistux.listIterator();
		
		while (!arraylistux.isEmpty()) {
			totalnumofrockets += 1;
			if (arraylistux.get(i).Launch()){
					try {
						if(itr.next().Land()) {
						itr.remove();
						}
					} catch (NoSuchElementException e) {
							if(itr.previous().Land()) {
							itr.remove();
							}
						
					}
			}
					
		}
		return totalnumofrockets;
	}
	
	
		
}	
