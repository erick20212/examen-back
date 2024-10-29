package pe.edu.upeu.syscaso.dao;

import java.util.List;
import java.util.Optional;


import pe.edu.upeu.syscaso.entity.Facultad;

public interface FacultadDao {
	Facultad create(Facultad a);
	Facultad update(Facultad a);
	void delete(Long id);
	Optional<Facultad> read(Long id);
	List<Facultad> readAll();
}
