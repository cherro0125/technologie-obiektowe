package pl.psk.to.mmo.model.character;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.model.base.Auditable;
import pl.psk.to.mmo.model.item.Item;

@EqualsAndHashCode(callSuper = true)
@Data
public class CharacterItem extends Auditable {
    private long Id;
    private Item item;
    private CharacterModel character;
}
