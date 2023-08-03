package bg.softuni.Mobilelele.web;


import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {

    public ModelAndView view(String name, ModelAndView modelAndView) {
        modelAndView.setViewName(name);
        return modelAndView;
    }

    public ModelAndView view(String name) {
        return this.view(name, new ModelAndView());
    }

    public ModelAndView redirect(String url) {
        return this.view("redirect:/" + url);
    }
}
