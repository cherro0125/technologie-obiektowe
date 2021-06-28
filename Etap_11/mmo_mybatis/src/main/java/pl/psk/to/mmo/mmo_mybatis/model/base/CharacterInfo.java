package pl.psk.to.mmo.mmo_mybatis.model.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.mmo_mybatis.model.BaseStatistic;

@EqualsAndHashCode(callSuper = true)
@Data
public class CharacterInfo extends Auditable{
    private Long id;
    private String name;
    private BaseStatistic statistic;
}
