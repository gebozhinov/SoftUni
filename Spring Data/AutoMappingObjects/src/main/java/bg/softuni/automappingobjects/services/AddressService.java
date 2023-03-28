package bg.softuni.automappingobjects.services;

import bg.softuni.automappingobjects.entities.Address;
import bg.softuni.automappingobjects.entities.dto.AddressDTO;

public interface AddressService {

    Address create(AddressDTO data);
}
