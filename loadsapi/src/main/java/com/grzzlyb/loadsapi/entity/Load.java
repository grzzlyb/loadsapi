package com.grzzlyb.loadsapi.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.grzzlyb.loadsapi.helper.LocalDateDeserializer;
import com.grzzlyb.loadsapi.helper.LocalDateSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "shipment_details")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "loading_point")
    private String loadingPoint;

    @Column(name = "unloading_point")
    private String unloadingPoint;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "truck_type")
    private String truckType;

    @Column(name = "no_of_trucks")
    private int noOfTrucks;

    @Column(name = "weight")
    private int weight;

    @Column(name = "cmts")
    private String comments;

    @Column(name = "shipper_id")
    private UUID shipperId;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "shipment_date")
    private LocalDate shipmentDate;

    public Load() {

    }

    public Load(String loadingPoint, String unloadingPoint, String productType, String truckType, int noOftrucks, int weight, String comments, UUID shipperId, LocalDate shipmentDate) {
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOftrucks;
        this.weight = weight;
        this.comments = comments;
        this.shipperId = shipperId;
        this.shipmentDate = shipmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public int getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(int noOftrucks) {
        this.noOfTrucks = noOftrucks;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public UUID getShipperId() {
        return shipperId;
    }

    public void setShipperId(UUID shipperId) {
        this.shipperId = shipperId;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
}
