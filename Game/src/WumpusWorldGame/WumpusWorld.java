package WumpusWorldGame;

public class WumpusWorld {

	private Square [][] gameboard;
	private int r, cl;
	private boolean death;
	
	
	/*Constructor creates object array gameboard, sets players
	 *  starting coordinates, sets games exit status to true,
	 *  and calls several calls to create the gameboard. */
	public WumpusWorld() {
		
		gameboard = new Square[4][4];
		
		r = 3;
		cl = 0;
		death = true;
	
		createGame(gameboard);
		setStart(gameboard);
		setPit(gameboard);
		setPit(gameboard);
		setPit(gameboard);
		setWumpus(gameboard);
		setGold(gameboard);
		setBreeze(gameboard);
		setStench(gameboard);
		setPlayer(gameboard);
	}

	
	/*Takes in a Square object array named gameboard and initializes
	 *  by using nested for loops to fill it with individual square
	 *  objects */
	public void createGame(Square [][] gameboard) {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				gameboard [i][j] = new Square();
	}
	
	
	/*Prints game using nested for loops to call sepecific elements in 
	 * an array and using Squares toString method to grab Squares private 
	 * message variable. it is then printed using formatting to create board 
	 * like appearance. */
	public void printGame (){
		
		for (int row = 0; row<4; row++) {
			for( int col = 0; col<4; col++)
			{
				System.out.printf("%-20s", gameboard[row][col].toString());
			}
			System.out.println("\n");
		}
	}
	
	
	/*Sets pits by generating random array indexes. The gameboard array
	 * is sent to the function sets the pit or re-calls function if the 
	 * pit is set over another pit*/
	public void setPit(Square [][] gameboard) {
		
		int i, j;
		String pit = "PIT";
		String start = "Start";
		
		i = (int)(Math.random() *4); 
		j = (int)(Math.random() *4);
		
		if ( gameboard[i][j].toString().equals(pit) || gameboard[i][j].toString().equals(start))
			setPit(gameboard);
		else
			gameboard[i][j].setMessage("PIT");
	}
     
	
	/*Function takes gameboard array and sets wumpus at random 
	 * location by generating random array indexs then checking
	 * to see if they are set on start, pits, or gold. If so the
	 * function is called again*/
	public void setWumpus(Square [][] gameboard) {
		
		int i, j;
		String pit = "PIT";
		String start = "Start";
		//String gold = "GOLD";
		
		i = (int)(Math.random() *4); 
		j = (int)(Math.random() *4);
		
		if ( gameboard[i][j].toString().equals(start) || gameboard[i][j].toString().equals(pit))	//may need to add check for gold back
			setWumpus(gameboard);
		else 
			gameboard[i][j].setMessage("WUMPUS");
	}
		
	/*Function takes gameboard array and sets gold at random location by
	 * randomizing numbers for array indexes then checks to make sure gold 
	 * is not set on start, pits or wumpus. If so the funciton is recalled*/
	public void setGold(Square [][] gameboard) {
		
		int i, j;
		String pit = "PIT";
		String start = "Start";
		String Wumpus = "WUMPUS";
		
		i = (int)(Math.random() *4); 
		j = (int)(Math.random() *4);
		
		if ( gameboard[i][j].toString().equals(pit) || gameboard[i][j].toString().equals(start) || gameboard[i][j].toString().equals(Wumpus))
			setGold(gameboard);	
		else 
			gameboard[i][j].setMessage("GOLD");
	}
	
