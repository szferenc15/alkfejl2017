package ca.irvine.cinema_inner_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Ticket {
    // START OF DEFAULT COLUMNS

    @Id
    @Size(min = 1, max = 30)
    private String type;

    @Range(min = 0)
    private short basicPrice;

    @Range(min = 0)
    private short imaxPrice;

    @Range(min = 0)
    private short imaxGlassPrice;

    @Range(min = 0)
    private short threeDimensionalPrice;

    @Range(min = 0)
    private short threeDimensionalGlassPrice;

    @Range(min = 0)
    private short fourDimensionalPrice;

    @Range(min = 0)
    private short fourDimensionalGlassPrice;

    @Range(min = 0)
    private short bedRoomPrice;

    @Range(min = 0)
    private short bedRoomGlassPrice;

    // END OF DEFAULT COLUMNS
}