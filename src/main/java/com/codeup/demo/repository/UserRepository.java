package com.codeup.demo.repository;

import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends PostRepository <User, Long> {
    Post findByUserName(String username); // select * from ads where title = ?
    Post findFirstByUserName(String username ); // select * from ads where title = ? limit 1

    // The following method is equivalent to the built in `getOne` method, there's no need to create this example
    @Query("from User a where a.id = ?1")
    Post getUserById(long id);

    // The following method shows you how to use named parameters in a HQL custom query:
    @Query("from User  a where a. like %:term%")
    List<Post> searchByUserNameLike(@Param("term") String term);


}
