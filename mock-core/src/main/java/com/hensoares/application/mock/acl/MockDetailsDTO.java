package com.hensoares.application.mock.acl;

import com.fasterxml.jackson.databind.JsonNode;
import com.hensoares.domain.entity.mock.details.WorkflowType;
import lombok.NonNull;

public record MockDetailsDTO(
        JsonNode payload,
        @NonNull WorkflowType workflowType,
        JsonNode metadata) {
}
