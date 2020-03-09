//package entjava.zcmarcus.ccb.entity;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity(name = "Comment")
//@Table(name = "comments")
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator =  "native")
//    @GenericGenerator(name = "native", strategy = "native")
//    private int id;
//
//    @Column(name = "content_body")
//    private String contentBody;
//
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "created_date")
//    private Date createdDate;
//
//    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "modified_date")
//    private Date modifiedDate;
//
//    @ManyToOne
//
//}
