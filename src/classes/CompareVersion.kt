package classes

class CompareVersion() {

    fun compareVersion(currentVersion: String, nextVersion: String): Boolean {
        val currentVersionLevels = currentVersion.split(".").map { array -> array.toIntOrNull() }
        val remoteVersionLevels = nextVersion.split(".").map { array -> array.toIntOrNull() }
        return when {
            currentVersionLevels.size >= remoteVersionLevels.size -> compareVersionOnBlock(currentVersionLevels, remoteVersionLevels)
            else -> compareVersionOnBlock(remoteVersionLevels, currentVersionLevels)
        }
    }

    private fun compareVersionOnBlock(biggerBlockList: List<Int?>, smallerBlockList: List<Int?>): Boolean {
        for (index in biggerBlockList.indices) {
            val currentLevel = biggerBlockList[index] ?: 0
            val nextLevel = smallerBlockList[index] ?: 0
            when {
                nextLevel > currentLevel -> return true
                nextLevel < currentLevel -> return false
            }
        }
        return false
    }
}