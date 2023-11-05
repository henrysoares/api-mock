package com.hensoares.domain.entity.mock;

import com.hensoares.domain.entity.mock.details.MockDetails;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "MOCK")
@AllArgsConstructor
@Builder
@Getter
public class Mock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    String mockName;

    @Column(name = "METHOD", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    MockMethodType method;

    @Column(name = "IS_ACTIVE", nullable = false)
    boolean isActive;

    @Column(name = "DAT_CREATION", nullable = false)
    LocalDateTime creationDate;

    @Column(name = "DAT_UPDATE", nullable = false)
    LocalDateTime updateDate;

    @Setter
    @OneToOne(mappedBy = "mock", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    MockDetails mockDetails;

    @PrePersist
    void initialize(){
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    @PreUpdate
    void update(){
        this.updateDate = LocalDateTime.now();
    }
}
