package com.mehmetcaliskan.carrentalapp.util;

import com.mehmetcaliskan.carrentalapp.entity.Company;
import com.mehmetcaliskan.carrentalapp.entity.Customer;
import com.mehmetcaliskan.carrentalapp.entity.PriceRange;
import com.mehmetcaliskan.carrentalapp.entity.RentalCar;
import com.mehmetcaliskan.carrentalapp.enums.CarTypeEnum;
import com.mehmetcaliskan.carrentalapp.enums.CityEnum;
import com.mehmetcaliskan.carrentalapp.service.CompanyService;
import com.mehmetcaliskan.carrentalapp.service.CustomerService;
import com.mehmetcaliskan.carrentalapp.service.RentalCarService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final CompanyService companyService;
    private final CustomerService customerService;
    private final RentalCarService rentalCarService;

    @Override
    public void run(ApplicationArguments args) {
        addCompanies();
        addCustomers();
        addRentalCars();
    }

    private void addCompanies() {
        companyService.addCompany(Company.builder()
                .name("RentACar")
                .city(CityEnum.ANTALYA)
                .username("kamil")
                .password("SC42GTD")
                .build());
    }

    private void addCustomers() {
        customerService.addCustomer(Customer.builder()
                .name("Ali")
                .surname("casd")
                .email("alicasd@deneme.com")
                .password("SC42GTD")
                .build());
    }

    private void addRentalCars() {
        RentalCar rentalCar = RentalCar.builder()
                .carType(CarTypeEnum.ARAZI)
                .brand("BMW")
                .company(companyService.getCompanyByName("RentACar"))
                .model("GTR")
                .price(25000L)
                .build();

        PriceRange priceRange = PriceRange.builder()
                .price(500L)
                .rentalCar(rentalCar)
                .startDate(LocalDate.parse("2022-04-10"))
                .endDate(LocalDate.parse("2022-04-15"))
                .build();

        PriceRange priceRange2 = PriceRange.builder()
                .price(700L)
                .rentalCar(rentalCar)
                .startDate(LocalDate.parse("2022-04-16"))
                .endDate(LocalDate.parse("2022-04-21"))
                .build();

        rentalCar.setPriceRanges(List.of(priceRange, priceRange2));
        rentalCarService.addRentalCar(rentalCar);
    }

}
