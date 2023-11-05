package com.hensoares.interfaces.mock;

import com.hensoares.application.MockApplicationService;
import com.hensoares.interfaces.mock.dto.MockCreationRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hensoares.interfaces.RestConstants.DEFAULT_MOCK_BASE_ENDPOINT;

@RestController
@RequestMapping(DEFAULT_MOCK_BASE_ENDPOINT)
public class MockManagementResource {

    @Autowired
    MockApplicationService mockApplicationService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createMock(@NonNull @Validated @RequestBody MockCreationRequest request){
        mockApplicationService.createMock(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
