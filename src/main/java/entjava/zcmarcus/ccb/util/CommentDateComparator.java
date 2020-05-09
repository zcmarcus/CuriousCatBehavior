package entjava.zcmarcus.ccb.util;

import entjava.zcmarcus.ccb.entity.Comment;

import java.util.Comparator;

public class CommentDateComparator implements Comparator<Comment> {
    @Override
    public int compare(Comment comment1, Comment comment2) {
        return comment1.getCreatedDate().compareTo(comment2.getCreatedDate());
    }
}
