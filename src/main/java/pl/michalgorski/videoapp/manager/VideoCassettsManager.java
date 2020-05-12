package pl.michalgorski.videoapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.michalgorski.videoapp.dao.VideoCassetteRepo;
import pl.michalgorski.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassettsManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassettsManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassette(1L, "Titanic", LocalDate.of(1995, 1, 1)));
        save(new VideoCassette(2L, "Pulp Fiction", LocalDate.of(1990, 2, 2)));

    }





}
