package AutorePost;

import Response.CreateResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoreService {
    private final AutoreRepo autoreRepo;

    public List<Autore> findAll() {
        return autoreRepo.findAll();
    }

    public Autore modify(Long id, AutoreReq request) {
        try {
            Autore autore = findById(id);
            BeanUtils.copyProperties(request, autore);
            return autoreRepo.save(autore);
        } catch (Exception e) {
            throw new RuntimeException("Failed to modify Autore", e);
        }
    }

    public CreateResponse save(AutoreReq request) {
        if (autoreRepo.existsByEmail(request.getEmail())) {
            throw new EntityExistsException("Email already exists");
        }

        Autore autore = new Autore();
        BeanUtils.copyProperties(request, autore);
        autoreRepo.save(autore);

        CreateResponse createResponse= new CreateResponse();
        BeanUtils.copyProperties(autore, createResponse);

        return createResponse;
    }

    public Autore findById(Long id) {
        if (!autoreRepo.existsById(id)) {
            throw new EntityNotFoundException("Autore not found");
        }
        return autoreRepo.findById(id).get();
    }

    public void delete(Long id) {
        Autore autore = findById(id);
        autoreRepo.deleteById(id);
    }
}
