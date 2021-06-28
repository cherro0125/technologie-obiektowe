package pl.psk.to.mmo.mmo_mybatis.model.character;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.mmo_mybatis.model.Account;
import pl.psk.to.mmo.mmo_mybatis.model.Position;
import pl.psk.to.mmo.mmo_mybatis.model.Server;
import pl.psk.to.mmo.mmo_mybatis.model.base.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class CharacterModel extends Auditable {
    private Long id;
    private Account account;
    private Server server;
    private CharacterLook characterLook;
    private CharacterClass characterClass;
    private CharacterRace characterRace;
    private Position position;
}
