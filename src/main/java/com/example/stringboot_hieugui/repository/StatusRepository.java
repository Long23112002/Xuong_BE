package com.example.stringboot_hieugui.repository;

import com.example.stringboot_hieugui.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByStatusName(String statusName);

    @Query(nativeQuery = true, value = "select status_name from status")
    List<String> findAllStatusName();
}
