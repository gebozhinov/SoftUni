package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dtos.sale.SaleDTO;
import bg.softuni.cardealer.model.entities.Sale;
import bg.softuni.cardealer.repository.SaleRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static bg.softuni.cardealer.config.Paths.SALES_WITH_APPLIED_DISCOUNT;

@Service
public class SaleServiceImpl implements SaleService{

    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, Gson gson) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public List<SaleDTO> getAll() throws IOException {
        List<Sale> sales = this.saleRepository.findAll();
        sales.forEach(Sale::calculatePrice);

        List<SaleDTO> saleDTOS = new ArrayList<>();
        for (Sale sale : sales) {
            SaleDTO saleDTO = modelMapper.map(sale, SaleDTO.class);
            saleDTO.setCustomerName(sale.getCustomer().getName());
            saleDTOS.add(saleDTO);
        }

        FileWriter fileWriter = new FileWriter(SALES_WITH_APPLIED_DISCOUNT.toFile());
        gson.toJson(saleDTOS, fileWriter);

        fileWriter.close();
        return saleDTOS;
    }
}
