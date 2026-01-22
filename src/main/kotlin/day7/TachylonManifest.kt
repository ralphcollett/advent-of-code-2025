package day7

enum class TachylonManifoldCell {
    SPLITTER, EMPTY, TACHYLON_BEAM_START_POSITION
}

data class TachylonManifold(val cells: List<List<TachylonManifoldCell>>)
