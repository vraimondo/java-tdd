package java.tdd.tennis.game;

public class Player {

    private String name;
    private int score;

    private static final String[] points = {"love", "fifteen", "thirty", "forty" };

    public Player(String name){

        this.name=name;
    }

    public int getScore(){

        return score;
    }

    public String getName(){

        return name;
    }

    public void pointWon(){

        score++;
    }

    public String pointDescription(){

        return points[score];
    }


}
