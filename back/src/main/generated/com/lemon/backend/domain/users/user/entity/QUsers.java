package com.lemon.backend.domain.users.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = -1606036206L;

    public static final QUsers users = new QUsers("users");

    public final com.lemon.backend.domain.base.QBaseEntity _super = new com.lemon.backend.domain.base.QBaseEntity(this);

    public final ListPath<com.lemon.backend.domain.characters.entity.Characters, com.lemon.backend.domain.characters.entity.QCharacters> characterList = this.<com.lemon.backend.domain.characters.entity.Characters, com.lemon.backend.domain.characters.entity.QCharacters>createList("characterList", com.lemon.backend.domain.characters.entity.Characters.class, com.lemon.backend.domain.characters.entity.QCharacters.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<com.lemon.backend.domain.FavoriteSketchbook.entity.FavoriteSketchbook, com.lemon.backend.domain.FavoriteSketchbook.entity.QFavoriteSketchbook> favoriteSketchbooks = this.<com.lemon.backend.domain.FavoriteSketchbook.entity.FavoriteSketchbook, com.lemon.backend.domain.FavoriteSketchbook.entity.QFavoriteSketchbook>createList("favoriteSketchbooks", com.lemon.backend.domain.FavoriteSketchbook.entity.FavoriteSketchbook.class, com.lemon.backend.domain.FavoriteSketchbook.entity.QFavoriteSketchbook.class, PathInits.DIRECT2);

    public final ListPath<com.lemon.backend.domain.friend.entity.Friends, com.lemon.backend.domain.friend.entity.QFriends> friendList = this.<com.lemon.backend.domain.friend.entity.Friends, com.lemon.backend.domain.friend.entity.QFriends>createList("friendList", com.lemon.backend.domain.friend.entity.Friends.class, com.lemon.backend.domain.friend.entity.QFriends.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    public final BooleanPath isLanguage = createBoolean("isLanguage");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath nickname = createString("nickname");

    public final StringPath nicknameTag = createString("nicknameTag");

    public final ListPath<com.lemon.backend.domain.notification.entity.Notification, com.lemon.backend.domain.notification.entity.QNotification> notificationList = this.<com.lemon.backend.domain.notification.entity.Notification, com.lemon.backend.domain.notification.entity.QNotification>createList("notificationList", com.lemon.backend.domain.notification.entity.Notification.class, com.lemon.backend.domain.notification.entity.QNotification.class, PathInits.DIRECT2);

    public final StringPath notificationToken = createString("notificationToken");

    public final EnumPath<Social> provider = createEnum("provider", Social.class);

    public final StringPath providerId = createString("providerId");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final ListPath<com.lemon.backend.domain.sketchbook.entity.Sketchbook, com.lemon.backend.domain.sketchbook.entity.QSketchbook> sketchbookList = this.<com.lemon.backend.domain.sketchbook.entity.Sketchbook, com.lemon.backend.domain.sketchbook.entity.QSketchbook>createList("sketchbookList", com.lemon.backend.domain.sketchbook.entity.Sketchbook.class, com.lemon.backend.domain.sketchbook.entity.QSketchbook.class, PathInits.DIRECT2);

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

