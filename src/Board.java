import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *The Board of the RISK Game.
 * @version 1.0
 * @author Sarah Jaber
 * @author Walid Baitul Islam
 * @author Judy Hamwi
 * @author Diana Miraflor
 */
public class Board {
    private final List<Continent> continents;
    private ArrayList<Country> countries;

    /**
     * Constructor of Board that creates a new Board
     */
    public Board(){
        continents= new LinkedList<>();
        countries = new ArrayList<>();
        createBoard();
        setTotalCountries();
    }

    /**
     * add a new continent to the Board
     * @param continent added to the board
     */
    public void addContinent(Continent continent){
        continents.add(continent);
    }

    public void addCountry(Country country) {countries.add(country);}

    public Country getCountry(String name) {
        for (Country c : countries) {
            if (c.getCountryName().equals(name)) {
                return c;
            }
        }
        return null;
    }


    /**
     * The textual represention of the Board. Contains information about every continent, country
     * and the player that owns the country
     * @return the textal representation of the board.
     */
    public String toString() {
        String Board= "RISK BOARD: \n" + "Continents: \n";
        for(Continent c:continents){
            Board=Board.concat(c.toString());
        }
        return Board;
    }

    /**
     * Set all the countries in the Board
     */
    public void setTotalCountries(){
        for(Continent c:continents){
            for(Country cy:c.getContinentCountries()){
                countries.add(cy);
            }
        }
    }

    /**
     * Retrieves all the countries in the Board
     * @return List of countries in the Board
     */
    public ArrayList<Country> getCountries(){
        return countries;
    }

    /**
     * create the Board for the RISK Game
     */
    private void createBoard(){

        //  create the Continents in the Game
        Continent NorthAmerica=new Continent("NorthAmerica");
        Continent SouthAmerica=new Continent("SouthAmerica");
        Continent Europe=new Continent("Europe");
        Continent Africa=new Continent("Africa");
        Continent Asia=new Continent("Asia");
        Continent Australia=new Continent("Australia");

        //add continents to board
        this.addContinent(NorthAmerica);
        this.addContinent(SouthAmerica);
        this.addContinent(Europe);
        this.addContinent(Africa);
        this.addContinent(Asia);
        this.addContinent(Australia);

        //create the countries in North America
        createContinentNorthAmerica(NorthAmerica);
        //create the countries in South America
        createContinentSouthAmerica(SouthAmerica);
        //create the countries in Europe
        createContinentEurope(Europe);
        //create the countries in Africa
        createContinentAfrica(Africa);
        //create the countries in Asia
        createContinentAsia(Asia);
        //create the countries in Australia
        createContinentAustralia(Australia);

        // add adjacent countries in NorthAmerica
        addNorthAmericaAdjacentCountries(NorthAmerica);
        // add adjacent countries in SouthAmerica
        addSouthAmericaAdjacentCountries(SouthAmerica);
        // add adjacent countries in Europe
        addEuropeAdjacentCountries(Europe);
        // add adjacent countries in Africa
        addAfricaAdjacentCountries(Africa);
        // add adjacent countries in Asia
        addAsiaAdjacentCountries(Asia);
        // add adjacent countries in Australia
        addAustraliaAdjacentCountries(Australia);


    }

    public void createContinentNorthAmerica(Continent NorthAmerica){
        Country Alaska=new Country("Alaska");
        this.addCountry(Alaska);
        Country Alberta=new Country("Alberta");
        this.addCountry(Alberta);
        Country CentralAmerica=new Country("CentralAmerica");
        this.addCountry(CentralAmerica);
        Country EasternUnitedStates=new Country("EasternUnitedStates");
        this.addCountry(EasternUnitedStates);
        Country Greenland=new Country("Greenland");
        this.addCountry(Greenland);
        Country NorthwestTerritory=new Country("NorthwestTerritory");
        this.addCountry(NorthwestTerritory);
        Country Ontario=new Country("Ontario");
        this.addCountry(Ontario);
        Country Quebec=new Country("Quebec");
        this.addCountry(Quebec);
        Country WesternUnitedStates=new Country("WesternUnitedStates");
        this.addCountry(WesternUnitedStates);
        NorthAmerica.addCountry(Alaska);
        NorthAmerica.addCountry(Alberta);
        NorthAmerica.addCountry(CentralAmerica);
        NorthAmerica.addCountry(EasternUnitedStates);
        NorthAmerica.addCountry(Greenland);
        NorthAmerica.addCountry(NorthwestTerritory);
        NorthAmerica.addCountry(Ontario);
        NorthAmerica.addCountry(Quebec);
        NorthAmerica.addCountry(WesternUnitedStates);


    }

