package uz.bek.click_up.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.click_up.entity.template.AbstractUUIDEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
public class Attachment extends AbstractUUIDEntity {

    private String name;

    private String originalName;

    private Long size;

    private String contentType;
}
