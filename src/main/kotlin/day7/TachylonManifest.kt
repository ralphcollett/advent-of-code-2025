package day7

enum class TachylonManifoldCell {
    SPLITTER, EMPTY, TACHYLON_BEAM
}

data class TachylonManifold(val grid: List<List<TachylonManifoldCell>>)
