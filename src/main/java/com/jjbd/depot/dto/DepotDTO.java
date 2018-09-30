
package com.jjbd.depot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = Include.NON_NULL)
public class DepotDTO {
	@JsonProperty("distributorName")
	@ApiModelProperty(value="Name", example="Ravi Kumar")
	private String distributorName;
	
	@JsonProperty("depotName")
	@ApiModelProperty(value="Depot Name", example="Test")
	private String depotName;
	
	@JsonProperty("add1")
	@ApiModelProperty(value="Address", example="add1")
	private String add1;

	@JsonProperty("place")
	@ApiModelProperty(value="place", example="place")
	private String place;
	
	@JsonProperty("district")
	@ApiModelProperty(value="district", example="district")
	private String district;
	
	@JsonProperty("state")
	@ApiModelProperty(value="state", example="state")
	private String state;
	
	@JsonProperty("pincode")
	@ApiModelProperty(value="pincode", example="pincode")
	private Integer pincode;
	
	@JsonProperty("id")
	@ApiModelProperty(value="id", example="id")
	private Integer id;
	
	@JsonProperty("firmCode")
	@ApiModelProperty(value="firmCode", example="firmCode")
	private String firmCode;

	public DepotDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepotDTO(String distributorName, String depotName, String add1, String place, String district, String state,
			Integer pincode, Integer id, String firmCode) {
		super();
		this.distributorName = distributorName;
		this.depotName = depotName;
		this.add1 = add1;
		this.place = place;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.id = id;
		this.firmCode = firmCode;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public String getDepotName() {
		return depotName;
	}

	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirmCode() {
		return firmCode;
	}

	public void setFirmCode(String firmCode) {
		this.firmCode = firmCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((add1 == null) ? 0 : add1.hashCode());
		result = prime * result + ((depotName == null) ? 0 : depotName.hashCode());
		result = prime * result + ((distributorName == null) ? 0 : distributorName.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((firmCode == null) ? 0 : firmCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepotDTO other = (DepotDTO) obj;
		if (add1 == null) {
			if (other.add1 != null)
				return false;
		} else if (!add1.equals(other.add1))
			return false;
		if (depotName == null) {
			if (other.depotName != null)
				return false;
		} else if (!depotName.equals(other.depotName))
			return false;
		if (distributorName == null) {
			if (other.distributorName != null)
				return false;
		} else if (!distributorName.equals(other.distributorName))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (firmCode == null) {
			if (other.firmCode != null)
				return false;
		} else if (!firmCode.equals(other.firmCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
	
}
