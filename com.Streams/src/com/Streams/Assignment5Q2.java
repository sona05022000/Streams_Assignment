package com.Streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class News {
    private int newsId;
    private String postedByUser;
    private String commentByUser;
    private String comment;

    public News(int newsId, String postedByUser, String commentByUser, String comment) {
        this.newsId = newsId;
        this.postedByUser = postedByUser;
        this.commentByUser = commentByUser;
        this.comment = comment;
    }

    public int getNewsId() {
        return newsId;
    }

    public String getPostedByUser() {
        return postedByUser;
    }

    public String getCommentByUser() {
        return commentByUser;
    }

    public String getComment() {
        return comment;
    }
}

public class Assignment5Q2 {
    public static int maxComments(List<News> news) {
        int maxComments = Integer.MIN_VALUE;
        int maxCommentsNewsId = -1;
        Map<Integer, Integer> commentCounts = new HashMap<>();
        for (News n : news) {
            int count = commentCounts.getOrDefault(n.getNewsId(), 0) + 1;
            commentCounts.put(n.getNewsId(), count);
            if (count > maxComments) {
                maxComments = count;
                maxCommentsNewsId = n.getNewsId();
            }
        }
        return maxCommentsNewsId;
    }

    public static int budgetCount(List<News> news) {
        int count = 0;
        for (News n : news) {
            if (n.getComment().toLowerCase().contains("budget")) {
                count++;
            }
        }
        return count;
    }

    public static String maxCommentsByUser(List<News> news) {
        Map<String, Integer> commentCounts = new HashMap<>();
        for (News n : news) {
            int count = commentCounts.getOrDefault(n.getCommentByUser(), 0) + 1;
            commentCounts.put(n.getCommentByUser(), count);
        }
        String maxCommentUser = null;
        int maxComments = Integer.MIN_VALUE;
        for (String user : commentCounts.keySet()) {
            int count = commentCounts.get(user);
            if (count > maxComments) {
                maxComments = count;
                maxCommentUser = user;
            }
        }
        return maxCommentUser;
    }

    public static Map<String, Integer> sortMaxCommentsByUser(List<News> news) {
        Map<String, Integer> commentCounts = new HashMap<>();
        for (News n : news) {
            int count = commentCounts.getOrDefault(n.getCommentByUser(), 0) + 1;
            commentCounts.put(n.getCommentByUser(), count);
        }
        Map<String, Integer> sortedCommentCounts = new LinkedHashMap<>();
        commentCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedCommentCounts.put(entry.getKey(), entry.getValue()));
        return sortedCommentCounts;
    }

    public static void main(String[] args) {
        List<News> newsList = new ArrayList<>();
        newsList.add(new News(1, "user1", "commenter1", "This is the first comment about the budget"));
        newsList.add(new News(1, "user2", "commenter2", "I agree with commenter1"));
        newsList.add(new News(2, "user1", "commenter3", "This is the first comment about the politics"));
        newsList.add(new News(2, "user3", "commenter4", "I disagree with commenter3"));

        System.out.println("News ID with maximum comments: " + maxComments(newsList));
        System.out.println("Number of times the word 'budget' appears in user comments: " + budgetCount(newsList));
        System.out.println("User with the maximum comments: " + maxCommentsByUser(newsList));
        System.out.println("CommentByUser wise number of comments: " + sortMaxCommentsByUser(newsList));
    }
}
