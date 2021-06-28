package pl.psk.to.mmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.base.Auditable;

import javax.persistence.*;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "accounts")
public class Account extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nickname;
    private String login;
    private String passwordHash;
    private Date banExpiredAt;
}
