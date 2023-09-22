package xyz.yldk.authme.Daos;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yldk.authme.Entities.UserTable;

import java.util.List;

public interface UserTableRepository extends JpaRepository<UserTable, Long> {

    UserTable findByUid(Long uid);
    List<UserTable> findByEmail(String email);


}
