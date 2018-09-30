package com.jjbd.depot.service;

import java.util.List;

import javax.validation.Valid;

import com.jjbd.depot.dto.DepotDTO;
import com.jjbd.depot.dto.DepotInputDTO;
import com.jjbd.depot.entity.DepotDetails;
import com.jjbd.depot.exception.ContentNotFoundException;
import com.jjbd.depot.exception.InvalidInputException;

public interface DepotService {


	List<DepotDTO> getDepots(String userId) throws ContentNotFoundException;


	DepotDetails addDepot(DepotInputDTO depotInput)
			throws InvalidInputException;


//	List<DepotDTO> getDepots() throws ContentNotFoundException;
	

	void deleteDepot(String targetUser, String notificationData);


	List<DepotDetails> findByfirmCode(String firmCode);

}
