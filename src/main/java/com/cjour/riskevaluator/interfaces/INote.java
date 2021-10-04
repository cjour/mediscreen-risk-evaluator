package com.cjour.riskevaluator.interfaces;

import com.cjour.riskevaluator.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="noteClient", url = "localhost:8088")
public interface INote {

    @GetMapping("/patientNote/{id}")
    ResponseEntity<List<Note>> getNotesForId(@PathVariable Integer id);

    @GetMapping("/patientNote/{familyName}")
    ResponseEntity<List<Note>> getNotesForFamilyName(@PathVariable String familyName);
}
