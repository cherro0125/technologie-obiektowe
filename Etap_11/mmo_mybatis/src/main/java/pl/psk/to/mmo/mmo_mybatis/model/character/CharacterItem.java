package pl.psk.to.mmo.mmo_mybatis.model.character;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.mmo_mybatis.model.base.Auditable;
import pl.psk.to.mmo.mmo_mybatis.model.item.Item;

@EqualsAndHashCode(callSuper = true)
@Data
public class CharacterItem extends Auditable {
    private long Id;
    private Item item;
    private CharacterModel character;
}
