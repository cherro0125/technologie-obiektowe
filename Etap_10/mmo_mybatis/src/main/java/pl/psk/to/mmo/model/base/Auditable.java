package pl.psk.to.mmo.model.base;

import lombok.Data;

import java.sql.Date;

@Data
public class Auditable {
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
}
