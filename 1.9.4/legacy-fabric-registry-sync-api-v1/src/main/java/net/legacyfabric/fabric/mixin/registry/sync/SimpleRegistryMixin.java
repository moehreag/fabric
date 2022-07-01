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

import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.class_2929;
import net.minecraft.util.registry.SimpleRegistry;

import net.legacyfabric.fabric.impl.registry.sync.compat.IdListCompat;
import net.legacyfabric.fabric.impl.registry.sync.compat.SimpleRegistryCompat;

@Mixin(SimpleRegistry.class)
public abstract class SimpleRegistryMixin<K, V> implements SimpleRegistryCompat<K, V> {
	@Shadow
	@Final
	protected Map<V, K> objects;

	@Mutable
	@Shadow
	@Final
	protected class_2929<V> field_13718;

	@Shadow
	public abstract int getRawId(Object par1);

	@Shadow
	public abstract K getIdentifier(V id);

	@Shadow
	public abstract V get(K key);

	@Override
	public IdListCompat<V> getIds() {
		return (IdListCompat<V>) this.field_13718;
	}

	@Override
	public Map<V, K> getObjects() {
		return this.objects;
	}

	@Override
	public void setIds(IdListCompat<V> idList) {
		this.field_13718 = (class_2929<V>) idList;
	}

	@Override
	public IdListCompat<V> createIdList() {
		return (IdListCompat<V>) new class_2929<V>(256);
	}

	@Override
	public int getRawID(V object) {
		return this.getRawId(object);
	}

	@Override
	public K getKey(V object) {
		return this.getIdentifier(object);
	}

	@Override
	public V getValue(K key) {
		return this.get(key);
	}
}