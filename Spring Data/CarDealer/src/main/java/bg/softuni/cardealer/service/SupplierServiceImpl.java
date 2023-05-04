package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.supplier.LocalSuppliersDTO;
import bg.softuni.cardealer.model.dtos.supplier.wrapper.LocalSuppliersWrapper;
import bg.softuni.cardealer.model.entities.Supplier;
import bg.softuni.cardealer.repository.SupplierRepository;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static bg.softuni.cardealer.config.Paths.EXPORT_LOCAL_SUPPLIERS;
import static bg.softuni.cardealer.config.Paths.EXPORT_LOCAL_SUPPLIERS_XML;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Gson gson) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public List<LocalSuppliersDTO> findAllByImporterIsFalse() throws IOException, JAXBException {
        List<Supplier> suppliers =
                this.supplierRepository.findAllByImporterIsFalse().orElseThrow(NoSuchElementException::new);

        List<LocalSuppliersDTO> localSuppliersDTOList = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            LocalSuppliersDTO localSupplier = modelMapper.map(supplier, LocalSuppliersDTO.class);
            localSupplier.setPartsCount(supplier.getParts().size());
            localSuppliersDTOList.add(localSupplier);
        }

        FileWriter fileWriter = new FileWriter(EXPORT_LOCAL_SUPPLIERS.toFile());
        gson.toJson(localSuppliersDTOList, fileWriter);
        fileWriter.close();

        File file = EXPORT_LOCAL_SUPPLIERS_XML.toFile();
        LocalSuppliersWrapper localSuppliersWrapper = new LocalSuppliersWrapper(localSuppliersDTOList);
        JAXBContext context = JAXBContext.newInstance(LocalSuppliersWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(localSuppliersWrapper, file);
        return localSuppliersDTOList;
    }
}
