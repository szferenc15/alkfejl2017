package ca.irvine.cinema_inner_world.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import ca.irvine.cinema_inner_world.model.Screening;
import java.sql.Time;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening,Integer>{
    Optional<Screening> findById(long id);
    Optional<Screening> findByTwoDimensional(boolean isTwoDimensional);    
    Optional<Screening> findByThreeDimensional(boolean isThreeDimensional);
    Optional<Screening> findByFourDimensional(boolean isFourDimensional);
    Optional<Screening> findByImax(boolean isImax);
    Optional<Screening> findByLanguage(String language);
    Optional<Screening> findBySynchron(boolean isSynchron);
    Optional<Screening> findByInscriptive(boolean isInscriptive);
    Optional<Screening> findByScreenDay(Date screenDay);
    Optional<Screening> findByScreenTime(Time screenTime);
    Iterable<Screening> findAll();
}