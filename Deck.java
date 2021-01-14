import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private LinkedList<Card> cardList;

    public Deck(int nbBox) { // nbBox = nbr jeu
        this.cardList = new LinkedList<Card>(); // on crée une liste vide de cartes

        Value[] mesValeurs = Value.values();
        Color[] mesCouleurs = Color.values();

        for (int h = 0; h < nbBox; h++) {
            for (int i = 0; i < mesValeurs.length; i++) {
                for (int j = 0; j < mesCouleurs.length; j++) {
                    // on crée une variable qui init une nouvelle carte
                    Card card = new Card(mesValeurs[i], mesCouleurs[j]);
                    this.cardList.add(card);// on ajoute cette carte à la liste
                }
            }
        }

        Collections.shuffle(cardList);

    }

    public Card draw() throws EmptyDeckException {
        Card resultat = cardList.pollFirst();
        if (resultat == null) {
            throw new EmptyDeckException();
        } 
        return resultat;
        
    }

    public String toString() {
        return this.cardList.toString();
    }
}
