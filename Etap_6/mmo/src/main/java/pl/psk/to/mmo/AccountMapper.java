package pl.psk.to.mmo;

import org.apache.ibatis.annotations.*;
import pl.psk.to.mmo.model.Account;

import java.util.List;

@Mapper
public interface AccountMapper {
    @Insert("INSERT INTO Accounts(email,nickname,login,password_hash,ban_expired_at) VALUES (#{email},#{nickname},#{login},#{passwordHash},#{ban_expired_at}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertAccount(@Param("account") Account account);
    @Update("UPDATE Accounts SET email = #{email}, nickname = #{nickname},login=#{login},password_hash = #{passwordHash},ban_expired_at=#{banExpiredAt} WHERE id = ${id}")
    void updateAccount(@Param("account") Account account);
    @Select("SELECT id,email,nickname,login,password_hash as passwordHash,ban_expired_at as banExpiredAt,created_at as createdAt, modified_at as modifiedAt, deleted_at as deletedAt WHERE id = ${id}")
    Account getAccountById(@Param("id") Long id);
    @Select("SELECT id,email,nickname,login,password_hash as passwordHash,ban_expired_at as banExpiredAt,created_at as createdAt, modified_at as modifiedAt, deleted_at as deletedAt")
    List<Account> getAllAccounts();
    @Delete("DELETE FROM Accounts WHERE id = ${id}")
    void deleteAccount(@Param("id") Long id);
}
