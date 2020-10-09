package com.codeup.demo.repository;

import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
//    User findByUserName(String username); // select * from ads where title = ?
//    User findFirstByUserName(String username ); // select * from ads where title = ? limit 1
//
//    // The following method is equivalent to the built in `getOne` method, there's no need to create this example
//    @Query("from User a where a.id = ?1")
//    User getUserById(long id);
//
//    // The following method shows you how to use named parameters in a HQL custom query:
//    @Query("from User  a where a.username like %:term%")
//    List<Post> searchByUserNameLike(@Param("term") String term);
}