    public void createContinentSouthAmerica(Continent SouthAmerica){
        Country Argentina=new Country("Argentina");
        this.addCountry(Argentina);
        Country Brazil=new Country("Brazil");
        this.addCountry(Brazil);
        Country Peru=new Country("Peru");
        this.addCountry(Peru);
        Country Venezuela=new Country("Venezuela");
        this.addCountry(Venezuela);
        SouthAmerica.addCountry(Argentina);
        SouthAmerica.addCountry(Brazil);
        SouthAmerica.addCountry(Peru);
        SouthAmerica.addCountry(Venezuela);


    }

    public void createContinentEurope(Continent Europe){
        Country GreatBritain=new Country("GreatBritain");
        this.addCountry(GreatBritain);
        Country Iceland=new Country("Iceland");
        this.addCountry(Iceland);
        Country NorthernEurope=new Country("NorthernEurope");
        this.addCountry(NorthernEurope);
        Country Scandinavia=new Country("Scandinavia");
        this.addCountry(Scandinavia);
        Country SouthernEurope=new Country("SouthernEurope");
        this.addCountry(SouthernEurope);
        Country Ukraine=new Country("Ukraine");
        this.addCountry(Ukraine);
        Country WesternEurope=new Country("WesternEurope");
        this.addCountry(WesternEurope);
        Europe.addCountry(GreatBritain);
        Europe.addCountry(Iceland);
        Europe.addCountry(NorthernEurope);
        Europe.addCountry(Scandinavia);
        Europe.addCountry(SouthernEurope);
        Europe.addCountry(Ukraine);
        Europe.addCountry(WesternEurope);

    }

    public void createContinentAfrica(Continent Africa){
        Country Congo=new Country("Congo");
        this.addCountry(Congo);
        Country EastAfrica=new Country("EastAfrica");
        this.addCountry(EastAfrica);
        Country Egypt=new Country("Egypt");
        this.addCountry(Egypt);
        Country Madagascar=new Country("Madagascar");
        this.addCountry(Madagascar);
        Country NorthAfrica=new Country("NorthAfrica");
        this.addCountry(NorthAfrica);
        Country SouthAfrica=new Country("SouthAfrica");
        this.addCountry(SouthAfrica);
        Africa.addCountry(Congo);
        Africa.addCountry(EastAfrica);
        Africa.addCountry(Egypt);
        Africa.addCountry(Madagascar);
        Africa.addCountry(NorthAfrica);
        Africa.addCountry(SouthAfrica);

    }

    public void createContinentAsia(Continent Asia){
        Country Afghanistan=new Country("Afghanistan");
        this.addCountry(Afghanistan);
        Country China=new Country("China");
        this.addCountry(China);
        Country India=new Country("India");
        this.addCountry(India);
        Country Irkutsk=new Country("Irkutsk");
        this.addCountry(Irkutsk);
        Country Japan=new Country("Japan");
        this.addCountry(Japan);
        Country Kamchatka=new Country("Kamchatka");
        this.addCountry(Kamchatka);
        Country MiddleEast=new Country("MiddleEast");
        this.addCountry(MiddleEast);
        Country Mongolia=new Country("Mongolia");
        this.addCountry(Mongolia);
        Country Siam=new Country("Siam");
        this.addCountry(Siam);
        Country Siberia=new Country("Siberia");
        this.addCountry(Siberia);
        Country Ural=new Country("Ural");
        this.addCountry(Ural);
        Country Yakutsk=new Country("Yakutsk");
        this.addCountry(Yakutsk);
        Asia.addCountry(Afghanistan);
        Asia.addCountry(China);
        Asia.addCountry(India);
        Asia.addCountry(Irkutsk);
        Asia.addCountry((Japan));
        Asia.addCountry(Kamchatka);
        Asia.addCountry(MiddleEast);
        Asia.addCountry(Mongolia);
        Asia.addCountry(Siam);
        Asia.addCountry(Siberia);
        Asia.addCountry(Ural);
        Asia.addCountry(Yakutsk);

    }

