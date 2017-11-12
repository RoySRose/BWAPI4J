package bwem.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openbw.bwapi4j.BW;
import org.openbw.bwapi4j.BWEventListener;
import org.openbw.bwapi4j.BWMap;
import org.openbw.bwapi4j.Player;
import org.openbw.bwapi4j.Position;
import org.openbw.bwapi4j.WalkPosition;
import org.openbw.bwapi4j.unit.MineralPatch;
import org.openbw.bwapi4j.unit.Unit;
import org.openbw.bwapi4j.unit.VespeneGeyser;

import bwem.BWEM;

public class MiniTileTest implements BWEventListener {

	private BW bw;
	private Map map;

	private OriginalBwemData bwemData = null;
	
	@BeforeClass
    public static void setUpClass() {

    }

	@Ignore
	@Test
    public void altitudeTest_Real() throws AssertionError {

		this.bw = new BW(this);
		this.bw.startGame();

		assertMiniTileAltitudes();
	}

    @Test
    public void altitudeTest_Mock() throws AssertionError {
    	
    	BWMap mapMock = new BWMapMock();
    	Collection<Player> players = new ArrayList<>();
    	List<MineralPatch> mineralPatches = new ArrayList<>();
    	List<VespeneGeyser> geysers = new ArrayList<>();
    	List<Unit> units = new ArrayList<>();
    	
    	this.map = new MapImpl(mapMock, null, players, mineralPatches, geysers, units);
    	this.map.Initialize();

    	assertMiniTileAltitudes();
    }

	private void ensureBwemData() {
		if (this.bwemData == null) {
			try {
				this.bwemData = new OriginalBwemData();
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Could not load dummy BWEM data.");
			}
		}
	}

	private void assertMiniTileAltitudes() {
		ensureBwemData();
		int width = (int) Math.sqrt(this.bwemData.miniTileAltitudes_ORIGINAL.length);
		int height = width;
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
//				if (x == 248 && y == 249) { continue; } // index = 127737
//				if (x == 273 && y == 260) { continue; } // index = 133393
//				if (x == 273 && y == 261) { continue; } // index = 133905
				Assert.assertEquals(
						x + " / " + y + " : mini tile altitude is wrong.",
						this.bwemData.miniTileAltitudes_ORIGINAL[width * y + x],
						this.map.GetMiniTile(new WalkPosition(x, y)).Altitude().intValue()
				);
			}
		}
	}

	@Override
	public void onStart() {
		
		this.map = new BWEM(this.bw).GetMap();
    	this.map.Initialize();
		
    	BWMap map1 = this.bw.getBWMap();
    	BWMap map2 = new BWMapMock();

    	// test the test: are the mock values correct?
//    	for (int j = 0; j < 128; j++ ) {
//			for (int i = 0; i < 128; i++) {
//				int groundHeight1 = map1.getGroundHeight(i, j);
//				int groundHeight2 = map2.getGroundHeight(i, j);
//				Assert.assertEquals("ground height not equal between real and mock.", groundHeight1, groundHeight2);
//	    	}
//		}
    	
    	this.bw.exit();
        this.bw.getInteractionHandler().leaveGame();
	}

	@Override
	public void onEnd(boolean isWinner) {
		
	}

	@Override
	public void onFrame() {
		
	}

	@Override
	public void onSendText(String text) {
		
	}

	@Override
	public void onReceiveText(Player player, String text) {
		
	}

	@Override
	public void onPlayerLeft(Player player) {
		
	}

	@Override
	public void onNukeDetect(Position target) {
		
	}

	@Override
	public void onUnitDiscover(Unit unit) {
		
	}

	@Override
	public void onUnitEvade(Unit unit) {
		
	}

	@Override
	public void onUnitShow(Unit unit) {
		
	}

	@Override
	public void onUnitHide(Unit unit) {
		
	}

	@Override
	public void onUnitCreate(Unit unit) {
		
	}

	@Override
	public void onUnitDestroy(Unit unit) {
		
	}

	@Override
	public void onUnitMorph(Unit unit) {
		
	}

	@Override
	public void onUnitRenegade(Unit unit) {
		
	}

	@Override
	public void onSaveGame(String gameName) {
		
	}

	@Override
	public void onUnitComplete(Unit unit) {
		
	}
}
