package net.bdew.wurm.action;

import com.wurmonline.client.game.inventory.InventoryMetaItem;
import com.wurmonline.client.renderer.gui.HeadsUpDisplay;
import com.wurmonline.client.renderer.gui.PaperDollInventory;
import com.wurmonline.client.renderer.gui.PaperDollSlot;

import java.lang.reflect.Field;

@SuppressWarnings("unchecked")
public class Reflect {
    // HeadsUpDisplay
    static private Field fldPaperdollInventory;

    // PaperDollInventory
    static private Field fldBodyItem;


    static public void setup() throws ReflectiveOperationException {
        fldPaperdollInventory = HeadsUpDisplay.class.getDeclaredField("paperdollInventory");
        fldPaperdollInventory.setAccessible(true);

        fldBodyItem = PaperDollInventory.class.getDeclaredField("bodyItem");
        fldBodyItem.setAccessible(true);
    }

    public static PaperDollInventory getPaperdollInventory(HeadsUpDisplay hud) throws ReflectiveOperationException {
        return (PaperDollInventory) fldPaperdollInventory.get(hud);
    }

    public static InventoryMetaItem getBodyItem(PaperDollInventory pd) throws ReflectiveOperationException {
        return ((PaperDollSlot) fldBodyItem.get(pd)).getItem();
    }
}