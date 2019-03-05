
fun transcribeToRna(dna: String): String {
    val decoder = mapOf('G' to 'C', 'C' to 'G', 'T' to 'A', 'A' to 'U')

    return dna.toList().map { decoder[it] }.joinToString("")
}
