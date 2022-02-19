package ro.fasttrackit.homework18;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    private CountryService countryService;

    public CountryController() throws Exception {
        this.countryService = new CountryService(new CountryReader());
    }

    @GetMapping("/countries")
    List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/countries/names")
    List<String> getCountriesNames() {
        return countryService.getCountriesNames();
    }

    @GetMapping("/countries/{countryId}/capital")
    List<String> getCapital(@PathVariable int countryId) {
        return countryService.getCapital(countryId);
    }

    @GetMapping("/countries/{countryId}/population")
    List<Integer> getPopulation(@PathVariable int countryId) {
        return countryService.getPopulation(countryId);
    }

    @GetMapping("/countries/{continentName}/countries")
    List<Country> getCountriesInContinent(@PathVariable String continentName) {
        return countryService.getCountriesInContinent(continentName);
    }

    @GetMapping("/continents/{countryId}/countries")
    List<String> getCountriesNeighbours(@PathVariable int countryId) {
        return countryService.getCountriesNeighbours(countryId);
    }

    @GetMapping("/continents/{continentName}") // daca pun /countries imi da exceptie..
    List<Country> getCountriesWithPopulation(
            @PathVariable String continentName,
            @RequestParam int minPopulation
    ) {
        return countryService.getCountriesWithPopulation(continentName, minPopulation);
    }

    @GetMapping("neighbour-country") // a mers..dar nu bine, si acum nu merge de fel :)
    List<Country> countryOnNeighbourFilter(
            @RequestParam String includeNeighbour,
            @RequestParam String excludeNeighbour) {
        return countryService.countryOnNeighbourFilter(includeNeighbour, excludeNeighbour);
    }
}
