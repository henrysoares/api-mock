package com.hensoares.interfaces.mock;

import com.hensoares.application.MockEngineApplicationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
public class MockEngineResource {

    MockEngineApplicationService mockEngineApplicationService;

    @RequestMapping(value = "/mock/**", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> handleGetMapping(@NonNull HttpServletRequest request){

        final var response = mockEngineApplicationService.processGetRequests(request);

        return ResponseEntity.status(response.status()).body(response.payload());
    }

    @RequestMapping(value = "/mock/**", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> handlePostMapping(@NonNull HttpServletRequest request){

        final var response = mockEngineApplicationService.processGetRequests(request);

        return ResponseEntity.status(response.status()).body(response.payload());
    }

    @RequestMapping(value = "/mock/**", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> handlePutMapping(@NonNull HttpServletRequest request){

        final var response = mockEngineApplicationService.processGetRequests(request);

        return ResponseEntity.status(response.status()).body(response.payload());
    }
}
