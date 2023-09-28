package xyz.yldk.authme.Daos;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yldk.authme.Entities.EMailCodeTable;
import xyz.yldk.authme.Entities.UserPasswordTable;

public interface EMailCodeTableRepository extends JpaRepository<EMailCodeTable, Long> {

    EMailCodeTable findByEmail(String email);

}
