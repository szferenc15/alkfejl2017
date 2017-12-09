package ca.irvine.cinema_inner_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @Column(columnDefinition = "VARCHAR2(20)")
    private String category;

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }
}