    public void createContinentAustralia(Continent Australia){
        Country EasternAustralia=new Country("EasternAustralia");
        this.addCountry(EasternAustralia);
        Country Indonesia=new Country("Indonesia");
        this.addCountry(Indonesia);
        Country NewGuinea=new Country("NewGuinea");
        this.addCountry(NewGuinea);
        Country WesternAustralia=new Country("WesternAustralia");
        this.addCountry(WesternAustralia);
        Australia.addCountry(EasternAustralia);
        Australia.addCountry(Indonesia);
        Australia.addCountry(NewGuinea);
        Australia.addCountry(WesternAustralia);
    }

    public void addNorthAmericaAdjacentCountries(Continent NorthAmerica){
        getCountry("Alaska").setAdjacentCountry(getCountry("NorthwestTerritory"));
        getCountry("Alaska").setAdjacentCountry(getCountry("Alberta"));
        getCountry("Alberta").setAdjacentCountry(getCountry("Alaska"));
        getCountry("Alberta").setAdjacentCountry(getCountry("NorthwestTerritory"));
        getCountry("Alberta").setAdjacentCountry(getCountry("Ontario"));
        getCountry("Alberta").setAdjacentCountry(getCountry("WesternUnitedStates"));
        getCountry("CentralAmerica").setAdjacentCountry(getCountry("EasternUnitedStates"));
        getCountry("CentralAmerica").setAdjacentCountry(getCountry("WesternUnitedStates"));
        getCountry("CentralAmerica").setAdjacentCountry(getCountry("Venezuela"));
        getCountry("EasternUnitedStates").setAdjacentCountry(getCountry("CentralAmerica"));
        getCountry("EasternUnitedStates").setAdjacentCountry(getCountry("WesternUnitedStates"));
        getCountry("EasternUnitedStates").setAdjacentCountry(getCountry("Ontario"));
        getCountry("EasternUnitedStates").setAdjacentCountry(getCountry("Quebec"));
        getCountry("Greenland").setAdjacentCountry(getCountry("NorthwestTerritory"));
        getCountry("Greenland").setAdjacentCountry(getCountry("Ontario"));
        getCountry("Greenland").setAdjacentCountry(getCountry("Quebec"));
        getCountry("Greenland").setAdjacentCountry(getCountry("Iceland"));
        getCountry("NorthwestTerritory").setAdjacentCountry(getCountry("Alaska"));
        getCountry("NorthwestTerritory").setAdjacentCountry(getCountry("Alberta"));
        getCountry("NorthwestTerritory").setAdjacentCountry(getCountry("Greenland)"));
        getCountry("NorthwestTerritory").setAdjacentCountry(getCountry("Ontario"));
        getCountry("Ontario").setAdjacentCountry(getCountry("WesternUnitedStates"));
        getCountry("Ontario").setAdjacentCountry(getCountry("EasternUnitedStates"));
        getCountry("Ontario").setAdjacentCountry(getCountry("Greenland"));
        getCountry("Ontario").setAdjacentCountry(getCountry("Quebec"));
        getCountry("Ontario").setAdjacentCountry(getCountry("NorthwestTerritory"));
        getCountry("Ontario").setAdjacentCountry(getCountry("Alberta"));
        getCountry("Quebec").setAdjacentCountry(getCountry("Greenland"));
        getCountry("Quebec").setAdjacentCountry(getCountry("Ontario"));
        getCountry("Quebec").setAdjacentCountry(getCountry("EasternUnitedStates"));
        getCountry("WesternUnitedStates").setAdjacentCountry(getCountry("Alberta"));
        getCountry("WesternUnitedStates").setAdjacentCountry(getCountry("CentralAmerica"));
        getCountry("WesternUnitedStates").setAdjacentCountry(getCountry("EasternUnitedStates"));

    }
    public void addSouthAmericaAdjacentCountries(Continent SouthAmerica){
        getCountry("Argentina").setAdjacentCountry(getCountry("Peru"));
        getCountry("Argentina").setAdjacentCountry(getCountry("Brazil"));
        getCountry("Brazil").setAdjacentCountry(getCountry("Argentina"));
        getCountry("Brazil").setAdjacentCountry(getCountry("Peru"));
        getCountry("Brazil").setAdjacentCountry(getCountry("Venezuela"));
        getCountry("Brazil").setAdjacentCountry(getCountry("NorthAfrica"));
        getCountry("Peru").setAdjacentCountry(getCountry("Argentina"));
        getCountry("Peru").setAdjacentCountry(getCountry("Brazil"));
        getCountry("Peru").setAdjacentCountry(getCountry("Venezuela"));
        getCountry("Venezuela").setAdjacentCountry(getCountry("CentralAmerica"));
        getCountry("Venezuela").setAdjacentCountry(getCountry("Peru"));
        getCountry("Venezuela").setAdjacentCountry(getCountry("Brazil"));

    }
    public void addEuropeAdjacentCountries(Continent Europe){
        getCountry("GreatBritain").setAdjacentCountry(getCountry("Iceland"));
        getCountry("GreatBritain").setAdjacentCountry(getCountry("NorthernEurope"));
        getCountry("GreatBritain").setAdjacentCountry(getCountry("Scandinavia"));
        getCountry("GreatBritain").setAdjacentCountry(getCountry("WesternEurope"));
        getCountry("Iceland").setAdjacentCountry(getCountry("GreenLand"));
        getCountry("Iceland").setAdjacentCountry(getCountry("GreatBritain"));
        getCountry("Iceland").setAdjacentCountry(getCountry("Scandinavia"));
        getCountry("NorthernEurope").setAdjacentCountry(getCountry("GreatBritain"));
        getCountry("NorthernEurope").setAdjacentCountry(getCountry("Scandinavia"));
        getCountry("NorthernEurope").setAdjacentCountry(getCountry("WesternEurope"));
        getCountry("NorthernEurope").setAdjacentCountry(getCountry("SouthernEurope"));
        getCountry("NorthernEurope").setAdjacentCountry(getCountry("Ukraine"));
        getCountry("Scandinavia").setAdjacentCountry(getCountry("Iceland"));
        getCountry("Scandinavia").setAdjacentCountry(getCountry("NorthernEurope"));
        getCountry("Scandinavia").setAdjacentCountry(getCountry("Ukraine"));
        getCountry("SouthernEurope").setAdjacentCountry(getCountry("Egypt"));
        getCountry("SouthernEurope").setAdjacentCountry(getCountry("NorthAfrica"));
        getCountry("SouthernEurope").setAdjacentCountry(getCountry("WesternEurope"));
        getCountry("SouthernEurope").setAdjacentCountry(getCountry("NorthernEurope"));
        getCountry("SouthernEurope").setAdjacentCountry(getCountry("Ukraine"));
        getCountry("SouthernEurope").setAdjacentCountry(getCountry("MiddleEast"));
        getCountry("Ukraine").setAdjacentCountry(getCountry("NorthernEurope"));
        getCountry("Ukraine").setAdjacentCountry(getCountry("Scandinavia"));
        getCountry("Ukraine").setAdjacentCountry(getCountry("SouthernEurope"));
        getCountry("Ukraine").setAdjacentCountry(getCountry("MiddleEast"));
        getCountry("Ukraine").setAdjacentCountry(getCountry("Afghanistan"));
        getCountry("Ukraine").setAdjacentCountry(getCountry("Ural"));
        getCountry("WesternEurope").setAdjacentCountry(getCountry("NorthAfrica"));
        getCountry("WesternEurope").setAdjacentCountry(getCountry("GreatBritain"));
        getCountry("WesternEurope").setAdjacentCountry(getCountry("NorthernEurope"));
        getCountry("WesternEurope").setAdjacentCountry(getCountry("SouthernEurope"));

    }

