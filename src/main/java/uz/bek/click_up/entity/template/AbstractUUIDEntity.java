package uz.bek.click_up.entity.template;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import uz.bek.click_up.entity.User;

import java.sql.Timestamp;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class AbstractUUIDEntity extends AbstractMainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
}