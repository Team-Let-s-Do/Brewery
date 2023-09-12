package net.bmjo.brewery.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.bmjo.brewery.Brewery;
import net.bmjo.brewery.entity.BeerKegFlowerPotBlockEntity;
import net.bmjo.brewery.entity.BrewKettleEntity;
import net.bmjo.brewery.util.BreweryIdentifier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    private static final Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Brewery.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY).getRegistrar();

    public static final RegistrySupplier<BlockEntityType<BrewKettleEntity>> BREW_KETTLE_BLOCK_ENTITY = create("brew_kettle", () -> BlockEntityType.Builder.of(BrewKettleEntity::new, ObjectRegistry.WATER_BASIN.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<BeerKegFlowerPotBlockEntity>> BEER_KEG_FLOWER_POT_BLOCK_ENTITY = create("beer_keg", () -> BlockEntityType.Builder.of(BeerKegFlowerPotBlockEntity::new, ObjectRegistry.BEER_KEG.get()).build(null));


    private static <T extends BlockEntityType<?>> RegistrySupplier<T> create(final String path, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(new BreweryIdentifier(path), type);
    }

    public static void registerBlockEntities() {
        
    }
}