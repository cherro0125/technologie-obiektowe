package pl.psk.to.mmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.base.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class Server extends Auditable {
    private Long id;
    private String name;
    private Integer slots;
    private Integer port;
    private Country country;
}
