package Application.controllers;


import Application.domain.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import Application.repositories.ParentRepository;

/**
 * Created by Kino on 2017-09-17.
 */
@Controller
@RequestMapping(path="/parent")
public class ParentController
{

    @Autowired
    private ParentRepository ParentRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewParent (@RequestParam String name, @RequestParam String sname, @RequestParam String cell, @RequestParam String gender) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Application.domain.Parent parent = new Parent();
        parent.setName(name);
        parent.setSurname(sname);
        parent.setCellphone(cell);
        parent.setGender(gender);

        ParentRepository.save(parent);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Application.domain.Parent> getAllUsers() {
        // This returns a JSON or XML with the users
        return ParentRepository.findAll();
    }

}
