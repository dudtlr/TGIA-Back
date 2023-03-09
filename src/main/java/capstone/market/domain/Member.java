package capstone.market.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name =  "member_id")
    private Long id;
    private String user_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id")
    private Track track;
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender")
    private ChatMessage chatMessage;

    public Member() {
    }

    public Member(String user_id) {
        this.user_id = user_id;
    }

    //    @OneToMany
//    private List<Post> liked = new ArrayList<>();
//
//    public void addLiked(Post post) {
//        liked.add(post);
//    }
}