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

/**
 * The type Post.
 */
@Entity(name = "Post")
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator =  "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "description_body")
    private String descriptionBody;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "post_tags", joinColumns = {
            @JoinColumn(name = "post_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "tag_id",
                    nullable = false, updatable = false) })
    private Set<Tag> tags = new HashSet<>();

    /**
     * Instantiates a new Post.
     */
    public Post() {
    }

    /**
     * Instantiates a new Post.
     *
     * @param user            the user
     * @param title           the title
     * @param videoUrl        the video url
     * @param descriptionBody the description body
     */
    public Post(User user, String title, String videoUrl, String descriptionBody) {
        this.user = user;
        this.title = title;
        this.videoUrl = videoUrl;
        this.descriptionBody = descriptionBody;
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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets video url.
     *
     * @return the video url
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * Sets video url.
     *
     * @param videoUrl the video url
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * Gets description body.
     *
     * @return the description body
     */
    public String getDescriptionBody() {
        return descriptionBody;
    }

    /**
     * Sets description body.
     *
     * @param descriptionBody the description body
     */
    public void setDescriptionBody(String descriptionBody) {
        this.descriptionBody = descriptionBody;
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
     * Gets comments.
     *
     * @return the comments
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Sets comments.
     *
     * @param comments the comments
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
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

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public Set<Tag> getTags() {
        return tags;
    }

    /**
     * Sets tags.
     *
     * @param tags the tags
     */
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Add comment.
     *
     * @param comment the comment
     */
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    /**
     * Delete comment.
     *
     * @param comment the comment
     */
    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(this);
    }


    /**
     * Add tag.
     *
     * @param tag the tag
     */
    public void addTag(Tag tag) {
        tags.add(tag);
        tag.addPost(this);
    }


    /**
     * Remove tag.
     *
     * @param tag the tag
     */
    public void removeTag(Tag tag) {
        comments.remove(tag);
        tag.removePost(this);
    }



    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", descriptionBody='" + descriptionBody + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                title.equals(post.title) &&
                videoUrl.equals(post.videoUrl) &&
                descriptionBody.equals(post.descriptionBody);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, videoUrl, descriptionBody);
    }
}
