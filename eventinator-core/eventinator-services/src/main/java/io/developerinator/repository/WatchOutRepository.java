package io.developerinator.repository;


import io.developerinator.app.domain.WatchOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchOutRepository extends JpaRepository<WatchOut, String>{
}
