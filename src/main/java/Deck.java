import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck ;

    public Deck(){
        deck = new ArrayList<Card>();
    }

    public Deck(Deck c){
        Collections.copy(this.deck, c.getCards());
    }

    public Deck(Boolean createHandCard){
        deck = new ArrayList<>();
        if(createHandCard){
            for(Suit suit : Suit.values()){
                for(Rank rank : Rank.values()){
                    deck.add(new Card(rank, suit));
                }
            }
        }
    }

    public void addCard(Card card){
        deck.add(card);
    }

    public void addAllCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public ArrayList<Card> getCards(){
        return deck;
    }

    public Card takeCard(){
        deck.remove(0);
        return deck.get(0);
    }

    public int cardRemains(){
        return deck.size();
    }

    public void clearDeck(){
        deck.clear();
    }
}
