package com.filmage.bagages.filmage.entities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaggageWrappingMachineRepository extends CrudRepository<BaggageWrappingMachine, Long> {
    List<BaggageWrappingMachine> findBaggageWrappingMachineByState(MachineState state);
    BaggageWrappingMachine findByCaseHeight(String manufacturer);
    void deleteBaggageWrappingMachineById(Long id);


}
