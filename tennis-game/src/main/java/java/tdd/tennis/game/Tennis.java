package java.tdd.tennis.game;

public class Tennis {

    private Player player1;
    private Player player2;

    public Tennis(Player player1, Player player2){
        this.player1=player1;
        this.player2=player2;
    }

    private String getPlayerLead(){
        return player1.getScore() > player2.getScore()? player1.getName() : player2.getName();
    }

    public String getScoreGame(){
        if(player1.getScore() >=3 && player2.getScore() >= 3){
            if(Math.abs(player1.getScore() - player2.getScore()) == 1){
                return "advantage " + getPlayerLead();
            }else if(player1.getScore() == player2.getScore()){
                return  "deuce";
            }else if(Math.abs(player1.getScore() - player2.getScore()) >= 2){
                return getPlayerLead() + " won";
            }else{
                return player1.pointDescription() + ", " + player2.pointDescription();
            }
        }else{
            return player1.pointDescription() + ", " + player2.pointDescription();
        }

    }




}
