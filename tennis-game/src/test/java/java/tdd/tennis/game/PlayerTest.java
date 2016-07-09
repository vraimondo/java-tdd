package java.tdd.tennis.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player djokovic;
    Player federer;

    @Before
    public void beforePlayerTest() {
        djokovic = new Player("Djokovic");
        federer = new Player("Federer");
    }


    @Test
    public void addPointsToPlayer(){
        djokovic.pointWon();
        djokovic.pointWon();
        federer.pointWon();

        assertEquals(2,djokovic.getScore());
        assertEquals(1,federer.getScore());
    }

}