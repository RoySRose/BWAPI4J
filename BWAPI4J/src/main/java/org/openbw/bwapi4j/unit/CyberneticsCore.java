////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (C) 2017-2018 OpenBW Team
//
//    This file is part of BWAPI4J.
//
//    BWAPI4J is free software: you can redistribute it and/or modify
//    it under the terms of the Lesser GNU General Public License as published
//    by the Free Software Foundation, version 3 only.
//
//    BWAPI4J is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with BWAPI4J.  If not, see <http://www.gnu.org/licenses/>.
//
////////////////////////////////////////////////////////////////////////////////

package org.openbw.bwapi4j.unit;

import org.openbw.bwapi4j.type.TechType;
import org.openbw.bwapi4j.type.UnitType;
import org.openbw.bwapi4j.type.UpgradeType;

public class CyberneticsCore extends BuildingImpl implements Mechanical, ResearchingFacility {

  protected CyberneticsCore(UnitType unitType, int timeSpotted) {
    super(unitType, timeSpotted);
  }

  public boolean upgradeAirArmor() {
    return super.upgrade(UpgradeType.Protoss_Air_Armor);
  }

  public boolean upgradeAirWeapons() {
    return super.upgrade(UpgradeType.Protoss_Air_Weapons);
  }

  public boolean upgradeSingularityCharge() {
    return super.upgrade(UpgradeType.Singularity_Charge);
  }

  @Override
  public boolean isUpgrading() {
    return upgrading;
  }

  @Override
  public boolean isResearching() {
    return researching;
  }

  @Override
  public boolean cancelResearch() {
    return super.cancelResearch();
  }

  @Override
  public boolean cancelUpgrade() {
    return super.cancelUpgrade();
  }

  @Override
  public boolean canResearch(TechType techType) {
    return super.canResearch(techType);
  }

  @Override
  public boolean canUpgrade(UpgradeType upgradeType) {
    return super.canUpgrade(upgradeType);
  }

  @Override
  public boolean research(TechType techType) {
    return super.research(techType);
  }

  @Override
  public boolean upgrade(UpgradeType upgradeType) {
    return super.upgrade(upgradeType);
  }

  @Override
  public UpgradeInProgress getUpgradeInProgress() {
    return super.getUpgradeInProgress();
  }

  @Override
  public ResearchInProgress getResearchInProgress() {
    return super.getResearchInProgress();
  }
}
