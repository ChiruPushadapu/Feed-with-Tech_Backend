package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer personCount = 0;

    @Column(nullable = false)
    private String facilityType;

    @Column
    private String inChargeName;

    @Column
    private String inChargeMobile;

    @Column
    private String additionalInfo;

    @Column(nullable = false)
    private String helperEmail;

    @Column(nullable = false)
    private Boolean isVerified  = false;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getInChargeName() {
        return inChargeName;
    }

    public void setInChargeName(String inChargeName) {
        this.inChargeName = inChargeName;
    }

    public String getInChargeMobile() {
        return inChargeMobile;
    }

    public void setInChargeMobile(String inChargeMobile) {
        this.inChargeMobile = inChargeMobile;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getHelperEmail() {
        return helperEmail;
    }

    public void setHelperEmail(String helperEmail) {
        this.helperEmail = helperEmail;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }
}
