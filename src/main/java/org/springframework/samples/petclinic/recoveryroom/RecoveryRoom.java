package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recoveryrooms")
public class RecoveryRoom extends BaseEntity{

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Min(0)
    private double size;

    @NotNull
    private boolean secure;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recoveryroom_type")
    @NotNull
    private RecoveryRoomType roomType;
}
