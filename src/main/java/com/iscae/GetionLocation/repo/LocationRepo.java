package com.iscae.GetionLocation.repo;
import com.iscae.GetionLocation.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Long> {
}
