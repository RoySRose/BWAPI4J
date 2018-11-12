package bwem;

import org.openbw.bwapi4j.BW;

public class BWEM {
  private BW bw = null;

  private native void Initialize_native();

  // This has to be called before any other function is called.
  // A good place to do this is in ExampleAIModule::onStart()
  public void Initialize(final BW bw) {
    this.bw = bw;

    Initialize_native();
  }

  //  // Will return true once Initialize() has been called.
  //  bool								Initialized() const			{ return m_size != 0; }
  //
  //  // Returns the status of the automatic path update (off (false) by default).
  //  // When on, each time a blocking Neutral (either Mineral or StaticBuilding) is destroyed,
  //  // any information relative to the paths through the Areas is updated accordingly.
  //  // For this to function, the Map still needs to be informed of such destructions
  //  // (by calling OnMineralDestroyed and OnStaticBuildingDestroyed).
  //  virtual bool						AutomaticPathUpdate() const = 0;
  //
  //  // Enables the automatic path update (Cf. AutomaticPathUpdate()).
  //  // One might NOT want to call this function, in order to make the accessibility between Areas
  // remain the same throughout the game.
  //  // Even in this case, one should keep calling OnMineralDestroyed and
  // OnStaticBuildingDestroyed.
  //  virtual void						EnableAutomaticPathAnalysis() const = 0;
  //
  //  // Tries to assign one Base for each starting Location in StartingLocations().
  //  // Only nearby Bases can be assigned (Cf.
  // detail::max_tiles_between_StartingLocation_and_its_AssignedBase).
  //  // Each such assigned Base then has Starting() == true, and its Location() is updated.
  //  // Returns whether the function succeeded (a fail may indicate a failure in BWEM's Base
  // placement analysis
  //  // or a suboptimal placement in one of the starting Locations).
  //  // You normally should call this function, unless you want to compare the StartingLocations()
  // with
  //  // BWEM's suggested locations for the Bases.
  //  virtual bool						FindBasesForStartingLocations() = 0;
  //
  //  // Returns the size of the Map in Tiles.
  //	const BWAPI::TilePosition &			Size() const								{ return m_Size; }
  //
  //  // Returns the size of the Map in MiniTiles.
  //	const BWAPI::WalkPosition &			WalkSize() const							{ return m_WalkSize; }
  //
  //  // Returns the center of the Map in pixels.
  //	const BWAPI::Position &				Center() const								{ return m_center; }
  //
  //  // Returns a random position in the Map in pixels.
  //  BWAPI::Position						RandomPosition() const;
  //
  //  // Returns the maximum altitude in the whole Map (Cf. MiniTile::Altitude()).
  //  virtual altitude_t					MaxAltitude() const = 0;
  //
  //  // Returns the number of Bases.
  //  virtual int							BaseCount() const = 0;
  //
  //  // Returns the number of ChokePoints.
  //  virtual int							ChokePointCount() const = 0;
  //
  //  // Returns a Tile, given its position.
  //	const Tile &						GetTile(const BWAPI::TilePosition & p, utils::check_t checkMode =
  // utils::check_t::check) const	{ bwem_assert((checkMode == utils::check_t::no_check) ||
  // Valid(p)); utils::unused(checkMode); return m_Tiles[Size().x * p.y + p.x]; }
  //
  //  // Returns a MiniTile, given its position.
  //	const MiniTile &					GetMiniTile(const BWAPI::WalkPosition & p, utils::check_t checkMode =
  // utils::check_t::check) const	{ bwem_assert((checkMode == utils::check_t::no_check) ||
  // Valid(p)); utils::unused(checkMode); return m_MiniTiles[WalkSize().x * p.y + p.x]; }
  //
  //  // Returns a Tile or a MiniTile, given its position.
  //  // Provided as a support of generic algorithms.
  //  template<class TPosition>
  //      const typename utils::TileOfPosition<TPosition>::type & GetTTile(const TPosition & p,
  // utils::check_t checkMode = utils::check_t::check) const;
  //
  //  // Provides access to the internal array of Tiles.
  //	const std::vector<Tile> &			Tiles() const									{ return m_Tiles; }
  //
  //  // Provides access to the internal array of MiniTiles.
  //	const std::vector<MiniTile> &		MiniTiles() const								{ return m_MiniTiles; }
  //
  //  // Returns whether the position p is valid.
  //  bool								Valid(const BWAPI::TilePosition & p) const		{ return (0 <= p.x) && (p.x <
  // Size().x) && (0 <= p.y) && (p.y < Size().y); }
  //  bool								Valid(const BWAPI::WalkPosition & p) const		{ return (0 <= p.x) && (p.x <
  // WalkSize().x) && (0 <= p.y) && (p.y < WalkSize().y); }
  //  bool								Valid(const BWAPI::Position & p) const			{ return Valid(BWAPI::WalkPosition(p)); }
  //
  //  // Returns the position closest to p that is valid.
  //  BWAPI::WalkPosition					Crop(const BWAPI::WalkPosition & p) const;
  //  BWAPI::TilePosition					Crop(const BWAPI::TilePosition & p) const;
  //  BWAPI::Position						Crop(const BWAPI::Position & p) const;
  //
  //  // Returns a reference to the starting Locations.
  //  // Note: these correspond to BWAPI::getStartLocations().
  //  virtual const std::vector<BWAPI::TilePosition> &				StartingLocations() const = 0;
  //
  //  // Returns a reference to the Minerals (Cf. Mineral).
  //  virtual const std::vector<std::unique_ptr<Mineral>> &			Minerals() const = 0;
  //
  //  // Returns a reference to the Geysers (Cf. Geyser).
  //  virtual const std::vector<std::unique_ptr<Geyser>> &			Geysers() const = 0;
  //
  //  // Returns a reference to the StaticBuildings (Cf. StaticBuilding).
  //  virtual const std::vector<std::unique_ptr<StaticBuilding>> &	StaticBuildings() const = 0;
  //
  //  // If a Mineral wrappers the given BWAPI unit, returns a pointer to it.
  //  // Otherwise, returns nullptr.
  //  virtual Mineral *					GetMineral(BWAPI::Unit u) const = 0;
  //
  //  // If a Geyser wrappers the given BWAPI unit, returns a pointer to it.
  //  // Otherwise, returns nullptr.
  //  virtual Geyser *					GetGeyser(BWAPI::Unit g) const = 0;
  //
  //  // Should be called for each destroyed BWAPI unit u having u->getType().isMineralField() ==
  // true
  //  virtual void						OnMineralDestroyed(BWAPI::Unit u) = 0;
  //
  //  // Should be called for each destroyed BWAPI unit u having u->getType().isSpecialBuilding() ==
  // true
  //  virtual void						OnStaticBuildingDestroyed(BWAPI::Unit u) = 0;
  //
  //  // Returns a reference to the Areas.
  //  virtual const std::vector<Area> &	Areas() const = 0;
  //
  //  // Returns an Area given its id.
  //  virtual const Area *				GetArea(Area::id id) const = 0;
  //
  //  // If the MiniTile at w is walkable and is part of an Area, returns that Area.
  //  // Otherwise, returns nullptr;
  //  // Note: because of the lakes, GetNearestArea should be prefered over GetArea.
  //  virtual const Area *				GetArea(BWAPI::WalkPosition w) const = 0;
  //
  //  // If the Tile at t contains walkable sub-MiniTiles which are all part of the same Area,
  // returns that Area.
  //  // Otherwise, returns nullptr;
  //  // Note: because of the lakes, GetNearestArea should be prefered over GetArea.
  //  virtual const Area *				GetArea(BWAPI::TilePosition t) const = 0;
  //
  //  // Returns the nearest Area from w.
  //  // Returns nullptr only if Areas().empty()
  //  // Note: Uses a breadth first search.
  //  virtual const Area *				GetNearestArea(BWAPI::WalkPosition w) const = 0;
  //
  //  // Returns the nearest Area from t.
  //  // Returns nullptr only if Areas().empty()
  //  // Note: Uses a breadth first search.
  //  virtual const Area *				GetNearestArea(BWAPI::TilePosition t) const = 0;
  //
  //
  //  // Returns a list of ChokePoints, which is intended to be the shortest walking path from 'a'
  // to 'b'.
  //  // Furthermore, if pLength != nullptr, the pointed integer is set to the corresponding length
  // in pixels.
  //  // If 'a' is not accessible from 'b', the empty Path is returned, and -1 is put in *pLength
  // (if pLength != nullptr).
  //  // If 'a' and 'b' are in the same Area, the empty Path is returned, and a.getApproxDistance(b)
  // is put in *pLength (if pLength != nullptr).
  //  // Otherwise, the function relies on ChokePoint::GetPathTo.
  //  // Cf. ChokePoint::GetPathTo for more information.
  //  // Note: in order to retrieve the Areas of 'a' and 'b', the function starts by calling
  //  //       GetNearestArea(TilePosition(a)) and GetNearestArea(TilePosition(b)).
  //  //       While this brings robustness, this could yield surprising results in the case where
  // 'a' and/or 'b' are in the Water.
  //  //       To avoid this and the potential performance penalty, just make sure GetArea(a) !=
  // nullptr and GetArea(b) != nullptr.
  //  //       Then GetPath should perform very quick.
  //  virtual const CPPath &				GetPath(const BWAPI::Position & a, const BWAPI::Position & b, int *
  // pLength = nullptr) const = 0;
  //
  //  // Generic algorithm for breadth first search in the Map.
  //  // See the several use cases in BWEM source files.
  //  template<class TPosition, class Pred1, class Pred2>
  //  TPosition							BreadthFirstSearch(TPosition start, Pred1 findCond, Pred2 visitCond, bool
  // connect8 = true) const;
  //
  //
  //  // Returns the union of the geometry of all the ChokePoints. Cf. ChokePoint::Geometry()
  //  virtual const std::vector<std::pair<std::pair<Area::id, Area::id>, BWAPI::WalkPosition>> &
  // RawFrontier() const = 0;
}
