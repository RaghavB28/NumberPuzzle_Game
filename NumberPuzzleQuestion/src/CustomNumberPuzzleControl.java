import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		int newEmpty=emptyCellId;
		Button[] buttons = game.getButtons();
		for(int i=0;i<16;i++) {
			if (buttons[i]==buttonClicked)
				newEmpty=i;
		}
		int flag=0;
		//Your logic here
//		System.out.println(emptyCellId);	
//		System.out.println(buttonClicked);	
//		System.out.println(Arrays.toString(buttons));	
		//Button emptyButton=new Button();
		//emptyButton.
		if(emptyCellId-newEmpty==4||newEmpty-emptyCellId==4||((newEmpty-emptyCellId==1&&(newEmpty/4==emptyCellId/4))||(emptyCellId-newEmpty==1&&(newEmpty/4==emptyCellId/4)))) {
		swapButton(buttons[emptyCellId],buttonClicked);
		//emptyCellId=game.getEmptyCellId()
		flag=1;
		game.setEmptyCellId(newEmpty);
		}
		if(flag==1)
		return newEmpty;
		else return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		ArrayList<Integer> a1=new ArrayList<Integer>();
		int temp=0;
		for(int i=0;i<15;i++) {
			while(true) {
		temp = getRandomNumber();
		temp=temp*15/100+1;
		
		if(!a1.contains(temp)) {
			
			a1.add(temp);
			
			break;
		}
			}
			//a1.add(i+1);
		
		}
		for(int i=0;i<15;i++)
			arr[i]=a1.get(i);
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int b_arr[]=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++) {
//			System.out.println(Arrays.toString(b_arr));
			if(b_arr[i]!=i+1)
			{	
				winner=false;
				break;
			}
		}
		return winner;
	}
}