package xenon.toy

import javax.inject.Singleton

@Singleton
class ToyMaker constructor(private val toy: Toy) {
    fun make() {
        println("making toy... " + toy.name)
        toy.makeNoise()
    }
}
