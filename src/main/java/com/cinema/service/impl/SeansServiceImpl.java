package com.cinema.service.impl;

import com.cinema.entity.Movie;
import com.cinema.entity.Seans;
import com.cinema.exception.SeansNotFoundException;
import com.cinema.repository.SeansRepository;
import com.cinema.service.MovieService;
import com.cinema.service.SeansService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.cinema.util.Consts.NO_SEANS_FOUND;

@Service
public class SeansServiceImpl implements SeansService {

    private final SeansRepository seansRepository;

    private final MovieService movieService;

    public SeansServiceImpl(SeansRepository seansRepository, MovieService movieService) {
        this.seansRepository = seansRepository;
        this.movieService = movieService;
    }
  @PostConstruct
    public void createSeanses() {

        // Create Titanic Seans

        Movie titanic = new Movie("Shire", LocalTime.of(7, 0), LocalTime.of(9, 0),
                5,
                100,
                29.90
        );

      titanic = movieService.createMovie(titanic);

        Seans firstTitanicSeans = new Seans();
      firstTitanicSeans.setSeansName("first Titanic");
      firstTitanicSeans.setSeansDate(LocalDate.of(2020, 12, 2));
      firstTitanicSeans.setMovie(titanic);

        seansRepository.save(firstTitanicSeans);

        // Create joker Seans

        Movie joker = new Movie(
                "Joker", LocalTime.of(10, 0), LocalTime.of(13, 0),
                11,
                50,
                59.90
        );

      joker = movieService.createMovie(joker);

        Seans firstJokerSeans = new Seans();
      firstJokerSeans.setSeansName("first seans Joker");
      firstJokerSeans.setSeansDate(LocalDate.of(2021, 1, 4));
      firstJokerSeans.setMovie(joker);

        seansRepository.save(firstJokerSeans);

        // Create Saw Seans

        Movie saw = new Movie(
                "Saw", LocalTime.of(14, 0), LocalTime.of(19, 0),
                18,
                40,
                99.90
        );


      saw = movieService.createMovie(saw);

        Seans firstSawSeans = new Seans();
      firstSawSeans.setSeansName("first seans Saw");
      firstSawSeans.setSeansDate(LocalDate.of(2021, 2, 7));
      firstSawSeans.setMovie(saw);

        seansRepository.save(firstSawSeans);

    }

    @Override
    public Seans getById(Long id) throws SeansNotFoundException {
        return seansRepository.getById(id).orElseThrow(
                () -> new SeansNotFoundException(NO_SEANS_FOUND)
        );
}
}
