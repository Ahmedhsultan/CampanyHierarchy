package com.iti.companyhierarchy.persistence.repository;

import com.iti.companyhierarchy.persistence.entity.Manager;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ManagerRepo extends BaseRepo<Manager, UUID> {
}
