import java.util.ArrayList;
import java.util.Collections;

public class Hand {

    private ArrayList<Card> handCard ;

    public Hand(){
        handCard = new ArrayList<Card>();
    }

    public void drawCard(Deck deck){
        handCard.add(deck.takeCard());
    }

    public void clearHandCard(){
        handCard.clear();
    }

    public Card showCard(int x){
        return handCard.get(x);
    }

    public int deckSize(){
        return handCard.size();
    }
    public int sumOfHandCard(){
        int sum=0;
        int aceRemain = 0;
        for(Card card : handCard){
            sum+=card.getValue();

            if(card.getRank().equals(Rank.ACE)){
                aceRemain++;
            }
        }
        while(sum>21&&aceRemain>0){
            aceRemain--;
            sum-=10;
        }
        return sum;
    }

    public String toString(){
        String output="" ;
        for(Card card: handCard){
            output += card + " - ";
        }
        return output;
    }

    public Boolean blackJack(){
        if(sumOfHandCard()==21){
            return true;
        }
        return false;
    }

    public Boolean busted(){
        if(sumOfHandCard()>21){
            return true;
        }
        return false;
    }

    public void replaceCard(Deck deck){
        deck.addAllCards(handCard);
        handCard.clear();
    }
}
