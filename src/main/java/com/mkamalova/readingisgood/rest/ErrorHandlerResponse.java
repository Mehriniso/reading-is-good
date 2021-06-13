package com.mkamalova.readingisgood.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorHandlerResponse
{
    private String responseCode;

    private String responseDescription;

    private LocalDateTime requestTimestamp;

    private String errorDetails;
}
