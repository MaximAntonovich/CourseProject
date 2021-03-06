package site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import site.dao.StoryDAO;
import site.dao.UserDAO;
import site.entity.Story;
import site.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by maxim on 14.9.23.
 */
@Controller
public class HomeController {

    @Autowired
    private StoryDAO storyDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping({"", "home.htm" })
    public String showPage(Model model) throws SQLException {
        ArrayList<Story> stories = storyDAO.getAllStories();
        model.addAttribute("stories",stories);
        Authentication authentic = SecurityContextHolder.getContext().getAuthentication();
        String login = authentic.getName();
        User user = userDAO.getUser(login);
        model.addAttribute("user",user);
        return "commons/home";
    }

}