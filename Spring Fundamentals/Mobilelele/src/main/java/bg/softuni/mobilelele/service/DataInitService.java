package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.service.brand.BrandService;
import bg.softuni.mobilelele.service.model.ModelService;
import bg.softuni.mobilelele.service.offer.OfferService;
import bg.softuni.mobilelele.service.role.UserRoleService;
import bg.softuni.mobilelele.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class DataInitService {

    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    public DataInitService(BrandService brandService,
                           ModelService modelService,
                           OfferService offerService,
                           UserService userService,
                           UserRoleService userRoleService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    public void dataInit() {
        brandService.fillDb();
        modelService.fillDb();
        offerService.fillDb();
        userService.fillDb();
        userRoleService.fillDb();
    }


}
