package com.cinema.exception;

import com.cinema.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Consts.NO_SEANS_FOUND)
public class SeansNotFoundException extends Exception {
    static final long serialVersionUID = -3387516993224229948L;


    public SeansNotFoundException(String message)
    {
        super(message);
    }
}
