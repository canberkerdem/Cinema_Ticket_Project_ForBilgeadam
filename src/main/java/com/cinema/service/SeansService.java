package com.cinema.service;

import com.cinema.entity.Seans;
import com.cinema.exception.SeansNotFoundException;

public interface SeansService {

    Seans getById(Long id) throws SeansNotFoundException;
}
