package com.hensoares.application.mock.acl;

import com.fasterxml.jackson.databind.JsonNode;
import com.hensoares.domain.entity.mock.MockMethodType;
import com.hensoares.domain.entity.mock.WorkflowType;
import lombok.NonNull;

/**
 * Anti-corruption-layer record.
 */
public record MockDTO(@NonNull String mockName,
                      @NonNull MockMethodType mockMethodType,
                      JsonNode payload,
                      int status,
                      String path,
                      @NonNull WorkflowType workflowType,
                      JsonNode metadata) {
}
