package pe.edu.upeu.syscaso.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upeu.syscaso.entity.Escuela;

public interface EscuelaService {
	Escuela create(Escuela a);
	Escuela update(Escuela a);
	void delete(Long id);
	Optional<Escuela> read(Long id);
	List<Escuela> readAll();

}
