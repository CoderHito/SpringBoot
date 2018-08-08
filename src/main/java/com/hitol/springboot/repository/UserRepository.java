package com.hitol.springboot.repository;

import com.hitol.springboot.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
    UserDO findByName(String name);


    UserDO findById(Integer id);

    /**
     * nativeQuery = true 采用原生sql方式来查询
     */
    @Query(nativeQuery = true, value = "select * from auth_user u where u.name=:name")
    UserDO findUser(@Param("name") String name);


/**
 *
 */
//    @Query("select a from auth_user  where name = :name")
//    UserDO findUserNew(@Param("name") String name);

}
