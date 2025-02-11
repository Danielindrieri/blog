package PostBlog;

import Response.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.CacheRequest;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post findById(@PathVariable Long id) {
        return postService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody PostReq request) {
        return postService.save(request);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post modify(@PathVariable Long id, @RequestBody PostReq request) {
        return postService.modify(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}