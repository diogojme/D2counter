package com.jd.d2counter.database;


import android.content.Context;

import com.jd.d2counter.objects.Hero;

public class DatabaseManager implements Database{

    private DatabaseHelper database;

    public DatabaseManager(Context context) {
        this.database = DatabaseHelper.with(context);
        this.database.open();
    }

    @Override
    public void insertHero() {
        database.beginTransaction();
        database.addHero(new Hero(0, "ABADDON", TYPE_STRENGHT));
        database.addHero(new Hero(1, "ALCHEMIST", TYPE_STRENGHT));
        database.addHero(new Hero(2, "ANCIENT APPARITION", TYPE_INTELIGENCE));
        database.addHero(new Hero(3, "ANTI MAGE", TYPE_AGILITY));
        database.addHero(new Hero(4, "AXE", TYPE_STRENGHT));
        database.addHero(new Hero(5, "BANE", TYPE_INTELIGENCE));
        database.addHero(new Hero(6, "BATRIDER", TYPE_INTELIGENCE));
        database.addHero(new Hero(7, "BEAST MASTER", TYPE_STRENGHT));
        database.addHero(new Hero(8, "BLOODSEEKER", TYPE_AGILITY));
        database.addHero(new Hero(9, "BOUNTY HUNTER", TYPE_AGILITY));
        database.addHero(new Hero(10, "BREWMASTER", TYPE_STRENGHT));
        database.addHero(new Hero(11, "BRISTLEBACK", TYPE_STRENGHT));
        database.addHero(new Hero(12, "CENTAUR WARRUNNER", TYPE_STRENGHT));
        database.addHero(new Hero(13, "CHAOS KNIGHT", TYPE_STRENGHT));
        database.addHero(new Hero(14, "CHEN", TYPE_INTELIGENCE));
        database.addHero(new Hero(15, "CLINCKZ", TYPE_AGILITY));
        database.addHero(new Hero(16, "CLOCKWERK", TYPE_STRENGHT));
        database.addHero(new Hero(17, "CRYSTAL MAIDEN", TYPE_INTELIGENCE));
        database.addHero(new Hero(18, "DARK SEER", TYPE_INTELIGENCE));
        database.addHero(new Hero(19, "DAZZLE", TYPE_INTELIGENCE));
        database.addHero(new Hero(20, "DEATH PROPHET", TYPE_INTELIGENCE));
        database.addHero(new Hero(21, "DISRUPTOR", TYPE_INTELIGENCE));
        database.addHero(new Hero(22, "DOOM BRINGER", TYPE_STRENGHT));
        database.addHero(new Hero(23, "DRAGON KNIGHT", TYPE_STRENGHT));
        database.addHero(new Hero(24, "DROW RANGER", TYPE_AGILITY));
        database.addHero(new Hero(25, "EARTHSHAKER", TYPE_STRENGHT));
        database.addHero(new Hero(26, "ELDER TITAN", TYPE_STRENGHT));
        database.addHero(new Hero(27, "ENCHANTRESS", TYPE_INTELIGENCE));
        database.addHero(new Hero(28, "ENIGMA", TYPE_INTELIGENCE));
        database.addHero(new Hero(29, "FACELESS VOID", TYPE_AGILITY));
        database.addHero(new Hero(30, "GYROCOPTER", TYPE_AGILITY));
        database.addHero(new Hero(31, "HUSKAR", TYPE_STRENGHT));
        database.addHero(new Hero(32, "INVOKER", TYPE_INTELIGENCE));
        database.addHero(new Hero(33, "IO", TYPE_STRENGHT));
        database.addHero(new Hero(34, "JAKIRO", TYPE_INTELIGENCE));
        database.addHero(new Hero(35, "JUGGERNAUT", TYPE_AGILITY));
        database.addHero(new Hero(36, "KEEPER OF THE LIGHT", TYPE_INTELIGENCE));
        database.addHero(new Hero(37, "KUNKKA", TYPE_STRENGHT));
        database.addHero(new Hero(38, "LESHRAK", TYPE_INTELIGENCE));
        database.addHero(new Hero(39, "LICH", TYPE_INTELIGENCE));
        database.addHero(new Hero(40, "LIFESTEALER", TYPE_STRENGHT));
        database.addHero(new Hero(41, "LINA", TYPE_INTELIGENCE));
        database.addHero(new Hero(42, "LION", TYPE_INTELIGENCE));
        database.addHero(new Hero(43, "LONE DRUID", TYPE_AGILITY));
        database.addHero(new Hero(44, "LUNA", TYPE_AGILITY));
        database.addHero(new Hero(45, "LYCANTROPE", TYPE_STRENGHT));
        database.addHero(new Hero(46, "MAGNUS", TYPE_STRENGHT));
        database.addHero(new Hero(47, "MEDUSA", TYPE_AGILITY));
        database.addHero(new Hero(48, "MEEPO", TYPE_AGILITY));
        database.addHero(new Hero(49, "MIRANA", TYPE_AGILITY));
        database.addHero(new Hero(50, "MORPHLING", TYPE_AGILITY));
        database.addHero(new Hero(51, "NAGA SIREN", TYPE_AGILITY));
        database.addHero(new Hero(52, "NATURE'S PROPHET", TYPE_INTELIGENCE));
        database.addHero(new Hero(53, "NECROPHOS", TYPE_INTELIGENCE));
        database.addHero(new Hero(54, "NIGHT STALKER", TYPE_STRENGHT));
        database.addHero(new Hero(55, "NYX ASSASSIN", TYPE_AGILITY));
        database.addHero(new Hero(56, "OGRE MAGI", TYPE_INTELIGENCE));
        database.addHero(new Hero(57, "OMNIKNIGHT", TYPE_STRENGHT));
        database.addHero(new Hero(58, "OUTWOLRD DEVOURER", TYPE_INTELIGENCE));
        database.addHero(new Hero(59, "PHANTON ASSASSIN", TYPE_AGILITY));
        database.addHero(new Hero(60, "PHANTOM LANCER ", TYPE_AGILITY));
        database.addHero(new Hero(61, "PUCK", TYPE_INTELIGENCE));
        database.addHero(new Hero(62, "PUDGE", TYPE_STRENGHT));
        database.addHero(new Hero(63, "QUEEN OF PAIN", TYPE_INTELIGENCE));
        database.addHero(new Hero(64, "RAZOR", TYPE_AGILITY));
        database.addHero(new Hero(65, "RIKI", TYPE_AGILITY));
        database.addHero(new Hero(66, "RUBICK", TYPE_INTELIGENCE));
        database.addHero(new Hero(67, "SAND KING", TYPE_STRENGHT));
        database.addHero(new Hero(68, "SHADOW DEMON", TYPE_INTELIGENCE));
        database.addHero(new Hero(69, "SHADOW FIEND", TYPE_AGILITY));
        database.addHero(new Hero(70, "SHADOW SHAMAN", TYPE_INTELIGENCE));
        database.addHero(new Hero(71, "SILENCER", TYPE_INTELIGENCE));
        database.addHero(new Hero(72, "SKYWRATH MAGE", TYPE_AGILITY));
        database.addHero(new Hero(73, "SLARDAR", TYPE_STRENGHT));
        database.addHero(new Hero(74, "SLARK", TYPE_AGILITY));
        database.addHero(new Hero(75, "SNIPER", TYPE_AGILITY));
        database.addHero(new Hero(76, "SPECTRE", TYPE_AGILITY));
        database.addHero(new Hero(77, "SPIRIT BREAKER", TYPE_STRENGHT));
        database.addHero(new Hero(78, "STORM SPIRIT", TYPE_INTELIGENCE));
        database.addHero(new Hero(79, "SVEN", TYPE_STRENGHT));
        database.addHero(new Hero(80, "TEMPLAR ASSASSIN ", TYPE_AGILITY));
        database.addHero(new Hero(81, "TIDE HUNTER", TYPE_STRENGHT));
        database.addHero(new Hero(82, "TIMBERSAW", TYPE_STRENGHT));
        database.addHero(new Hero(83, "TINKER", TYPE_STRENGHT));
        database.addHero(new Hero(84, "TINY", TYPE_STRENGHT));
        database.addHero(new Hero(85, "TREANT PROTECTOR", TYPE_STRENGHT));
        database.addHero(new Hero(86, "TROLL WARLORD ", TYPE_AGILITY));
        database.addHero(new Hero(87, "TUSK", TYPE_STRENGHT));
        database.addHero(new Hero(88, "UNDYING", TYPE_STRENGHT));
        database.addHero(new Hero(89, "URSA", TYPE_AGILITY));
        database.addHero(new Hero(90, "VENGEFUL SPIRIT", TYPE_AGILITY));
        database.addHero(new Hero(91, "VENOMANCER", TYPE_AGILITY));
        database.addHero(new Hero(92, "VIPER ", TYPE_AGILITY));
        database.addHero(new Hero(93, "VISAGE", TYPE_INTELIGENCE));
        database.addHero(new Hero(94, "WARLOCK", TYPE_INTELIGENCE));
        database.addHero(new Hero(95, "WEAVER", TYPE_AGILITY));
        database.addHero(new Hero(96, "WINDRANGER", TYPE_INTELIGENCE));
        database.addHero(new Hero(97, "WITCH DOCTOR", TYPE_INTELIGENCE));
        database.addHero(new Hero(98, "WRATH KING", TYPE_STRENGHT));
        database.addHero(new Hero(99, "ZEUS", TYPE_INTELIGENCE));
        database.addHero(new Hero(100, "EARTH SPIRIT", TYPE_STRENGHT));
        database.addHero(new Hero(101, "EMBER SPIRIT", TYPE_STRENGHT));
        database.addHero(new Hero(102, "TERRORBLADE", TYPE_AGILITY));
        database.addHero(new Hero(103, "PHOENIX", TYPE_STRENGHT));
        database.addHero(new Hero(104, "LEGION COMMANDER", TYPE_STRENGHT));
        database.endTransaction();
    }

    // ID heroi, id counter, id melhor suporte
    @Override
    public void insertCounter() {
        //ABADON
        database.addCounter(0,22,0);
        database.addCounter(0,105,0);
        database.addCounter(0,45,0);
        database.addCounter(0,48,0);
        database.addCounter(0,3,0);
    }


    private static final long TYPE_AGILITY = 1;
    private static final long TYPE_STRENGHT = 2;
    private static final long TYPE_INTELIGENCE = 3;


}
