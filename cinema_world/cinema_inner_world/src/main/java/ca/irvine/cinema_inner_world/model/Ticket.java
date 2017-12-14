package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {
    // START OF DEFAULT COLUMNS

    @Id
    @Size(min = 1, max = 30)
    private String type;

    @Range(min = 0)
    private short price;

    // END OF DEFAULT COLUMNS

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the price
     */
    public short getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(short price) {
        this.price = price;
    }
}