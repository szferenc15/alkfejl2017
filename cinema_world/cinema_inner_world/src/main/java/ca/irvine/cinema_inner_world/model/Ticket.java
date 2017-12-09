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

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the basicPrice
     */
    public short getBasicPrice() {
        return basicPrice;
    }

    /**
     * @return the imaxPrice
     */
    public short getImaxPrice() {
        return imaxPrice;
    }

    /**
     * @return the imaxGlassPrice
     */
    public short getImaxGlassPrice() {
        return imaxGlassPrice;
    }

    /**
     * @return the threeDimensionalPrice
     */
    public short getThreeDimensionalPrice() {
        return threeDimensionalPrice;
    }

    /**
     * @return the threeDimensionalGlassPrice
     */
    public short getThreeDimensionalGlassPrice() {
        return threeDimensionalGlassPrice;
    }

    /**
     * @return the fourDimensionalPrice
     */
    public short getFourDimensionalPrice() {
        return fourDimensionalPrice;
    }

    /**
     * @return the fourDimensionalGlassPrice
     */
    public short getFourDimensionalGlassPrice() {
        return fourDimensionalGlassPrice;
    }

    /**
     * @return the bedRoomPrice
     */
    public short getBedRoomPrice() {
        return bedRoomPrice;
    }

    /**
     * @return the bedRoomGlassPrice
     */
    public short getBedRoomGlassPrice() {
        return bedRoomGlassPrice;
    }
}