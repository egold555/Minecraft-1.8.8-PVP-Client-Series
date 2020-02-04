public void writeString(PacketDataSerializer data, String msg) {
	data.writeInt(msg.length());
	data.a(msg);
}

public void writeUUID(PacketDataSerializer data, UUID uuid) {
	data.a(uuid);
}

public void writeNBTTagCompound(PacketDataSerializer data, NBTTagCompound nbt) {
	data.a(nbt);
}

public void writeItemStack(PacketDataSerializer data, net.minecraft.server.v1_8_R3.ItemStack is) {
	data.a(is);
}

public void writeItemStackBukkit(PacketDataSerializer data, org.bukkit.inventory.ItemStack is) {
	writeItemStack(data, CraftItemStack.asNMSCopy(is));
}

public void writeBlockPosition(PacketDataSerializer data, BlockPosition pos) {
	data.a(pos);
}

public void writeBlockPosition(PacketDataSerializer data, Location loc) {
	this.writeBlockPosition(data, new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()));
}

public void writeEnum(PacketDataSerializer data, final Enum<?> in) {
	data.a(in);
}

public void writeByteArray(PacketDataSerializer data, byte...bytes) {
	data.a(bytes);
}