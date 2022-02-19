package ro.fasttrackit.homework18;

import java.util.Objects;

public class Country {
    private final int id;
    private final String name;
    private final String capital;
    private final int population;
    private final String area;
    private final String continent;
    private String neighbours;

    public Country(int id, String name, String capital, int population, String area, String continent) {
        this.id = id;
        this.name = notNull(name);
        this.capital = notNull(capital);
        this.population = population < 1 ? 0 : population;
        this.area = notNull(area);
        this.continent = notNull(continent);
    }

    public Country(int id, String name, String capital, int population, String area, String continent, String neighbours) {
        this(id, name, capital, population, area, continent);
        this.neighbours = notNull(neighbours);
    }

    private String notNull(String text) {
        return Objects.requireNonNullElse(text, "");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public String getNeighbours() {
        return neighbours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return population == country.population && Objects.equals(name, country.name) && Objects.equals(capital, country.capital) && Objects.equals(area, country.area) && Objects.equals(continent, country.continent) && Objects.equals(neighbours, country.neighbours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, population, area, continent, neighbours);
    }

    @Override
    public String toString() {
        return "Country: " + "\n" +
                "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Capital: " + capital + "\n" +
                "Population: " + population + "\n" +
                "Area: " + area + "\n" +
                "Continent: " + continent + "\n" +
                "Neighbours: " + neighbours + "\n\n"
        ;
    }
}
