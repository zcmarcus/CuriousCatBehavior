package entjava.zcmarcus.ccb.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a keyword or tag that can be associated with a post.
 */
@Entity(name = "Tag")
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator =  "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "tag_name")
    private String tagName;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private Set<Post> taggedPosts = new HashSet<>();

    /**
     * Instantiates a new Tag.
     */
    public Tag() {

    }

    /**
     * Instantiates a new Tag.
     *
     * @param tagName the tag name
     */
    public Tag(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Instantiates a new Tag with posts.
     *
     * @param tagName the tag name
     * @param posts   the posts
     */
    public Tag(String tagName, Set<Post> posts) {
        this.tagName = tagName;
        this.taggedPosts = posts;
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
     * Gets tag name.
     *
     * @return the tag name
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Sets tag name.
     *
     * @param tagName the tag name
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Gets posts.
     *
     * @return the posts
     */
    public Set<Post> getTaggedPosts() {
        return taggedPosts;
    }

    /**
     * Sets posts.
     *
     * @param posts the posts
     */
    public void setTaggedPosts(Set<Post> posts) {
        this.taggedPosts = posts;
    }

    /**
     * Add post.
     *
     * @param post the post
     */
    public void addPost(Post post) {
        taggedPosts.add(post);
        post.addTag(this);
    }


    /**
     * Remove post.
     *
     * @param post the post
     */
    public void removePost(Post post) {
        taggedPosts.remove(post);
        post.removeTag(this);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id &&
                tagName.equals(tag.tagName);

    }


    @Override
    public int hashCode() {
        return Objects.hash(tagName);
    }
}
