package bg.softuni.LinkedOut.model.validation;

import bg.softuni.LinkedOut.repository.CompanyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueCompanyNameValidator implements ConstraintValidator<UniqueCompanyName, String> {


    private final CompanyRepository companyRepository;

    public UniqueCompanyNameValidator(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.companyRepository.findByName(value).isEmpty();
    }
}
