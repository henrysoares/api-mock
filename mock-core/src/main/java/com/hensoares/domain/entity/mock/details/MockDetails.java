package com.hensoares.domain.entity.mock.details;

import com.hensoares.domain.entity.mock.Mock;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "MOCK_DETAILS")
@AllArgsConstructor
@Builder
@Getter
public class MockDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "PAYLOAD")
    String payload;

    @Column(name = "WORKFLOW_SCRIPT")
    @Enumerated(EnumType.STRING)
    WorkflowType workflow;

    @Column(name = "METADATA")
    String metadata;

    @Column(name = "DAT_CREATION", nullable = false)
    LocalDateTime creationDate;

    @Column(name = "DAT_UPDATE", nullable = false)
    LocalDateTime updateDate;

    @OneToOne
    @JoinColumn(name = "mock_id")
    Mock mock;

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
