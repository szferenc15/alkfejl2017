package ca.irvine.cinema_inner_world.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trailer {
    @Id
    @Column(columnDefinition = "VARCHAR2(200)", insertable = false, updatable = false, nullable = false)
    private String url;
    
    @JsonBackReference()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_title")
    private Film filmTitle;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the filmTitle
     */
    public Film getFilmTitle() {
        return filmTitle;
    }
}