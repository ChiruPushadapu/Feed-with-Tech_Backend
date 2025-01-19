package com.example.demo.Repo;

import com.example.demo.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository  extends JpaRepository<Location, Long> {

}
