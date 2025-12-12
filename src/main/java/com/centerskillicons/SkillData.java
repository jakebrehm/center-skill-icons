package com.centerskillicons;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import net.runelite.api.Skill;

@AllArgsConstructor
enum SkillData {
    ATTACK(Skill.ATTACK, 4, 3),
    STRENGTH(Skill.STRENGTH, 4, 3),
    DEFENCE(Skill.DEFENCE, 4, 3),
    RANGED(Skill.RANGED, 4, 3),
    PRAYER(Skill.PRAYER, 4, 3),
    MAGIC(Skill.MAGIC, 4, 3),
    RUNECRAFT(Skill.RUNECRAFT, 4, 3),
    CONSTRUCTION(Skill.CONSTRUCTION, 4, 3),
    HITPOINTS(Skill.HITPOINTS, 4, 3),
    AGILITY(Skill.AGILITY, 4, 3),
    HERBLORE(Skill.HERBLORE, 4, 3),
    THIEVING(Skill.THIEVING, 4, 3),
    CRAFTING(Skill.CRAFTING, 5, 3),
    FLETCHING(Skill.FLETCHING, 4, 3),
    SLAYER(Skill.SLAYER, 3, 3),
    HUNTER(Skill.HUNTER, 4, 3),
    MINING(Skill.MINING, 4, 3),
    SMITHING(Skill.SMITHING, 4, 3),
    FISHING(Skill.FISHING, 4, 3),
    COOKING(Skill.COOKING, 4, 3),
    FIREMAKING(Skill.FIREMAKING, 4, 3),
    WOODCUTTING(Skill.WOODCUTTING, 4, 3),
    FARMING(Skill.FARMING, 4, 2),
    SAILING(Skill.SAILING, 4, 3);

    final Skill skill;
    final int newX;
    final int newY;

    static SkillData get(int idx) {
        if (idx < 0 || idx >= values().length) return null;
        return values()[idx];
    }

    static HashMap<Skill, Coordinate> mapping() {
        HashMap<Skill, Coordinate> result = new HashMap<>();
        for (int i = 0; i < values().length; i++) {
            SkillData skillData = values()[i];
            result.put(skillData.skill, new Coordinate(skillData.newX, skillData.newY));
        }
        return result;
    }
}
