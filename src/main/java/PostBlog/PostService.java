package PostBlog;

import Response.CreateResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo PostRepo;

    public List<Post> findAll() {
        return PostRepo.findAll();
    }

    public Post modify(Long id, PostReq request) {
        try {
            Post post = findById(id);
            BeanUtils.copyProperties(request, post);
            return PostRepo.save(post);
        } catch (Exception e) {
            throw new RuntimeException("Failed to modify Post", e);
        }
    }

    public CreateResponse save(PostReq request) {
        if (PostRepo.existsByTitolo(request.getTitolo())) {
            throw new EntityExistsException("Titolo already exists");
        }

        Post post = new Post();
        BeanUtils.copyProperties(request, post);
        PostRepo.save(post);

        CreateResponse createResponse = new CreateResponse();
        BeanUtils.copyProperties(post, createResponse);

        return createResponse;
    }

    public Post findById(Long id) {
        if (!PostRepo.existsById(id)) {
            throw new EntityNotFoundException("Post not found");
        }
        return PostRepo.findById(id).get();
    }

    public void delete(Long id) {
        Post post = findById(id);
        PostRepo.deleteById(id);
    }
}