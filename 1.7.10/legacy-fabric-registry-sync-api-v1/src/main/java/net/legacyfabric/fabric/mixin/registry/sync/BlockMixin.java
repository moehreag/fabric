/*
 * Copyright (c) 2020 - 2022 Legacy Fabric
 * Copyright (c) 2016 - 2022 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.legacyfabric.fabric.mixin.registry.sync;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.block.Block;
import net.minecraft.util.registry.SimpleRegistry;

import net.legacyfabric.fabric.api.util.Identifier;
import net.legacyfabric.fabric.impl.registry.sync.compat.BlockCompat;
import net.legacyfabric.fabric.impl.registry.sync.compat.SimpleRegistryCompat;

@Mixin(Block.class)
public class BlockMixin implements BlockCompat {
	@Shadow
	@Final
	public static SimpleRegistry field_7260;

	@Override
	public void addToRegistry(int id, Identifier identifier, Block block) {
		field_7260.method_7327(id, identifier.toString(), block);
	}

	@Override
	public <K> SimpleRegistryCompat<K, Block> getRegistry() {
		return (SimpleRegistryCompat<K, Block>) field_7260;
	}
}