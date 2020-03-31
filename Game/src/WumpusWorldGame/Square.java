package WumpusWorldGame;

public class Square {
		
	private String message;

	/*default constructor to set square to safe*/
	public Square() {		
	 message = "Safe";
	}
	
	/*Method to set message based on what string is
	 * passed to it. The variable is set to the passed 
	 * in string if the conditions are met otherwise the
	 * string passed in will be catenated to the current 
	 * string in message */
	public void setMessage(String str) {
		
		String gold = "GOLD";
		String empty = "Safe";
		String pit = "PIT";
		String start = "Start";
		String wumpus = "WUMPUS";
		String breeze = "Breeze";
		String stench = "Stench";
		
		if ( (str.equals(start) || str.equals(wumpus) || str.equals(pit) || str.equals(gold) || str.equals(breeze) || str.equals(stench) )&& this.message.equals(empty) )
			this.message = str;
		else if (this.message.equals(wumpus) && (str.equals(breeze) || str.equals(stench)))
			this.message = wumpus;
		else if (this.message.equals(pit) &&  (str.equals(breeze) || str.equals(stench)))
			this.message = pit;
		else 
			this.message+=str;
	}

	/*Method to called by wumpus world to set message 
	 * to a new string that is passed in after the word 
	 * player is trimmed off of it*/
	public void setPrevMessage(String str) {
		message = str;
	}
   	
	/*To string method for the class that returns the message*/
	public String toString() {
   		return this.message;
   	}
   	
}

