package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockStairConcrete extends BlockStairs{
    
    public BlockStairConcrete(int id, Block block){
        super(id, block, 1);
        
        this.setUnlocalizedName(Names.Blocks.STAIRCONCRETE);
        this.setCreativeTab(CreativeTabHandler.tabNoname);
        this.useNeighborBrightness[id] = true;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg){
        this.blockIcon = reg.registerIcon(Textures.Blocks.PATHCONCRETE);
    }
}
