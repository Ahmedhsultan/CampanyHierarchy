package com.iti.companyhierarchy.persistence.repository;

import com.iti.companyhierarchy.persistence.entity.Engineer;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class EngineerRepo extends BaseRepo<Engineer, UUID> {
}
