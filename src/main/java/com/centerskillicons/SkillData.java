package com.centerskillicons;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import net.runelite.api.Skill;

@AllArgsConstructor
enum SkillData {
    ATTACK(Skill.ATTACK, 5, 3),
    STRENGTH(Skill.STRENGTH, 5, 3),
    DEFENCE(Skill.DEFENCE, 5, 3),
    RANGED(Skill.RANGED, 5, 3),
    PRAYER(Skill.PRAYER, 5, 3),
    MAGIC(Skill.MAGIC, 5, 3),
    RUNECRAFT(Skill.RUNECRAFT, 5, 3),
    CONSTRUCTION(Skill.CONSTRUCTION, 5, 3),
    HITPOINTS(Skill.HITPOINTS, 5, 3),
    AGILITY(Skill.AGILITY, 5, 3),
    HERBLORE(Skill.HERBLORE, 5, 3),
    THIEVING(Skill.THIEVING, 5, 3),
    CRAFTING(Skill.CRAFTING, 5, 3),
    FLETCHING(Skill.FLETCHING, 5, 3),
    SLAYER(Skill.SLAYER, 5, 3),
    HUNTER(Skill.HUNTER, 5, 3),
    MINING(Skill.MINING, 5, 3),
    SMITHING(Skill.SMITHING, 5, 3),
    FISHING(Skill.FISHING, 5, 3),
    COOKING(Skill.COOKING, 5, 3),
    FIREMAKING(Skill.FIREMAKING, 5, 3),
    WOODCUTTING(Skill.WOODCUTTING, 5, 3),
    FARMING(Skill.FARMING, 5, 2),
    SAILING(Skill.SAILING, 5, 3);

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
