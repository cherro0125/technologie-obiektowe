package pl.psk.to.mmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.base.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class Skill extends Auditable {
    private Long id;
    private String name;
    private BaseStatistic baseStatistic;
    private Boolean isPassive;
}
