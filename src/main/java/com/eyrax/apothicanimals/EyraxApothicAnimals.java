package com.eyrax.apothicanimals;

import com.mojang.logging.LogUtils;
import dev.shadowsoffire.apotheosis.Apoth;
import dev.shadowsoffire.apotheosis.loot.LootCategory;
import dev.shadowsoffire.apotheosis.socket.gem.ExtraGemBonusRegistry;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

/**
 * Adds Critter Armory's animal armor to the Apotheosis affix system.
 */
@Mod(EyraxApothicAnimals.MOD_ID)
public final class EyraxApothicAnimals {

    public static final String MOD_ID = "eyrax_apothic_animals";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final TagKey<Item> ANIMAL_ARMOR = TagKey.create(
        Registries.ITEM,
        ResourceLocation.fromNamespaceAndPath(MOD_ID, "animal_armor")
    );

    private static final DeferredRegister<LootCategory> LOOT_CATEGORIES =
        DeferredRegister.create(Apoth.BuiltInRegs.LOOT_CATEGORY.key(), MOD_ID);

    public static final DeferredHolder<LootCategory, LootCategory> ANIMAL_ARMOR_CATEGORY =
        LOOT_CATEGORIES.register(
            "animal_armor",
            () -> new LootCategory(stack -> stack.is(ANIMAL_ARMOR), ALObjects.EquipmentSlotGroups.BODY, 900)
        );

    public EyraxApothicAnimals(IEventBus modBus) {
        LOOT_CATEGORIES.register(modBus);
        NeoForge.EVENT_BUS.addListener(this::verifyIntegration);
    }

    private void verifyIntegration(ServerStartedEvent event) {
        int taggedItems = 0;
        int recognizedItems = 0;

        for (Holder<Item> holder : BuiltInRegistries.ITEM.getTagOrEmpty(ANIMAL_ARMOR)) {
            taggedItems++;
            if (LootCategory.forItem(new ItemStack(holder.value())) == ANIMAL_ARMOR_CATEGORY.get()) {
                recognizedItems++;
            }
        }

        if (taggedItems > 0 && taggedItems == recognizedItems) {
            LOGGER.info("EYRAX Apothic Animals recognized all {} tagged animal armor items.", taggedItems);
        }
        else {
            LOGGER.warn(
                "EYRAX Apothic Animals recognized {} of {} tagged animal armor items. Check Critter Armory tags and mod versions.",
                recognizedItems,
                taggedItems
            );
        }

        int extraGemBonuses = ExtraGemBonusRegistry.INSTANCE.getValues().size();
        if (extraGemBonuses == 20) {
            LOGGER.info("EYRAX Apothic Animals registered all {} animal gem bonuses.", extraGemBonuses);
        }
        else {
            LOGGER.warn(
                "EYRAX Apothic Animals expected 20 animal gem bonuses but found {}. Check datapack loading errors.",
                extraGemBonuses
            );
        }
    }
}
