package com.hitol.springboot.repository;

import com.hitol.springboot.model.UserDO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@CacheConfig(cacheNames = "users")
@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
    @Cacheable
    UserDO findByName(String name);

    @Override
    Optional<UserDO> findById(Long aLong);
    //
//
//    UserDO findById(Integer id);
//
//    /**
//     * nativeQuery = true 采用原生sql方式来查询
//     */
//    @Query(nativeQuery = true, value = "select * from auth_user u where u.name=:name")
//    UserDO findUser(@Param("name") String name);
//
//
//    UserDO getOne(Integer id);

/**
 *
 */
//    @Query("select a from auth_user  where name = :name")
//    UserDO findUserNew(@Param("name") String name);

}
