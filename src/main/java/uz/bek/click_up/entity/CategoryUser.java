package uz.bek.click_up.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.bek.click_up.entity.enums.TaskPermissions;
import uz.bek.click_up.entity.template.AbstractLongEntity;
import uz.bek.click_up.entity.template.AbstractUUIDEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryUser extends AbstractLongEntity {

    @ManyToOne
    private Category category;

    @ManyToOne
    private User member;

//    @Enumerated(value = EnumType.STRING)
//    @ElementCollection(fetch = FetchType.LAZY)
//    private List<TaskPermissions> taskPermissions;
}
