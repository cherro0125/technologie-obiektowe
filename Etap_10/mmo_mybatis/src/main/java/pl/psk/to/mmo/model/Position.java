package pl.psk.to.mmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.base.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class Position extends Auditable {
    private Long id;
    private Float posX;
    private Float posY;
    private Float posZ;
    private Boolean isSpawnPosition;
    private MapModel map;
}
