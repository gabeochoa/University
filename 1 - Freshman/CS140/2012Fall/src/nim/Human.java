package nim;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

public class Human implements Play {
	public Logger logObj = Logger.getLogger("Human");
	private static Handler handler;

	public Human() {
		//creates this handler
		//output will go to file named in argument
		try {
			handler = new FileHandler("Nim.log");
			//SimpleFormatter produces plain text(as opposed to XML)
			handler.setFormatter(new SimpleFormatter());
			logObj.addHandler(handler);
			logObj.setLevel(Level.ALL);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public int takeTurn(int currentState) {
		int numberToTake = -1;
		while(numberToTake < 0) {
			String in = JOptionPane.showInputDialog(null,
			"Number to remove:");
			Scanner input = new Scanner(in);
			if(input.hasNextInt()){
				numberToTake = input.nextInt();
				if ((currentState != 1 && (numberToTake < 1 || numberToTake > currentState/2))
						|| (currentState == 1 && numberToTake != 1)) {
					JOptionPane.showMessageDialog(null, "You can only take between\n" +
							"1 and " + (currentState == 1 ? 1 : currentState/2) + " sticks from the pile");
					numberToTake = -1;
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "You did not enter an integer");
			}
		}
		logObj.info("Human takes " + numberToTake + "\n");
		return numberToTake;
	}

}
