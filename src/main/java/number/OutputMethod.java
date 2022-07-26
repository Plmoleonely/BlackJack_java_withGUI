package number;


public class OutputMethod {
    private Ranknumber rankNumber;
    public OutputMethod() {
    }
    
    public int getCardValue(){
        int number = 0;
            switch (rankNumber){
                case ACE:
                    number=11;
                    break;
                case TWO:
                    number= 2;
                    break;
                case THREE:
                    number= 3;
                    break;
                case FOUR:
                    number=4;
                    break;
                case FIVE:
                    number= 5;
                    break;
                case SIX:
                    number= 6;
                    break;
                case SEVEN:
                    number= 7;
                    break;
                case EIGHT:
                    number= 8;
                    break;
                case NINE:
                    number= 9;
                    break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    number=10;
                    break;
            }
            return number;
        }
    
}
