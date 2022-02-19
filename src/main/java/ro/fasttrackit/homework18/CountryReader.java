package ro.fasttrackit.homework18;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Component
public class CountryReader {

    public List<Country> readCountries(String filePath) throws Exception {
        List<Country> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int id = 0;
            while ((line = reader.readLine()) != null) {
                result.add(readCountryFromLine(id++, line));
            }
        }
        return result;
    }

    private Country readCountryFromLine(int id, String line) {
        String[] tokens = line.split(Pattern.quote("|"));

        if(line.contains("~")) {
            return new Country(
                    id,
                    tokens[0],
                    tokens[1],
                    Integer.parseInt(tokens[2]),
                    tokens[3],
                    tokens[4],
                    Objects.requireNonNull(tokens[5].replaceAll("~", ", "), "")
            );
        } else {
            return new Country(
                    id,
                    tokens[0],
                    tokens[1],
                    Integer.parseInt(tokens[2]),
                    tokens[3],
                    tokens[4]
            );
        }
    }
}
