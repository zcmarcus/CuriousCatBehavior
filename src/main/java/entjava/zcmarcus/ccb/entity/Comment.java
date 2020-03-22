package entjava.zcmarcus.ccb.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type Comment.
 */
@Entity(name = "Comment")
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator =  "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "content_body")
    private String contentBody;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     * Instantiates a new Comment.
     */
    public Comment() {

    }

    /**
     * Instantiates a new Comment.
     *
     * @param contentBody  the content body
     * @param post         the post
     * @param user         the user
     */
    public Comment(String contentBody, Post post, User user) {
        this.contentBody = contentBody;
        this.post = post;
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets content body.
     *
     * @return the content body
     */
    public String getContentBody() {
        return contentBody;
    }

    /**
     * Sets content body.
     *
     * @param contentBody the content body
     */
    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets created date.
     *
     * @param createdDate the created date
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets modified date.
     *
     * @return the modified date
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets modified date.
     *
     * @param modifiedDate the modified date
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * Gets post.
     *
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    /**
     * Sets post.
     *
     * @param post the post
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", contentBody='" + contentBody + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", post=" + post +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(contentBody, comment.contentBody) &&
                Objects.equals(post, comment.post) &&
                Objects.equals(user, comment.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contentBody, post, user);
    }
}
