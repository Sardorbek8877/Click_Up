package uz.bek.click_up.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.click_up.entity.template.AbstractLongEntity;
import uz.bek.click_up.entity.template.AbstractUUIDEntity;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskHistory extends AbstractUUIDEntity {

    @ManyToOne
    private Task task;

    private String ChangeFieldName;

    private boolean before;

    private boolean after;

    private String data;
}
