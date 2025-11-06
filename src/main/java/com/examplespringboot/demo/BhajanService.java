package com.examplespringboot.demo;

import com.examplespringboot.demo.Bhajan;
import com.examplespringboot.demo.Deity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BhajanService {

    private final List<Bhajan> bhajans;

    public BhajanService() {
        bhajans = new ArrayList<>();

        // Krishna bhajans
        bhajans.add(new Bhajan("Achyutam Keshavam", "https://www.youtube.com/embed/5-Xoh7jKVo8", "krishna"));
        bhajans.add(new Bhajan("Govind Bolo Hari Gopal Bolo", "https://www.youtube.com/embed/9xcFFz8nZgI", "krishna"));

        // Shiva bhajans
        bhajans.add(new Bhajan("Om Namah Shivaya", "https://www.youtube.com/embed/OXrTpwB8zFQ", "shiva"));
        bhajans.add(new Bhajan("Shiv Tandav Stotram", "https://www.youtube.com/embed/NP8v7rkKMwI", "shiva"));

        // Ganesha bhajans
        bhajans.add(new Bhajan("Jai Ganesh Deva", "https://www.youtube.com/embed/s83Buw5z5w0", "ganesha"));
    }

    public List<Bhajan> getBhajansFor(String god) {
        return bhajans.stream()
                .filter(b -> b.getGod().equalsIgnoreCase(god))
                .toList();
    }

    public List<Deity> getAllDeities() {
        // Assuming all images are in .jpeg format
        return List.of(
                new Deity("krishna", "jpeg"),
                new Deity("shiva", "jpeg"),
                new Deity("ganesha", "jpeg")
        );
    }
}
