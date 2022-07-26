public enum Suit {
    CLUB("Clubs"),DIAMOND("Diamonds"),SPADE("Spades"),HEART("Hearts");

    private final String suitName;

    private Suit(String suitName){
        this.suitName = suitName;
    }

    public String suitName(){
        return suitName;
    }

}
