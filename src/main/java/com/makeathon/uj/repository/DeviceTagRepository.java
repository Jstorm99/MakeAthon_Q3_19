package com.makeathon.uj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makeathon.uj.entity.DeviceTagId;
import com.makeathon.uj.entity.DeviceTags;

public interface DeviceTagRepository extends JpaRepository<DeviceTags,DeviceTagId>{

}
