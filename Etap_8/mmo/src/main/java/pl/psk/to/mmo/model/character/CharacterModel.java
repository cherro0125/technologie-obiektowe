package pl.psk.to.mmo.model.character;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.Account;
import pl.psk.to.mmo.model.Server;
import pl.psk.to.mmo.model.base.Auditable;
import pl.psk.to.mmo.model.Position;

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
