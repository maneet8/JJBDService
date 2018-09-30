
package com.jjbd.depot.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjbd.depot.dto.DepotDTO;
import com.jjbd.depot.dto.DepotInputDTO;
import com.jjbd.depot.entity.DepotDetails;
import com.jjbd.depot.exception.ContentNotFoundException;
import com.jjbd.depot.exception.InvalidInputException;
import com.jjbd.depot.repository.DepotRepository;
import com.jjbd.depot.service.DepotService;
import com.jjbd.depot.utility.AppConstants;


@Service
public class DepotServiceImpl implements DepotService {

	Logger loggers = LoggerFactory.getLogger(DepotServiceImpl.class);

	@Autowired
	private DepotRepository depotRepo;

	@Override
	public List<DepotDTO> getDepots(String userId)throws ContentNotFoundException {

		return null;
	}

//	@Override
//	public List<DepotDTO> getDepots() throws ContentNotFoundException {
//		List<DepotDTO> test = depotRepo.geDepotDTOs();
//		if (test.isEmpty()) {
//			throw new ContentNotFoundException(AppConstants.getValue());
//		}
//		return test;
//	}

	@Override
	public DepotDetails addDepot(DepotInputDTO depotInput) throws InvalidInputException {
		DepotDetails depotDetails = new DepotDetails();
		depotDetails.setDistributorName(depotInput.getDistributorName());
		depotDetails.setDepotName(depotInput.getDepotName());
		depotDetails.setAdd1(depotInput.getAdd1());
		depotDetails.setPlace(depotInput.getPlace());
		depotDetails.setDistrict(depotInput.getDistrict());
		depotDetails.setState(depotInput.getState());
		depotDetails.setFirmCode("JJ-"+ depotInput.getPlace().substring(0, 3).toUpperCase() + depotInput.getDepotName().substring(0, 3).toUpperCase());
		depotDetails.setPincode(depotInput.getPincode());
		return depotRepo.save(depotDetails);
	}


	@Override
	public void deleteDepot(String targetUser,
			String testData) {
//		depotRepo.deleteDepot(targetUser, testData);
	}

	@Override
	public List<DepotDetails> findByfirmCode(String firmCode) {
		return depotRepo.findByFirmCode(firmCode);
	}
}
