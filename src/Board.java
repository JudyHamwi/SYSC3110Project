import java.util.LinkedList;
import java.util.List;

/**
 * The Board of the RISK Game
 */
public class Board {
    private List<Continent> continents;

    /**
     * Constructor of Board that creates a new Board
     */
    public Board(){
        continents= new LinkedList<>();
        createBoard();
    }

    /**
     * add a new continent to the Board
     * @param continent added to the board
     */
    public void addContinent(Continent continent){
        continents.add(continent);
    }

    /**
     * Print the Board
     */
    public String toString() {
        String Board= "RISK BOARD: \n" + "Continets: \n";
        for(Continent c:continents){
            Board+=c;
        }
        return Board;
    }

    /**
     * create the Board for the RISK Game
     */
    private void createBoard(){

        //  create the Continents in the Game
        Continent NorthAmerica=new Continent("North America");
        Continent SouthAmerica=new Continent("South America");
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
        Country Alaska=new Country("Alaska");
        Country Alberta=new Country("Alberta");
        Country CentralAmerica=new Country("Central America");
        Country EasternUnitedStates=new Country("Eastern United States");
        Country Greenland=new Country("Greenland");
        Country NorthwestTerritory=new Country("Northwest Territory");
        Country Ontario=new Country("Ontario");
        Country Quebec=new Country("Quebec");
        Country WesternUnitedStates=new Country("Western United States");

        //create the countries in South America
        Country Argentina=new Country("Argentina");
        Country Brazil=new Country("Brazil");
        Country Peru=new Country("Peru");
        Country Venezuela=new Country("Venezuela");

        //create the countries in Europe
        Country GreatBritain=new Country("Great Britain");
        Country Iceland=new Country("Iceland");
        Country NorthernEurope=new Country("Northern Europe");
        Country Scandinavia=new Country("Scandinavia");
        Country SouthernEurope=new Country("Southern Europe");
        Country Ukraine=new Country("Ukraine");
        Country WesternEurope=new Country("Western Europe");

        //create the countries in Africa
        Country Congo=new Country("Congo");
        Country EastAfrica=new Country("East Africa");
        Country Egypt=new Country("Egypt");
        Country Madagascar=new Country("Madagascar");
        Country NorthAfrica=new Country("North Africa");
        Country SouthAfrica=new Country("South Africa");

        //create the countries in Africa
        Country Afghanistan=new Country("Afghanistan");
        Country China=new Country("China");
        Country India=new Country("India");
        Country Irkutsk=new Country("Irkutsk");
        Country Japan=new Country("Japan");
        Country Kamchatka=new Country("Kamchatka");
        Country MiddleEast=new Country("Middle East");
        Country Mongolia=new Country("Mongolia");
        Country Siam=new Country("Siam");
        Country Siberia=new Country("Siberia");
        Country Ural=new Country("Ural");
        Country Yakutsk=new Country("Yakutsk");

        //create the countries in Australia
        Country EasternAustralia=new Country("Eastern Australia");
        Country Indonesia=new Country("Indonesia");
        Country NewGuinea=new Country("New Guinea");
        Country WesternAustralia=new Country("Western Australia");

        // add countries to North America
        NorthAmerica.addCountry(Alaska);
        NorthAmerica.addCountry(Alberta);
        NorthAmerica.addCountry(CentralAmerica);
        NorthAmerica.addCountry(EasternUnitedStates);
        NorthAmerica.addCountry(Greenland);
        NorthAmerica.addCountry(NorthwestTerritory);
        NorthAmerica.addCountry(Ontario);
        NorthAmerica.addCountry(Quebec);
        NorthAmerica.addCountry(WesternUnitedStates);

        // add countries to South America
        SouthAmerica.addCountry(Argentina);
        SouthAmerica.addCountry(Brazil);
        SouthAmerica.addCountry(Peru);
        SouthAmerica.addCountry(Venezuela);

        // add countries to continent Europe
        Europe.addCountry(GreatBritain);
        Europe.addCountry(Iceland);
        Europe.addCountry(NorthernEurope);
        Europe.addCountry(Scandinavia);
        Europe.addCountry(SouthernEurope);
        Europe.addCountry(Ukraine);
        Europe.addCountry(WesternEurope);

        // add countries to continent Africa
        Africa.addCountry(Congo);
        Africa.addCountry(EastAfrica);
        Africa.addCountry(Egypt);
        Africa.addCountry(Madagascar);
        Africa.addCountry(NorthAfrica);
        Africa.addCountry(SouthAfrica);

        // add countries to continent Asia
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

        // add countries to continent Australia
        Australia.addCountry(EasternAustralia);
        Australia.addCountry(Indonesia);
        Australia.addCountry(NewGuinea);
        Australia.addCountry(WesternAustralia);

        //add adjacent countries in North America
        Alaska.setAdjacentCountry(NorthwestTerritory);
        Alaska.setAdjacentCountry(Alberta);
        Alberta.setAdjacentCountry(Alaska);
        Alberta.setAdjacentCountry(NorthwestTerritory);
        Alberta.setAdjacentCountry(Ontario);
        Alberta.setAdjacentCountry(WesternUnitedStates);
        CentralAmerica.setAdjacentCountry(EasternUnitedStates);
        CentralAmerica.setAdjacentCountry(WesternUnitedStates);
        CentralAmerica.setAdjacentCountry(Venezuela);
        EasternUnitedStates.setAdjacentCountry(CentralAmerica);
        EasternUnitedStates.setAdjacentCountry(WesternUnitedStates);
        EasternUnitedStates.setAdjacentCountry(Ontario);
        EasternUnitedStates.setAdjacentCountry(Quebec);
        Greenland.setAdjacentCountry(NorthwestTerritory);
        Greenland.setAdjacentCountry(Ontario);
        Greenland.setAdjacentCountry(Quebec);
        Greenland.setAdjacentCountry(Iceland);
        NorthwestTerritory.setAdjacentCountry(Alaska);
        NorthwestTerritory.setAdjacentCountry(Alberta);
        NorthwestTerritory.setAdjacentCountry(Greenland);
        NorthwestTerritory.setAdjacentCountry(Ontario);
        Ontario.setAdjacentCountry(WesternUnitedStates);
        Ontario.setAdjacentCountry(EasternUnitedStates);
        Ontario.setAdjacentCountry(Greenland);
        Ontario.setAdjacentCountry(Quebec);
        Ontario.setAdjacentCountry(NorthwestTerritory);
        Ontario.setAdjacentCountry(Alberta);
        Quebec.setAdjacentCountry(Greenland);
        Quebec.setAdjacentCountry(Ontario);
        Quebec.setAdjacentCountry(EasternUnitedStates);
        WesternUnitedStates.setAdjacentCountry(Alberta);
        WesternUnitedStates.setAdjacentCountry(CentralAmerica);
        WesternUnitedStates.setAdjacentCountry(EasternUnitedStates);

        //add adjacent countries in South America
        Argentina.setAdjacentCountry(Peru);
        Argentina.setAdjacentCountry(Brazil);
        Brazil.setAdjacentCountry(Argentina);
        Brazil.setAdjacentCountry(Peru);
        Brazil.setAdjacentCountry(Venezuela);
        Brazil.setAdjacentCountry(NorthAfrica);
        Peru.setAdjacentCountry(Argentina);
        Peru.setAdjacentCountry(Brazil);
        Peru.setAdjacentCountry(Venezuela);
        Venezuela.setAdjacentCountry(CentralAmerica);
        Venezuela.setAdjacentCountry(Peru);
        Venezuela.setAdjacentCountry(Brazil);

        //add adjacent countries in Africa
        Congo.setAdjacentCountry(SouthAfrica);
        Congo.setAdjacentCountry(EastAfrica);
        Congo.setAdjacentCountry(NorthAfrica);
        EastAfrica.setAdjacentCountry(Congo);
        EastAfrica.setAdjacentCountry(Egypt);
        EastAfrica.setAdjacentCountry(Madagascar);
        EastAfrica.setAdjacentCountry(NorthAfrica);
        EastAfrica.setAdjacentCountry(SouthAfrica);
        EastAfrica.setAdjacentCountry(MiddleEast);
        Egypt.setAdjacentCountry(EastAfrica);
        Egypt.setAdjacentCountry(NorthAfrica);
        Egypt.setAdjacentCountry(MiddleEast);
        Egypt.setAdjacentCountry(SouthernEurope);
        Madagascar.setAdjacentCountry(EastAfrica);
        Madagascar.setAdjacentCountry(SouthAfrica);
        NorthAfrica.setAdjacentCountry(Congo);
        NorthAfrica.setAdjacentCountry(EastAfrica);
        NorthAfrica.setAdjacentCountry(Egypt);
        NorthAfrica.setAdjacentCountry(Brazil);
        NorthAfrica.setAdjacentCountry(WesternEurope);
        NorthAfrica.setAdjacentCountry(SouthernEurope);
        SouthAfrica.setAdjacentCountry(Congo);
        SouthAfrica.setAdjacentCountry(EastAfrica);
        SouthAfrica.setAdjacentCountry(Madagascar);

        //add adjacent countries in Europe
        GreatBritain.setAdjacentCountry(Iceland);
        GreatBritain.setAdjacentCountry(NorthernEurope);
        GreatBritain.setAdjacentCountry(Scandinavia);
        GreatBritain.setAdjacentCountry(WesternEurope);
        Iceland.setAdjacentCountry(Greenland);
        Iceland.setAdjacentCountry(GreatBritain);
        Iceland.setAdjacentCountry(Scandinavia);
        NorthernEurope.setAdjacentCountry(GreatBritain);
        NorthernEurope.setAdjacentCountry(Scandinavia);
        NorthernEurope.setAdjacentCountry(WesternEurope);
        NorthernEurope.setAdjacentCountry(SouthernEurope);
        NorthernEurope.setAdjacentCountry(Ukraine);
        Scandinavia.setAdjacentCountry(Iceland);
        Scandinavia.setAdjacentCountry(NorthernEurope);
        Scandinavia.setAdjacentCountry(Ukraine);
        SouthernEurope.setAdjacentCountry(Egypt);
        SouthernEurope.setAdjacentCountry(NorthAfrica);
        SouthernEurope.setAdjacentCountry(WesternEurope);
        SouthernEurope.setAdjacentCountry(NorthernEurope);
        SouthernEurope.setAdjacentCountry(Ukraine);
        SouthernEurope.setAdjacentCountry(MiddleEast);
        Ukraine.setAdjacentCountry(NorthernEurope);
        Ukraine.setAdjacentCountry(Scandinavia);
        Ukraine.setAdjacentCountry(SouthernEurope);
        Ukraine.setAdjacentCountry(MiddleEast);
        Ukraine.setAdjacentCountry(Afghanistan);
        Ukraine.setAdjacentCountry(Ural);
        WesternEurope.setAdjacentCountry(NorthAfrica);
        WesternEurope.setAdjacentCountry(GreatBritain);
        WesternEurope.setAdjacentCountry(NorthernEurope);
        WesternEurope.setAdjacentCountry(SouthernEurope);

        //add adjacent countries in Asia
        Afghanistan.setAdjacentCountry(Ukraine);
        Afghanistan.setAdjacentCountry(MiddleEast);
        Afghanistan.setAdjacentCountry(Ural);
        Afghanistan.setAdjacentCountry(India);
        Afghanistan.setAdjacentCountry(China);
        China.setAdjacentCountry(Siam);
        China.setAdjacentCountry(India);
        China.setAdjacentCountry(Afghanistan);
        China.setAdjacentCountry(Ural);
        China.setAdjacentCountry(Siberia);
        China.setAdjacentCountry(Mongolia);
        India.setAdjacentCountry(Siam);
        India.setAdjacentCountry(MiddleEast);
        India.setAdjacentCountry(China);
        India.setAdjacentCountry(Afghanistan);
        Irkutsk.setAdjacentCountry(Yakutsk);
        Irkutsk.setAdjacentCountry(Kamchatka);
        Irkutsk.setAdjacentCountry(Mongolia);
        Irkutsk.setAdjacentCountry(Siberia);
        Japan.setAdjacentCountry(Kamchatka);
        Japan.setAdjacentCountry(Mongolia);
        Kamchatka.setAdjacentCountry(Yakutsk);
        Kamchatka.setAdjacentCountry(Irkutsk);
        Kamchatka.setAdjacentCountry(Mongolia);
        Kamchatka.setAdjacentCountry(Japan);
        MiddleEast.setAdjacentCountry(EastAfrica);
        MiddleEast.setAdjacentCountry(Egypt);
        MiddleEast.setAdjacentCountry(SouthernEurope);
        MiddleEast.setAdjacentCountry(Ukraine);
        MiddleEast.setAdjacentCountry(Afghanistan);
        MiddleEast.setAdjacentCountry(India);
        Mongolia.setAdjacentCountry(Siberia);
        Mongolia.setAdjacentCountry(Irkutsk);
        Mongolia.setAdjacentCountry(Kamchatka);
        Mongolia.setAdjacentCountry(Japan);
        Mongolia.setAdjacentCountry(China);
        Siam.setAdjacentCountry(China);
        Siam.setAdjacentCountry(India);
        Siam.setAdjacentCountry(Indonesia);
        Siberia.setAdjacentCountry(Yakutsk);
        Siberia.setAdjacentCountry(Irkutsk);
        Siberia.setAdjacentCountry(Mongolia);
        Siberia.setAdjacentCountry(China);
        Siberia.setAdjacentCountry(Ural);
        Ural.setAdjacentCountry(Ukraine);
        Ural.setAdjacentCountry(Siberia);
        Ural.setAdjacentCountry(China);
        Ural.setAdjacentCountry(Afghanistan);
        Yakutsk.setAdjacentCountry(Siberia);
        Yakutsk.setAdjacentCountry(Kamchatka);
        Yakutsk.setAdjacentCountry(Irkutsk);

        //add adjacent countries in Australia
        EasternAustralia.setAdjacentCountry(WesternAustralia);
        EasternAustralia.setAdjacentCountry(NewGuinea);
        Indonesia.setAdjacentCountry(Siam);
        Indonesia.setAdjacentCountry(NewGuinea);
        NewGuinea.setAdjacentCountry(EasternAustralia);
        NewGuinea.setAdjacentCountry(Indonesia);
        NewGuinea.setAdjacentCountry(WesternAustralia);
        WesternAustralia.setAdjacentCountry(EasternAustralia);
        WesternAustralia.setAdjacentCountry(NewGuinea);
    }

    public static void main(String[] args) {
        Board b=new Board();
        System.out.println(b);

    }
}
