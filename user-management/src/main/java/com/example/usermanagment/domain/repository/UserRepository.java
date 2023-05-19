package com.example.usermanagment.domain.repository;

import com.example.usermanagment.domain.models.UserId;
import com.example.usermanagment.domain.models.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTable, UserId> {
}
