package com.hensoares.domain.entity.mock.repository;

import com.hensoares.domain.entity.mock.Mock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockRepository extends JpaRepository<Mock, Long> {
}
