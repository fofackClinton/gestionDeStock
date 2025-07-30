package com.fintech.gestionDeStock.models;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @CreatedDate
    @JsonIgnore
    @Column(name= "created_at", nullable= false)
    private Instant creationDate;

    @LastModifiedDate
    @JsonIgnore
    @Column(name="last_modified_date")
    private Instant lastModiedDate;

}
