package pl.psk.to.mmo.mmo_mybatis.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.mmo_mybatis.model.base.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class MapModel extends Auditable {
    private Long id;
    private String name;
}
