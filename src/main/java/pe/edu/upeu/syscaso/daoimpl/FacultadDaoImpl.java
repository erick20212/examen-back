package pe.edu.upeu.syscaso.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.syscaso.dao.FacultadDao;
import pe.edu.upeu.syscaso.entity.Facultad;
import pe.edu.upeu.syscaso.repository.FacultadRepository;

@Component
public class FacultadDaoImpl implements FacultadDao{

	@Autowired
	private FacultadRepository repository;
	@Override
	public Facultad create(Facultad a) {
		// TODO Auto-generated method stub
		return repository.save(a);
	}

	@Override
	public Facultad update(Facultad a) {
		// TODO Auto-generated method stub
		return repository.save(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public Optional<Facultad> read(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Facultad> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
