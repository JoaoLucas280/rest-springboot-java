package com.JoaoLucas.spring_boot_application.Aula03.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details){}
