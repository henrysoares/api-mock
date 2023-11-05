package com.hensoares.interfaces.mock.dto;

import com.hensoares.domain.entity.mock.MockMethodType;
import lombok.NonNull;

public record MockCreationRequest(
        @NonNull String mockName,
        @NonNull MockMethodType mockMethodType,
        @NonNull MockDetailsCreationRecord mockDetails) {
}
