package pe.edu.upeu.syscaso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.upeu.syscaso.entity.Escuela;
import pe.edu.upeu.syscaso.service.EscuelaService;

@RestController
@RequestMapping("/api/escuela")
@CrossOrigin(origins ="http://localhost:4200")
public class EscuelaController {
	@Autowired
	private EscuelaService service;
	
	@GetMapping
	public ResponseEntity<List<Escuela>> readAll() {
		try {
			List<Escuela> lista = service.readAll();
			if(lista.isEmpty()){
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Escuela> create(@Valid @RequestBody Escuela obj){
		try {
			Escuela objeto = service.create(obj);
			return new ResponseEntity<>(objeto, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Escuela> getEscuelaId(@PathVariable Long id){
		try {
			Escuela objeto = service.read(id).get();
			return new ResponseEntity<>(objeto, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Escuela> delEscuela(@PathVariable Long id){
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Escuela> updateEscuela(@PathVariable Long id, @Valid @RequestBody Escuela obj) {
	    Optional<Escuela> objeto = service.read(id);
	    if (objeto.isPresent()) {
	        // Aquí se asume que el servicio actualiza el objeto y lo retorna
	    	Escuela actualizado = service.update(obj);
	        return new ResponseEntity<>(actualizado, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si no se encuentra el objeto
	    }		
	}
}