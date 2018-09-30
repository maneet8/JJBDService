
package com.jjbd.depot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "DepotDetails")
public class DepotDetails {

	@Id
	@Column(name = "Id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="MySequenceGenerator")
    @SequenceGenerator(allocationSize=1, schema="public",  name="MySequenceGenerator", sequenceName = "depot_id_seq")
	@ApiModelProperty(value="Internal id of the depot maintained by the jjbd service.", example="1")
	private Integer id;

	@ApiModelProperty(value="depot name", example="Test")
	@Column(name = "DepotName")
	private String depotName;

	@ApiModelProperty(value="Distributor Name", example="Ravi Kumar")
	@Column(name = "DistributorName")
	private String distributorName;

	@ApiModelProperty(value="Depot address", example="Address")
	@Column(name = "Add1")
	private String add1;

	@ApiModelProperty(value="Place", example="place")
	@Column(name = "Place")
	private String place;
	
	@ApiModelProperty(value="District", example="Pune")
	@Column(name = "District")
	private String district;
	
	@ApiModelProperty(value="State", example="Maharashtra")
	@Column(name = "State")
	private String state;
	
	@ApiModelProperty(value="pincode", example="281006")
	@Column(name = "Pincode")
	private Integer pincode;
	
	@ApiModelProperty(value="FirmCode", example="test")
	@Column(name = "FirmCode", unique=true)
	private String firmCode;

	@ApiModelProperty(value="Timestamp", example="time")
	@Column(name = "Timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date timestamp;

	public DepotDetails(Integer id, String depotName, String distributorName, String add1, String place,
			String district, String state, Integer pincode, String firmCode, Date timestamp) {
		super();
		this.id = id;
		this.depotName = depotName;
		this.distributorName = distributorName;
		this.add1 = add1;
		this.place = place;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.firmCode = firmCode;
		this.timestamp = timestamp;
	}

	public DepotDetails() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepotName() {
		return depotName;
	}

	public void setDepotName(String depotName) {
		this.depotName = depotName;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
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

	public String getFirmCode() {
		return firmCode;
	}

	public void setFirmCode(String firmCode) {
		this.firmCode = firmCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		DepotDetails other = (DepotDetails) obj;
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
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
}
