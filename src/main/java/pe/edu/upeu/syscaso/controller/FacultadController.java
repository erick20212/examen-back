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
import pe.edu.upeu.syscaso.entity.Facultad;
import pe.edu.upeu.syscaso.service.FacultadService;

@RestController
@RequestMapping("/api/facultad")
@CrossOrigin(origins ="http://localhost:4200")
public class FacultadController {
	@Autowired
	private FacultadService service;
	
	@GetMapping
	public ResponseEntity<List<Facultad>> readAll() {
		try {
			List<Facultad> lista = service.readAll();
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
	public ResponseEntity<Facultad> create(@Valid @RequestBody Facultad obj){
		try {
			Facultad objeto = service.create(obj);
			return new ResponseEntity<>(objeto, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Facultad> getFacultadId(@PathVariable Long id){
		try {
			Facultad objeto = service.read(id).get();
			return new ResponseEntity<>(objeto, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Facultad> delFacultad(@PathVariable Long id){
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Facultad> updatFacultad(@PathVariable Long id, @Valid @RequestBody Facultad obj) {
	    Optional<Facultad> objeto = service.read(id);

	    if (objeto.isPresent()) {
	        Facultad facultadExistente = objeto.get();

	        // Actualizar solo los campos necesarios, sin reemplazar la lista de escuelas
	        facultadExistente.setNombre(obj.getNombre());

	        // Aquí asumimos que no estamos reemplazando `escuelas` y evitando problemas de proxy
	        Facultad actualizado = service.update(facultadExistente);
	        
	        return new ResponseEntity<>(actualizado, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si no se encuentra el objeto
	    }
	}
	}