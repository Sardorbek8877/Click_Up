package uz.bek.click_up.entity.template;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class AbstractUUIDEntity extends AbstractMainEntity{

//    @GeneratedValue(generator = "uuid2")
//    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
//    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @GeneratedValue
    private UUID id;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private UUID id;
}