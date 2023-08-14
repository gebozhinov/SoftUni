package bg.softuni.Mobilelele.web;

import bg.softuni.Mobilelele.model.dto.AddOfferDTO;
import bg.softuni.Mobilelele.model.dto.BrandDTO;
import bg.softuni.Mobilelele.service.BrandService;
import bg.softuni.Mobilelele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService,
                           BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("offerModel")
    public AddOfferDTO offerModel() {
        return new AddOfferDTO();
    }
    @ModelAttribute("brands")
    public List<BrandDTO> brands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/all")
    public String allOffers() {
        return "offers";
    }

    @GetMapping("/add")
    public String addOffer() {
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDTO offerModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);

            return "redirect:/offers/add";
        }

        offerService.addOffer(offerModel);
        return "redirect:/offers/all";
    }

}