    public void addAfricaAdjacentCountries(Continent Africa){
        getCountry("Congo").setAdjacentCountry(getCountry("SouthAfrica"));
        getCountry("Congo").setAdjacentCountry(getCountry("EastAfrica"));
        getCountry("Congo").setAdjacentCountry(getCountry("NorthAfrica"));
        getCountry("EastAfrica").setAdjacentCountry(getCountry("Congo"));
        getCountry("EastAfrica").setAdjacentCountry(getCountry("Egypt"));
        getCountry("EastAfrica").setAdjacentCountry(getCountry("Madagascar"));
        getCountry("EastAfrica").setAdjacentCountry(getCountry("NorthAfrica"));
        getCountry("EastAfrica").setAdjacentCountry(getCountry("SouthAfrica"));
        getCountry("EastAfrica").setAdjacentCountry(getCountry("MiddleEast"));
        getCountry("Egypt").setAdjacentCountry(getCountry("EastAfrica"));
        getCountry("Egypt").setAdjacentCountry(getCountry("NorthAfrica"));
        getCountry("Egypt").setAdjacentCountry(getCountry("MiddleEast"));
        getCountry("Egypt").setAdjacentCountry(getCountry("SouthernEurope"));
        getCountry("Madagascar").setAdjacentCountry(getCountry("EastAfrica"));
        getCountry("Madagascar").setAdjacentCountry(getCountry("SouthAfrica"));
        getCountry("NorthAfrica").setAdjacentCountry(getCountry("Congo"));
        getCountry("NorthAfrica").setAdjacentCountry(getCountry("EastAfrica"));
        getCountry("NorthAfrica").setAdjacentCountry(getCountry("Egypt"));
        getCountry("NorthAfrica").setAdjacentCountry(getCountry("Brazil"));
        getCountry("NorthAfrica").setAdjacentCountry(getCountry("WesternEurope"));
        getCountry("NorthAfrica").setAdjacentCountry(getCountry("SouthernEurope"));
        getCountry("SouthAfrica").setAdjacentCountry(getCountry("Congo"));
        getCountry("SouthAfrica").setAdjacentCountry(getCountry("EastAfrica"));
        getCountry("SouthAfrica").setAdjacentCountry(getCountry("Madagascar"));

    }

