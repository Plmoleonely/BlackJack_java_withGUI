public class Card  {
    private Rank rank;
    private Suit suit;

    public Card(){

    }
    public Card(Rank rank, Suit suit){
        this.rank=rank;
        this.suit=suit;

    }

    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    public int getValue(){
        return rank.rankValue();
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public String toString(){
        return (rank.rankString()+suit.suitName()+"="+this.getValue());
    }
}
