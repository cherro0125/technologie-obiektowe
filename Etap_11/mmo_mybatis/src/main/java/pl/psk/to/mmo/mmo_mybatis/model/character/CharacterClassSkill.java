package pl.psk.to.mmo.mmo_mybatis.model.character;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.mmo_mybatis.model.Skill;
import pl.psk.to.mmo.mmo_mybatis.model.base.Auditable;

@EqualsAndHashCode(callSuper = true)
@Data
public class CharacterClassSkill extends Auditable {
    private Long id;
    private Skill skill;
    private CharacterClass characterClass;
}
