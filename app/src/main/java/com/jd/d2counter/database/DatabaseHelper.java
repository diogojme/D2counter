package com.jd.d2counter.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.jd.d2counter.R;
import com.jd.d2counter.objects.Hero;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper implements Database {

    private Hero hero;
    private SQLiteDatabase database;
    private static DatabaseHelper instance;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dota.database";

    private DatabaseHelper(Context context) {
        super(context.getApplicationContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper with(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_HERO);
        sqLiteDatabase.execSQL(CREATE_TABLE_HERO_COUNTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO_COUNTER);
        this.onCreate(sqLiteDatabase);
    }

    @Override
    public void open() {
        if (database == null) {
            database = getWritableDatabase();
        }
    }

    @Override
    public void beginTransaction() {
        database.beginTransaction();
    }

    @Override
    public void setTransactionSuccessful() {
        database.setTransactionSuccessful();
    }

    @Override
    public boolean inTransaction() {
        return database.inTransaction();
    }

    @Override
    public void endTransaction() {
        database.endTransaction();
    }

    @Override
    public List<Hero> getHeroList(String query) {
        List<Hero> heroes = new ArrayList<Hero>();
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                heroes.add(getHero(cursor.getLong(0)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return heroes;
    }

    @Override
    public Hero getHero(long id) {
        Hero hero = null;
        String query = "SELECT * FROM " + TABLE_HERO + " WHERE " + COLUMN_HERO_ID + " = " + id;
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            hero = new Hero(cursor.getLong(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4));
        }

        return hero;
    }

    @Override
    public void addHero(Hero hero) {
        SQLiteStatement statement = Statement.with(database).get(STATEMENT_HERO);
        statement.bindLong(1, hero.getId());
        statement.bindString(2, hero.getName());
        statement.bindLong(3, hero.getType());
        statement.bindLong(3, hero.getId());
        statement.execute();
        statement.clearBindings();
    }

    public void addCounter(long idHero, long idCounter, long idSupport, long rank) {
        SQLiteStatement statement = Statement.with(database).get(STATEMENT_HERO_COUNTER);
        statement.bindLong(1, idHero);
        statement.bindLong(2, idCounter);
        statement.bindLong(3, idSupport);
        statement.bindLong(4, rank);
        statement.execute();
        statement.clearBindings();
    }

    @Override
    public void insertHero() {
        beginTransaction();
        addHero(new Hero(0, "ABADDON", Hero.TYPE_STRENGHT, R.drawable.abaddon_vert));
        addHero(new Hero(1, "ALCHEMIST", Hero.TYPE_STRENGHT, R.drawable.alchemist_vert));
        addHero(new Hero(2, "ANCIENT APPARITION", Hero.TYPE_INTELIGENCE, R.drawable.ancient_apparition_vert));
        addHero(new Hero(3, "ANTI MAGE", Hero.TYPE_AGILITY, R.drawable.antimage_vert));
        addHero(new Hero(4, "AXE", Hero.TYPE_STRENGHT, R.drawable.axe_vert));
        addHero(new Hero(5, "BANE", Hero.TYPE_INTELIGENCE, R.drawable.bane_vert));
        addHero(new Hero(6, "BATRIDER", Hero.TYPE_INTELIGENCE, R.drawable.batrider_vert));
        addHero(new Hero(7, "BEAST MASTER", Hero.TYPE_STRENGHT, R.drawable.beastmaster_vert));
        addHero(new Hero(8, "BLOODSEEKER", Hero.TYPE_AGILITY, R.drawable.bloodseeker_vert));
        addHero(new Hero(9, "BOUNTY HUNTER", Hero.TYPE_AGILITY, R.drawable.bounty_hunter_vert));
        addHero(new Hero(10, "BREWMASTER", Hero.TYPE_STRENGHT, R.drawable.brewmaster_vert));
        addHero(new Hero(11, "BRISTLEBACK", Hero.TYPE_STRENGHT, R.drawable.bristleback_vert));
        addHero(new Hero(12, "CENTAUR WARRUNNER", Hero.TYPE_STRENGHT, R.drawable.centaur_vert));
        addHero(new Hero(13, "CHAOS KNIGHT", Hero.TYPE_STRENGHT, R.drawable.chaos_knight_vert));
        addHero(new Hero(14, "CHEN", Hero.TYPE_INTELIGENCE, R.drawable.chen_vert));
        addHero(new Hero(15, "CLINCKZ", Hero.TYPE_AGILITY, R.drawable.clinkz_vert));
        addHero(new Hero(16, "CLOCKWERK", Hero.TYPE_STRENGHT, R.drawable.rattletrap_vert));
        addHero(new Hero(17, "CRYSTAL MAIDEN", Hero.TYPE_INTELIGENCE, R.drawable.crystal_maiden_vert));
        addHero(new Hero(18, "DARK SEER", Hero.TYPE_INTELIGENCE, R.drawable.dark_seer_vert));
        addHero(new Hero(19, "DAZZLE", Hero.TYPE_INTELIGENCE, R.drawable.dazzle_vert));
        addHero(new Hero(20, "DEATH PROPHET", Hero.TYPE_INTELIGENCE, R.drawable.death_prophet_vert));
        addHero(new Hero(21, "DISRUPTOR", Hero.TYPE_INTELIGENCE, R.drawable.disruptor_vert));
        addHero(new Hero(22, "DOOM BRINGER", Hero.TYPE_STRENGHT, R.drawable.doom_bringer_vert));
        addHero(new Hero(23, "DRAGON KNIGHT", Hero.TYPE_STRENGHT, R.drawable.dragon_knight_vert));
        addHero(new Hero(24, "DROW RANGER", Hero.TYPE_AGILITY, R.drawable.drow_ranger_vert));
        addHero(new Hero(25, "EARTHSHAKER", Hero.TYPE_STRENGHT, R.drawable.earth_spirit_vert));
        addHero(new Hero(26, "ELDER TITAN", Hero.TYPE_STRENGHT, R.drawable.elder_titan_vert));
        addHero(new Hero(27, "ENCHANTRESS", Hero.TYPE_INTELIGENCE, R.drawable.enchantress_vert));
        addHero(new Hero(28, "ENIGMA", Hero.TYPE_INTELIGENCE, R.drawable.enigma_vert));
        addHero(new Hero(29, "FACELESS VOID", Hero.TYPE_AGILITY, R.drawable.faceless_void_vert));
        addHero(new Hero(30, "GYROCOPTER", Hero.TYPE_AGILITY, R.drawable.gyrocopter_vert));
        addHero(new Hero(31, "HUSKAR", Hero.TYPE_STRENGHT, R.drawable.huskar_vert));
        addHero(new Hero(32, "INVOKER", Hero.TYPE_INTELIGENCE, R.drawable.invoker_vert));
        addHero(new Hero(33, "IO", Hero.TYPE_STRENGHT, R.drawable.wisp_vert));
        addHero(new Hero(34, "JAKIRO", Hero.TYPE_INTELIGENCE, R.drawable.jakiro_vert));
        addHero(new Hero(35, "JUGGERNAUT", Hero.TYPE_AGILITY, R.drawable.juggernaut_vert));
        addHero(new Hero(36, "KEEPER OF THE LIGHT", Hero.TYPE_INTELIGENCE, R.drawable.keeper_of_the_light_vert));
        addHero(new Hero(37, "KUNKKA", Hero.TYPE_STRENGHT, R.drawable.kunkka_vert));
        addHero(new Hero(38, "LESHRAK", Hero.TYPE_INTELIGENCE, R.drawable.leshrac_vert));
        addHero(new Hero(39, "LICH", Hero.TYPE_INTELIGENCE, R.drawable.lich_vert));
        addHero(new Hero(40, "LIFESTEALER", Hero.TYPE_STRENGHT, R.drawable.life_stealer_vert));
        addHero(new Hero(41, "LINA", Hero.TYPE_INTELIGENCE, R.drawable.lina_vert));
        addHero(new Hero(42, "LION", Hero.TYPE_INTELIGENCE, R.drawable.lion_vert));
        addHero(new Hero(43, "LONE DRUID", Hero.TYPE_AGILITY, R.drawable.lone_druid_vert));
        addHero(new Hero(44, "LUNA", Hero.TYPE_AGILITY, R.drawable.luna_vert));
        addHero(new Hero(45, "LYCANTROPE", Hero.TYPE_STRENGHT, R.drawable.lycan_vert));
        addHero(new Hero(46, "MAGNUS", Hero.TYPE_STRENGHT, R.drawable.magnataur_vert));
        addHero(new Hero(47, "MEDUSA", Hero.TYPE_AGILITY, R.drawable.medusa_vert));
        addHero(new Hero(48, "MEEPO", Hero.TYPE_AGILITY, R.drawable.meepo_vert));
        addHero(new Hero(49, "MIRANA", Hero.TYPE_AGILITY, R.drawable.mirana_vert));
        addHero(new Hero(50, "MORPHLING", Hero.TYPE_AGILITY, R.drawable.morphling_vert));
        addHero(new Hero(51, "NAGA SIREN", Hero.TYPE_AGILITY, R.drawable.naga_siren_vert));
        addHero(new Hero(52, "NATURE'S PROPHET", Hero.TYPE_INTELIGENCE, R.drawable.furion_vert));
        addHero(new Hero(53, "NECROPHOS", Hero.TYPE_INTELIGENCE, R.drawable.necrolyte_vert));
        addHero(new Hero(54, "NIGHT STALKER", Hero.TYPE_STRENGHT, R.drawable.night_stalker_vert));
        addHero(new Hero(55, "NYX ASSASSIN", Hero.TYPE_AGILITY, R.drawable.nyx_assassin_vert));
        addHero(new Hero(56, "OGRE MAGI", Hero.TYPE_INTELIGENCE, R.drawable.ogre_magi_vert));
        addHero(new Hero(57, "OMNIKNIGHT", Hero.TYPE_STRENGHT, R.drawable.omniknight_vert));
        addHero(new Hero(58, "OUTWOLRD DEVOURER", Hero.TYPE_INTELIGENCE, R.drawable.obsidian_destroyer_vert));
        addHero(new Hero(59, "PHANTON ASSASSIN", Hero.TYPE_AGILITY, R.drawable.phantom_assassin_vert));
        addHero(new Hero(60, "PHANTOM LANCER ", Hero.TYPE_AGILITY, R.drawable.phantom_lancer_vert));
        addHero(new Hero(61, "PUCK", Hero.TYPE_INTELIGENCE, R.drawable.puck_vert));
        addHero(new Hero(62, "PUDGE", Hero.TYPE_STRENGHT, R.drawable.pudge_vert));
        addHero(new Hero(63, "QUEEN OF PAIN", Hero.TYPE_INTELIGENCE, R.drawable.queenofpain_vert));
        addHero(new Hero(64, "RAZOR", Hero.TYPE_AGILITY, R.drawable.razor_vert));
        addHero(new Hero(65, "RIKI", Hero.TYPE_AGILITY, R.drawable.riki_vert));
        addHero(new Hero(66, "RUBICK", Hero.TYPE_INTELIGENCE, R.drawable.rubick_vert));
        addHero(new Hero(67, "SAND KING", Hero.TYPE_STRENGHT, R.drawable.sand_king_vert));
        addHero(new Hero(68, "SHADOW DEMON", Hero.TYPE_INTELIGENCE, R.drawable.shadow_demon_vert));
        addHero(new Hero(69, "SHADOW FIEND", Hero.TYPE_AGILITY, R.drawable.nevermore_vert));
        addHero(new Hero(70, "SHADOW SHAMAN", Hero.TYPE_INTELIGENCE, R.drawable.shadow_shaman_vert));
        addHero(new Hero(71, "SILENCER", Hero.TYPE_INTELIGENCE, R.drawable.silencer_vert));
        addHero(new Hero(72, "SKYWRATH MAGE", Hero.TYPE_AGILITY, R.drawable.skywrath_mage_vert));
        addHero(new Hero(73, "SLARDAR", Hero.TYPE_STRENGHT, R.drawable.slardar_vert));
        addHero(new Hero(74, "SLARK", Hero.TYPE_AGILITY, R.drawable.slark_vert));
        addHero(new Hero(75, "SNIPER", Hero.TYPE_AGILITY, R.drawable.sniper_vert));
        addHero(new Hero(76, "SPECTRE", Hero.TYPE_AGILITY, R.drawable.spectre_vert));
        addHero(new Hero(77, "SPIRIT BREAKER", Hero.TYPE_STRENGHT, R.drawable.spirit_breaker_vert));
        addHero(new Hero(78, "STORM SPIRIT", Hero.TYPE_INTELIGENCE, R.drawable.storm_spirit_vert));
        addHero(new Hero(79, "SVEN", Hero.TYPE_STRENGHT, R.drawable.sven_vert));
        addHero(new Hero(80, "TEMPLAR ASSASSIN ", Hero.TYPE_AGILITY, R.drawable.templar_assassin_vert));
        addHero(new Hero(81, "TIDE HUNTER", Hero.TYPE_STRENGHT, R.drawable.tidehunter_vert));
        addHero(new Hero(82, "TIMBERSAW", Hero.TYPE_STRENGHT, R.drawable.shredder_vert));
        addHero(new Hero(83, "TINKER", Hero.TYPE_STRENGHT, R.drawable.tinker_vert));
        addHero(new Hero(84, "TINY", Hero.TYPE_STRENGHT, R.drawable.tiny_vert));
        addHero(new Hero(85, "TREANT PROTECTOR", Hero.TYPE_STRENGHT, R.drawable.treant_vert));
        addHero(new Hero(86, "TROLL WARLORD ", Hero.TYPE_AGILITY, R.drawable.troll_warlord_vert));
        addHero(new Hero(87, "TUSK", Hero.TYPE_STRENGHT, R.drawable.tusk_vert));
        addHero(new Hero(88, "UNDYING", Hero.TYPE_STRENGHT, R.drawable.undying_vert));
        addHero(new Hero(89, "URSA", Hero.TYPE_AGILITY, R.drawable.ursa_vert));
        addHero(new Hero(90, "VENGEFUL SPIRIT", Hero.TYPE_AGILITY, R.drawable.vengefulspirit_vert));
        addHero(new Hero(91, "VENOMANCER", Hero.TYPE_AGILITY, R.drawable.venomancer_vert));
        addHero(new Hero(92, "VIPER ", Hero.TYPE_AGILITY, R.drawable.viper_vert));
        addHero(new Hero(93, "VISAGE", Hero.TYPE_INTELIGENCE, R.drawable.visage_vert));
        addHero(new Hero(94, "WARLOCK", Hero.TYPE_INTELIGENCE, R.drawable.warlock_vert));
        addHero(new Hero(95, "WEAVER", Hero.TYPE_AGILITY, R.drawable.weaver_vert));
        addHero(new Hero(96, "WINDRANGER", Hero.TYPE_INTELIGENCE, R.drawable.windrunner_vert));
        addHero(new Hero(97, "WITCH DOCTOR", Hero.TYPE_INTELIGENCE, R.drawable.witch_doctor_vert));
        addHero(new Hero(98, "WRATH KING", Hero.TYPE_STRENGHT, R.drawable.skeleton_king_vert));
        addHero(new Hero(99, "ZEUS", Hero.TYPE_INTELIGENCE, R.drawable.zuus_vert));
        addHero(new Hero(100, "EARTH SPIRIT", Hero.TYPE_STRENGHT, R.drawable.earth_spirit_vert));
        addHero(new Hero(101, "EMBER SPIRIT", Hero.TYPE_STRENGHT, R.drawable.ember_spirit_vert));
        addHero(new Hero(102, "TERRORBLADE", Hero.TYPE_AGILITY, R.drawable.terrorblade_vert));
        addHero(new Hero(103, "PHOENIX", Hero.TYPE_STRENGHT, R.drawable.phoenix_vert));
        addHero(new Hero(104, "LEGION COMMANDER", Hero.TYPE_STRENGHT, R.drawable.legion_commander_vert));
        addHero(new Hero(105, "BROODMOTHER", Hero.TYPE_AGILITY, R.drawable.broodmother_vert));
        endTransaction();
    }

    // ID heroi, id counter, id melhor suporte
    @Override
    public void insertCounter() {
        beginTransaction();
        //ABADON
        addCounter(0, 3, 88, 1);
        addCounter(0, 47, 36, 2);
        addCounter(0, 22, 7, 3);
        addCounter(0, 53, 53, 4);
        addCounter(0, 26, 26, 5);

        //ALCHEMIST
        addCounter(1, 65, 39, 1);
        addCounter(1, 92, 90, 2);
        addCounter(1, 59, 2, 3);
        addCounter(1, 51, 57, 4);
        addCounter(1, 13, 17, 5);

        //ANCIENT
        addCounter(2, 3, 93, 1);
        addCounter(2, 105, 96, 2);
        addCounter(2, 52, 87, 3);
        addCounter(2, 10, 12, 4);
        addCounter(2, 102, 72, 5);

        //ANTI MAGE
        addCounter(3, 65, 79, 1);
        addCounter(3, 73, 17, 2);
        addCounter(3, 8, 68, 3);
        addCounter(3, 24, 70, 4);
        addCounter(3, 79, 4, 5);

        //AXE
        addCounter(4, 71, 91, 1);
        addCounter(4, 44, 99, 2);
        addCounter(4, 64, 71, 3);
        addCounter(4, 30, 39, 4);
        addCounter(4, 92, 16, 5);

        //BANE
        addCounter(5, 105, 93, 1);
        addCounter(5, 44, 81, 2);
        addCounter(5, 46, 67, 3);
        addCounter(5, 102, 26, 4);
        addCounter(5, 23, 41, 5);

        //BATRIDER
        addCounter(6, 0, 57, 1);
        addCounter(6, 92, 0, 2);
        addCounter(6, 53, 53, 3);
        addCounter(6, 35, 91, 4);
        addCounter(6, 54, 7, 5);

        //BEAST MASTER
        addCounter(7, 47, 4, 1);
        addCounter(7, 51, 53, 2);
        addCounter(7, 13, 12, 3);
        addCounter(7, 4, 67, 4);
        addCounter(7, 53, 81, 5);

        //BLOODSEEKER
        addCounter(8, 102, 53, 1);
        addCounter(8, 53, 33, 2);
        addCounter(8, 47, 16, 3);
        addCounter(8, 10, 7, 4);
        addCounter(8, 44, 34, 5);

        //BOUNTY HUNTER
        addCounter(9, 0, 0, 1);
        addCounter(9, 104, 57, 2);
        addCounter(9, 74, 81, 3);
        addCounter(9, 84, 7, 4);
        addCounter(9, 86, 33, 5);
        addSergio();

        endTransaction();
    }

    private void addSergio() {
        //WARLOCK
        addCounter(94, 101, 66, 1);
        addCounter(94, 45, 39, 2);
        addCounter(94, 95, 36, 3);
        addCounter(94, 52, 27, 4);
        addCounter(94, 20, 33, 5);

        //WEAVER
        addCounter(95, 8, 99, 1);
        addCounter(95, 65, 53, 2);
        addCounter(95, 53, 5, 3);
        addCounter(95, 9, 55, 4);
        addCounter(95, 73, 72, 5);

        //WINDRANGER
        addCounter(96, 64, 56, 1);
        addCounter(96, 50, 16, 2);
        addCounter(96, 51, 85, 3);
        addCounter(96, 98, 36, 4);
        addCounter(96, 46, 81, 5);

        //WITCH DOCTOR
        addCounter(97, 105, 71, 1);
        addCounter(97, 52, 93, 2);
        addCounter(97, 65, 36, 3);
        addCounter(97, 95, 72, 4);
        addCounter(97, 15, 61, 5);

        //WRATH KING
        addCounter(98, 60, 88, 1);
        addCounter(98, 48, 57, 2);
        addCounter(98, 3, 19, 3);
        addCounter(98, 32, 34, 4);
        addCounter(98, 102, 18, 5);

        //ZEUS
        addCounter(99, 31, 14, 1);
        addCounter(99, 48, 93, 2);
        addCounter(99, 98, 85, 3);
        addCounter(99, 40, 103, 4);
        addCounter(99, 35, 33, 5);

        //EARTH SPIRIT
        addCounter(100, 31, 53, 1);
        addCounter(100, 53, 94, 2);
        addCounter(100, 36, 7, 3);
        addCounter(100, 89, 36, 4);
        addCounter(100, 8, 0, 5);

        //EMBER SPIRIT
        addCounter(101, 31, 21, 1);
        addCounter(101, 35, 57, 2);
        addCounter(101, 40, 91, 3);
        addCounter(101, 15, 103, 4);
        addCounter(101, 29, 71, 5);

        //TERRORBLADE
        addCounter(102, 48, 67, 1);
        addCounter(102, 47, 18, 2);
        addCounter(102, 105, 82, 3);
        addCounter(102, 104, 38, 4);
        addCounter(102, 46, 41, 5);

        //PHOENIX
        addCounter(103, 71, 71, 1);
        addCounter(103, 86, 27, 2);
        addCounter(103, 48, 57, 3);
        addCounter(103, 31, 33, 4);
        addCounter(103, 8, 96, 5);

        //LEGION COMMANDER
        addCounter(104, 23, 19, 1);
        addCounter(104, 86, 90, 2);
        addCounter(104, 80, 57, 3);
        addCounter(104, 79, 79, 4);
        addCounter(104, 47, 39, 5);

        //BROODMOTHER
        addCounter(105, 4, 19, 1);
        addCounter(105, 48, 82, 2);
        addCounter(105, 51, 25, 3);
        addCounter(105, 73, 67, 4);
        addCounter(105, 104, 18, 5);
    }

    private static final String TABLE_HERO = "hero";

    private static final String COLUMN_HERO_ID = "id";
    private static final String COLUMN_HERO_NAME = "name";
    private static final String COLUMN_HERO_TYPE = "type";

    private static final String CREATE_TABLE_HERO = "CREATE TABLE " + TABLE_HERO + "("
            + COLUMN_HERO_ID + " LONG PRIMARY KEY, "
            + COLUMN_HERO_NAME + " TEXT NOT NULL, "
            + COLUMN_HERO_TYPE + " INTEGER NOT NULL );";

    private static final String TABLE_HERO_COUNTER = "hero_counter";

    private static final String COLUMN_HERO_COUNTER_ID = "id_counter";
    private static final String COLUMN_HERO_COUNTER_POSITION = "position";
    private static final String COLUMN_HERO_COUNTER_SUPPORT_ID = "id_counter_support";

    private static final String CREATE_TABLE_HERO_COUNTER = "CREATE TABLE " + TABLE_HERO_COUNTER + "("
            + COLUMN_HERO_ID + " LONG NOT NULL, "
            + COLUMN_HERO_COUNTER_ID + " LONG NOT NULL,"
            + COLUMN_HERO_COUNTER_SUPPORT_ID + " LONG NOT NULL,"
            + COLUMN_HERO_COUNTER_POSITION + " LONG NOT NULL"
            + ");";

    private static final String STATEMENT_HERO = "INSERT INTO " + TABLE_HERO + " VALUES (?, ?, ?)";
    private static final String STATEMENT_HERO_COUNTER = "INSERT INTO " + TABLE_HERO_COUNTER + " VALUES (?, ?, ?, ?)";

    public static final String QUERY_GET_ALL_AGI = "SELECT * FROM " + TABLE_HERO + " WHERE "+ COLUMN_HERO_TYPE + " = " + Hero.TYPE_AGILITY;
    public static final String QUERY_GET_ALL_STR = "SELECT * FROM " + TABLE_HERO + " WHERE "+ COLUMN_HERO_TYPE + " = " + Hero.TYPE_STRENGHT;
    public static final String QUERY_GET_ALL_INT = "SELECT * FROM " + TABLE_HERO + " WHERE "+ COLUMN_HERO_TYPE + " = " + Hero.TYPE_INTELIGENCE;

}