	/*Creates breezes based on pit locations, the if statments check to
	 * see where the pits are on the gameboard and based on location 
	 * creates breezes that will not be plotted outside of the game board*/
	public void setBreeze(Square [][] gameboard) {
		
		String pit = "PIT";
		
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {
				
				if(gameboard[row][col].toString().equals(pit)){
					
					if(row == 3){
						if(col == 3) {
						  	gameboard[--row][col].setMessage("Breeze");				  	
						  	row++;
						  	gameboard[row][--col].setMessage("Breeze");
						  	col++;
						}
						else if (col == 2) {
							gameboard[--row][col].setMessage("Breeze");				  	
						  	row++;
						  	gameboard[row][--col].setMessage("Breeze");
						  	col++;
						  	gameboard[row][++col].setMessage("Breeze");				  	
						  	col--;
						}
						else {
							gameboard[--row][col].setMessage("Breeze");				  	
						  	row++;
						  	gameboard[row][--col].setMessage("Breeze");
						  	col++;
						  	gameboard[row][++col].setMessage("Breeze");				  	
						  	col--;
						} 	
					}
					if (row == 2) {
						if (col == 3) {
							gameboard[--row][col].setMessage("Breeze");
							row++;
							gameboard[++row][col].setMessage("Breeze");
							row--;
							gameboard[row][--col].setMessage("Breeze");
							col++;
						}
						else if(col == 0) {
							gameboard[row][++col].setMessage("Breeze");
							col--;
							gameboard[++row][col].setMessage("Breeze");
							row--;
							gameboard[--row][col].setMessage("Breeze");								
							row++;
						}	
						else {
							gameboard[++row][col].setMessage("Breeze");
							row--;
							gameboard[--row][col].setMessage("Breeze");
							row++;
							gameboard[row][++col].setMessage("Breeze");		
							col--;
							gameboard[row][--col].setMessage("Breeze");
							col++;
						}
					}
					if (row == 1) {
						if (col == 3) {
							gameboard[--row][col].setMessage("Breeze");
							row++;
							gameboard[++row][col].setMessage("Breeze");
							row--;
							gameboard[row][--col].setMessage("Breeze");
							col++;
						}
						else if(col == 0) {
							gameboard[row][++col].setMessage("Breeze");
							col--;
							gameboard[++row][col].setMessage("Breeze");
							row--;
							gameboard[--row][col].setMessage("Breeze");
							row++;
						}
						else {
							gameboard[++row][col].setMessage("Breeze");
							row--;
							gameboard[--row][col].setMessage("Breeze");
							row++;
							gameboard[row][++col].setMessage("Breeze");
							col--;
							gameboard[row][--col].setMessage("Breeze");
							col++;
						}
					}
					if (row == 0) {
						if (col == 3) {
							gameboard[row][--col].setMessage("Breeze");
							col++;
							gameboard[++row][col].setMessage("Breeze");
							row--;
							}
						else if (col == 0) {
							gameboard[++row][col].setMessage("Breeze");
							row--;
							gameboard[row][++col].setMessage("Breeze");
							col--;
						}
						else {
							gameboard[row][--col].setMessage("Breeze");
							col++;
							gameboard[row][++col].setMessage("Breeze");
							col--;
							gameboard[++row][col].setMessage("Breeze");
							row--;
						}
					}
				}
			}
						
		}
	}
	
	/*Creates stenches and sets them around the wumpus based on its location
	 * this method is similar to the breeze method*/
	public void setStench(Square [][] gameboard) {
		
		String wumpus = "WUMPUS";
		
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col < 4; col++) {

				if(gameboard[row][col].toString().equals(wumpus)){
					
					if(row == 3){
						if(col == 3) {
						  	gameboard[--row][col].setMessage("Stench");				  	
						  	row++;
						  	gameboard[row][--col].setMessage("Stench");
						  	col++;
						}
						else if (col == 2) {
							gameboard[--row][col].setMessage("Stench");				  	
						  	row++;
						  	gameboard[row][--col].setMessage("Stench");
						  	col++;
						  	gameboard[row][++col].setMessage("Stench");				  	
						  	col--;
						}
						else {
							gameboard[--row][col].setMessage("Stench");				  	
						  	row++;
						  	gameboard[row][--col].setMessage("Stench");
						  	col++;
						  	gameboard[row][++col].setMessage("Stench");				  	
						  	col--;
						} 	
					}
					if (row == 2) {
						if (col == 3) {
							gameboard[--row][col].setMessage("Stench");
							row++;
							gameboard[++row][col].setMessage("Stench");
							row--;
							gameboard[row][--col].setMessage("Stench");
							col++;
						}
						else if(col == 0) {
							gameboard[row][++col].setMessage("Stench");
							col--;
							gameboard[++row][col].setMessage("Stench");
							row--;
							gameboard[--row][col].setMessage("Stench");								
							row++;
						}	
						else {
							gameboard[++row][col].setMessage("Stench");
							row--;
							gameboard[--row][col].setMessage("Stench");
							row++;
							gameboard[row][++col].setMessage("Stench");		
							col--;
							gameboard[row][--col].setMessage("Stench");
							col++;
						}
					}
					if (row == 1) {
						if (col == 3) {
							gameboard[--row][col].setMessage("Stench");
							row++;
							gameboard[++row][col].setMessage("Stench");
							row--;
							gameboard[row][--col].setMessage("Stench");
							col++;
						}
						else if(col == 0) {
							gameboard[row][++col].setMessage("Stench");
							col--;
							gameboard[++row][col].setMessage("Stench");
							row--;
							gameboard[--row][col].setMessage("Stench");
							row++;
						}
						else {
							gameboard[++row][col].setMessage("Stench");
							row--;
							gameboard[--row][col].setMessage("Stench");
							row++;
							gameboard[row][++col].setMessage("Stench");
							col--;
							gameboard[row][--col].setMessage("Stench");
							col++;
						}
					}
					if (row == 0) {
						if (col == 3) {
							gameboard[row][--col].setMessage("Stench");
							col++;
							gameboard[++row][col].setMessage("Stench");
							row--;
							}
						else if (col == 0) {
							gameboard[++row][col].setMessage("Stench");
							row--;
							gameboard[row][++col].setMessage("Stench");
							col--;
						}
						else {
							gameboard[row][--col].setMessage("Stench");
							col++;
							gameboard[row][++col].setMessage("Stench");
							col--;
							gameboard[++row][col].setMessage("Stench");
							row--;
						}
					}
				}
				
			}
		}
	}
	
	/*This method takes in a string from the Project3 main class and moves the
	 * player based on what is passed to it. The method does bounds checking each
	 * time a movement is made, and removes the portion of the string that contains
	 * the player*/
	public void movePlayer(String str) {
	
		String n = "N",
				e = "E",
				s = "S",
				w = "W",
				c = "C",
				message;
		
		int stringsize;
		
		if(str.toUpperCase().equals(n)) {
			
			if( r != 0) {
				
				/*This algorithm removes the end of the string 
				 *that shows the player from the last element of 
				 *the array before moving the player to the next 
				 *element*/
				message = gameboard[r][cl].toString();
				stringsize = (message.length() - 1);
				stringsize -= 5;
				message = message.substring(0, stringsize);
				gameboard[r][cl].setPrevMessage(message);
				
				gameboard[--r][cl].setMessage("Player");
				checkSquare(gameboard);
			}
			else 
				System.out.println("You have moved too far north");
			
		}
		else if(str.toUpperCase().equals(e)) {
			
			if (cl != 3) {

				message = gameboard[r][cl].toString();
				stringsize = (message.length() - 1);
				stringsize -= 5;
				message = message.substring(0, stringsize);
				gameboard[r][cl].setPrevMessage(message);
				
				gameboard[r][++cl].setMessage("Player");
				checkSquare(gameboard);
			}
			else
				System.out.println("You have moved too far east");
		}
		else if (str.toUpperCase().equals(s)) {
			
			if (r != 3) {
				
				message = gameboard[r][cl].toString();
				stringsize = (message.length() - 1);
				stringsize -= 5;
				message = message.substring(0, stringsize);
				gameboard[r][cl].setPrevMessage(message);
				
				gameboard[++r][cl].setMessage("Player");
				checkSquare(gameboard);
			}
			else
				System.out.println("You have moved too far south");	
			
		}
		else if (str.toUpperCase().equals(w)){
			if (cl != 0) {
				
				message = gameboard[r][cl].toString();
				stringsize = (message.length() - 1);
				stringsize -= 5;
				message = message.substring(0, stringsize);
				gameboard[r][cl].setPrevMessage(message);
		
				gameboard[r][--cl].setMessage("Player");
				checkSquare(gameboard);
			}
			else
				System.out.println("You have moved too far west");	
		}
		else if (str.toUpperCase().equals(c))
			System.out.println("You have decided to cheat!");
		else
			System.out.println("You have entered an invalid character!");
	}
	
	/*This method takes in the gameboard array and checks the status of the square 
	 * objects message, based on the message it displays a specific message to the player*/
	public void checkSquare(Square [][] gameboard) {
		
		String b = "BreezePlayer",
				bb = "BreezeBreezePlayer",
				bbb = "BreezeBreezeBreezePlayer",
				p = "PITPlayer",
				g = "GOLDPlayer",
				gb = "GOLDBreezePlayer",
				gbb = "GOLDBreezeBreezePlayer",
				gbs = "GOLDBreezeStenchPlayer",
				gs = "GOLDStenchPlayer",
				w = "WUMPUSPlayer",
				st = "StenchPlayer",
				bs = "BreezeStenchPlayer",
				bbs = "BreezeBreezeStenchPlayer";
				
		/*if else statements display messages based on possible strings
		 * also sets private boolean variable that will be used to exit the 
		 * game by project3*/
		if (this.gameboard[r][cl].toString().equals(b))
			System.out.println("There is a strong breeze blowing...");
		else if (this.gameboard[r][cl].toString().equals(bb))
			System.out.println("There are two breezes blowing near you...");
		else if (this.gameboard[r][cl].toString().equals(bbb))
			System.out.println("There are three breezes blowing near you, this area seems dangerous...");
		else if (this.gameboard[r][cl].toString().equals(p)) {
			System.out.println("You have stumbled into a pit and fell to your death.");
			this.death = false;
		}
		else if (this.gameboard[r][cl].toString().equals(g)) {
			System.out.println("Congratulations! You have discovered the gold you have been searching for. ");
			this.death = false;
		}
		else if (this.gameboard[r][cl].toString().equals(gb)) {
			System.out.println("Congratulations! You just missed the pit and discovered the gold you have been searching for.");
			this.death = false;
		}
		else if (this.gameboard[r][cl].toString().equals(gbb)) {
			System.out.println("Excellent navigation! You have avoided two pits and discovered the gold!");
			this.death = false;
		}
		else if (this.gameboard[r][cl].toString().equals(gbs)) {
			System.out.println("Excellent navigation! You have avoided a pit and the Wumpus to discover the gold!");
			this.death = false;
		}
		else if (this.gameboard[r][cl].toString().equals(gs)) {
			System.out.println("Excellent navigation! You have avoided the Wumpus to discover the gold!");
			this.death = false;
		}
		else if (this.gameboard[r][cl].toString().equals(w)) {
			System.out.println("You have ran into the stinky Wumpus and he has consumed you.");
			this.death = false;
		}
		else if (this.gameboard[r][cl].toString().equals(st))
			System.out.println("There is a strong stench eminating from nearby...");
		else if (this.gameboard[r][cl].toString().equals(bs))
			System.out.println("There is a strong breeze and stench coming from nearby...");
		else if (this.gameboard[r][cl].toString().equals(bbs))
			System.out.println("There are two strong breezes and a stench coming from nearby...");
		else
			System.out.println("This area seems safe...");
		
	}

	/*This method checks the starting conditions by comparing square objects message variable
	 * with the possibilities that can be generated*/
	public void checkStart() {
		
		String start = "StartPlayer",
				startb = "StartBreezePlayer",
				startbb = "StartBreeezeBreezePlayer",
				startbs = "StartBreezeStenchPlayer",
				starts = "StartStenchPlayer";
		
		if (this.gameboard[r][cl].toString().equals(start))
			System.out.println("You have entered Wumpus World everything seems safe so far...");
		else if (this.gameboard[r][cl].toString().equals(startb))
			System.out.println("You have entered Wumpus World, there is a strong breeze blowing from nearby...");
		else if (this.gameboard[r][cl].toString().equals(startbb))
			System.out.println("You have entered Wumpus World, there are two strong breezes nearby. Things do not look good turn back now!");
		else if (this.gameboard[r][cl].toString().equals(startbs))
			System.out.println("You have entered Wumpus World, ther is a strong stench nearby. There is also a breeze, things do not look good. Turn back now!");
		else if (this.gameboard[r][cl].toString().equals(starts)) 
			System.out.println("You have entered Wumpus World, There is a strong stench near by.");
		else
			System.out.println("This area seems safe...");
	}
	
	/*Setter methods for setting the start and the player*/
	public void setStart(Square [][] gameboard) {
		gameboard[3][0].setMessage("Start");
		
	}
	
	public void setPlayer(Square [][] gameboard) {
		gameboard[3][0].setMessage("Player");
	}
	
	/*Getter method for getting boolean exit value for loop in project3 class*/
	public boolean getDeath() {
		return death;	
	}
	
}
		
	
	

