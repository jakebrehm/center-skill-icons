package com.centerskillicons;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import net.runelite.api.Skill;

@AllArgsConstructor
enum SkillData {
    ATTACK(Skill.ATTACK),
    STRENGTH(Skill.STRENGTH),
    DEFENCE(Skill.DEFENCE),
    RANGED(Skill.RANGED),
    PRAYER(Skill.PRAYER),
    MAGIC(Skill.MAGIC),
    RUNECRAFT(Skill.RUNECRAFT),
    CONSTRUCTION(Skill.CONSTRUCTION),
    HITPOINTS(Skill.HITPOINTS),
    AGILITY(Skill.AGILITY),
    HERBLORE(Skill.HERBLORE),
    THIEVING(Skill.THIEVING),
    CRAFTING(Skill.CRAFTING),
    FLETCHING(Skill.FLETCHING),
    SLAYER(Skill.SLAYER),
    HUNTER(Skill.HUNTER),
    MINING(Skill.MINING),
    SMITHING(Skill.SMITHING),
    FISHING(Skill.FISHING),
    COOKING(Skill.COOKING),
    FIREMAKING(Skill.FIREMAKING),
    WOODCUTTING(Skill.WOODCUTTING),
    FARMING(Skill.FARMING),
    SAILING(Skill.SAILING);

    final Skill skill;

    static SkillData get(int idx) {
        if (idx < 0 || idx >= values().length) return null;
        return values()[idx];
    }
}
