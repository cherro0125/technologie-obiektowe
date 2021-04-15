package pl.psk.to.mmo.model.item;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.BaseStatistic;
import pl.psk.to.mmo.model.base.Auditable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
public class Item extends Auditable {
    private Long id;
    private String name;
    private BaseStatistic statistic;
    @Enumerated(EnumType.STRING)
    private ItemType itemType;
}
