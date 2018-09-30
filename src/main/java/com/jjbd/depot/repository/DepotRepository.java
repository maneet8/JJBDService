
package com.jjbd.depot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jjbd.depot.dto.DepotDTO;
import com.jjbd.depot.entity.DepotDetails;


@Repository
public interface DepotRepository extends JpaRepository<DepotDetails, Integer> {

	List<DepotDetails> findByFirmCode(String firmCode);
	
}
