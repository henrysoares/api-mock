package com.hensoares.application.mock.acl;

import com.fasterxml.jackson.databind.JsonNode;
import com.hensoares.domain.entity.mock.WorkflowType;
import lombok.NonNull;

/**
 * Anti-corruption-layer record.
 */
public record MockDetailsDTO(
        JsonNode payload,
        String path,
        @NonNull WorkflowType workflowType,
        JsonNode metadata) {
}
