package com.tech.tnshop.repository;

import com.tech.tnshop.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, String> {
    Optional<Profile> getProfileByUser(String userId);
}
