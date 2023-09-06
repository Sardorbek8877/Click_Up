package uz.bek.click_up.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.click_up.entity.template.AbstractLongEntity;
import uz.bek.click_up.entity.template.AbstractUUIDEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Icon extends AbstractLongEntity {

    @OneToOne
    private Attachment attachment;

    private String color;

    private String initialLetter;
}
