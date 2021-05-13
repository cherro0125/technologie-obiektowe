package pl.psk.to.mmo.mmo_mybatis.mapper;

import org.apache.ibatis.annotations.*;
import pl.psk.to.mmo.mmo_mybatis.model.Account;
import pl.psk.to.mmo.mmo_mybatis.model.base.Criteria;

import java.util.List;


@Mapper
public interface AccountMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertAccount(@Param("account") Account account);

    void updateAccount(@Param("account") Account account);

    Account getAccountById(@Param("id") Long id);

    List<Account> getAllAccounts(@Param("criteria")Criteria criteria);

    void deleteAccount(@Param("id") Long id);
}