package com.iti.companyhierarchy.persistence.repository;

import com.iti.companyhierarchy.persistence.entity.Administrative;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AdministrativeRepo extends BaseRepo<Administrative, UUID> {
}
