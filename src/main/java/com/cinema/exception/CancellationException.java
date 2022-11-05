package com.cinema.exception;

import com.cinema.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = Consts.CANCEL_SURNAME_EXCEPTION)
public class CancellationException extends Exception{

    static final long serialVersionUID = -3387516993224229948L;


    public CancellationException(String message)
    {
        super(message);
    }
}
