import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {

    BowlingGame game = new BowlingGame();

    private void rollMany(int numberRolls, int numberPins) {
        for (int i = 0; i < numberRolls; i++) {
            game.roll(numberPins);
        }
    }
    
    @Test
    public void QueDesGoutieresDonne0Points() {
        rollMany(20, 0);
        assertEquals(0, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(0, game.nbOfStrikes());
        assertEquals(20, game.nbOfFails());
        assertEquals(20, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void UneSeuleQuille(){
        game.roll(1);
        rollMany(19, 0);
        assertEquals(1, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(0, game.nbOfStrikes());
        assertEquals(19, game.nbOfFails());
        assertEquals(20, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void QueDesUneSeuleQuille(){
        rollMany(20, 1);
        assertEquals(20, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(0, game.nbOfStrikes());
        assertEquals(0, game.nbOfFails());
        assertEquals(20, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void TricheEtFaitUnLancerDeTrop(){
        rollMany(21, 1);
        assertEquals(21, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(0, game.nbOfStrikes());
        assertEquals(0, game.nbOfFails());
        assertEquals(21, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(-1, game.checkIfNotWrong());
        assertEquals(true, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void TricheEtFaitDeuxLancersDeTrop(){
        rollMany(22, 1);
        assertEquals(22, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(0, game.nbOfStrikes());
        assertEquals(0, game.nbOfFails());
        assertEquals(22, game.nbOfRolls());
        assertEquals(11, game.nbOfFrames());
        assertEquals(-2, game.checkIfNotWrong());
        assertEquals(true, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void BonusDunSpare(){
        game.roll(8);
        game.roll(2);
        game.roll(1);
        rollMany(17, 0);
        assertEquals(12, game.score());
        assertEquals(1, game.nbObSpares());
        assertEquals(0, game.nbOfStrikes());
        assertEquals(17, game.nbOfFails());
        assertEquals(20, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void BonusDeuxSparesConsecutifs(){
        game.roll(8);
        game.roll(2);
        game.roll(8);
        game.roll(2);
        game.roll(1);
        game.roll(1);
        rollMany(14, 0);
        assertEquals(31, game.score());
        assertEquals(2, game.nbObSpares());
        assertEquals(0, game.nbOfStrikes());
        assertEquals(14, game.nbOfFails());
        assertEquals(20, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void FiniParSpare(){
        rollMany(18, 0);
        game.roll(8);
        game.roll(2);
        game.roll(1);
        assertEquals(11, game.score());
        assertEquals(1, game.nbObSpares());
        assertEquals(0, game.nbOfStrikes());
        assertEquals(18, game.nbOfFails());
        assertEquals(21, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(true, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void FiniParStrikePuisSpare(){
        rollMany(18, 0);
        game.roll(10);
        game.roll(2);
        game.roll(8);
        assertEquals(20, game.score());
        assertEquals(1, game.nbObSpares());
        assertEquals(1, game.nbOfStrikes());
        assertEquals(18, game.nbOfFails());
        assertEquals(21, game.nbOfRolls());
        assertEquals(11, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(true, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void BonusDunStrike(){
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(1, game.nbOfStrikes());
        assertEquals(16, game.nbOfFails());
        assertEquals(19, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void BonusDeuxStrikesConsecutifs(){
        game.roll(10);
        game.roll(10);
        game.roll(4);
        game.roll(2);
        game.roll(4);
        game.roll(4);
        rollMany(12, 0);
        // score from https://en.wikipedia.org/wiki/Strike_(bowling)
        assertEquals(54, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(2, game.nbOfStrikes());
        assertEquals(12, game.nbOfFails());
        assertEquals(18, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void FiniParStrike(){
        rollMany(18, 0);
        game.roll(10);
        game.roll(2);
        game.roll(1);
        assertEquals(13, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(1, game.nbOfStrikes());
        assertEquals(18, game.nbOfFails());
        assertEquals(21, game.nbOfRolls());
        assertEquals(11, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(true, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void QueDesStrikes(){
        rollMany(11, 10);
        assertEquals(300, game.score());
        assertEquals(0, game.nbObSpares());
        assertEquals(11, game.nbOfStrikes());
        assertEquals(0, game.nbOfFails());
        assertEquals(11, game.nbOfRolls());
        assertEquals(11, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(true, game.checkIfHasWonExtraFrame());
    }
     
    @Test
    public void SpareSuiviDunStrike(){
    	game.roll(9);
    	game.roll(1);
    	game.roll(10);
        rollMany(2, 2);
        rollMany(14, 0);
        assertEquals(38, game.score());
        assertEquals(1, game.nbObSpares());
        assertEquals(1, game.nbOfStrikes());
        assertEquals(14, game.nbOfFails());
        assertEquals(19, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void StrikeSuiviDunSpare(){
    	game.roll(10);
    	game.roll(9);
    	game.roll(1);
        rollMany(16, 2);
        assertEquals(64, game.score());
        assertEquals(1, game.nbObSpares());
        assertEquals(1, game.nbOfStrikes());
        assertEquals(0, game.nbOfFails());
        assertEquals(19, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void StrikeSpareStrike(){
    	game.roll(10);
    	game.roll(9);
    	game.roll(1);
    	game.roll(10);
        rollMany(2, 2);
        rollMany(12, 0);
        assertEquals(58, game.score());
        assertEquals(1, game.nbObSpares());
        assertEquals(2, game.nbOfStrikes());
        assertEquals(12, game.nbOfFails());
        assertEquals(18, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void ReproduireUnVraiScore1() {
    	// Use: http://forum.brice.free.fr/index.php?section=regles
        game.roll(7);
        game.roll(2);
        game.roll(8);
        game.roll(2);
        game.roll(5);
        game.roll(4);
        game.roll(10);
        game.roll(8);
        game.roll(0);
        game.roll(6);
        game.roll(0);
        game.roll(8);
        game.roll(1);
        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(10);
        game.roll(7);
        game.roll(0);
        assertEquals(131, game.score());
        assertEquals(2, game.nbObSpares());
        assertEquals(3, game.nbOfStrikes());
        assertEquals(3, game.nbOfFails());
        assertEquals(19, game.nbOfRolls());
        assertEquals(11, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(true, game.checkIfHasWonExtraFrame());
    }
   
    @Test
    public void StrikeSuiviDeuxSpares(){
    	game.roll(10);
    	game.roll(7);
    	game.roll(3);
    	game.roll(5);
    	game.roll(5);
        rollMany(2, 2);
        rollMany(12, 0);
        assertEquals(51, game.score());
        assertEquals(2, game.nbObSpares());
        assertEquals(1, game.nbOfStrikes());
        assertEquals(12, game.nbOfFails());
        assertEquals(19, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void ReproduireUnVraiScore2() {
    	// Use: https://www.tutorialspoint.com/ten_pin_bowling/ten_pin_bowling_scoring.htm == took the line of DH
        game.roll(10);
        game.roll(8);
        game.roll(2);
        game.roll(9);
        game.roll(1);
        game.roll(8);
        game.roll(0);
        game.roll(10);
        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(9);
        game.roll(1);
        game.roll(10);
        game.roll(10);
        game.roll(9);
        game.roll(1);
        assertEquals(202, game.score());
        assertEquals(5, game.nbObSpares());
        assertEquals(5, game.nbOfStrikes());
        assertEquals(1, game.nbOfFails());
        assertEquals(17, game.nbOfRolls());
        assertEquals(11, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(true, game.checkIfHasWonExtraFrame());
    }
    
    @Test
    public void ReproduireUnVraiScore3() {
    	// Use: https://www.tutorialspoint.com/ten_pin_bowling/ten_pin_bowling_scoring.htm == took the line of DT
        game.roll(7);
        game.roll(3);
        game.roll(10);
        game.roll(10);
        game.roll(8);
        game.roll(1);
        game.roll(9);
        game.roll(1);
        game.roll(8);
        game.roll(1);
        game.roll(10);
        game.roll(9);
        game.roll(1);
        game.roll(8);
        game.roll(2);
        game.roll(6);
        game.roll(1);
        assertEquals(164, game.score());
        assertEquals(4, game.nbObSpares());
        assertEquals(3, game.nbOfStrikes());
        assertEquals(0, game.nbOfFails());
        assertEquals(17, game.nbOfRolls());
        assertEquals(10, game.nbOfFrames());
        assertEquals(0, game.checkIfNotWrong());
        assertEquals(false, game.checkIfCheater());
        assertEquals(false, game.checkIfHasWonExtraRoll());
        assertEquals(false, game.checkIfHasWonExtraFrame());
    }
}