
package com.jjbd.depot.controller;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.PrinterLocation;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.jjbd.depot.dto.DepotDTO;
import com.jjbd.depot.dto.DepotInputDTO;
import com.jjbd.depot.entity.DepotDetails;
import com.jjbd.depot.exception.ContentNotFoundException;
import com.jjbd.depot.exception.InvalidInputException;
import com.jjbd.depot.repository.DepotRepository;
import com.jjbd.depot.service.DepotService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/depot")
@Api( tags = {"JJBDService"})
public class DepotController {

	@Autowired
	private DepotService depotService;
	
	@Autowired
	private DepotRepository depoRepo;

	Logger loggers = LoggerFactory.getLogger(DepotController.class);

	@Transactional
	@ResponseStatus(value = HttpStatus.OK)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Get Depot Details Successfully"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized. Missing access token."),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not found") })
	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Get list of Depots", notes = "Get all Depot Details")
	public List<DepotDetails> getDepots() {
			return depoRepo.findAll();
	}

	/**
	 * Adds new Depot
	 *
	 * @param DepotDetails
	 * @param email
	 * @return Notification
	 * @throws InvalidInputException
	 * @throws NotificationTypeDoesNotExist
	 */
	@Transactional
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized. Missing access token."),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 409, message = "Conflict") })
	@ApiOperation(value = "Add a new depot", notes = "add a new depot")
	public DepotDetails addDepot(
			@Valid @RequestBody @ApiParam(value = "depot input Object", name = "depot") DepotInputDTO depotInput)
			throws InvalidInputException {
		loggers.info("Add Depot details for:{}", depotInput.getDistributorName());
		return depotService.addDepot(depotInput);
	}


	/**
	 * Deletes notification specific for user based on notification data present
	 * @param notification
	 */
	@Transactional
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "The operation completed successfully."),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized. Missing access token."),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 409, message = "Conflict") })
	@ApiOperation(value = "Delete a Depot", notes = "delete a depot")
	public void deleteNotification(
			@Valid @RequestBody @ApiParam(value = "depot input Object", name = "depot") DepotInputDTO notification) {
		depotService.deleteDepot(
				notification.getDistributorName(), notification.getDepotName());
	}
	
	@Transactional
	@ResponseStatus(value = HttpStatus.OK)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Get Depot Details Successfully"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized. Missing access token."),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not found") })
	@GetMapping(value = "/firmCode", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Get list of Depots", notes = "Get all Depot Details")
	public List<DepotDetails> getDepotByFirmCode(@RequestParam(value="firmCode") String firmCode) {
		System.out.println("Firm Code : " + firmCode);
			return depotService.findByfirmCode(firmCode);
	}
	
}
