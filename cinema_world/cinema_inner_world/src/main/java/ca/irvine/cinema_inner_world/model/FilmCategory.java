package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FilmCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_title")
    private Film filmTitle;

    @JsonManagedReference()
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category", referencedColumnName = "category")
    private Category category;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the filmTitle
     */
    public Film getFilmTitle() {
        return filmTitle;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }
}