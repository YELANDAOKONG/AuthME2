package xyz.yldk.authme.Daos;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yldk.authme.Entities.UserPasswordTable;
import xyz.yldk.authme.Entities.UserTable;

import java.util.List;

public interface UserPasswordTableRepository extends JpaRepository<UserPasswordTable, Long> {

    UserPasswordTable findByUid(Long uid);

}