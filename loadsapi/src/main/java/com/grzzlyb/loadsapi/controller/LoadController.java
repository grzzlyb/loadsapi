package com.grzzlyb.loadsapi.controller;

import com.grzzlyb.loadsapi.entity.Load;
import com.grzzlyb.loadsapi.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadRepository loadRepository;

    @GetMapping
    public ResponseEntity<List<Load>> getAllLoads() {
        List<Load> loads = loadRepository.findAll();
        return new ResponseEntity<>(loads, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        loadRepository.save(load);
        return new ResponseEntity<>("Load details added successfully", HttpStatus.OK);
    }

    @GetMapping(params = "shipperId")
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam UUID shipperId) {
        List<Load> loads = loadRepository.findByShipperId(shipperId);
        return new ResponseEntity<>(loads, HttpStatus.OK);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
        Load load = loadRepository.findById(loadId).orElse(null);
        if (load != null) {
            return new ResponseEntity<>(load, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable Long loadId, @RequestBody Load loadDetails) {
        Load load = loadRepository.findById(loadId).orElse(null);
        if (load != null) {
            load.setLoadingPoint(loadDetails.getLoadingPoint());
            load.setUnloadingPoint(loadDetails.getUnloadingPoint());
            load.setProductType(loadDetails.getProductType());
            load.setTruckType(loadDetails.getTruckType());
            load.setNoOfTrucks(loadDetails.getNoOfTrucks());
            load.setWeight(loadDetails.getWeight());
            load.setComments(loadDetails.getComments());
            load.setShipperId(loadDetails.getShipperId());
            load.setShipmentDate(loadDetails.getShipmentDate());
            loadRepository.save(load);
            return new ResponseEntity<>("Load updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Load not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        if (loadRepository.existsById(loadId)) {
            loadRepository.deleteById(loadId);
            return new ResponseEntity<>("Load deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Load not found", HttpStatus.NOT_FOUND);
        }
    }
}
