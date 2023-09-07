package uz.bek.click_up.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.click_up.entity.template.AbstractLongEntity;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeTracker extends AbstractLongEntity {

    @ManyToOne
    private Task task;

    private Timestamp startedAt;

    private Timestamp stoppedAt;
}
