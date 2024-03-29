package nim;
import javax.swing.JOptionPane;

public class Nim {
	private static boolean gameOver(int currentState) {
		return currentState == 0;
	}
	private static void announceResult(boolean humanPlaying) {
		if(humanPlaying) {
			JOptionPane.showMessageDialog(null, "You lost");
		} else {
			JOptionPane.showMessageDialog(null, "You won");			
		}
	}
	public static void main(String[] args) {
		int currentState = 10 + (int)(90*Math.random());
		PlayAreaView playAreaView = new PlayAreaView(currentState);
		Play computer = new Guess();
		Play human = new Human();
		boolean humanPlaying = true;
		while(!gameOver(currentState)) {
			humanPlaying = true;
			int take = human.takeTurn(currentState);
			currentState -= take;
			playAreaView.remove(take);			
			if( !gameOver(currentState) ) {
				try { // pretend the computer is thinking
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				humanPlaying = false;
				take = computer.takeTurn(currentState);
				currentState -= take;
				playAreaView.remove(take);
			}
		}
		announceResult(humanPlaying);
		playAgain();
	}
	
	public static void playAgain()
	{
		String in = JOptionPane.showInputDialog(null,
				"Play again?");
		
		if(in.equalsIgnoreCase("yes"))
		{
		String[] s = {"a","b"}; 
		main(s);
		}
		else
		{
			System.exit(0);
		}
	}
}
