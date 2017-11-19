package ca.irvine.cinema_inner_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import ca.irvine.cinema_inner_world.model.Film;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<Film,Integer>{
    Optional<Film> findByTitle(String title);
    Optional<Film> findByLanguage(String language);
    Optional<Film> findBySynchron(boolean isSynchron);
    Optional<Film> findByInscriptive(boolean isInscriptive);
    Optional<Film> findByImax(boolean isImax);
    Optional<Film> findByThreeDimensional(boolean isThreeDimensional);
    Optional<Film> findByFourDimensional(boolean isFourDimensional); 
    Optional<Film> findByPlayTime(int playTime);    
    Optional<Film> findByPremiere(Date premiereDate); 
    Optional<Film> findByAgeLimit(int ageLimit);
    Optional<Film> findByDirectorFirstName(String directorFName); 
    Optional<Film> findByDirectorLastName(String directorLName); 
    Optional<Film> findByCountry(String country);
    Optional<Film> findByYear(int year);
    Optional<Film> findByRate(BigDecimal rate); 
    Iterable<Film> findAll(); 
}