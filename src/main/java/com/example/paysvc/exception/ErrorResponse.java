package com.example.paysvc.exception;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {

    private final String message;
}
