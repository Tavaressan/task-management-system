package br.com.dio.persistence.entity;

import lombok.Data;

import java.util.List;

@Data
public class BoardEntity {

    private long id;

    private String name;

    private List<ColumnEntity> columns;
}
