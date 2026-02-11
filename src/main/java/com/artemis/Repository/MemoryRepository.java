package com.artemis.Repository;

import com.artemis.Entity.MemoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoryRepository extends JpaRepository<MemoryEntity, Long> {
    List<MemoryEntity> findByUsername(String username);
}
