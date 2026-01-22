package day7

enum class TachylonManifoldCell {
    SPLITTER, EMPTY, TACHYLON_BEAM_START_POSITION, TACHYLON_BEAM
}

data class TachylonManifold(val grid: List<List<TachylonManifoldCell>>)
