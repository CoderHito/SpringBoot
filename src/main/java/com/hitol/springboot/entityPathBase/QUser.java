package com.hitol.springboot.entityPathBase;

import com.hitol.springboot.model.UserDO;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathInits;

import javax.annotation.Nullable;

/** 
* 使用 EntityPathBase
* @author hitol 
* @date 2018/9/12 下午7:48
*/ 
public class QUser extends EntityPathBase<UserDO> {
//    public static final QUser user = new QUser(UserDO.class);
    public QUser(Class<? extends UserDO> type, String variable) {
        super(type, variable);
    }

    public QUser(Class<? extends UserDO> type, PathMetadata metadata) {
        super(type, metadata);
    }

    public QUser(Class<? extends UserDO> type, PathMetadata metadata, @Nullable PathInits inits) {
        super(type, metadata, inits);
    }
}
