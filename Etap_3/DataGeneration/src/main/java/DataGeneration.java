public class DataGeneration {

    public static void main(String[] args) {


        int mapNumberOfRows = 50;
        int countryNumberOfRows = 10;
        int basicStatisticsNumberOfRows = 50;
        int skillsNumberOfRows = 50;
        int accountsNumberOfRows = 50;
        int serversNumberOfRows = 50;
        int characterLooksNumberOfRows = 50;
        int characterClassesNumberOfRows = 50;
        int characterRacesNumberOfRows = 50;
        int mapPositionsNumberOfRows = 50;
        int itemsNumberOfRows = 50;
        int charactersNumberOfRows = 50;

        try {
            Generator.generateMapData("data/map.csv", mapNumberOfRows);
            Generator.generateCountriesData("data/countries.csv", countryNumberOfRows);
            Generator.generateBaseStatisticsData("data/base_statistics.csv", basicStatisticsNumberOfRows);
            Generator.generateCharacterLooksData("data/character_looks.csv", characterLooksNumberOfRows);
            Generator.generateMapPositionData("data/map_position.csv", mapPositionsNumberOfRows, mapNumberOfRows);
            Generator.generateAccountsData("data/accounts.csv", accountsNumberOfRows);
            Generator.generateServersData("data/servers.csv", serversNumberOfRows, countryNumberOfRows);
            Generator.generateCharacterRacesData("data/character_races.csv", characterRacesNumberOfRows, basicStatisticsNumberOfRows);
            Generator.generateCharacterClassesData("data/character_classes.csv", characterClassesNumberOfRows, basicStatisticsNumberOfRows);
            Generator.generateSkillsData("data/skills.csv", skillsNumberOfRows, basicStatisticsNumberOfRows);
            Generator.generateItemsData("data/items.csv", itemsNumberOfRows, basicStatisticsNumberOfRows);
            Generator.generateCharacterClassSkillsData("data/character_class_skills.csv", 50, characterClassesNumberOfRows, skillsNumberOfRows);
            Generator.generateCharactersData("data/characters.csv", charactersNumberOfRows, accountsNumberOfRows, serversNumberOfRows, characterLooksNumberOfRows, characterClassesNumberOfRows, characterRacesNumberOfRows, mapPositionsNumberOfRows);
            Generator.generateCharacterItemsData("data/character_items.csv", 50, itemsNumberOfRows, charactersNumberOfRows);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
