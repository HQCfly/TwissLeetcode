package com.twiss.flexport;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、使用map定义key是颜色，value是所需要的数量，然后对比card和player的对应颜色的数量是否一致问题
 * 2、定义Tokens结构，从结构里面获取各个颜色的数量对比是否一致
 * @Author: Twiss
 * @Date: 2022/8/20 12:14 下午
 */
public class TokensCardGames {

    public boolean canPurchase(Map<String,Integer> card, Map<String,Integer> player) {
        Map<String,Integer> resultCard = new HashMap<>();
        for (String tokenCard : player.keySet()) {
            if (!card.containsKey(tokenCard)) {
                return false;
            } else {
                resultCard.put(tokenCard, card.get(tokenCard) - player.get(tokenCard));
            }
        }
        for (String tokenCard : resultCard.keySet()) {
            if (resultCard.get(tokenCard) > 0) {
                return false;
            }
        }
        return true;
    }

    public void purchase(Map<String,Map<String,Integer>> cards, Map<String,Integer> player) {
        for (String cardName:cards.keySet()){
            Map<String,Integer> card = cards.get(cardName);
            if (canPurchase(card,player)){
                for (String tokenCard:player.keySet()){
                    player.put(tokenCard,player.get(tokenCard)-card.get(tokenCard));
                }
                player.put(cardName,player.getOrDefault(cardName,0)+1);
            }
        }
    }

    public static void main(String[] args) {
        TokensCardGames tg = new TokensCardGames();
        Map<String,Map<String,Integer>> cards = new HashMap<>();
        Map<String,Integer> cardA = new HashMap<>();
        cardA.put("WH",2);
        cardA.put("BL",1);
        cardA.put("B",4);
        cards.put("cardA",cardA);

        Map<String,Integer> player = new HashMap<>();
        player.put("WH",4);
        player.put("BL",2);
        player.put("B",5);

        for (String cardName:cards.keySet()){
            boolean valid = tg.canPurchase(cards.get(cardName),player);
            System.out.println(valid);
        }

        tg.purchase(cards, player);

    }
}
