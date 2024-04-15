package com.lemon.backend.domain.users.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.lemon.backend.domain.characters.character.entity.Characters;
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

    private static final long serialVersionUID = -1641376469L;

    public static final QUsers users = new QUsers("users");

    public final com.lemon.backend.domain.base.QBaseEntity _super = new com.lemon.backend.domain.base.QBaseEntity(this);

    public final ListPath<Characters, com.lemon.backend.domain.character.entity.QCharacters> characterList = this.<Characters, com.lemon.backend.domain.character.entity.QCharacters>createList("characterList", Characters.class, com.lemon.backend.domain.character.entity.QCharacters.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final BooleanPath isDeleted = _super.isDeleted;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath nickname = createString("nickname");

    public final StringPath nicknameTag = createString("nicknameTag");

    public final StringPath provider = createString("provider");

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

