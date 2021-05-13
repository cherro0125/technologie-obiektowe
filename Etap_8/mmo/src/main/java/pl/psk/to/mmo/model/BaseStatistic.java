package pl.psk.to.mmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.base.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseStatistic extends Auditable {
    private Long id;
    private Integer intelligentValue;
    private Integer strengthValue;
    private Integer vitalityValue;
    private Integer luckValue;
    private Integer armor;
    private Integer magicArmor;
    private Integer attack;
    private Integer magicAttack;
    private Integer maxHp;
    private Integer maxMp;
    private Integer maxSp;
}
