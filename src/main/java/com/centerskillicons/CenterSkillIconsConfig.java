package com.centerskillicons;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(CenterSkillIconsConfig.GROUP_NAME)
public interface CenterSkillIconsConfig extends Config
{
    String GROUP_NAME = "centerskillicons";

    // SECTION - Skill positions

    @ConfigSection(
        name="Skill positions",
        description="Change the positions of specific skills",
        position=100,
        closedByDefault = true
    )
    String SECTION_INDIVIDUAL_SKILLS = "individualSkills";

    String ITEM_POSITION_ATTACK_X = "positionAttackX";
    String ITEM_POSITION_ATTACK_Y = "positionAttackY";
    String ITEM_POSITION_STRENGTH_X = "positionStrengthX";
    String ITEM_POSITION_STRENGTH_Y = "positionStrengthY";
    String ITEM_POSITION_DEFENCE_X = "positionDefenceX";
    String ITEM_POSITION_DEFENCE_Y = "positionDefenceY";
    String ITEM_POSITION_RANGED_X = "positionRangedX";
    String ITEM_POSITION_RANGED_Y = "positionRangedY";
    String ITEM_POSITION_PRAYER_X = "positionPrayerX";
    String ITEM_POSITION_PRAYER_Y = "positionPrayerY";
    String ITEM_POSITION_MAGIC_X = "positionMagicX";
    String ITEM_POSITION_MAGIC_Y = "positionMagicY";
    String ITEM_POSITION_RUNECRAFT_X = "positionRunecraftX";
    String ITEM_POSITION_RUNECRAFT_Y = "positionRunecraftY";
    String ITEM_POSITION_CONSTRUCTION_X = "positionConstructionX";
    String ITEM_POSITION_CONSTRUCTION_Y = "positionConstructionY";
    String ITEM_POSITION_HITPOINTS_X = "positionHitpointsX";
    String ITEM_POSITION_HITPOINTS_Y = "positionHitpointsY";
    String ITEM_POSITION_AGILITY_X = "positionAgilityX";
    String ITEM_POSITION_AGILITY_Y = "positionAgilityY";
    String ITEM_POSITION_HERBLORE_X = "positionHerbloreX";
    String ITEM_POSITION_HERBLORE_Y = "positionHerbloreY";
    String ITEM_POSITION_THIEVING_X = "positionThievingX";
    String ITEM_POSITION_THIEVING_Y = "positionThievingY";
    String ITEM_POSITION_CRAFTING_X = "positionCraftingX";
    String ITEM_POSITION_CRAFTING_Y = "positionCraftingY";
    String ITEM_POSITION_FLETCHING_X = "positionFletchingX";
    String ITEM_POSITION_FLETCHING_Y = "positionFletchingY";
    String ITEM_POSITION_SLAYER_X = "positionSlayerX";
    String ITEM_POSITION_SLAYER_Y = "positionSlayerY";
    String ITEM_POSITION_HUNTER_X = "positionHunterX";
    String ITEM_POSITION_HUNTER_Y = "positionHunterY";
    String ITEM_POSITION_MINING_X = "positionMiningX";
    String ITEM_POSITION_MINING_Y = "positionMiningY";
    String ITEM_POSITION_SMITHING_X = "positionSmithingX";
    String ITEM_POSITION_SMITHING_Y = "positionSmithingY";
    String ITEM_POSITION_FISHING_X = "positionFishingX";
    String ITEM_POSITION_FISHING_Y = "positionFishingY";
    String ITEM_POSITION_COOKING_X = "positionCookingX";
    String ITEM_POSITION_COOKING_Y = "positionCookingY";
    String ITEM_POSITION_FIREMAKING_X = "positionFiremakingX";
    String ITEM_POSITION_FIREMAKING_Y = "positionFiremakingY";
    String ITEM_POSITION_WOODCUTTING_X = "positionWoodcuttingX";
    String ITEM_POSITION_WOODCUTTING_Y = "positionWoodcuttingY";
    String ITEM_POSITION_FARMING_X = "positionFarmingX";
    String ITEM_POSITION_FARMING_Y = "positionFarmingY";
    String ITEM_POSITION_SAILING_X = "positionSailingX";
    String ITEM_POSITION_SAILING_Y = "positionSailingY";

