public class BowlingGame {

	private int rollsToPlay=20; 
    private int framesToPlay=10;
    private int roll1Score=0;
    private int strikeBonusCountRoll=0;
    private boolean frameIn2Rolls=false;
    private boolean isSpare=false;
    private boolean isStrike=false;
    
    	
    private int score;
    private int totalNbStrikes=0; 
    private int totalNbSpares=0;
    private int totalNbFails=0;
    private int totalNbFrames=0;
    private int totalNbRolls=0;
    private int checkIfNotWrong=1;
    private boolean alertCheater=false;
    private boolean hasWonExtraRoll=false;
    private boolean hasWonExtraFrame=false;
         
    public int score() {
        return score;
    }   
    
    public int nbObSpares() {
        return totalNbSpares;
    } 
    
    public int nbOfStrikes() {
        return totalNbStrikes;
    } 
    
    public int nbOfFails() {
        return totalNbFails;
    } 
    
    public int nbOfRolls() {
        return totalNbRolls;
    } 
    
    public int nbOfFrames() {
        return totalNbFrames;
    } 
    
    public int checkIfNotWrong() {
        return checkIfNotWrong;
    } 
    
    public boolean checkIfCheater() {
        return alertCheater;
    } 
    
    public boolean checkIfHasWonExtraRoll() {
        return hasWonExtraRoll;
    } 
    
    public boolean checkIfHasWonExtraFrame() {
        return hasWonExtraFrame;
    } 
      
    public void roll(int numberPins) {
    	if (numberPins == 10) {
    		if (isStrike==true && strikeBonusCountRoll>2) {
    			strikeBonusCountRoll-=2;
    			score+=numberPins;
    			score+=numberPins;
    		}
    		else if (isStrike==true && strikeBonusCountRoll<=2 && strikeBonusCountRoll>0) {
    			strikeBonusCountRoll--;
    			score+=numberPins;
    		}
    		if (isSpare==true) {
    			isSpare=false;
    			score+=numberPins;
    		}
    		framesToPlay--; 
    		rollsToPlay-=2;
    		isStrike=true;
    		totalNbStrikes++;
    		totalNbFrames++;
    		totalNbRolls++;
    		score+=10;
    		strikeBonusCountRoll+=2;
    		// Allow to add one frame if game is finishing by a strike
			if (hasWonExtraFrame!= true && framesToPlay==0 && rollsToPlay==0 && isStrike==true) {
		    	rollsToPlay+=2;
		    	framesToPlay++;
		    	hasWonExtraFrame=true;
		    }
    	}  
    	else {
    		if (isStrike==true && strikeBonusCountRoll>2 && hasWonExtraFrame!=true) {
    			strikeBonusCountRoll-=2;
    			score+=numberPins;
    			score+=numberPins;
    		}
    		else if (isStrike==true && strikeBonusCountRoll>2 && hasWonExtraFrame==true) {
    			strikeBonusCountRoll--;
    			score+=numberPins;
    		}
    		else if ((isStrike==true && strikeBonusCountRoll<=2 && strikeBonusCountRoll>0 && hasWonExtraFrame!=true)) {
    			strikeBonusCountRoll--;
    			score+=numberPins;
    		}
    		else {
    			isStrike=false;
    		}
    		if (isSpare==true ) {
    			isSpare=false;
    			if (hasWonExtraRoll!=true) {
    				score+=numberPins;
    			}
    		}
    		if (roll1Score+numberPins==10) {
    			isSpare=true;
    			totalNbSpares++;
    		}
    		if (numberPins == 0) {
    			totalNbFails++;
    		}
    		score+=numberPins;
    		totalNbRolls++;
    		rollsToPlay--;
    		if (frameIn2Rolls==false) {
    			frameIn2Rolls=true; 
    			roll1Score=numberPins;
    		}
    		else {
    			frameIn2Rolls=false; 
    			totalNbFrames++;
    			framesToPlay--;
    			roll1Score=0;
    		}

    	}
    	// Allow to add one roll if game is finished by a spare (if a strike, we add a frame and not a roll)
    	if (framesToPlay==0 && rollsToPlay==0 && isSpare==true && hasWonExtraFrame!=true) {
    		rollsToPlay++;
    		hasWonExtraRoll=true;
    	}
    	// Allow to check if we did something wrong. If something is wrong, we will get a negative number for checkIfNotWrong
    	if (framesToPlay == 0 && rollsToPlay==0) {
    		checkIfNotWrong--;
    	}
    	else if (rollsToPlay<0) {
    		checkIfNotWrong--;
    		alertCheater=true;
    	}	
    }
    

}