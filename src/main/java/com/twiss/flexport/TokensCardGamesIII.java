package com.twiss.flexport;

import java.util.HashMap;
import java.util.Map;

/**
 * 有黄金卡
 * @Author: Twiss
 * @Date: 2022/8/20 12:14 下午
 */
public class TokensCardGamesIII {

    private Map<String,Integer> card;
    private Map<String,Integer> player;
    private Map<String,Integer> playerCards;
    private final static String GOLD_COLOR = "Gold";

    public TokensCardGamesIII(){
        this.card = new HashMap<>();
        this.player = new HashMap<>();
        this.playerCards = new HashMap<>();
    }

    public boolean canPurchase() {
        Map<String,Integer> resultCard = new HashMap<>();
        for (String tokenCard : player.keySet()) {
            if (card.containsKey(tokenCard)) {

                resultCard.put(tokenCard, card.get(tokenCard)
                        - player.get(tokenCard));
                for (String resultCardName : resultCard.keySet()) {
                    if (resultCard.get(resultCardName) <= 0) {
                        return true;
                    }else {
                        if (player.containsKey(GOLD_COLOR)){
                            int goldNums = player.get(GOLD_COLOR);
                            while (goldNums>0){
                                resultCard.put(resultCardName,resultCard.get(resultCardName)-1);
                                goldNums--;
                                if (resultCard.get(resultCardName)<=0){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void purchase(Map<String,Map<String,Integer>> cards, Map<String,Integer> player) {
        for (String cardName:cards.keySet()){
            card = cards.get(cardName);
            if (canPurchase()){
                for (String tokenCard:card.keySet()){
                    int remainderCard = player.get(tokenCard)
                            -card.get(tokenCard);
                    if(remainderCard>=0){
                        player.put(tokenCard,remainderCard);
                    }else {
                        player.put(tokenCard,0);
                        player.put(GOLD_COLOR, player.get(GOLD_COLOR)+remainderCard);
                    }
                }
                playerCards.put(cardName,playerCards.getOrDefault(cardName,0)+1);
            }
        }
    }

    public static void print(Map<String,Integer> map){

        StringBuilder res = new StringBuilder();
        res.append("{");
        int idx = 0;
        for (String key:map.keySet()){
            res.append("\"").append(key).append("\"").append(":").append(map.get(key));
            if (idx<map.size()-1){
                res.append(",");
            }
            idx++;
        }
        res.append("}");
        System.out.println(res);
    }

    /**
     * 假设：
     * card:{"Red":4}
     * player:{"Red":6,"Blue":7}
     * playerCards:{"Red":1}
     * @param args
     */
    public static void main(String[] args) {
        TokensCardGamesIII tg = new TokensCardGamesIII();
        Map<String,Map<String,Integer>> cards = new HashMap<>();
        Map<String,Integer> redCard = new HashMap<>();
        redCard.put("Red",4);
        cards.put("Red",redCard);

        Map<String,Integer> player = new HashMap<>();
        player.put("Red",6);
        player.put("Blue",2);
        player.put("Gold",5);
        tg.player = player;
        for (String cardName: cards.keySet()){
            tg.card = cards.get(cardName);
            boolean valid = tg.canPurchase();
            System.out.println(valid);
        }
        tg.purchase(cards, player);
        System.out.print("player:");
        print(tg.player);
        System.out.print("playerCards:");
        print(tg.playerCards);
        tg.purchase(cards, player);
        System.out.print("player:");
        print(tg.player);
        System.out.print("playerCards:");
        print(tg.playerCards);
    }
}
