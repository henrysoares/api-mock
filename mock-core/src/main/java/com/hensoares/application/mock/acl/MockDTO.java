package com.hensoares.application.mock.acl;

import com.hensoares.domain.entity.mock.MockMethodType;
import lombok.NonNull;

public record MockDTO(@NonNull String mockName,
                      @NonNull MockMethodType mockMethodType,
                      @NonNull MockDetailsDTO mockDetails) {
}
