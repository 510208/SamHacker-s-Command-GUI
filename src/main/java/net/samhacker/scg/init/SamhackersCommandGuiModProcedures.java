
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.samhacker.scg.init;

import net.samhacker.scg.procedures.ShowGMFunctProcedure;
import net.samhacker.scg.procedures.GmSurvivalProcedure;
import net.samhacker.scg.procedures.GmSpectorProcedure;
import net.samhacker.scg.procedures.GmCreativeProcedure;
import net.samhacker.scg.procedures.GmAdventureProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class SamhackersCommandGuiModProcedures {
	public static void load() {
		new GmSurvivalProcedure();
		new GmCreativeProcedure();
		new GmSpectorProcedure();
		new GmAdventureProcedure();
		new ShowGMFunctProcedure();
	}
}
