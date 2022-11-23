package fact.it.individualprojectjavazv.controller;

import fact.it.individualprojectjavazv.model.Movie;
import fact.it.individualprojectjavazv.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class MovieController {
    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

//    @PostConstruct
//    public void fillDatabaseTemporary(){
//        for (int i = 0; i < 10; i++){
//            Movie movie = new Movie();
//            movie.setMovieId(i);
//            movie.setWatchedorNot(true);
//            movie.setComment("Movie"+i);
//            movieRepository.save(movie);
//            //the created Bread object is stored in a table "bread"
//        }
//    }

    @RequestMapping("/test")
    public String index(Model model){
        List<Movie> list = movieRepository.findAll();
        model.addAttribute("movielist",list);
        return "index";
    }
}
