package br.com.dio.persistence.entity;

import lombok.Data;

import java.util.List;

@Data
public class ColumnEntity {

    private Long id;

    private String name;

    private Integer orderOnBoard;

    private Type type;

    private List<CardEntity> cards;
}
