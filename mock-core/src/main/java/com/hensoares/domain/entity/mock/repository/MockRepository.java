package com.hensoares.domain.entity.mock.repository;

import com.hensoares.domain.entity.mock.Mock;
import com.hensoares.domain.entity.mock.MockMethodType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MockRepository extends JpaRepository<Mock, Long> {

    Optional<Mock> findByPathAndMethod(@NonNull final String path, @NonNull final MockMethodType methodType);

}
