package pl.psk.to.mmo.mmo_mybatis.model.character;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.psk.to.mmo.mmo_mybatis.model.base.Auditable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Data
public class CharacterLook extends Auditable {
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private HairType hairType;
    @Enumerated(EnumType.ORDINAL)
    private HairColor hairColor;
    @Enumerated(EnumType.ORDINAL)
    private BodyType bodyType;
    @Enumerated(EnumType.ORDINAL)
    private SkinColor skinColor;
    @Enumerated(EnumType.ORDINAL)
    private HeadType headType;
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;
}
