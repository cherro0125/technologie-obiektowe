package pl.psk.to.mmo.model.character;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.Skill;
import pl.psk.to.mmo.model.base.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class CharacterClassSkill extends Auditable {
    private Long id;
    private Skill skill;
    private CharacterClass characterClass;
}
