package bd2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dataStructures.*;

public class carParking extends ArrayStack{
	
	private ArrayStack temppark;
	
	public carParking() {
		super(10);
		temppark = new ArrayStack(10);
		
	}
	
	//mashin oruulah
	public void input(String number) {
		if(this.top == this.stack.length - 1) {
			System.out.println("Zogsool duuren baina " + number + " dugaartai mashiniig oruulah bolomjgui");	
		}
		else {
			this.push(number);
			System.out.println(number + " dugaartai mashin zogsoold orloo");
		}
	}
	
	//mashin gargah
	public void output(String number) {
		if(this.empty()) {
			System.out.println(number + " dugaartai mashin zogsoold baihgui");
		}
		else {
			this.process(number);
		}
	}
	
	//gargah uildliig bolovsruulalt hiine
	public void process(String number) {
	    int k = 0; // Count of cars moved temporarily
	    boolean found = false;

	    // Move cars to temp stack until we find the desired car or the stack is empty
	    while (!this.empty()) {
	        if (this.peek().equals(number)) {
	            found = true;
	            this.pop(); // Remove the desired car
	            break;
	        } else {
	            temppark.push(this.pop());
	            k++; // Increment count for cars moved temporarily
	        }
	    }

	    if (found) {
	        System.out.println(k + " mashin tur gargasnii daraa " + number + " dugaartai mashin zogsooloos garlaa");
	    } else {
	        System.out.println(number + " dugaartai mashin zogsoold baihgui");
	    }

	    // Restore cars back to the parking stack
	    while (!temppark.empty()) {
	        this.push(temppark.pop());
	    }

	    // Notify if cars were moved temporarily
	    if (k > 0) {
	        System.out.println(k + " mashiniig butsaaj zogsoold oruulav");
	    }
	}

	
	public static void main(String[] args) {
		carParking cp = new carParking();
		
		try {
			File file = new File("cars.txt");
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				String [] inputline = sc.nextLine().split(" ");
				if(inputline[0].equals("A")) {
					cp.input(inputline[1]);
				}
				else {
					cp.output(inputline[1]);
				}
			}
			
		
		} catch(FileNotFoundException ex){
			System.out.println("Error: " + ex.getMessage());
			System.exit(0);
		}
			
		}
	
	

}
