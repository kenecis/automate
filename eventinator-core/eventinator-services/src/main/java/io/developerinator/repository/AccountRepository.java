package io.developerinator.repository;


import io.developerinator.app.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long>{

    Account findByUsername(String username);

    Account findByProfile_Id(String externalId);
}
