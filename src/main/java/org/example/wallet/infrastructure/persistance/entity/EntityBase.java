package org.example.wallet.infrastructure.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@Setter
@Getter
public class EntityBase {
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @PrePersist
    public void creationData() {
        final var now = LocalDateTime.now();
        setCreationDate(now);
        setUpdateDate(now);
    }

    @PreUpdate
    public void updateTime() {
        setUpdateDate(LocalDateTime.now());
    }
}
