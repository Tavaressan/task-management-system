package br.com.dio.persistence.entity;

import java.util.stream.Stream;

public enum TypeEnum {

    INITIAL,
    PENDING,
    FINISHED,
    CANCELLED;

    public static TypeEnum getByDbType (final String dbType){
    return Stream.of(TypeEnum.values())
            .filter(t -> t.name().startsWith(dbType.toUpperCase()))
            .findFirst()
            .orElseThrow();
    }

}
