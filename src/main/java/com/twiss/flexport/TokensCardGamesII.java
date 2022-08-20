package com.twiss.flexport;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、每种卡都有一个特定的颜色，
 * @Author: Twiss
 * @Date: 2022/8/20 12:14 下午
 */
public class TokensCardGamesII {

    private Map<String,Integer> card;
    private Map<String,Integer> player;
    private Map<String,Integer> playerCards;

    public TokensCardGamesII(){
        this.card = new HashMap<>();
        this.player = new HashMap<>();
        this.playerCards = new HashMap<>();
    }

    public boolean canPurchase() {
        Map<String,Integer> resultCard = new HashMap<>();
        for (String tokenCard : player.keySet()) {
            if (card.containsKey(tokenCard)) {

                resultCard.put(tokenCard, card.get(tokenCard)
                        - player.get(tokenCard)
                        -playerCards.getOrDefault(tokenCard,0));
                for (String resultCardName : resultCard.keySet()) {
                    if (resultCard.get(resultCardName) <= 0) {
                        return true;
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
                    player.put(tokenCard,player.get(tokenCard)
                            -card.get(tokenCard)
                            +playerCards.getOrDefault(tokenCard,0));
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
        TokensCardGamesII tg = new TokensCardGamesII();
        Map<String,Map<String,Integer>> cards = new HashMap<>();
        Map<String,Integer> redCard = new HashMap<>();
        redCard.put("Red",4);
        cards.put("Red",redCard);

        Map<String,Integer> player = new HashMap<>();
        player.put("Red",7);
        player.put("Blue",2);
        player.put("Black",5);
        tg.player = player;
        for (String cardName: cards.keySet()){
            tg.card = cards.get(cardName);
            boolean valid = tg.canPurchase();
            System.out.println(valid);
        }
        tg.purchase(cards, player);
        print(tg.player);
        print(tg.playerCards);
        tg.purchase(cards, player);
        print(tg.player);
        print(tg.playerCards);
    }
}
