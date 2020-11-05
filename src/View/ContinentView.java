package View;

import java.awt.*;
import java.util.Set;

public class ContinentView {

    private final Color color;
    private final Point position;
    private final String name;

    private final Set<CountryView> countries;

    public ContinentView(Color color, Point position, String name, Set<CountryView> countries) {
        this.color = color;
        this.position = position;
        this.name = name;
        this.countries = countries;
    }
}
