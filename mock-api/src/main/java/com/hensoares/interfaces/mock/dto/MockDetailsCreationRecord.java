package com.hensoares.interfaces.mock.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.hensoares.domain.entity.mock.details.WorkflowType;
import lombok.NonNull;

public record MockDetailsCreationRecord(
        @NonNull JsonNode payload,
        WorkflowType workflowType,
        JsonNode metadata) {
}
