package cricket.web;

import cricket.domain.Innings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harish Chakravarthy
 */
@RestController
public class InningsController {

    @Autowired
    private InningsRepository repository;

    @RequestMapping(path = "/cricket/innings")
    public Innings getInnings(@RequestParam(name = "id") long id) {
        return repository.findById(id);
    }
}
