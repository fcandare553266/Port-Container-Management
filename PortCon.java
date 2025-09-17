import java.util.ArrayDeque;
import java.util.Scanner;

public class PortCon {
	private static ArrayDeque<Container> containerStack = new ArrayDeque <>();
	private static ArrayDeque<ship> shipStack = new ArrayDeque <>();
	private static Scanner cons = new Scanner (System.in);
	static class Container{
		private String ID;
		private String descript;
		private double weight;
		
		public Container(String ID, String descript, double weight) {
			this.ID = ID;
			this.descript = descript;
			this.weight = weight;		
			}
		public String toString() {
			return ID + "|" + descript + "|" + weight + "kg";
		}
	}
	
	static class ship {
		private String name;
		private String capt;
		
		public ship(String name, String capt) {
			this.name = name;
			this.capt = capt;	
		}
		public String toString() {
			return name+ "|" + capt;
			
		}
	}




	public static void main(String[] args) {
		int choice;
		String choice2;
	do {	
		System.out.println("\n Port Container Management System \n");
		System.out.println("[1] Store container");
		System.out.println("[2] View port containers");
		System.out.println("[3] Register arriving ship");
		System.out.println("[4] View waiting ships");
		System.out.println("[5] Load next ship");
		System.out.println("[0] Exit");
		choice=cons.nextInt();
		cons.nextLine();
		
		switch (choice) {
		case 1: 
			storecontainer();
			break;
		case 2:
			viewcontainerr();
			break;
		case 3:
			registership();
			break;
		case 4: 
			viewwaitship();
			break;
		case 5:
			loadship();
			break;
		case 0: 
			System.out.println("Exiting....");
			return;
				
		}
		System.out.println("Do you want to Continue? : [y/n]");
		choice2 =cons.nextLine();
	}while (choice2 .equals("y"));
	return;
		
	}
	
	
	

	private static void storecontainer() {
	
		 System.out.println("Enter Container ID: ");
		    String ID = cons.nextLine();
		    System.out.println("Enter description: ");
		    String descript = cons.nextLine();
		    System.out.println("Enter weight: ");
		    double weight = cons.nextDouble();
		    cons.nextLine(); 
		
		    
		    Container c =new Container(ID, descript, weight);
		    containerStack.push(c);

		    System.out.println("Stored: " + c);
		   
	}
	private static void viewcontainerr() {
		if(containerStack.isEmpty()) {
			System.out.println("No containers found at port");
			return;
		}
		else {
			System.out.println("Top =>");
			for (Container c: containerStack) {
				System.out.println(c);
			}
			System.out.println("<= Bottom");
		}
		
	}
	private static void registership() {
		System.out.print("Enter Ship name: ");
		String name = cons.nextLine();
		System.out.print("Enter Captain name: ");
		String Captain = cons.nextLine();
		
		ship s = new ship (name, Captain);
		shipStack.offer(s);
		System.out.println("Registered: " + s);
		
	}
	private static void viewwaitship() {
		if (shipStack.isEmpty()) {
			System.out.println("No ships waiting");
			return;
		}else {
			System.out.println("Front =>");
			for (ship s: shipStack){
				System.out.println(s);
			}
			System.out.println(" <= Rear");
		}
	}
	private static void loadship() {
		if (containerStack.isEmpty()) {
			System.out.println("No containers available to load");
			return;
		}
		if (shipStack.isEmpty()) {
			System.out.println("No ships waiting to be loaded");
			return;
		}
		Container c = containerStack.pop();
		ship s = shipStack.poll();
		
		System.out.println("Loaded:" + c + "> " + s);
		System.out.println("Remaining containers: " + containerStack.size());
		System.out.println("Remaining ships:" + shipStack.size());
		
	}



}

