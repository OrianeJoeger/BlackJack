import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hand {

    private LinkedList<Card> cardList;

    public Hand() {
        this.cardList = new LinkedList<Card>();
    }

    public String toString() {
        return this.cardList.toString() + " : " + this.count();
    }

    public void add(Card card) {
        this.cardList.add(card);
    }

    public void clear() {
        this.cardList.clear();
    }

    public List<Integer> count() {
        LinkedList<Integer> maListe = new LinkedList<Integer>();
        int taille;
        int val;

        maListe.add(0);
        for (int i = 0; i < this.cardList.size(); i++) {
            taille = maListe.size();
            for (int j = 0; j < taille; j++) {
                val = maListe.get(j); // on récupère dans la liste de résultat, le résultat à l'indice j
                val += cardList.get(i).getPoints();
                maListe.set(j, val);
                if (cardList.get(i).getPoints() == 1) {
                    maListe.add(val + 10); // on ajoute 10 au lieu de 11 car 1 a déjà été pris en compte avant
                }
            }
        }
        return maListe;
    }

    public int best() {
        List<Integer> maListe = this.count();
        Collections.sort(maListe);
        int sizeList = maListe.size()-1;
        
        for (int i = sizeList; i >= 0; i--) {
            if (maListe.get(i) <= 21) {
                return maListe.get(i);
            }
        }
        return maListe.get(sizeList);
    }
}
