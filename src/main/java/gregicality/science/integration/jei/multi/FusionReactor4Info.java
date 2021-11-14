package gregicality.science.integration.jei.multi;

import gregicality.science.common.block.GCYSciMetaBlocks;
import gregicality.science.common.block.fusion.GACryostatCasing;
import gregicality.science.common.block.fusion.GADivertorCasing;
import gregicality.science.common.block.fusion.GAFusionCasing;
import gregicality.science.common.block.fusion.GAVacuumCasing;
import gregicality.science.common.machine.GCYSciTileEntities;
import gregicality.science.integration.jei.GAMultiblockShapeInfo;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class FusionReactor4Info extends MultiblockInfoPage {

    @Override
    public MultiblockControllerBase getController() {
        return GCYSciTileEntities.ADVANCED_FUSION_REACTOR;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            GAMultiblockShapeInfo.Builder builder = GAMultiblockShapeInfo.builder();
            builder .aisle("###############", "###############","#####ccCcc#####","#####ccCcc#####","###############","###############")
                    .aisle("###############", "#######C#######","###ccvEvEvcc###","###ccvEvEvcc###","#######C#######","###############")
                    .aisle("#######C#######", "##C##EEdEE##C##","##Cvv#####vvC##","##Cvv#####vvC##","##C##bbbbb##C##","#######C#######")
                    .aisle("###C###C###C###", "###EEdddddEE###","#cv#########vc#","#cv#########vc#","###bbbbbbbbb###","###C###C###C###")
                    .aisle("####C#####C####", "###Edd#C#ddE###","#cv###vvv###vc#","#cv###vvv###vc#","###bbb#C#bbb###","####C#####C####")
                    .aisle("###############", "##EddC###CddE##","cv###v#C#v###vc","cv###v#C#v###vc","##bbbC###Cbbb##","###############")
                    .aisle("######XXX######", "##dd##CCC##dd##","cv##v#CCC#v##vc","cv##v#CCC#v##vc","##bb##CCC##bb##","######XXX######")
                    .aisle("##CC##XXX##CC##", "#CddC#CCC#CddC#","Cv##vCCCCCv##vC","Cv##vCCCCCv##vC","#CbbC#CCC#CbbC#","##CC##XXX##CC##")
                    .aisle("######XXX######", "##dd##CCC##dd##","cv##v#CCC#v##vc","cv##v#CCC#v##vc","##bb##CCC##bb##","######XXX######")
                    .aisle("###############", "##dddC###Cddd##","cv###v#C#v###vc","cv###v#C#v###vc","##bbbC###Cbbb##","###############")
                    .aisle("####C#####C####", "###ddd#C#ddd###","#cv###vvv###vc#","#cv###vvv###vc#","###bbb#C#bbb###","####C#####C####")
                    .aisle("###C###C###C###", "###dfddddddd###","#cv#########vc#","#cv#########vc#","###bbbbbbbbb###","###C###C###C###")
                    .aisle("#######C#######", "##C##ffdFF##C##","##Cvv#####vvC##","##Cvv#####vvC##","##C##bbbbb##C##","#######C#######")
                    .aisle("###############", "#######S#######","###ccvvvvvcc###","###ccvvvvvcc###","#######C#######","###############")
                    .aisle("###############", "###############","#####ccCcc#####","#####ccCcc#####","###############","###############")
                    .where('S', GCYSciTileEntities.ADVANCED_FUSION_REACTOR, EnumFacing.SOUTH)
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('C', GCYSciMetaBlocks.FUSION_CASING.getState(GAFusionCasing.CasingType.values()[i + 4]))
                    .where('X', GCYSciMetaBlocks.FUSION_CASING.getState(GAFusionCasing.CasingType.ADV_FUSION_CASING))
                    .where('f', MetaTileEntities.FLUID_IMPORT_HATCH[8], EnumFacing.SOUTH)
                    .where('F', MetaTileEntities.FLUID_EXPORT_HATCH[8], EnumFacing.SOUTH)
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.UHV], EnumFacing.NORTH)
                    .where('c', GCYSciMetaBlocks.CRYOSTAT_CASING.getState(GACryostatCasing.CasingType.values()[i]))
                    .where('v', GCYSciMetaBlocks.VACUUM_CASING.getState(GAVacuumCasing.CasingType.values()[i]))
                    .where('b', GCYSciMetaBlocks.FUSION_CASING.getState(GAFusionCasing.CasingType.FUSION_BLANKET))
                    .where('d', GCYSciMetaBlocks.DIVERTOR_CASING.getState(GADivertorCasing.CasingType.values()[i]))
                    .build();
            shapeInfo.add(builder.build());
        }
        return shapeInfo;
    }

    @Override
    public String[] getDescription() {
        return new String[] {I18n.format("gtadditions.machine.multiblock.description")};
    }

    @Override
    public float getDefaultZoom() {
        return 0.5f;
    }
}