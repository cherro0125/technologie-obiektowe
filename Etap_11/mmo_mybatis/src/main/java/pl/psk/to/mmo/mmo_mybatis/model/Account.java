package pl.psk.to.mmo.mmo_mybatis.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.mmo_mybatis.model.base.Auditable;


import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Account extends Auditable {
    private Long id;
    private String email;
    private String nickname;
    private String login;
    private String passwordHash;
    private Date banExpiredAt;
}
