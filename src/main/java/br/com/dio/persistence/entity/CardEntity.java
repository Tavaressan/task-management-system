package br.com.dio.persistence.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CardEntity {
    private long id;

    private String title;

    private String description;

    private OffsetDateTime creationDate;

    private boolean isBlocked;
}
