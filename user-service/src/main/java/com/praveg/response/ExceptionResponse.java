package com.praveg.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private String message;
    private String error;
    private LocalDateTime timeStamp;
}
