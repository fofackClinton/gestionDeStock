package com.fintech.gestionDeStock.handlers;

import java.util.ArrayList;
import java.util.List;

import com.fintech.gestionDeStock.exception.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private int httpCode;

    private ErrorCode errorCode;

    private String message;

    private List<String> errors = new ArrayList<>();
}
