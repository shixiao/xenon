package xenon.toy

import javax.inject.Singleton

@Singleton
class Toy constructor(val name: String) {
    fun makeNoise() {
        println("Yikes " + name)
    }
}