package live;

import music.Playable;
import music.string.Veena;
import music.wind.Saxophone;

public class Test {

    public static void main(String[] args) {

        Veena veena = new Veena();
        Saxophone saxophone = new Saxophone();

        System.out.println("Direct Objects:");
        veena.play();
        saxophone.play();

        System.out.println();

        Playable p;

        p = veena;
        p.play();

        p = saxophone;
        p.play();
    }
}