package model;

public class AvanceLigne extends Thread{
    Position pos;

    public AvanceLigne(Position p){
        this.pos = p;
    }

    @Override
    public void run(){
        while(true){
            try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}
            if(pos.getAvancement()<4) pos.avance();
        }
    }

}
