package pl.michalgorski.videoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.michalgorski.videoapp.dao.entity.VideoCassette;
import pl.michalgorski.videoapp.manager.VideoCassettsManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {

//    private List<VideoCassette> videoCassettes;
//
//    public VideoCassetteApi() {
//        videoCassettes = new ArrayList<>();
//        videoCassettes.add(new VideoCassette(1L, "Titanic", LocalDate.of(1995, 1, 1)));
//        videoCassettes.add(new VideoCassette(2L, "Pulp Fiction", LocalDate.of(1990, 2, 2)));
//    }

//    @GetMapping("/all")
//    public List<VideoCassette> getAll() {
//        return videoCassettes;
//    }
//
//    @GetMapping
//    public VideoCassette getById(@RequestParam int index) {
//        Optional<VideoCassette> first = videoCassettes.stream()
//                .filter(s -> s.getId() == index)
//                .findFirst();
//
//        return first.get();
//    }
//
//    @PostMapping
//    public boolean addVideo(@RequestBody VideoCassette videoCassette) {
//        return videoCassettes.add(videoCassette);
//    }
//
//    @PutMapping
//    public boolean updateVideo(@RequestBody VideoCassette videoCassette) {
//        return videoCassettes.add(videoCassette);
//    }
//
//    @DeleteMapping
//    public boolean deleteVideo(@RequestParam int index) {
//        return videoCassettes.removeIf(s -> s.getId() == index);
//    }



    private VideoCassettsManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassettsManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
        return videoCassettes.findById(index);
    }


    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {
        videoCassettes.deleteById(index);
    }




}
