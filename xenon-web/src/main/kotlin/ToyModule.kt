package xenon.toy

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ToyModule {
    @Provides
    @Singleton
    fun provideToy(): Toy {
        return Toy("the only toy")
    }

    @Provides
    @Singleton
    fun provideToyMaker(): ToyMaker {
        return ToyMaker(provideToy())
    }
}