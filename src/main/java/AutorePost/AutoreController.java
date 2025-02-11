package AutorePost;

import Response.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.CacheRequest;
import java.util.List;

@RestController
@RequestMapping("/api/autore")
@RequiredArgsConstructor
public class AutoreController {
    private final AutoreService autoreService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Autore> findAll() {
        return autoreService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore findById(@PathVariable Long id) {
        return autoreService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody AutoreReq request) {
        return autoreService.save(request);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore modify(@PathVariable Long id, @RequestBody AutoreReq request) {
        return autoreService.modify(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        autoreService.delete(id);
    }
}
