package com.jd.d2counter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jd.d2counter.R;
import com.jd.d2counter.objects.Hero;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    private static DatabaseHelper instance;
    private static final int DATABASE_VERSION = 3;
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
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_HERO + " (id long primary key, name TEXT NOT NULL, type int not null, image int not null, status int not null)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_HERO_COUNTER + " (id_hero long NOT NULL, id_counter LONG NOT NULL, id_support LONG NOT NULL, position INT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HERO_COUNTER);
        this.onCreate(sqLiteDatabase);
    }

    public void open() {
        if (database == null) {
            database = getWritableDatabase();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    deleteHeros();
                    deleteCounters();
                    insertHero();
                    insertCounter();
                }
            }).start();
        }
    }

    private void deleteHeros() {
        String sql = "DELETE FROM " + TABLE_HERO;
        database.execSQL(sql);
    }

    private void deleteCounters() {
        String sql = "DELETE FROM " + TABLE_HERO_COUNTER;
        database.execSQL(sql);
    }

    private void addHero(long id, String name, int type, int image, int status) {
        String sql = "INSERT OR REPLACE INTO " + TABLE_HERO + " (id,name,type,image,status) VALUES('" + id + "','" + name + "','" + type + "','" + image + "','" + status + "')";
        database.execSQL(sql);
    }

    private void addCounter(long id, long idCounter, long idSupport, int position) {
        String sql = "INSERT OR REPLACE INTO " + TABLE_HERO_COUNTER + "  (id_hero, id_counter, id_support, position) VALUES('" + id + "','" + idCounter + "','" + idSupport + "','" + position + "')";
        database.execSQL(sql);
    }

    public void updateHeroStatus(long idHero, int status) {
        String strFilter = "id = " + idHero;
        ContentValues args = new ContentValues();
        args.put("status", status);
        database.update(TABLE_HERO, args, strFilter, null);
    }

    public Hero getHero(long idHero) {
        Hero hero = null;
        String selectQuery = "SELECT * FROM " + TABLE_HERO + " WHERE id = ?";
        Cursor cursor = database.rawQuery(selectQuery, new String[]{String.valueOf(idHero)});

        if (cursor.moveToFirst()) {
            hero = new Hero(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
        }

        cursor.close();
        return hero;
    }

    public List<Hero> getHeroList(int type) {
        String table[] = {"id", "name", "type", "image", "status"};
        Cursor cursor = database.query(TABLE_HERO, table, "type = " + type, null, null, null, null);
        System.out.println(cursor.getCount());
        List<Hero> list = new ArrayList<Hero>();

        if (cursor.moveToFirst()) {
            do {
                Hero hero = new Hero(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
                list.add(hero);
            } while (cursor.moveToNext());
        }

        return list;
    }

    public List<Hero> getSuggestedPickList(final long idHero) {
        List<Hero> list = new ArrayList<Hero>();

        String table[] = {"id_hero", "id_counter", "id_support", "position"};
        //TODO duplicanddo dados sempre que roda o app de novo
        Cursor cursor = database.query(TABLE_HERO_COUNTER, table, "id_hero = " + idHero, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                list.add(getHero(cursor.getLong(1)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return list;
    }


    public void insertHero() {
        addHero(0, "ABADDON", Hero.TYPE_STRENGHT, R.drawable.abaddon_vert, Hero.STATUS_NOTHING);
        addHero(1, "ALCHEMIST", Hero.TYPE_STRENGHT, R.drawable.alchemist_vert, Hero.STATUS_NOTHING);
        addHero(2, "ANCIENT APPARITION", Hero.TYPE_INTELIGENCE, R.drawable.ancient_apparition_vert, Hero.STATUS_NOTHING);
        addHero(3, "ANTI MAGE", Hero.TYPE_AGILITY, R.drawable.antimage_vert, Hero.STATUS_NOTHING);
        addHero(4, "AXE", Hero.TYPE_STRENGHT, R.drawable.axe_vert, Hero.STATUS_NOTHING);
        addHero(5, "BANE", Hero.TYPE_INTELIGENCE, R.drawable.bane_vert, Hero.STATUS_NOTHING);
        addHero(6, "BATRIDER", Hero.TYPE_INTELIGENCE, R.drawable.batrider_vert, Hero.STATUS_NOTHING);
        addHero(7, "BEAST MASTER", Hero.TYPE_STRENGHT, R.drawable.beastmaster_vert, Hero.STATUS_NOTHING);
        addHero(8, "BLOODSEEKER", Hero.TYPE_AGILITY, R.drawable.bloodseeker_vert, Hero.STATUS_NOTHING);
        addHero(9, "BOUNTY HUNTER", Hero.TYPE_AGILITY, R.drawable.bounty_hunter_vert, Hero.STATUS_NOTHING);
        addHero(10, "BREWMASTER", Hero.TYPE_STRENGHT, R.drawable.brewmaster_vert, Hero.STATUS_NOTHING);
        addHero(11, "BRISTLEBACK", Hero.TYPE_STRENGHT, R.drawable.bristleback_vert, Hero.STATUS_NOTHING);
        addHero(12, "CENTAUR WARRUNNER", Hero.TYPE_STRENGHT, R.drawable.centaur_vert, Hero.STATUS_NOTHING);
        addHero(13, "CHAOS KNIGHT", Hero.TYPE_STRENGHT, R.drawable.chaos_knight_vert, Hero.STATUS_NOTHING);
        addHero(14, "CHEN", Hero.TYPE_INTELIGENCE, R.drawable.chen_vert, Hero.STATUS_NOTHING);
        addHero(15, "CLINCKZ", Hero.TYPE_AGILITY, R.drawable.clinkz_vert, Hero.STATUS_NOTHING);
        addHero(16, "CLOCKWERK", Hero.TYPE_STRENGHT, R.drawable.rattletrap_vert, Hero.STATUS_NOTHING);
        addHero(17, "CRYSTAL MAIDEN", Hero.TYPE_INTELIGENCE, R.drawable.crystal_maiden_vert, Hero.STATUS_NOTHING);
        addHero(18, "DARK SEER", Hero.TYPE_INTELIGENCE, R.drawable.dark_seer_vert, Hero.STATUS_NOTHING);
        addHero(19, "DAZZLE", Hero.TYPE_INTELIGENCE, R.drawable.dazzle_vert, Hero.STATUS_NOTHING);
        addHero(20, "DEATH PROPHET", Hero.TYPE_INTELIGENCE, R.drawable.death_prophet_vert, Hero.STATUS_NOTHING);
        addHero(21, "DISRUPTOR", Hero.TYPE_INTELIGENCE, R.drawable.disruptor_vert, Hero.STATUS_NOTHING);
        addHero(22, "DOOM BRINGER", Hero.TYPE_STRENGHT, R.drawable.doom_bringer_vert, Hero.STATUS_NOTHING);
        addHero(23, "DRAGON KNIGHT", Hero.TYPE_STRENGHT, R.drawable.dragon_knight_vert, Hero.STATUS_NOTHING);
        addHero(24, "DROW RANGER", Hero.TYPE_AGILITY, R.drawable.drow_ranger_vert, Hero.STATUS_NOTHING);
        addHero(25, "EARTHSHAKER", Hero.TYPE_STRENGHT, R.drawable.earth_spirit_vert, Hero.STATUS_NOTHING);
        addHero(26, "ELDER TITAN", Hero.TYPE_STRENGHT, R.drawable.elder_titan_vert, Hero.STATUS_NOTHING);
        addHero(27, "ENCHANTRESS", Hero.TYPE_INTELIGENCE, R.drawable.enchantress_vert, Hero.STATUS_NOTHING);
        addHero(28, "ENIGMA", Hero.TYPE_INTELIGENCE, R.drawable.enigma_vert, Hero.STATUS_NOTHING);
        addHero(29, "FACELESS VOID", Hero.TYPE_AGILITY, R.drawable.faceless_void_vert, Hero.STATUS_NOTHING);
        addHero(30, "GYROCOPTER", Hero.TYPE_AGILITY, R.drawable.gyrocopter_vert, Hero.STATUS_NOTHING);
        addHero(31, "HUSKAR", Hero.TYPE_STRENGHT, R.drawable.huskar_vert, Hero.STATUS_NOTHING);
        addHero(32, "INVOKER", Hero.TYPE_INTELIGENCE, R.drawable.invoker_vert, Hero.STATUS_NOTHING);
        addHero(33, "IO", Hero.TYPE_STRENGHT, R.drawable.wisp_vert, Hero.STATUS_NOTHING);
        addHero(34, "JAKIRO", Hero.TYPE_INTELIGENCE, R.drawable.jakiro_vert, Hero.STATUS_NOTHING);
        addHero(35, "JUGGERNAUT", Hero.TYPE_AGILITY, R.drawable.juggernaut_vert, Hero.STATUS_NOTHING);
        addHero(36, "KEEPER OF THE LIGHT", Hero.TYPE_INTELIGENCE, R.drawable.keeper_of_the_light_vert, Hero.STATUS_NOTHING);
        addHero(37, "KUNKKA", Hero.TYPE_STRENGHT, R.drawable.kunkka_vert, Hero.STATUS_NOTHING);
        addHero(38, "LESHRAK", Hero.TYPE_INTELIGENCE, R.drawable.leshrac_vert, Hero.STATUS_NOTHING);
        addHero(39, "LICH", Hero.TYPE_INTELIGENCE, R.drawable.lich_vert, Hero.STATUS_NOTHING);
        addHero(40, "LIFESTEALER", Hero.TYPE_STRENGHT, R.drawable.life_stealer_vert, Hero.STATUS_NOTHING);
        addHero(41, "LINA", Hero.TYPE_INTELIGENCE, R.drawable.lina_vert, Hero.STATUS_NOTHING);
        addHero(42, "LION", Hero.TYPE_INTELIGENCE, R.drawable.lion_vert, Hero.STATUS_NOTHING);
        addHero(43, "LONE DRUID", Hero.TYPE_AGILITY, R.drawable.lone_druid_vert, Hero.STATUS_NOTHING);
        addHero(44, "LUNA", Hero.TYPE_AGILITY, R.drawable.luna_vert, Hero.STATUS_NOTHING);
        addHero(45, "LYCANTROPE", Hero.TYPE_STRENGHT, R.drawable.lycan_vert, Hero.STATUS_NOTHING);
        addHero(46, "MAGNUS", Hero.TYPE_STRENGHT, R.drawable.magnataur_vert, Hero.STATUS_NOTHING);
        addHero(47, "MEDUSA", Hero.TYPE_AGILITY, R.drawable.medusa_vert, Hero.STATUS_NOTHING);
        addHero(48, "MEEPO", Hero.TYPE_AGILITY, R.drawable.meepo_vert, Hero.STATUS_NOTHING);
        addHero(49, "MIRANA", Hero.TYPE_AGILITY, R.drawable.mirana_vert, Hero.STATUS_NOTHING);
        addHero(50, "MORPHLING", Hero.TYPE_AGILITY, R.drawable.morphling_vert, Hero.STATUS_NOTHING);
        addHero(51, "NAGA SIREN", Hero.TYPE_AGILITY, R.drawable.naga_siren_vert, Hero.STATUS_NOTHING);
        addHero(52, "NATURES PROPHET", Hero.TYPE_INTELIGENCE, R.drawable.furion_vert, Hero.STATUS_NOTHING);
        addHero(53, "NECROPHOS", Hero.TYPE_INTELIGENCE, R.drawable.necrolyte_vert, Hero.STATUS_NOTHING);
        addHero(54, "NIGHT STALKER", Hero.TYPE_STRENGHT, R.drawable.night_stalker_vert, Hero.STATUS_NOTHING);
        addHero(55, "NYX ASSASSIN", Hero.TYPE_AGILITY, R.drawable.nyx_assassin_vert, Hero.STATUS_NOTHING);
        addHero(56, "OGRE MAGI", Hero.TYPE_INTELIGENCE, R.drawable.ogre_magi_vert, Hero.STATUS_NOTHING);
        addHero(57, "OMNIKNIGHT", Hero.TYPE_STRENGHT, R.drawable.omniknight_vert, Hero.STATUS_NOTHING);
        addHero(58, "OUTWOLRD DEVOURER", Hero.TYPE_INTELIGENCE, R.drawable.obsidian_destroyer_vert, Hero.STATUS_NOTHING);
        addHero(59, "PHANTON ASSASSIN", Hero.TYPE_AGILITY, R.drawable.phantom_assassin_vert, Hero.STATUS_NOTHING);
        addHero(60, "PHANTOM LANCER ", Hero.TYPE_AGILITY, R.drawable.phantom_lancer_vert, Hero.STATUS_NOTHING);
        addHero(61, "PUCK", Hero.TYPE_INTELIGENCE, R.drawable.puck_vert, Hero.STATUS_NOTHING);
        addHero(62, "PUDGE", Hero.TYPE_STRENGHT, R.drawable.pudge_vert, Hero.STATUS_NOTHING);
        addHero(63, "QUEEN OF PAIN", Hero.TYPE_INTELIGENCE, R.drawable.queenofpain_vert, Hero.STATUS_NOTHING);
        addHero(64, "RAZOR", Hero.TYPE_AGILITY, R.drawable.razor_vert, Hero.STATUS_NOTHING);
        addHero(65, "RIKI", Hero.TYPE_AGILITY, R.drawable.riki_vert, Hero.STATUS_NOTHING);
        addHero(66, "RUBICK", Hero.TYPE_INTELIGENCE, R.drawable.rubick_vert, Hero.STATUS_NOTHING);
        addHero(67, "SAND KING", Hero.TYPE_STRENGHT, R.drawable.sand_king_vert, Hero.STATUS_NOTHING);
        addHero(68, "SHADOW DEMON", Hero.TYPE_INTELIGENCE, R.drawable.shadow_demon_vert, Hero.STATUS_NOTHING);
        addHero(69, "SHADOW FIEND", Hero.TYPE_AGILITY, R.drawable.nevermore_vert, Hero.STATUS_NOTHING);
        addHero(70, "SHADOW SHAMAN", Hero.TYPE_INTELIGENCE, R.drawable.shadow_shaman_vert, Hero.STATUS_NOTHING);
        addHero(71, "SILENCER", Hero.TYPE_INTELIGENCE, R.drawable.silencer_vert, Hero.STATUS_NOTHING);
        addHero(72, "SKYWRATH MAGE", Hero.TYPE_AGILITY, R.drawable.skywrath_mage_vert, Hero.STATUS_NOTHING);
        addHero(73, "SLARDAR", Hero.TYPE_STRENGHT, R.drawable.slardar_vert, Hero.STATUS_NOTHING);
        addHero(74, "SLARK", Hero.TYPE_AGILITY, R.drawable.slark_vert, Hero.STATUS_NOTHING);
        addHero(75, "SNIPER", Hero.TYPE_AGILITY, R.drawable.sniper_vert, Hero.STATUS_NOTHING);
        addHero(76, "SPECTRE", Hero.TYPE_AGILITY, R.drawable.spectre_vert, Hero.STATUS_NOTHING);
        addHero(77, "SPIRIT BREAKER", Hero.TYPE_STRENGHT, R.drawable.spirit_breaker_vert, Hero.STATUS_NOTHING);
        addHero(78, "STORM SPIRIT", Hero.TYPE_INTELIGENCE, R.drawable.storm_spirit_vert, Hero.STATUS_NOTHING);
        addHero(79, "SVEN", Hero.TYPE_STRENGHT, R.drawable.sven_vert, Hero.STATUS_NOTHING);
        addHero(80, "TEMPLAR ASSASSIN ", Hero.TYPE_AGILITY, R.drawable.templar_assassin_vert, Hero.STATUS_NOTHING);
        addHero(81, "TIDE HUNTER", Hero.TYPE_STRENGHT, R.drawable.tidehunter_vert, Hero.STATUS_NOTHING);
        addHero(82, "TIMBERSAW", Hero.TYPE_STRENGHT, R.drawable.shredder_vert, Hero.STATUS_NOTHING);
        addHero(83, "TINKER", Hero.TYPE_STRENGHT, R.drawable.tinker_vert, Hero.STATUS_NOTHING);
        addHero(84, "TINY", Hero.TYPE_STRENGHT, R.drawable.tiny_vert, Hero.STATUS_NOTHING);
        addHero(85, "TREANT PROTECTOR", Hero.TYPE_STRENGHT, R.drawable.treant_vert, Hero.STATUS_NOTHING);
        addHero(86, "TROLL WARLORD ", Hero.TYPE_AGILITY, R.drawable.troll_warlord_vert, Hero.STATUS_NOTHING);
        addHero(87, "TUSK", Hero.TYPE_STRENGHT, R.drawable.tusk_vert, Hero.STATUS_NOTHING);
        addHero(88, "UNDYING", Hero.TYPE_STRENGHT, R.drawable.undying_vert, Hero.STATUS_NOTHING);
        addHero(89, "URSA", Hero.TYPE_AGILITY, R.drawable.ursa_vert, Hero.STATUS_NOTHING);
        addHero(90, "VENGEFUL SPIRIT", Hero.TYPE_AGILITY, R.drawable.vengefulspirit_vert, Hero.STATUS_NOTHING);
        addHero(91, "VENOMANCER", Hero.TYPE_AGILITY, R.drawable.venomancer_vert, Hero.STATUS_NOTHING);
        addHero(92, "VIPER ", Hero.TYPE_AGILITY, R.drawable.viper_vert, Hero.STATUS_NOTHING);
        addHero(93, "VISAGE", Hero.TYPE_INTELIGENCE, R.drawable.visage_vert, Hero.STATUS_NOTHING);
        addHero(94, "WARLOCK", Hero.TYPE_INTELIGENCE, R.drawable.warlock_vert, Hero.STATUS_NOTHING);
        addHero(95, "WEAVER", Hero.TYPE_AGILITY, R.drawable.weaver_vert, Hero.STATUS_NOTHING);
        addHero(96, "WINDRANGER", Hero.TYPE_INTELIGENCE, R.drawable.windrunner_vert, Hero.STATUS_NOTHING);
        addHero(97, "WITCH DOCTOR", Hero.TYPE_INTELIGENCE, R.drawable.witch_doctor_vert, Hero.STATUS_NOTHING);
        addHero(98, "WRATH KING", Hero.TYPE_STRENGHT, R.drawable.skeleton_king_vert, Hero.STATUS_NOTHING);
        addHero(99, "ZEUS", Hero.TYPE_INTELIGENCE, R.drawable.zuus_vert, Hero.STATUS_NOTHING);
        addHero(100, "EARTH SPIRIT", Hero.TYPE_STRENGHT, R.drawable.earth_spirit_vert, Hero.STATUS_NOTHING);
        addHero(101, "EMBER SPIRIT", Hero.TYPE_STRENGHT, R.drawable.ember_spirit_vert, Hero.STATUS_NOTHING);
        addHero(102, "TERRORBLADE", Hero.TYPE_AGILITY, R.drawable.terrorblade_vert, Hero.STATUS_NOTHING);
        addHero(103, "PHOENIX", Hero.TYPE_STRENGHT, R.drawable.phoenix_vert, Hero.STATUS_NOTHING);
        addHero(104, "LEGION COMMANDER", Hero.TYPE_STRENGHT, R.drawable.legion_commander_vert, Hero.STATUS_NOTHING);
        addHero(105, "BROODMOTHER", Hero.TYPE_AGILITY, R.drawable.broodmother_vert, Hero.STATUS_NOTHING);
        System.out.println("Herois inseridos!");
    }

    public void insertCounter() {
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
        System.out.println("Counters inseridos com sucesso!");

    }

    private static String TABLE_HERO = "hero";
    private static String TABLE_HERO_COUNTER = "counter";

}
