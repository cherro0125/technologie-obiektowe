package pl.psk.to.mmo.mmo_mybatis.model.base;

import lombok.Data;

@Data
public class Criteria {
    private String sortColumn;
    private String sortType;
    private Integer limit;
    private Integer offset;
}
