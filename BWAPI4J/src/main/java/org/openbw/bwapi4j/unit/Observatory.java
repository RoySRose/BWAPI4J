package org.openbw.bwapi4j.unit;

import org.openbw.bwapi4j.type.UnitType;
import org.openbw.bwapi4j.type.UpgradeType;

public class Observatory extends Building implements Mechanical, ResearchingFacility {

    private Researcher researcher;
    
    protected Observatory(int id, int timeSpotted) {
        
        super(id, UnitType.Protoss_Observatory, timeSpotted);
        this.researcher = new Researcher();
    }

    @Override
    public void update(int[] unitData, int index) {

        this.researcher.update(unitData, index);
        super.update(unitData, index);
    }
    
    public boolean upgradeSensorArray() {
        
        return this.researcher.upgrade(UpgradeType.Sensor_Array);
    }
    
    public boolean upgradeGraviticBooster() {
        
        return this.researcher.upgrade(UpgradeType.Gravitic_Boosters);
    }
    
    @Override
    public boolean isUpgrading() {
        
        return this.researcher.isUpgrading();
    }

    @Override
    public boolean isResearching() {
        
        return this.researcher.isResearching();
    }

    @Override
    public boolean cancelResearch() {
        
        return this.researcher.cancelResearch();
    }

    @Override
    public boolean cancelUpgrade() {
        
        return this.researcher.cancelUpgrade();
    }
}