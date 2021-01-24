package com.example.controller;

import com.example.entity.EtfPortion;
import com.example.entity.EtfPortion;
//import com.example.exception.EtfPortionNotFoundException;
import com.example.entity.EtfPortionRepository;
import com.example.entity.TransactionLog;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class EtfPortionController {

  private final EtfPortionRepository repository;

  EtfPortionController(EtfPortionRepository repository) {
    this.repository = repository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/etfportion")
  List<EtfPortion> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @GetMapping("/etfportion/{charId}/{account}")
  List<EtfPortion> findByCharIdAndAccount(@PathVariable String charId, @PathVariable String account) {
    return repository.findByCharIdAndAccount(charId, account);
  }

  @PutMapping("/etfportion")
  @Transactional
  EtfPortion updateEtfPortion(@RequestBody EtfPortion newEtfPortion) {
//    System.out.printf("%s, %s, %s\n", newEtfPortion.getCharId(), newEtfPortion.getAccount(), newEtfPortion.getSectorCode());
    EtfPortion etfPortion = repository.findByCharIdAndAccountAndSectorCode(newEtfPortion.getCharId(), newEtfPortion.getAccount(), newEtfPortion.getSectorCode());
//    System.out.println(etfPortion);
    etfPortion.update(newEtfPortion.getSectorPortion());

    return repository.save(etfPortion);
  }
//
//  // Single item
//
//  @GetMapping("/etfportion/{id}")
//  EtfPortion one(@PathVariable Long id) {
//
//    return repository.findById(id)
//      .orElseThrow(() -> new EtfPortionNotFoundException(id));
//  }
//
//  @PutMapping("/etfportion/{id}")
//  EtfPortion replaceEtfPortion(@RequestBody EtfPortion newEtfPortion, @PathVariable Long id) {
//
//    return repository.findById(id)
//      .map(EtfPortion -> {
//        EtfPortion.setName(newEtfPortion.getName());
//        EtfPortion.setRole(newEtfPortion.getRole());
//        return repository.save(EtfPortion);
//      })
//      .orElseGet(() -> {
//        newEtfPortion.setId(id);
//        return repository.save(newEtfPortion);
//      });
//  }
//
//  @DeleteMapping("/etfportion/{id}")
//  void deleteEtfPortion(@PathVariable Long id) {
//    repository.deleteById(id);
//  }
}