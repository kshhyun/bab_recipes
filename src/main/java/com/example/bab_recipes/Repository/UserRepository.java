package com.example.bab_recipes.Repository;

import com.example.bab_recipes.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
