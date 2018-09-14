import java.io.*;
import java.util.Scanner;

public class Order {

	private static int order;
	private static int Prod1, Prod2, Prod3;//scope changed and moved here

	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int answer = 1;
		int TProd1, TProd2, TProd3;
		double Tprofit = 0;
		
		while (answer == 1) {
		
		double A = 13.99;
		double B = 37.99;
		double C = 41.99;
		double cost, total = 0, profit, holder;
		// int Prod1, Prod2, Prod3; - moved outside main and scope changed
		
		String Fname, Lname, Address, City, State, Zip;
		
		setOrder(-1);
		
		//Data Collection
		System.out.println("Enter your first name:  ");
		Fname = reader.nextLine();
		
		System.out.println("Enter your last name:  ");
		Lname = reader.nextLine();
		
		System.out.println("Enter your address:  ");
		Address = reader.nextLine();
		
		System.out.println("Enter your city:  ");
		City = reader.nextLine();
		
		System.out.println("Enter your state:  ");
		State = reader.nextLine();
		
		System.out.println("Enter your ZIP code:  ");
		Zip = reader.nextLine();
		
		
		//Logging how much of which is being bought
		System.out.println("How many of Product 1 do you want to purchase?");
		Prod1 = reader.nextInt();
		cost = (A * Prod1);
		TProd1 =+ Prod1;
		
		System.out.println("How many of Product 2 do you want to purchase?");
		Prod2 = reader.nextInt();
		cost += (B * Prod2);
		TProd2 =+ Prod2;
		
		System.out.println("How many of Product 3 do you want to purchase?");
		Prod3 = reader.nextInt();
		cost += (C * Prod3);
		TProd3 =+ Prod3;
		
		
		
		try {
			FileWriter writer = new FileWriter("Output.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
		//jotting orders down to a file that happens to be called Output.txt
		bufferedWriter.write(Fname + System.getProperty("line.separator") + Lname + System.getProperty("line.separator") + Address + System.getProperty("line.separator") + City + System.getProperty("line.separator") + Zip + System.getProperty("line.separator"));
		bufferedWriter.newLine();
		bufferedWriter.newLine();
		
		bufferedWriter.write(Lname + "'s Orders: " + System.getProperty("line.separator") + Prod1 + " of Product 1" + System.getProperty("line.separator") + Prod2 + " of Product 2" + System.getProperty("line.separator") + Prod3 + " of Product 3" + System.getProperty("line.separator"));
		
		
		
		
		if(cost < 39.99) {
			total = cost + 5;
		}
		
		else if(cost <= 149.99) {
			total = cost + 10;
		}
		
		else if(cost >= 150) {
			total = cost;
		}
		
		total*= 1.06;
		
		
		
		
		System.out.println("Your final cost is: $" + total);
		
		
		holder = cost / 1.35;
		profit = cost - holder;
		Tprofit += profit;
		
		bufferedWriter.write("Cost and tax:  $" + cost + System.getProperty("line.separator"));
		bufferedWriter.write("Cost and shipping:  $" + total + System.getProperty("line.separator"));
		bufferedWriter.write("Profit:  " + profit + System.getProperty("line.separator"));
		bufferedWriter.close();
		
		System.out.println("Enter 1 to place another order.");
		answer = reader.nextInt();
		reader.nextLine();
		
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		}
		
		try{
			FileWriter writer = new FileWriter("Output.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write("Daily profit: " + Tprofit);
			bufferedWriter.write(Prod1 + " Product 1 total" + System.getProperty("line.separator"));//took out newLine
			//bufferedWriter.newLine(Prod1 + " Product 1 total\n");
			bufferedWriter.write(Prod2 + " Product 2 total" + System.getProperty("line.separator"));
			bufferedWriter.write(Prod3 + " Product 3 total" + System.getProperty("line.separator"));
			bufferedWriter.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Terminating Program.");
	}
		
		public static int getOrder() {
			return order;
		}
		
		public static void setOrder(int order) {
			Order.order = order;
		}
	}
	
//fin