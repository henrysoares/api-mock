package com.hensoares.domain.entity.mock;

import lombok.Getter;
import lombok.NonNull;

/**
 * Enum that contains the request method types.
 * These types are used for mapping the mocks.
 */
@Getter
public enum MockMethodType {
    POST,
    GET,
    PUT,
    DELETE,
    PATCH;


    public static MockMethodType parseString(@NonNull final String value){
        try{
            return MockMethodType.valueOf(value);
        }catch (Exception e){
            throw e;
        }
    }
}
