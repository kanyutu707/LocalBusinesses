package org.example.backend.Repository;

import org.example.backend.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Image_Repo extends JpaRepository<Image, Integer> {
}
