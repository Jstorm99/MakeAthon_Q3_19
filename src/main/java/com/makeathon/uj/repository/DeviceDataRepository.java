package com.makeathon.uj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makeathon.uj.entity.DeviceData;

@Repository
public interface DeviceDataRepository extends JpaRepository<DeviceData, String>{

}
