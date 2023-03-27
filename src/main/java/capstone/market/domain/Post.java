package capstone.market.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post extends BaseEntity {
    @Id @GeneratedValue
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member who_posted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    protected Category category;
    private Integer price;

    private String post_title;
    private String post_text;



    private Integer views = 0;

    private Integer likes = 0;

    @OneToOne(fetch = FetchType.LAZY)
    private Purchased purchased;

    @OneToMany(mappedBy = "post")
    private List<ChatRoom> chatRooms = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;
    // time
    // place
    // depart
    // image
    public Post() {
    }

    public Post(Member who_posted) {
        this.who_posted = who_posted;
    }

    public Post(String post_title, String post_text) {
        this.post_title = post_title;
        this.post_text = post_text;
    }

    public Post(Member who_posted, Category category, Integer price, String post_title, String post_text, Image image) {
        this.who_posted = who_posted;
       this.category = category;
        this.price = price;
        this.post_title = post_title;
        this.post_text = post_text;
        this.image = image;
    }
}
