package com.hensoares.application.engine;

import com.hensoares.domain.entity.mock.MockMethodType;
import lombok.NonNull;

public record MockProcessingContext(@NonNull String path, @NonNull MockMethodType methodType) {
}
