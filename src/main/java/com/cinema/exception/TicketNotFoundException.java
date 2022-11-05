package com.cinema.exception;

import com.cinema.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Consts.NO_TICKET_FOUND)
public class TicketNotFoundException extends Exception {


    static final long serialVersionUID = -3387516993224229948L;

    public TicketNotFoundException(String message)
    {
        super(message);
    }


}
