import com.github.javafaker.Faker;

import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Generator {
    private static Faker faker = new Faker();

    private static void printDates(PrintWriter printWriter) {
        LocalDateTime createdAt = LocalDateTime.ofInstant(faker.date().between(Date.valueOf(LocalDate.now().minusYears(20)), Date.valueOf(LocalDate.now().minusDays(1))).toInstant(), ZoneOffset.UTC);
        LocalDateTime modifiedAt = LocalDateTime.ofInstant(faker.date().between(Date.valueOf(createdAt.toLocalDate()), Date.valueOf(LocalDate.now().minusDays(1))).toInstant(), ZoneOffset.UTC);
        LocalDateTime deletedAt = LocalDateTime.ofInstant(faker.date().between(Date.valueOf(modifiedAt.toLocalDate()), Date.valueOf(LocalDate.now())).toInstant(), ZoneOffset.UTC);

        printWriter.print(";" + createdAt + ";");
        if (faker.random().nextBoolean()) {
            printWriter.print(modifiedAt);
        } else {
            printWriter.print("\\N");
        }
        printWriter.print(";");
        if (faker.random().nextBoolean()) {
            printWriter.print(deletedAt);
        } else {
            printWriter.print("\\N");
        }
    }

    public static void generateMapData(String filename, int rowNum) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;name;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";" + faker.witcher().location().replaceAll("[^A-Za-z]", "") + i);
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateCountriesData(String filename, int rowNum) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;code;name;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";" + faker.country().countryCode3() + ";" + faker.country().name().replaceAll("[^A-Za-z]", "") + i);
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateBaseStatisticsData(String filename, int rowNum) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;intelligent_value;strength_value;vitality_value;luck_value;armor;magic_armor;attack;magic_attack;max_hp;max_mp;max_sp;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateCharacterLooksData(String filename, int rowNum) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;hair_type;hair_color;body_type;skin_color;head_type;sex;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(0, 1));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateMapPositionData(String filename, int rowNum, int maxMapId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;pos_x;pos_y;pos_z;is_spawn_position;map_id;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.random().nextInt(1, 1000) + ";");
            printWriter.print(faker.random().nextInt(1, 100) + ";");
            printWriter.print(faker.random().nextInt(1, 1000) + ";");
            printWriter.print((faker.random().nextBoolean()?1:0) + ";");
            printWriter.print(faker.random().nextInt(1, maxMapId));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateAccountsData(String filename, int rowNum) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;email;nickname;login;password_hash;created_at;modified_at;deleted_at;ban_expired_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.internet().safeEmailAddress() + ";");
            String name = faker.name().username();
            printWriter.print(name + ";");
            printWriter.print(name + i + ";");
            printWriter.print(faker.internet().password());
            printDates(printWriter);
            printWriter.print(";");
            if (faker.random().nextBoolean()) {
                LocalDateTime banExpiredAt = LocalDateTime.ofInstant(faker.date().between(Date.valueOf(LocalDate.now().minusYears(20)), Date.valueOf(LocalDate.now().plusMonths(12))).toInstant(), ZoneOffset.UTC);
                printWriter.print(banExpiredAt);
            }
            else{
                printWriter.print("\\N");
            }
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateServersData(String filename, int rowNum, int maxCountryId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;name;slots;port;country_id;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.music().genre() + i + ";");
            printWriter.print(faker.random().nextInt(20, 100) + ";");
            printWriter.print(faker.random().nextInt(49152, 65535)+ ";");
            printWriter.print(faker.random().nextInt(1, maxCountryId) );
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateCharacterRacesData(String filename, int rowNum, int maxBaseStatId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;name;base_stat_id;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.elderScrolls().race() + ";");
            printWriter.print(faker.random().nextInt(1, maxBaseStatId));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateCharacterClassesData(String filename, int rowNum, int maxBaseStatId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;name;base_stat_id;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            String[] classes = {"Knight", "Mage", "Barbarian", "Paladin", "Monk", "Assassin", "Ranger", "Necromancer"};
            printWriter.print(classes[faker.random().nextInt(0, classes.length - 1)] + ";");
            printWriter.print(faker.random().nextInt(1, maxBaseStatId));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateSkillsData(String filename, int rowNum, int maxBaseStatId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;name;base_stat_id;is_passive;is_buff;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.leagueOfLegends().summonerSpell() + i + ";");
            printWriter.print(faker.random().nextInt(1, maxBaseStatId)+";");
            printWriter.print((faker.random().nextBoolean()?1:0) + ";");
            printWriter.print((faker.random().nextBoolean()?1:0));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateItemsData(String filename, int rowNum, int maxBaseStatId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;name;base_stat_id;item_type;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            if (faker.random().nextBoolean()) {
                printWriter.print(faker.commerce().color() + " ");
            }
            printWriter.print(faker.commerce().productName() + i + ";");
            printWriter.print(faker.random().nextInt(1, maxBaseStatId)+";");
            String[] itemType = {"Wand", "Sword", "Chestplate", "Consumable", "Pants", "Helmet", "Bow", "Staff", "Boots", "Gloves", "Ring", "Amulet"};
            printWriter.print(itemType[faker.random().nextInt(0, itemType.length - 1)]);
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateCharacterClassSkillsData(String filename, int rowNum, int maxCharacterClassesId, int maxSkillsId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;skill_id;char_class_id;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.random().nextInt(1, maxSkillsId) + ";");
            printWriter.print(faker.random().nextInt(1, maxCharacterClassesId));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateCharactersData(String filename, int rowNum, int maxAccountId, int maxServerId, int maxCharacterLooksId, int maxCharacterClassesId, int maxCharacterRacesId, int maxPositionsId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;account_id;server_id;char_look_id;char_class_id;char_race_id;position_id;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.random().nextInt(1, maxAccountId) + ";");
            printWriter.print(faker.random().nextInt(1, maxServerId) + ";");
            printWriter.print(faker.random().nextInt(1, maxCharacterLooksId) + ";");
            printWriter.print(faker.random().nextInt(1, maxCharacterClassesId) + ";");
            printWriter.print(faker.random().nextInt(1, maxCharacterRacesId) + ";");
            printWriter.print(faker.random().nextInt(1, maxPositionsId));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }

    public static void generateCharacterItemsData(String filename, int rowNum, int maxItemId, int maxCharacterId) throws Exception {

        PrintWriter printWriter = new PrintWriter(filename);
        printWriter.println("id;item_id;char_id;created_at;modified_at;deleted_at");
        for (int i = 1; i <= rowNum; ++i) {

            printWriter.print(i + ";");
            printWriter.print(faker.random().nextInt(1, maxItemId) + ";");
            printWriter.print(faker.random().nextInt(1, maxCharacterId));
            printDates(printWriter);
            printWriter.print("\n");

        }
        printWriter.close();
    }
}