    public void addAsiaAdjacentCountries(Continent Asia){
        getCountry("Afghanistan").setAdjacentCountry(getCountry("Ukraine"));
        getCountry("Afghanistan").setAdjacentCountry(getCountry("MiddleEast"));
        getCountry("Afghanistan").setAdjacentCountry(getCountry("Ural"));
        getCountry("Afghanistan").setAdjacentCountry(getCountry("India"));
        getCountry("Afghanistan").setAdjacentCountry(getCountry("China"));
        getCountry("China").setAdjacentCountry(getCountry("Siam"));
        getCountry("China").setAdjacentCountry(getCountry("India"));
        getCountry("China").setAdjacentCountry(getCountry("Afghanistan"));
        getCountry("China").setAdjacentCountry(getCountry("Ural"));
        getCountry("China").setAdjacentCountry(getCountry("Siberia"));
        getCountry("China").setAdjacentCountry(getCountry("Mongolia"));
        getCountry("India").setAdjacentCountry(getCountry("Siam"));
        getCountry("India").setAdjacentCountry(getCountry("MiddleEast"));
        getCountry("India").setAdjacentCountry(getCountry("China"));
        getCountry("India").setAdjacentCountry(getCountry("Afghanistan"));
        getCountry("Irkutsk").setAdjacentCountry(getCountry("Yakutsk"));
        getCountry("Irkutsk").setAdjacentCountry(getCountry("Kamchatka"));
        getCountry("Irkutsk").setAdjacentCountry(getCountry("Mongolia"));
        getCountry("Irkutsk").setAdjacentCountry(getCountry("Siberia"));
        getCountry("Japan").setAdjacentCountry(getCountry("Kamchatka"));
        getCountry("Japan").setAdjacentCountry(getCountry("Mongolia"));
        getCountry("Kamchatka").setAdjacentCountry(getCountry("Yakutsk"));
        getCountry("Kamchatka").setAdjacentCountry( getCountry("Irkutsk"));
        getCountry("Kamchatka").setAdjacentCountry(getCountry("Mongolia"));
        getCountry("Kamchatka").setAdjacentCountry(getCountry("Japan"));
        getCountry("MiddleEast").setAdjacentCountry(getCountry("EastAfrica"));
        getCountry("MiddleEast").setAdjacentCountry(getCountry("Egypt"));
        getCountry("MiddleEast").setAdjacentCountry(getCountry("SouthernEurope"));
        getCountry("MiddleEast").setAdjacentCountry(getCountry("Ukraine"));
        getCountry("MiddleEast").setAdjacentCountry(getCountry("Afghanistan"));
        getCountry("MiddleEast").setAdjacentCountry(getCountry("India"));
        getCountry("Mongolia").setAdjacentCountry(getCountry("Siberia"));
        getCountry("Mongolia").setAdjacentCountry( getCountry("Irkutsk"));
        getCountry("Mongolia").setAdjacentCountry(getCountry("Kamchatka"));
        getCountry("Mongolia").setAdjacentCountry(getCountry("Japan"));
        getCountry("Mongolia").setAdjacentCountry(getCountry("China"));
        getCountry("Siam").setAdjacentCountry(getCountry("China"));
        getCountry("Siam").setAdjacentCountry(getCountry("India"));
        getCountry("Siam").setAdjacentCountry(getCountry("Indonesia"));
        getCountry("Siberia").setAdjacentCountry(getCountry("Yakutsk"));
        getCountry("Siberia").setAdjacentCountry( getCountry("Irkutsk"));
        getCountry("Siberia").setAdjacentCountry(getCountry("Mongolia"));
        getCountry("Siberia").setAdjacentCountry(getCountry("China"));
        getCountry("Siberia").setAdjacentCountry(getCountry("Ural"));
        getCountry("Ural").setAdjacentCountry(getCountry("Ukraine"));
        getCountry("Ural").setAdjacentCountry(getCountry("Siberia"));
        getCountry("Ural").setAdjacentCountry(getCountry("China"));
        getCountry("Ural").setAdjacentCountry(getCountry("Afghanistan"));
        getCountry("Yakutsk").setAdjacentCountry(getCountry("Siberia"));
        getCountry("Yakutsk").setAdjacentCountry(getCountry("Kamchatka"));
        getCountry("Yakutsk").setAdjacentCountry( getCountry("Irkutsk"));

    }

    public void addAustraliaAdjacentCountries(Continent Australia){
        getCountry("EasternAustralia").setAdjacentCountry(getCountry("WesternAustralia"));
        getCountry("EasternAustralia").setAdjacentCountry(getCountry("NewGuinea"));
        getCountry("Indonesia").setAdjacentCountry(getCountry("Siam"));
        getCountry("Indonesia").setAdjacentCountry(getCountry("NewGuinea"));
        getCountry("NewGuinea").setAdjacentCountry(getCountry("EasternAustralia"));
        getCountry("NewGuinea").setAdjacentCountry(getCountry("Indonesia"));
        getCountry("NewGuinea").setAdjacentCountry(getCountry("WesternAustralia"));
        getCountry("WesternAustralia").setAdjacentCountry(getCountry("EasternAustralia"));
        getCountry("WesternAustralia").setAdjacentCountry(getCountry("NewGuinea"));
    }

}
