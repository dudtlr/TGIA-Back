package capstone.market.repository;

import capstone.market.domain.Post;
import capstone.market.domain.Purchased;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class PostRepository {
    private final EntityManager em;

    public void savePost(Post post) {
        em.persist(post);
    }

    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    public List<Post> findAll() {
        return em.createQuery("select p from Post p")
                .getResultList();
    }

    public List<Post> findByUserId(String user_id) {
        String jpql = "select p from Post p join p.who_posted m where m.user_id = :user_id";

        return em.createQuery(jpql, Post.class)
                .setParameter("user_id", user_id)
                .getResultList();
    }

    // 구매 목록
    public List<Purchased> findBoughtListByUserId(Long user_id) {
        System.out.println("user_id&&&&&&&&&& = " + user_id);
//        String jpql = "select p from Post p join p.buyer m where m.user_id = :user_id";
        String jpql = "select p from Purchased p join p.member m where m.id = :user_id";
//        String jpql = "select p from Purchased p where p.purchased_id = :user_id";

        List<Purchased> list = em.createQuery(jpql, Purchased.class)
                .setParameter("user_id", user_id)
                .getResultList();

        return list;
    }
}
