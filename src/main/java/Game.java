import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game implements ActionListener{
    
    protected Deck gameDeck;
    protected Deck usedHandDeck;
    protected Hand myHandDeck;
    protected Hand pcHandDeck;
    protected int win = 0, lose = 0, tie = 0, round = 1;
    String input;
    MyFrame frame;

    public Game(){
        frame = new MyFrame();
        gameDeck = new Deck(Boolean.TRUE);
        myHandDeck = new Hand();
        pcHandDeck = new Hand();
        usedHandDeck = new Deck();

        labelCardRemain();
        frame.button.addActionListener(this);
        frame.button2.addActionListener(this);
    }

    // Scanner enter = new Scanner(System.in);

    public void gameStart(){
        gameDeck.shuffle();
        startRound();
    }

    public void startRound(){
        System.out.println("================");
        System.out.println("開始遊戲"+"局數:"+this.round +" "+"win"+win+" "+"lose"+lose+" "+"tie"+tie);
        frame.label2.setText("開始遊戲!"+" 局數:"+this.round +" "+"win"+win+" "+"lose"+lose+" "+"tie"+tie);
        if(gameDeck.cardRemains()<=4){
            int message = JOptionPane.showConfirmDialog(null, "卡片不夠了，要重新遊玩遊戲嗎?", "無標題", JOptionPane.YES_NO_OPTION);
            System.out.println("卡片不夠了，要重新遊玩遊戲嗎?(y/n)");
            if(message == 0){
                gameOver();
            }
            else if(message == 1){
                System.exit(0);
            }
        }

        pcHandDeck.drawCard(gameDeck);
        myHandDeck.drawCard(gameDeck);
        pcHandDeck.drawCard(gameDeck);
        myHandDeck.drawCard(gameDeck);
        labelCardRemain();
        pcShowCard();
        meShowCard();
        winOrLose();

    }

    public void pcShowCard(){
        System.out.println("電腦的牌:");
        System.out.println(pcHandDeck.showCard(1));
        System.out.println("電腦還有一張蓋牌");
        frame.label3.setText("電腦的牌:" + pcHandDeck.showCard(1) + " 電腦還有一張蓋牌");
    }

    public void meShowCard(){
        System.out.println("我的牌");
        System.out.println(myHandDeck);
        System.out.println("我的牌合計:");
        System.out.println(myHandDeck.sumOfHandCard());
        frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
    }

    public void winOrLose(){
        if(pcHandDeck.blackJack() || myHandDeck.busted()){
            if(myHandDeck.blackJack()){
                System.out.println("平手"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
                frame.label5.setText("平手"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
                frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
                JOptionPane.showMessageDialog(null, "平手!!\n下一局開始...");
                this.tie++;
                this.round++;
                System.out.println("下一局開始.....");
                replacementWork();
                startRound();
            }
            System.out.println("電腦贏了"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label5.setText("電腦贏了"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
            JOptionPane.showMessageDialog(null, "可惜!!  電腦贏了!!!\n下一局開始...");
            this.lose++;
            this.round++;
            System.out.println("下一局開始....");
            replacementWork();
            startRound();
        }
        else if (myHandDeck.blackJack() || pcHandDeck.busted()){
            System.out.println("你贏了"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label5.setText("你贏了"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
            JOptionPane.showMessageDialog(null, "恭喜!!  你贏了!!!\n下一局開始...");
            this.win++;
            this.round++;
            System.out.println("下一局開始...");
            replacementWork();
            startRound();
        }
        else{
            frame.label6.setText("你要抽卡嗎?");
        }
    }

    public void compareSum(){
        if(myHandDeck.sumOfHandCard()> pcHandDeck.sumOfHandCard()){
            System.out.println("你贏了"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label5.setText("你贏了"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
            JOptionPane.showMessageDialog(null, "恭喜!!  你贏了!!!\n下一局開始...");
            this.win++;
            this.round++;
            System.out.println("下一局開始...");
            replacementWork();
            startRound();
        }
        else if(myHandDeck.sumOfHandCard()< pcHandDeck.sumOfHandCard()){
            System.out.println("電腦贏了"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label5.setText("電腦贏了"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
            JOptionPane.showMessageDialog(null, "可惜!!  電腦贏了!!!\n下一局開始...");
            this.lose++;
            this.round++;
            System.out.println("下一局開始....");
            replacementWork();
            startRound();
        }
        else if(myHandDeck.sumOfHandCard()== pcHandDeck.sumOfHandCard()){
            System.out.println("平手"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label5.setText("平手"+" "+"電腦排組"+pcHandDeck+"電腦合計"+pcHandDeck.sumOfHandCard());
            frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
            JOptionPane.showMessageDialog(null, "平手!!\n下一局開始...");
            this.tie++;
            this.round++;
            System.out.println("下一局開始.....");
            replacementWork();
            startRound();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("你要抽卡嗎?Ans:(y/n)"+"卡片剩餘: "+ gameDeck.cardRemains());
        if(e.getSource() == frame.button){
            frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
            chooseYes();
            labelCardRemain();
        }
        else if(e.getSource() == frame.button2){
            frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
            chooseNo();
            labelCardRemain();
        }
    }
    // public void makeUrChoose() {
        // System.out.println("你要抽卡嗎?Ans:(y/n)"+"卡片剩餘: "+ gameDeck.cardRemains());
    //     // input = enter.next();
    //     if(input.equals("y")){
    //         chooseYes();
    //     }
    //     else if(input.equals("n")){
    //         chooseNo();
    //     }
    // }

    public void chooseYes(){
        if(gameDeck.cardRemains()<=2){
            startRound();
        }
        myHandDeck.drawCard(gameDeck);
        pcDrawCard();
        pcShowCards();
        frame.label10.setText("我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard());
        System.out.println("我的合計:"+myHandDeck.sumOfHandCard()+" "+"我的排組"+myHandDeck);
        if(myHandDeck.sumOfHandCard() <= 21 && pcHandDeck.sumOfHandCard() <= 21){
            winOrLose();
        }
        winOrLose();
        compareSum();
    }

    public void chooseNo(){
        if(gameDeck.cardRemains()<=2){
            startRound();
        }
        pcDrawCard();
        winOrLose();
        compareSum();
    }

    public void pcDrawCard() {
        if (pcHandDeck.sumOfHandCard() < 17) {
            pcHandDeck.drawCard(gameDeck);
        }
    }
    public void pcShowCards(){
        String s = "電腦的 ";
        for(int i =2 ;i<pcHandDeck.deckSize();i++){
            System.out.println("電腦的第"+(i+1)+"張"+pcHandDeck.showCard(i));
            s = s + "第"+(i)+"張:"+ pcHandDeck.showCard(i) + " ";
        }
        frame.label4.setText(s);
    }

    public void labelCardRemain(){
        frame.label11.setText("卡片剩餘: "+ gameDeck.cardRemains());
    }


    /*把手牌丟回桌上的牌*/
    public void replacementWork(){
    myHandDeck.replaceCard(usedHandDeck);
    pcHandDeck.replaceCard(usedHandDeck);
    frame.label4.setText("");
    frame.label5.setText("");
    }

    public void cardReplaceBack(){
        gameDeck.addAllCards(usedHandDeck.getCards());
    }

    public void gameOver(){
        // this.win = 0;
        // this.lose = 0;
        // this.tie = 0;
        // this.round = 1;
        replacementWork();
        cardReplaceBack();
        usedHandDeck.clearDeck();
        gameStart();
    }
}
