package com.example.crudwithsqlite.Repo;

import com.example.crudwithsqlite.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface UserRepo extends JpaRepository<User,Long> {
}
