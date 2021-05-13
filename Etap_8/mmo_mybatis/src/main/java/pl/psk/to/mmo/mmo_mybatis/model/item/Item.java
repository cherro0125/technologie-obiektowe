package pl.psk.to.mmo.mmo_mybatis.model.item;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.mmo_mybatis.model.BaseStatistic;
import pl.psk.to.mmo.mmo_mybatis.model.base.Auditable;

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