    @ConfigItem(
        keyName=ITEM_POSITION_ATTACK_X,
        name="Attack X",
        description="Attack skill icon X coordinate.",
        section=SECTION_INDIVIDUAL_SKILLS,
        position=1
    )
    default int positionAttackX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_ATTACK_Y,
            name="Attack Y",
            description="Attack skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=2
    )
    default int positionAttackY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_STRENGTH_X,
            name="Strength X",
            description="Strength skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=3
    )
    default int positionStrengthX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_STRENGTH_Y,
            name="Strength Y",
            description="Strength skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=4
    )
    default int positionStrengthY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_DEFENCE_X,
            name="Defence X",
            description="Defence skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=5
    )
    default int positionDefenceX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_DEFENCE_Y,
            name="Defence Y",
            description="Defence skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=6
    )
    default int positionDefenceY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_RANGED_X,
            name="Ranged X",
            description="Ranged skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=7
    )
    default int positionRangedX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_RANGED_Y,
            name="Ranged Y",
            description="Ranged skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=8
    )
    default int positionRangedY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_PRAYER_X,
            name="Prayer X",
            description="Prayer skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=9
    )
    default int positionPrayerX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_PRAYER_Y,
            name="Prayer Y",
            description="Prayer skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=10
    )
    default int positionPrayerY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_MAGIC_X,
            name="Magic X",
            description="Magic skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=11
    )
    default int positionMagicX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_MAGIC_Y,
            name="Magic Y",
            description="Magic skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=12
    )
    default int positionMagicY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_RUNECRAFT_X,
            name="Runecraft X",
            description="Runecraft skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=13
    )
    default int positionRunecraftX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_RUNECRAFT_Y,
            name="Runecraft Y",
            description="Runecraft skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=14
    )
    default int positionRunecraftY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_CONSTRUCTION_X,
            name="Construction X",
            description="Construction skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=15
    )
    default int positionConstructionX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_CONSTRUCTION_Y,
            name="Construction Y",
            description="Construction skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=16
    )
    default int positionConstructionY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_HITPOINTS_X,
            name="Hitpoints X",
            description="Hitpoints skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=17
    )
    default int positionHitpointsX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_HITPOINTS_Y,
            name="Hitpoints Y",
            description="Hitpoints skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=18
    )
    default int positionHitpointsY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_AGILITY_X,
            name="Agility X",
            description="Agility skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=19
    )
    default int positionAgilityX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_AGILITY_Y,
            name="Agility Y",
            description="Agility skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=20
    )
    default int positionAgilityY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_HERBLORE_X,
            name="Herblore X",
            description="Herblore skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=21
    )
    default int positionHerbloreX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_HERBLORE_Y,
            name="Herblore Y",
            description="Herblore skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=22
    )
    default int positionHerbloreY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_THIEVING_X,
            name="Thieving X",
            description="Thieving skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=23
    )
    default int positionThievingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_THIEVING_Y,
            name="Thieving Y",
            description="Thieving skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=24
    )
    default int positionThievingY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_CRAFTING_X,
            name="Crafting X",
            description="Crafting skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=25
    )
    default int positionCraftingX() {
        return 5;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_CRAFTING_Y,
            name="Crafting Y",
            description="Crafting skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=26
    )
    default int positionCraftingY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_FLETCHING_X,
            name="Fletching X",
            description="Fletching skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=27
    )
    default int positionFletchingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_FLETCHING_Y,
            name="Fletching Y",
            description="Fletching skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=28
    )
    default int positionFletchingY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_SLAYER_X,
            name="Slayer X",
            description="Slayer skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=29
    )
    default int positionSlayerX() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_SLAYER_Y,
            name="Slayer Y",
            description="Slayer skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=30
    )
    default int positionSlayerY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_HUNTER_X,
            name="Hunter X",
            description="Hunter skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=31
    )
    default int positionHunterX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_HUNTER_Y,
            name="Hunter Y",
            description="Hunter skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=32
    )
    default int positionHunterY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_MINING_X,
            name="Mining X",
            description="Mining skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=33
    )
    default int positionMiningX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_MINING_Y,
            name="Mining Y",
            description="Mining skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=34
    )
    default int positionMiningY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_SMITHING_X,
            name="Smithing X",
            description="Smithing skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=35
    )
    default int positionSmithingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_SMITHING_Y,
            name="Smithing Y",
            description="Smithing skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=36
    )
    default int positionSmithingY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_FISHING_X,
            name="Fishing X",
            description="Fishing skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=37
    )
    default int positionFishingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_FISHING_Y,
            name="Fishing Y",
            description="Fishing skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=38
    )
    default int positionFishingY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_COOKING_X,
            name="Cooking X",
            description="Cooking skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=39
    )
    default int positionCookingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_COOKING_Y,
            name="Cooking Y",
            description="Cooking skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=40
    )
    default int positionCookingY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_FIREMAKING_X,
            name="Firemaking X",
            description="Firemaking skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=41
    )
    default int positionFiremakingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_FIREMAKING_Y,
            name="Firemaking Y",
            description="Firemaking skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=42
    )
    default int positionFiremakingY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_WOODCUTTING_X,
            name="Woodcutting X",
            description="Woodcutting skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=43
    )
    default int positionWoodcuttingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_WOODCUTTING_Y,
            name="Woodcutting Y",
            description="Woodcutting skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=44
    )
    default int positionWoodcuttingY() {
        return 3;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_FARMING_X,
            name="Farming X",
            description="Farming skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=45
    )
    default int positionFarmingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_FARMING_Y,
            name="Farming Y",
            description="Farming skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=46
    )
    default int positionFarmingY() {
        return 2;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_SAILING_X,
            name="Sailing X",
            description="Sailing skill icon X coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=47
    )
    default int positionSailingX() {
        return 4;
    }

    @ConfigItem(
            keyName=ITEM_POSITION_SAILING_Y,
            name="Sailing Y",
            description="Sailing skill icon Y coordinate.",
            section=SECTION_INDIVIDUAL_SKILLS,
            position=48
    )
    default int positionSailingY() {
        return 3;
    }

}
