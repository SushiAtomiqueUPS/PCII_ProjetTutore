package model;

public class Score extends Thread{
    private int score;

    public Score(){ this.score = 0; }

    //Accesseur qui renvoie l'attribut score
    public int getScore() {
        return score;
    }

    //Méthode run qui incrémente l'attribut score de 1 toutes les 1000ms
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
            this.score += 1;
        }
    }
}
