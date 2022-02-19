package ro.fasttrackit.homework18;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final List<Country> countries;

    public CountryService(CountryReader reader) throws Exception {
        this.countries = reader.readCountries("src/main/java/ro/fasttrackit/homework18/countries");
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public List<String> getCountriesNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public List<String> getCapital(int id) {
            return countries.stream()
                    .filter(country -> country.getId() == id)
                    .map(Country::getCapital)
                    .collect(Collectors.toList());
    }

    public List<Integer> getPopulation(int id) {
            return countries.stream()
                    .filter(country -> country.getId() == id)
                    .map(Country::getPopulation)
                    .collect(Collectors.toList());
    }

    public List<Country> getCountriesInContinent(String continentName) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continentName))
                .collect(Collectors.toList());
    }

    public List<String> getCountriesNeighbours(int id) {
            return countries.stream()
                    .filter(country -> country.getId() == id)
                    .map(Country::getNeighbours)
                    .collect(Collectors.toList());
    }

    public List<Country> getCountriesWithPopulation(String continentName, int minPopulation) {
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continentName))
                .filter(country -> country.getPopulation() > minPopulation)
                .collect(Collectors.toList());
    }

    public List<Country> countryOnNeighbourFilter(String include, String exclude) {
        return countries.stream()
                .filter(country -> country.getNeighbours().contains(include))
                .filter(country -> !country.getNeighbours().contains(exclude))
                .collect(Collectors.toList());
    }
}
