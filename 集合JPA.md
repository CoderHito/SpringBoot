##集合JPA

1、 在POM文件中添加依赖

```
<dependency
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

2、在配置文件中添加配置

```
spring.jpa.properties.hibernate.hbm2ddl.auto=update
```

`spring.jpa.properties.hibernate.hbm2ddl.auto`是hibernate的配置属性，其主要作用是：自动创建、更新、验证数据库表结构。该参数的几种配置如下：

create：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
create-drop：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等应用第一次运行起来后才会。
validate：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。

3、创建实体

```
package com.hitol.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hitol
 * @date 2018/8/8 下午4:13
 */
@Entity
/**
 *这个类对应了一个数据库表
 */
@Table(name = "AUTH_USER")
/**
 *这里声明这个实体类对应的表名是 AUTH_USER。如果没有指定，则表名和实体的名称保持一致。
 */
public class UserDO {
    @Id
    /**
     * @Id 注解声明了实体唯一标识对应的属性。
     */
    private Long id;
    @Column(length = 32)
    /**
     * Column(length = 32) 用来声明实体属性的表字段的定义。默认的实体每个属性都对应了表的一个字段。字段的名称默认和属性名称保持一致（并不一定相等）。字段的类型根据实体属性类型自动推断。这里主要是声明了字符字段的长度。如果不这么声明，则系统会采用 255 作为该字段的长度
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

```
创建了实体之后，通过ORM框架，在系统启动的时候，会自动去数据库创建对应的表。


[![自动创建数据库.png](https://i.loli.net/2018/08/08/5b6aade539a0f.png)](https://i.loli.net/2018/08/08/5b6aade539a0f.png)

4、创建数据访问接口

```
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


//这种写法有异常出现，暂未解决
//    @Query("select a from auth_user  where name = :name")
//    UserDO findUserNew(@Param("name") String name);

}
```

service中直接调用repository接口就好。


```
package com.hitol.springboot.manager.impl;

import com.hitol.springboot.manager.UserManage;
import com.hitol.springboot.mapper.UserMapper;
import com.hitol.springboot.model.UserDO;
import com.hitol.springboot.model.UserPO;
import com.hitol.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageImpl implements UserManage {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository repository;


    @Override
    public List<UserPO> queryUserInfoList() {
        return userMapper.queryUserInfoList();
    }

    @Override
    public UserDO findByName(String name) {
        UserDO userDO = repository.findByName(name);
        return userDO;
    }

    @Override
    public UserDO findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public UserDO findUser(String name) {
        return repository.findUser(name);
    }
}

```


异常：
踩坑的过程总是令人心酸。

`org.hibernate.hql.internal.ast.QuerySyntaxException: table is not mapped`:还没查询到是因为啥