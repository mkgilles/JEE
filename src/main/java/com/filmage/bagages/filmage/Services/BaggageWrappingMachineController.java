package com.filmage.bagages.filmage.Services;

import com.filmage.bagages.filmage.entities.BaggageWrappingMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baggageWrappingMachines")
public class BaggageWrappingMachineController {

    @Autowired
    private BaggageWrappingMachineService baggageWrappingMachineService;

    @PostMapping
    public ResponseEntity<BaggageWrappingMachine> addBaggageWrappingMachine(@RequestBody BaggageWrappingMachine baggageWrappingMachine) {
        BaggageWrappingMachine addedBaggageWrappingMachine = baggageWrappingMachineService.addBaggageWrappingMachine(baggageWrappingMachine);
        return new ResponseEntity<>(addedBaggageWrappingMachine, HttpStatus.CREATED);
    }

    @GetMapping
    public List<BaggageWrappingMachine> getAllBaggageWrappingMachines() {
        return baggageWrappingMachineService.getAllBaggageWrappingMachines();
    }

    @PutMapping("/{id}")
    public void updateBaggageWrappingMachine(@PathVariable Long id, @RequestBody BaggageWrappingMachine baggageWrappingMachine) {
        baggageWrappingMachineService.updateBaggageWrappingMachine(id, baggageWrappingMachine);
    }

    @DeleteMapping("/{id}")
    public void deleteBaggageWrappingMachine(@PathVariable Long id) {
        baggageWrappingMachineService.deleteBaggageWrappingMachine(id);
    }
}
