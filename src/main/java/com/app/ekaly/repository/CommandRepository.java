package com.app.ekaly.repository;

import com.app.ekaly.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long> {
}
