package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoryInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_title")
    public Film filmTitle;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", referencedColumnName = "category")
    public Category category;
}