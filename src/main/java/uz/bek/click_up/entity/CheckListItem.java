package uz.bek.click_up.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.click_up.entity.template.AbstractLongEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckListItem extends AbstractLongEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private CheckList checkList;

    private boolean resolved;

    @ManyToOne
    private User assignedUser;
}
