package etklik.koebenhavnkulturopgave.services;

import etklik.koebenhavnkulturopgave.model.Band;
import etklik.koebenhavnkulturopgave.repositories.BandRepository;
import etklik.koebenhavnkulturopgave.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BandService implements IBandService{

    private BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }


    @Override
    public Set<Band> findAll() {
        return null;
    }

    @Override
    public Band save(Band object) {
        return bandRepository.save(object);
    }

    @Override
    public void delete(Band object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return bandRepository.findById(aLong);
    }
}
