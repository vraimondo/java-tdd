package java.tdd.tennis.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.hamcrest.CoreMatchers.not;

/*
Implement a simple tennis game

Rules:
Scores from zero to three points are described as "love", "fifteen", "thirty", and "forty" respectively.
If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "advantage" for the player in the lead.
If at least three points have been scored by each player, and the scores are equal, the score is "deuce".
A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
*/

public class TennisTest {

    Player djokovic;
    Player federer;
    Tennis match;

    @Before
    public void beforeTennisTest() {
        djokovic = new Player("Djokovic");
        federer = new Player("Federer");
        match = new Tennis(djokovic, federer);
    }

    @Test
    public void loveScore() {
        assertEquals("love, love", match.getScoreGame());
    }

    @Test
    public void fifteenScore() {
        djokovic.pointWon(); // 1 point won
        assertEquals("fifteen, love",match.getScoreGame());
    }

    @Test
    public void thirtyScore() {
        djokovic.pointWon();
        djokovic.pointWon();
        federer.pointWon();
        assertEquals("thirty, fifteen",match.getScoreGame());
    }

    @Test
    public void fortyScore() {
        for (int i=1; i<=3; i++){
            djokovic.pointWon();
        }
        assertEquals("forty, love",match.getScoreGame());
    }

    @Test
    public void advantageScore() {
        for (int i=1; i<=4; i++){
            djokovic.pointWon();
        }
        for (int j=1; j<=3; j++){
            federer.pointWon();
        }
        assertEquals("advantage Djokovic",match.getScoreGame());
    }

    @Test
    public void deuceScore() {
        for (int i=1; i<=3; i++){
            djokovic.pointWon();
            federer.pointWon();
        }
        assertEquals("deuce",match.getScoreGame());
        federer.pointWon();
        assertNotEquals(not("deuce"),match.getScoreGame());
    }

    @Test
    public void playerWonTheMatch() {
        for (int i=1; i<=5; i++){
            djokovic.pointWon();
        }
        for (int j=1; j<=3; j++){
            federer.pointWon();
        }
        String expected = "Djokovic won";
        String actual = match.getScoreGame();
        assertEquals(expected,actual);
    }
    
    
}


