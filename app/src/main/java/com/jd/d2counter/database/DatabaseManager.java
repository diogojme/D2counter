package com.jd.d2counter.database;


import android.content.Context;

import com.jd.d2counter.objects.Hero;

public class DatabaseManager implements Database {

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
        database.addHero(new Hero(105, "BROODMOTHER", TYPE_AGILITY));
        database.endTransaction();
    }

    // ID heroi, id counter, id melhor suporte
    @Override
    public void insertCounter() {
        //ABADON
        database.addCounter(0, 22, 57, 1);
        database.addCounter(0, 105, 88, 2);
        database.addCounter(0, 45, 19, 3);
        database.addCounter(0, 48, 18, 4);
        database.addCounter(0, 3, 36, 5);

        //ALCHEMIST
        database.addCounter(1, 65, 39, 1);
        database.addCounter(1, 89, 57, 2);
        database.addCounter(1, 59, 2, 3);
        database.addCounter(1, 9, 19, 4);
        database.addCounter(1, 92, 90, 5);

        //ANCIENT
        database.addCounter(1, 45, 55, 1);
        database.addCounter(1, 10, 72, 2);
        database.addCounter(1, 15, 5, 3);
        database.addCounter(1, 95, 66, 4);
        database.addCounter(1, 3, 87, 5);


        addSergio();
    }

    private void addSergio() {
        //WARLOCK
        database.addCounter(94,101,66, 1);
        database.addCounter(94,45,39, 2);
        database.addCounter(94,95,36, 3);
        database.addCounter(94,52,27, 4);
        database.addCounter(94,20,33, 5);

        //WEAVER
        database.addCounter(95,8,99, 1);
        database.addCounter(95,65,53, 2);
        database.addCounter(95,53,5, 3);
        database.addCounter(95,9,55, 4);
        database.addCounter(95,73,72, 5);

        //WINDRANGER
        database.addCounter(96,64,56, 1);
        database.addCounter(96,50,16, 2);
        database.addCounter(96,51,85, 3);
        database.addCounter(96,98,36, 4);
        database.addCounter(96,46,81, 5);

        //WITCH DOCTOR
        database.addCounter(97,105,71, 1);
        database.addCounter(97,52,93, 2);
        database.addCounter(97,65,36, 3);
        database.addCounter(97,95,72, 4);
        database.addCounter(97,15,61, 5);

        //WRATH KING
        database.addCounter(98,60,88, 1);
        database.addCounter(98,48,57, 2);
        database.addCounter(98,3,19, 3);
        database.addCounter(98,32,34, 4);
        database.addCounter(98,102,18, 5);

        //ZEUS
        database.addCounter(99,31,14, 1);
        database.addCounter(99,48,93, 2);
        database.addCounter(99,98,85, 3);
        database.addCounter(99,40,103, 4);
        database.addCounter(99,35,33, 5);

        //EARTH SPIRIT
        database.addCounter(100,31,53, 1);
        database.addCounter(100,53,94, 2);
        database.addCounter(100,36,7, 3);
        database.addCounter(100,89,36, 4);
        database.addCounter(100,8,0, 5);

        //EMBER SPIRIT
        database.addCounter(101,31,21, 1);
        database.addCounter(101,35,57, 2);
        database.addCounter(101,40,91, 3);
        database.addCounter(101,15,103, 4);
        database.addCounter(101,29,71, 5);

        //TERRORBLADE
        database.addCounter(102,48,67, 1);
        database.addCounter(102,47,18, 2);
        database.addCounter(102,105,82, 3);
        database.addCounter(102,104,38, 4);
        database.addCounter(102,46,41, 5);

        //PHOENIX
        database.addCounter(103,71,71, 1);
        database.addCounter(103,86,27, 2);
        database.addCounter(103,48,57, 3);
        database.addCounter(103,31,33, 4);
        database.addCounter(103,8,96, 5);

        //LEGION COMMANDER
        database.addCounter(104,23,19, 1);
        database.addCounter(104,86,90, 2);
        database.addCounter(104,80,57, 3);
        database.addCounter(104,79,79, 4);
        database.addCounter(104,47,39, 5);

        //BROODMOTHER
        database.addCounter(105,4,19, 1);
        database.addCounter(105,48,82, 2);
        database.addCounter(105,51,25, 3);
        database.addCounter(105,73,67, 4);
        database.addCounter(105,104,18, 5);
    }


    private static final long TYPE_AGILITY = 1;
    private static final long TYPE_STRENGHT = 2;
    private static final long TYPE_INTELIGENCE = 3;


}
