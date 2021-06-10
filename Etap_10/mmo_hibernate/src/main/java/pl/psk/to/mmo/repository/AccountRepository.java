package pl.psk.to.mmo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.psk.to.mmo.model.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account,Long> {
}
