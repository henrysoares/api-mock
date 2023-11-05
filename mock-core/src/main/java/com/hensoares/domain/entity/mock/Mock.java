package com.hensoares.domain.entity.mock;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * Class that represents the MOCK entity in the database.
 */
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "MOCK")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Mock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOCK_ID")
    Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    String mockName;

    /**
     * Request method type.
     */
    @Column(name = "METHOD", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    MockMethodType method;

    /**
     * Indicates if mock still available.
     */
    @Column(name = "IS_ACTIVE", nullable = false)
    boolean isActive;

    @Column(name = "REQUEST_PATH")
    String path;

    @Column(name = "PAYLOAD")
    String payload;

    @Column(name = "STATUS")
    int status;

    @Column(name = "WORKFLOW_SCRIPT")
    @Enumerated(EnumType.STRING)
    WorkflowType workflow;

    @Column(name = "METADATA")
    String metadata;

    @Column(name = "DAT_CREATION", nullable = false)
    LocalDateTime creationDate;

    @Column(name = "DAT_UPDATE", nullable = false)
    LocalDateTime updateDate;

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
