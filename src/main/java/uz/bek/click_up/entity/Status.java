package uz.bek.click_up.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.click_up.entity.template.AbstractUUIDEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Status extends AbstractUUIDEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Space space;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Category category;

    @Column(nullable = false)
    private String type;

    private String color;
}
