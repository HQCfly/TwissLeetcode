package com.twiss.heaps;


import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/9/10 10:55 下午
 */
public class Twitter {
    private class Tweet {

        /**
         * 推文id
         */
        private int id;
        /**
         * 发推文的时间的时间戳
         */
        private int timestamp;
        /**
         * 当前推文的下一条
         */
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    /**
     * 用户id和推文（单链表对应关系）
     */
    private Map<Integer, Tweet> twitter;

    /**
     * 用户id和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> followings;

    /**
     * 全局使用的时间错字段，用户每发一条推文之前+1
     */
    private static int timestamp = 0;

    /**
     * 合并k组推文使用的数据结构
     */
    private static PriorityQueue<Tweet> maxHeap;

    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
    }

    /**
     * 发送推文
     *
     * @param userId  用户id
     * @param tweetId 推文id
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)) {
            Tweet oleHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oleHead;
            twitter.put(userId, newHead);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /**
     * 获取最新的推文
     *
     * @param userId
     * @return
     */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();

        // 如果自己发推文也要算上
        if (twitter.containsKey(userId)) {
            maxHeap.offer(twitter.get(userId));
        }
        // 获取userId的关注列表（关注的up列表）,并将其up的推文存入heap中
        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followings.get(userId).size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = twitter.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }

        // 从heap中选出最新推文信息
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty()) {
            Tweet head = maxHeap.poll();
            res.add(head.id);

            if (head.next != null) {
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }

    /**
     * 关注功能
     *
     * @param followerId 发起关注者id
     * @param followeeId 被关注着 id （up主）
     */
    public void follow(int followerId, int followeeId) {
        // 被关注人不能少自己
        if (followeeId == followerId) {
            return;
        }
        // 获取我的关系圈
        Set<Integer> followingList = followings.get(followeeId);
        if (followingList == null) {
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        } else {
            if (followingList.contains(followeeId)){
                return;
            }
            followingList.add(followeeId);
        }
    }

    /**
     * 取消关注
     * @param followerId 发起取消关注者
     * @param followeeId 被取消的up主
     */
    public void unfollow(int followerId, int followeeId){
        if (followeeId==followerId){
            return;
        }

        // 获取我自己的关系列表
        Set<Integer> followingList = followings.get(followeeId);

        if (followingList==null){
            return;
        }
        // 删除up主
        followingList.remove(followeeId);
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);
        twitter.postTweet(1, 2);

        List<Integer> res22 = twitter.getNewsFeed(2);
        System.out.println(res22);


        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);
    }
}
