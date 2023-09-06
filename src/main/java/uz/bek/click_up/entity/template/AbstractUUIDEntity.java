package uz.bek.click_up.entity.template;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import uz.bek.click_up.entity.User;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AbstractUUIDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

//    @Column(updatable = false, nullable = false)
//    @CreationTimestamp
//    private Timestamp createdAt;
//
//    @Column(nullable = false)
//    @UpdateTimestamp
//    private Timestamp updatedAt;
//
//    @CreatedBy
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(updatable = false)
//    private User createdBy;
//
//    @LastModifiedBy
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User updatedBy;
}