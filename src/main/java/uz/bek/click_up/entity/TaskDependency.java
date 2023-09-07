package uz.bek.click_up.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.click_up.entity.enums.DependencyType;
import uz.bek.click_up.entity.template.AbstractLongEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskDependency extends AbstractLongEntity {

    @ManyToOne
    private Task task;


    private String dependencyTaskLink;

    private DependencyType dependencyType;
}
